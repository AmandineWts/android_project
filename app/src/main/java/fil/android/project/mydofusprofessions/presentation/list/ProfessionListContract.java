package fil.android.project.mydofusprofessions.presentation.list;

import java.util.List;

import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionItemViewModel;

public interface ProfessionListContract {

    interface View {

        void displayProfessions(List<ProfessionItemViewModel> professionItemViewModelList);

        void onProfessionAddedAsLearned();

        void onProfessionRemovedFromLearned();
    }

    interface Presenter {

        void listProfessions();

        void attachView(View view);

        void addProfessionAsLearned(String professionId);

        void removeProfessionFromLearned(String professionId);

    }

}
