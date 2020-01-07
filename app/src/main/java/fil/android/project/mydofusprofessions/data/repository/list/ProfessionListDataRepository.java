package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ProfessionListDataRepository implements ProfessionListRepository {

    private ProfessionListLocaleDataSource professionListLocaleDataSource;
    private ProfessionListRemoteDataSource professionListRemoteDataSource;
    private ProfessionToProfessionEntityMapper professionToProfessionEntityMapper;

    public ProfessionListDataRepository(ProfessionListRemoteDataSource professionListRemoteDataSource, ProfessionListLocaleDataSource professionListLocaleDataSource, ProfessionToProfessionEntityMapper professionToProfessionEntityMapper) {
        this.professionListLocaleDataSource = professionListLocaleDataSource;
        this.professionListRemoteDataSource = professionListRemoteDataSource;
        this.professionToProfessionEntityMapper = professionToProfessionEntityMapper;
    }

    public Single<List<Profession>> listProfessions() {
        return professionListRemoteDataSource.listProfessions();
    }

    @Override
    public Completable markProfessionAsLearned(String professionId) {
        return professionListRemoteDataSource.getProfessionById(professionId)
                .map(new Function<Profession, ProfessionEntity>() {
                    @Override
                    public ProfessionEntity apply(Profession profession) {
                        return professionToProfessionEntityMapper.map(profession);
                    }
                })
                .flatMapCompletable(new Function<ProfessionEntity, CompletableSource>() {
                    @Override
                    public CompletableSource apply(ProfessionEntity professionEntity) throws Exception {
                        return professionListLocaleDataSource.markProfessionAsLearned(professionEntity);
                    }
                });
    }
}
