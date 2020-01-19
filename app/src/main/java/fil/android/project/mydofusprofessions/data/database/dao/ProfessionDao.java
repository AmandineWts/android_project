package fil.android.project.mydofusprofessions.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Data Access Object to make entries and get datas from locale database
 */
@Dao
public interface ProfessionDao {

    /**
     * mark profession as learned
     * @param professionEntity the profession to mark as learned
     * @return completable to inform of the success or not
     */
    @Insert
    public Completable markProfessionAsLearned(ProfessionEntity professionEntity);

    /**
     * unmark a profession from learned
     * @param id the profession id to remove
     * @return completable to inform of the success or not
     */
    @Query("DELETE FROM professionentity WHERE ankama_id = :id")
    public Completable unmarkProfessionAsLearned(String id);

    /**
     * get the list of the profession id that are learned
     * @return completable to inform of the success or not
     */
    @Query("SELECT ankama_id from professionentity")
    Single<List<String>> getLearnedProfessionIdList();

}
