package fil.android.project.mydofusprofessions.presentation.detail;

import android.util.Log;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.repository.detail.ProfessionDetailRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * profession detail presenter to make calls to data repositories
 */
public class ProfessionDetailPresenter implements ProfessionDetailContract.Presenter {

    private ProfessionDetailContract.View professionDetailContractView;
    private ProfessionDetailRepository professionDetailRepository;
    private CompositeDisposable compositeDisposable;


    public ProfessionDetailPresenter(ProfessionDetailRepository professionDetailRepository) {
        this.professionDetailRepository = professionDetailRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    /**
     * make a call to the repository to get the details of a profession by its id
     * @param id the id of the profession to get
     */
    @Override
    public void getDetailsById(String id) {
        professionDetailRepository.getProfessionById(id).subscribeOn(Schedulers.io())
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

    /**
     * make a call to the repository to mark a profession as learned with its id
     * @param professionId the id of the profession to mark as learned
     */
    @Override
    public void addProfessionAsLearned(String professionId) {
        compositeDisposable.add(professionDetailRepository.markProfessionAsLearned(professionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        professionDetailContractView.onProfessionAddedAsLearned();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERREUR = ", e.getMessage());
                    }
                }));
    }

    /**
     * make a call to the repository to unmark a profession from learned
     * @param professionId the id of the profession to remove from learned
     */
    @Override
    public void removeProfessionFromLearned(String professionId) {
        compositeDisposable.add(professionDetailRepository.unmarkProfessionAsLearned(professionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        professionDetailContractView.onProfessionRemovedFromLearned();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERREUR = ", e.getMessage());
                    }
                }));
    }

    /**
     * attach view
     * @param view the view to attach
     */
    @Override
    public void attachView(ProfessionDetailContract.View view) {
        this.professionDetailContractView = view;
    }

}
