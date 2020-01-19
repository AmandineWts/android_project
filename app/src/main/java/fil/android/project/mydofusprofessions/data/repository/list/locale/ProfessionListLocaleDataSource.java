package fil.android.project.mydofusprofessions.data.repository.list.locale;

import java.util.List;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;
import io.reactivex.Single;

/**
 * class to handle locale data source and its request to the database
 */
public class ProfessionListLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    /**
     * constructor
     * @param myProfessionsDatabase database instance
     */
    public ProfessionListLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

    /**
     * make a call to the database to get the list of profession id learned
     * @return single of the list of string id
     */
    public Single<List<String>> getLearnedProfessionIdList() {
        return myProfessionsDatabase.itemDao().getLearnedProfessionIdList();
    }

}
