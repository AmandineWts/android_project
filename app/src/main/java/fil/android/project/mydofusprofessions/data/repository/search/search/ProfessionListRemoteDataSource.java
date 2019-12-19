package fil.android.project.mydofusprofessions.data.repository.search.search;

import fil.android.project.mydofusprofessions.data.api.model.ProfessionListResponse;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import io.reactivex.Single;

public class ProfessionListRemoteDataSource {

    private ProfessionService professionService;

    public ProfessionListRemoteDataSource(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public Single<ProfessionListResponse> listProfessions() {
        return professionService.getProfessions();
    }

}
