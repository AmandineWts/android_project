package fil.android.project.mydofusprofessions.data.repository.list.mapper;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;

public class ProfessionToProfessionEntityMapper {

    public ProfessionEntity map(Profession profession) {
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setAnkamaId(profession.getAnkamaId());
        return professionEntity;
    }

}
