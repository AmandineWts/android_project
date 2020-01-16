package fil.android.project.mydofusprofessions.data.repository.detail.remote;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import io.reactivex.Single;

public class ProfessionDetailRemoteDataSource {

    private ProfessionService professionService;

    public ProfessionDetailRemoteDataSource(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public Single<Profession> getProfessionById(String id) {
        return professionService.getProfessionById(id);
    }

}
