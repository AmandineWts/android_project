package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.ArrayList;
import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.list.locale.ProfessionListLocaleDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.remote.ProfessionListRemoteDataSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;


/**
 * implementation of the profession list repository
 * makes the link between remote and locale datasources
 */
public class ProfessionListDataRepository implements ProfessionListRepository {

    private ProfessionListLocaleDataSource professionListLocaleDataSource;
    private ProfessionListRemoteDataSource professionListRemoteDataSource;

    /**
     * constructor
     * @param professionListRemoteDataSource instance of the profession list remote data source
     * @param professionListLocaleDataSource instance of the profession list locale data source
     */
    public ProfessionListDataRepository(ProfessionListRemoteDataSource professionListRemoteDataSource, ProfessionListLocaleDataSource professionListLocaleDataSource) {
        this.professionListLocaleDataSource = professionListLocaleDataSource;
        this.professionListRemoteDataSource = professionListRemoteDataSource;
    }

    /**
     * get all the professions
     * @return a single with the list of the professions
     */
    @Override
    public Single<List<Profession>> listProfessions() {
        return professionListRemoteDataSource.listProfessions();
    }

    /**
     * get all the learned professions
     * it makes first a call to the remote datasource to get all the professions, then it makes a call to the locale datasource to get the list of professions id learned
     * the rxJava operator zipwith then make a treatment of the list to only return the professions learned
     * @return a single of the list of learned professions
     */
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

}
