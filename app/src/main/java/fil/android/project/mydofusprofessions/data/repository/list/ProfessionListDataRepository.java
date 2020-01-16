package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.ArrayList;
import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import fil.android.project.mydofusprofessions.data.repository.list.locale.ProfessionListLocaleDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.mapper.ProfessionToProfessionEntityMapper;
import fil.android.project.mydofusprofessions.data.repository.list.remote.ProfessionListRemoteDataSource;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
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

    @Override
    public Single<List<Profession>> listProfessions() {
        return professionListRemoteDataSource.listProfessions()
                .zipWith(professionListLocaleDataSource.getLearnedProfessionIdList(), new BiFunction<List<Profession>, List<String>, List<Profession>>() {
            @Override
            public List<Profession> apply(List<Profession> professionList, List<String> ids) {
                for(Profession profession : professionList) {
                    if(ids.contains(profession.getAnkamaId())) {
                        profession.setLearned(true);
                    }
                }
                return professionList;
            }
        });
    }

    @Override
    public Single<List<Profession>> listLearnedProfessions() {
        return professionListRemoteDataSource.listProfessions()
                .zipWith(professionListLocaleDataSource.getLearnedProfessionIdList(), new BiFunction<List<Profession>, List<String>, List<Profession>>() {
                    @Override
                    public List<Profession> apply(List<Profession> professionList, List<String> ids) {
                        List<Profession> learnedProfessions = new ArrayList<>();
                        for (Profession profession : professionList) {
                            if (ids.contains(profession.getAnkamaId())) {
                                profession.setLearned(true);
                                learnedProfessions.add(profession);
                            }
                        }
                        return learnedProfessions;
                    }
                });
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

    @Override
    public Completable unmarkProfessionAsLearned(String professionId) {
        return professionListLocaleDataSource.unmarkProfessionAsLearned(professionId);
    }
}
