package fil.android.project.mydofusprofessions.data.repository.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Single;

public class ProfessionDetailDataRepository {

    private ProfessionDetailRemoteDataSource professionDetailRemoteDataSource;

    public ProfessionDetailDataRepository(ProfessionDetailRemoteDataSource professionDetailRemoteDataSource) {
        this.professionDetailRemoteDataSource = professionDetailRemoteDataSource;
    }

    public Single<Profession> getProfessionById(String id) {
        return professionDetailRemoteDataSource.getProfessionById(id);
    }

}
