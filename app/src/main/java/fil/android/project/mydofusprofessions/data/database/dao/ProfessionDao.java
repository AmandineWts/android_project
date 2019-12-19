package fil.android.project.mydofusprofessions.data.database.dao;

import androidx.room.Dao;

import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;

@Dao
public interface ProfessionDao {

    Completable insert(ProfessionEntity item);

}
