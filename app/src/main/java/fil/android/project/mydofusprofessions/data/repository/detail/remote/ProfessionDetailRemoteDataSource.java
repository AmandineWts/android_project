package fil.android.project.mydofusprofessions.data.repository.detail.remote;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import io.reactivex.Single;

/**
 * class to handle remote data source and its request to the service
 */
public class ProfessionDetailRemoteDataSource {

    private ProfessionService professionService;

    /**
     * constructor
     * @param professionService instance of profession service
     */
    public ProfessionDetailRemoteDataSource(ProfessionService professionService) {
        this.professionService = professionService;
    }

    /**
     * make a call to the profession service to get a profession by its id
     * @param id the id of the profession to get
     * @return a single of the profession
     */
    public Single<Profession> getProfessionById(String id) {
        return professionService.getProfessionById(id);
    }

}
