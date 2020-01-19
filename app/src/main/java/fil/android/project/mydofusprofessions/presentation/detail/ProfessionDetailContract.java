package fil.android.project.mydofusprofessions.presentation.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;

/**
 * profession detail contract interface for presentation layer of the details
 */
public interface ProfessionDetailContract {

    interface View {

        /**
         * map the profession datas to the views and displays it
         * @param profession the profession to display
         */
        void displayProfessionWithDetails(Profession profession);

        /**
         * set the current profession as learned and change the button text
         */
        void onProfessionAddedAsLearned();

        /**
         * set the current professiona as unlearned and change the button text
         */
        void onProfessionRemovedFromLearned();
    }

    interface Presenter {

        /**
         * make a call to the repository to get the details of a profession by its id
         * @param id the id of the profession to get
         */
        void getDetailsById(String id);

        /**
         * make a call to the repository to mark a profession as learned with its id
         * @param professionId the id of the profession to mark as learned
         */
        void addProfessionAsLearned(String professionId);

        /**
         * make a call to the repository to unmark a profession from learned
         * @param professionId the id of the profession to remove from learned
         */
        void removeProfessionFromLearned(String professionId);

        /**
         * attach view
         * @param view the view to attach
         */
        void attachView(View view);

    }

}
