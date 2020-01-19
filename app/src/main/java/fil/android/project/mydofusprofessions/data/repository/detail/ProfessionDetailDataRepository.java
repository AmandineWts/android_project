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

/**
 * implementation of the profession detail repository
 * makes the link between remote and locale datasources
 */
public class ProfessionDetailDataRepository implements ProfessionDetailRepository {

    private ProfessionDetailRemoteDataSource professionDetailRemoteDataSource;
    private ProfessionDetailLocaleDataSource professionDetailLocaleDataSource;
    private ProfessionToProfessionEntityMapper professionToProfessionEntityMapper;

    /**
     * constructor
     * @param professionDetailRemoteDataSource instance of the profession detail remote data source
     * @param professionDetailLocaleDataSource instance of the profession detail locale data source
     * @param professionToProfessionEntityMapper instance of the profession to profession entity mapper
     */
    public ProfessionDetailDataRepository(ProfessionDetailRemoteDataSource professionDetailRemoteDataSource, ProfessionDetailLocaleDataSource professionDetailLocaleDataSource, ProfessionToProfessionEntityMapper professionToProfessionEntityMapper) {
        this.professionDetailRemoteDataSource = professionDetailRemoteDataSource;
        this.professionDetailLocaleDataSource = professionDetailLocaleDataSource;
        this.professionToProfessionEntityMapper = professionToProfessionEntityMapper;
    }

    /**
     * get a profession by its id
     * @param id the id of the profession
     * @return a single of the profession
     */
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

    /**
     * mark a profession as learned with its id
     * @param professionId profession id to learn
     * @return completable to inform of the success or not
     */
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

    /**
     * unmark a profession from learned with its id
     * @param professionId profession id to unlearn
     * @return completable to inform of the success or not
     */
    @Override
    public Completable unmarkProfessionAsLearned(String professionId) {
        return professionDetailLocaleDataSource.unmarkProfessionAsLearned(professionId);
    }


}
