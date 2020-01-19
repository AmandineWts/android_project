package fil.android.project.mydofusprofessions.data.services;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * profession service to handle remote calls to the API with retrofit
 */
public interface ProfessionService {

    /**
     * get all the professions from the API
     * @return a single of the list of professions
     */
    @GET("professions")
    Single<List<Profession>> getProfessions();

    /**
     * get the profession by its id from the API
     * @param id the profession id to get
     * @return a single of the returned profession
     */
    @GET("professions/{id}")
    Single<Profession> getProfessionById(@Path("id") String id);

}
