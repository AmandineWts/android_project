package fil.android.project.mydofusprofessions.data.repository.detail.locale;

import java.util.List;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * class to handle locale data source and its request to the database
 */
public class ProfessionDetailLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    /**
     * constructor
     * @param myProfessionsDatabase database instance
     */
    public ProfessionDetailLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

    /**
     * make a call to the database to mark a profession as learned
     * @param professionEntity the profession entity to mark as learned
     * @return completable to inform of the success or not
     */
    public Completable markProfessionAsLearned(ProfessionEntity professionEntity) {
        return myProfessionsDatabase.itemDao().markProfessionAsLearned(professionEntity);
    }

    /**
     * make a call to the database to unmark a profession as learned
     * @param professionId the profession id to unlearn
     * @return completable to inform of the success or not
     */
    public Completable unmarkProfessionAsLearned(String professionId) {
        return myProfessionsDatabase.itemDao().unmarkProfessionAsLearned(professionId);
    }

    /**
     * make a call to the database to get the list of profession id learned
     * @return single of the list of string id
     */
    public Single<List<String>> getLearnedProfessionIdList() {
        return myProfessionsDatabase.itemDao().getLearnedProfessionIdList();
    }
}
