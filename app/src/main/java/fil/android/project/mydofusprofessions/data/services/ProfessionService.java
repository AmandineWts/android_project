package fil.android.project.mydofusprofessions.data.services;

import fil.android.project.mydofusprofessions.data.api.model.ProfessionListResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ProfessionService {

    @GET("professions")
    Single<ProfessionListResponse> getProfessions();

}
