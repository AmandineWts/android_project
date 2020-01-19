package fil.android.project.mydofusprofessions.data.repository.detail;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import fil.android.project.mydofusprofessions.data.repository.detail.locale.ProfessionDetailLocaleDataSource;
import fil.android.project.mydofusprofessions.data.repository.detail.remote.ProfessionDetailRemoteDataSource;
import fil.android.project.mydofusprofessions.data.repository.detail.mapper.ProfessionToProfessionEntityMapper;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class ProfessionDetailDataRepository implements ProfessionDetailRepository {

    private ProfessionDetailRemoteDataSource professionDetailRemoteDataSource;
    private ProfessionDetailLocaleDataSource professionDetailLocaleDataSource;
    private ProfessionToProfessionEntityMapper professionToProfessionEntityMapper;

    public ProfessionDetailDataRepository(ProfessionDetailRemoteDataSource professionDetailRemoteDataSource, ProfessionDetailLocaleDataSource professionDetailLocaleDataSource, ProfessionToProfessionEntityMapper professionToProfessionEntityMapper) {
        this.professionDetailRemoteDataSource = professionDetailRemoteDataSource;
        this.professionDetailLocaleDataSource = professionDetailLocaleDataSource;
        this.professionToProfessionEntityMapper = professionToProfessionEntityMapper;
    }

    @Override
    public Single<Profession> getProfessionById(String id) {
        return professionDetailRemoteDataSource.getProfessionById(id)
                .zipWith(professionDetailLocaleDataSource.getLearnedProfessionIdList(), new BiFunction<Profession, List<String>, Profession>() {
                    @Override
                    public Profession apply(Profession profession, List<String> ids) {
                        if(ids.contains(profession.getAnkamaId())) {
                            profession.setLearned(true);
                        }
                        return profession;
                    }
                });
    }

    @Override
    public Completable markProfessionAsLearned(String professionId) {
        return professionDetailRemoteDataSource.getProfessionById(professionId)
                .map(new Function<Profession, ProfessionEntity>() {
                    @Override
                    public ProfessionEntity apply(Profession profession) {
                        return professionToProfessionEntityMapper.map(profession);
                    }
                })
                .flatMapCompletable(new Function<ProfessionEntity, CompletableSource>() {
                    @Override
                    public CompletableSource apply(ProfessionEntity professionEntity) throws Exception {
                        return professionDetailLocaleDataSource.markProfessionAsLearned(professionEntity);
                    }
                });
    }

    @Override
    public Completable unmarkProfessionAsLearned(String professionId) {
        return professionDetailLocaleDataSource.unmarkProfessionAsLearned(professionId);
    }


}
