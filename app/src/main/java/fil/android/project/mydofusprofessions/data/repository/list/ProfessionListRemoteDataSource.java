package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import io.reactivex.Single;

public class ProfessionListRemoteDataSource {

    private ProfessionService professionService;

    public ProfessionListRemoteDataSource(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public Single<List<Profession>> listProfessions() {
        return professionService.getProfessions();
    }

}
