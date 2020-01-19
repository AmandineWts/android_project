package fil.android.project.mydofusprofessions.presentation.list;

import java.util.List;

import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionItemViewModel;

/**
 * profession detail contract interface for presentation layer of the details
 */
public interface ProfessionListContract {

    interface View {

        /**
         * bind the profession item view model list to the adapter
         * @param professionItemViewModelList the profession item view model list to bind
         */
        void displayProfessions(List<ProfessionItemViewModel> professionItemViewModelList);

    }

    interface Presenter {

        /**
         * make a call to the repository to get the list of all the professions
         */
        void listProfessions();

        /**
         * attach the view
         * @param view the view to attach
         */
        void attachView(View view);

        /**
         * make a call to the repository to get the list of all the learned professions
         */
        void listLearnedProfessions();

    }

}
