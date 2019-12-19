package fil.android.project.mydofusprofessions.data.repository.search.search;

import fil.android.project.mydofusprofessions.data.api.model.ProfessionListResponse;
import io.reactivex.Single;

public class ProfessionListDataRepository {

    private ProfessionListLocaleDataSource professionListLocaleDataSource;
    private ProfessionListRemoteDataSource professionListRemoteDataSource;

    public ProfessionListDataRepository(ProfessionListRemoteDataSource professionListRemoteDataSource, ProfessionListLocaleDataSource professionListLocaleDataSource) {
        this.professionListLocaleDataSource = professionListLocaleDataSource;
        this.professionListRemoteDataSource = professionListRemoteDataSource;
    }

    public Single<ProfessionListResponse> listProfessions() {
        return professionListRemoteDataSource.listProfessions();
    }

}
