package fil.android.project.mydofusprofessions.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;

@Dao
public interface ProfessionDao {

    @Insert
    Completable insert(ProfessionEntity item);

}
