package fil.android.project.mydofusprofessions.data.repository.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * profession detail repository interface
 */
public interface ProfessionDetailRepository {

    /**
     * get a profession by its id
     * @param id the id of the profession
     * @return a single of the profession
     */
    Single<Profession> getProfessionById(String id);

    /**
     * mark a profession as learned with its id
     * @param professionId profession id to learn
     * @return completable to inform of the success or not
     */
    Completable markProfessionAsLearned(String professionId);

    /**
     * unmark a profession from learned with its id
     * @param professionId profession id to unlearn
     * @return completable to inform of the success or not
     */
    Completable unmarkProfessionAsLearned(String professionId);
}
