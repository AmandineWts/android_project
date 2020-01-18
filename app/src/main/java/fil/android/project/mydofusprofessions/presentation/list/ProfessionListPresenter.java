package fil.android.project.mydofusprofessions.presentation.list;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.list.ProfessionListDataRepository;
import fil.android.project.mydofusprofessions.presentation.list.mapper.ProfessionToItemViewModelMapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfessionListPresenter implements ProfessionListContract.Presenter {

    private ProfessionListContract.View professionsListContractView;
    private ProfessionListDataRepository professionListDataRepository;
    private ProfessionToItemViewModelMapper professionToItemViewModelMapper;

    public ProfessionListPresenter(ProfessionListDataRepository professionListDataRepository, ProfessionToItemViewModelMapper professionToItemViewModelMapper) {
        this.professionListDataRepository = professionListDataRepository;
        this.professionToItemViewModelMapper = professionToItemViewModelMapper;
    }

    @Override
    public void attachView(ProfessionListContract.View view) {
        this.professionsListContractView = view;
    }

    @Override
    public void listProfessions() {
        professionListDataRepository.listProfessions()
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

    @Override
    public void listLearnedProfessions() {
        professionListDataRepository.listLearnedProfessions()
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
