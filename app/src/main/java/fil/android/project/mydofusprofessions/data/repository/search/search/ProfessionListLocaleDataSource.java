package fil.android.project.mydofusprofessions.data.repository.search.search;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;

public class ProfessionListLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    public ProfessionListLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

}
