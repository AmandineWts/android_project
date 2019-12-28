package fil.android.project.mydofusprofessions.data.services;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProfessionService {

    @GET("professions")
    Single<List<Profession>> getProfessions();

    @GET("professions/{id}")
    Single<Profession> getProfessionById(@Path("id") String id);

}
