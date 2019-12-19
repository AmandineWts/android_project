package fil.android.project.mydofusprofessions.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fil.android.project.mydofusprofessions.data.database.dao.ProfessionDao;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;

@Database(entities = {ProfessionEntity.class}, version = 1, exportSchema = false)
public abstract class MyProfessionsDatabase extends RoomDatabase {

    public abstract ProfessionDao itemDao();
}
