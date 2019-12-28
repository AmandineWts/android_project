package fil.android.project.mydofusprofessions.data.repository.list;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;

public class ProfessionListLocaleDataSource {

    private MyProfessionsDatabase myProfessionsDatabase;

    public ProfessionListLocaleDataSource(MyProfessionsDatabase myProfessionsDatabase) {
        this.myProfessionsDatabase = myProfessionsDatabase;
    }

}
