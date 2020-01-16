package fil.android.project.mydofusprofessions.data.repository.detail;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface ProfessionDetailRepository {
    Single<Profession> getProfessionById(String id);

    Completable markProfessionAsLearned(String professionId);

    Completable unmarkProfessionAsLearned(String professionId);
}
