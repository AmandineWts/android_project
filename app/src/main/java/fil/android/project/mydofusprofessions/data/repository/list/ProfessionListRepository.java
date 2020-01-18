package fil.android.project.mydofusprofessions.data.repository.list;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface ProfessionListRepository {

    Single<List<Profession>> listProfessions();

    Single<List<Profession>> listLearnedProfessions();

}
