package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.ArrayList;
import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.list.locale.ProfessionListLocaleDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.remote.ProfessionListRemoteDataSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;

public class ProfessionListDataRepository implements ProfessionListRepository {

    private ProfessionListLocaleDataSource professionListLocaleDataSource;
    private ProfessionListRemoteDataSource professionListRemoteDataSource;

    public ProfessionListDataRepository(ProfessionListRemoteDataSource professionListRemoteDataSource, ProfessionListLocaleDataSource professionListLocaleDataSource) {
        this.professionListLocaleDataSource = professionListLocaleDataSource;
        this.professionListRemoteDataSource = professionListRemoteDataSource;
    }

    @Override
    public Single<List<Profession>> listProfessions() {
        return professionListRemoteDataSource.listProfessions();
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

}
