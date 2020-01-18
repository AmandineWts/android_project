package fil.android.project.mydofusprofessions.presentation.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;

public interface ProfessionDetailContract {

    interface View {

        void displayProfessionWithDetails(Profession profession);

        void onProfessionAddedAsLearned();

        void onProfessionRemovedFromLearned();
    }

    interface Presenter {

        void getDetailsById(String id);

        void addProfessionAsLearned(String professionId);

        void removeProfessionFromLearned(String professionId);

        void attachView(View view);

    }

}
