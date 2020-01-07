package fil.android.project.mydofusprofessions.data.repository.list;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;

public class ProfessionListLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    public ProfessionListLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

    public Completable markProfessionAsLearned(ProfessionEntity professionEntity) {
        return myProfessionsDatabase.itemDao().markProfessionAsLearned(professionEntity);
    }

}
