package fil.android.project.mydofusprofessions.presentation.detail;

import android.util.Log;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.detail.ProfessionDetailDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfessionDetailPresenter implements ProfessionDetailContract.Presenter {

    private ProfessionDetailContract.View professionDetailContractView;
    private ProfessionDetailDataRepository professionDetailDataRepository;

    public ProfessionDetailPresenter(ProfessionDetailDataRepository professionDetailDataRepository) {
        this.professionDetailDataRepository = professionDetailDataRepository;
    }

    @Override
    public void getDetailsById(String id) {
        professionDetailDataRepository.getProfessionById(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Profession>() {

                    @Override
                    public void onSuccess(Profession profession) {
                        professionDetailContractView.displayProfessionWithDetails(profession);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Erreur de requête", e.getMessage());
                    }
                });
    }

    @Override
    public void attachView(ProfessionDetailContract.View view) {
        this.professionDetailContractView = view;
    }
}
