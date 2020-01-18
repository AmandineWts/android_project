package fil.android.project.mydofusprofessions.data.repository.list.locale;

import java.util.List;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;
import io.reactivex.Single;

public class ProfessionListLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    public ProfessionListLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

    public Single<List<String>> getLearnedProfessionIdList() {
        return myProfessionsDatabase.itemDao().getLearnedProfessionIdList();
    }

}
