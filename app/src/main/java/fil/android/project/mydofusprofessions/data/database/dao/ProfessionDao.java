package fil.android.project.mydofusprofessions.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;

@Dao
public interface ProfessionDao {

    @Insert
    public Completable markProfessionAsLearned(ProfessionEntity professionEntity);

    @Query("DELETE FROM professionentity WHERE ankama_id = :id")
    public Completable unmarkProfessionAsLearned(String id);


}
