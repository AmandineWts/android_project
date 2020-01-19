package fil.android.project.mydofusprofessions.presentation.list;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.list.ProfessionListRepository;
import fil.android.project.mydofusprofessions.presentation.list.mapper.ProfessionToItemViewModelMapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfessionListPresenter implements ProfessionListContract.Presenter {

    private ProfessionListContract.View professionsListContractView;
    private ProfessionListRepository professionListRepository;
    private ProfessionToItemViewModelMapper professionToItemViewModelMapper;

    public ProfessionListPresenter(ProfessionListRepository professionListRepository, ProfessionToItemViewModelMapper professionToItemViewModelMapper) {
        this.professionListRepository = professionListRepository;
        this.professionToItemViewModelMapper = professionToItemViewModelMapper;
    }

    /**
     * attach the view
     * @param view the view to attach
     */
    @Override
    public void attachView(ProfessionListContract.View view) {
        this.professionsListContractView = view;
    }

    /**
     * make a call to the repository to get the list of all the professions
     */
    @Override
    public void listProfessions() {
        professionListRepository.listProfessions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Profession>>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onSuccess(List<Profession> professionListResponse) {
                        professionsListContractView.displayProfessions(professionToItemViewModelMapper.map(professionListResponse));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Erreur de requête", e.getMessage());
                    }
                });

    }

    /**
     * make a call to the repository to get the list of all the learned professions
     */
    @Override
    public void listLearnedProfessions() {
        professionListRepository.listLearnedProfessions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Profession>>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onSuccess(List<Profession> professionListResponse) {
                        professionsListContractView.displayProfessions(professionToItemViewModelMapper.map(professionListResponse));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Erreur de requête", e.getMessage());
                    }
                });
    }

}
