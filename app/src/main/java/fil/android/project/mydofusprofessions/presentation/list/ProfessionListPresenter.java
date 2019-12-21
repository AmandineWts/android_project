package fil.android.project.mydofusprofessions.presentation.list;

import android.util.Log;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.search.search.ProfessionListDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfessionListPresenter implements ProfessionListContract.Presenter {

    private ProfessionListContract.View professionsListContractView;
    private ProfessionListDataRepository professionListDataRepository;

    public ProfessionListPresenter(ProfessionListDataRepository professionListDataRepository) {
        this.professionListDataRepository = professionListDataRepository;
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

                    @Override
                    public void onSuccess(List<Profession> professionListResponse) {
                        Log.i("debug requete", "Taille de la liste des professions = " + professionListResponse.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("erreur requete", e.getMessage());
                    }
                });

    }

}
