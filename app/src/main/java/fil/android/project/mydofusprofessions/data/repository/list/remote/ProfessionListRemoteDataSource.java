package fil.android.project.mydofusprofessions.data.repository.list.remote;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import io.reactivex.Single;

/**
 * class to handle remote data source and its request to the service
 */
public class ProfessionListRemoteDataSource {

    private ProfessionService professionService;

    /**
     * constructor
     * @param professionService instance of profession service
     */
    public ProfessionListRemoteDataSource(ProfessionService professionService) {
        this.professionService = professionService;
    }

    /**
     * make a call to the profession service to get all the professions
     * @return a single of the list of professions
     */
    public Single<List<Profession>> listProfessions() {
        return professionService.getProfessions();
    }

}
