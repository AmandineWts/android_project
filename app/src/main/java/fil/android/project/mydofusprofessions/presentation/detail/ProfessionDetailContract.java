package fil.android.project.mydofusprofessions.presentation.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.presentation.detail.modelview.ProfessionDetailsViewModel;

public interface ProfessionDetailContract {

    interface View {

        void displayProfessionWithDetails(Profession profession);
    }

    interface Presenter {

        void getDetailsById(String id);

        void attachView(View view);

    }

}
