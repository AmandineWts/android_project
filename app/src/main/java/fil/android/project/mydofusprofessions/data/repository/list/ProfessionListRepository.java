package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Single;

/**
 * profession list repository interface
 */
public interface ProfessionListRepository {

    /**
     * get all the professions
     * @return a single with the list of the professions
     */
    Single<List<Profession>> listProfessions();

    /**
     * get all the learned professions
     * it makes first a call to the remote datasource to get all the professions, then it makes a call to the locale datasource to get the list of professions id learned
     * the rxJava operator zipwith then make a treatment of the list to only return the professions learned
     * @return a single of the list of learned professions
     */
    Single<List<Profession>> listLearnedProfessions();

}
