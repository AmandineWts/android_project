package fil.android.project.mydofusprofessions.data.repository.detail.mapper;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.database.entity.ProfessionEntity;

/**
 * mapper to map a Profession to a ProfessionEntity
 */
public class ProfessionToProfessionEntityMapper {

    /**
     * map a profession to a profession entity
     * @param profession the profession to map
     * @return the profession entity mapped
     */
    public ProfessionEntity map(Profession profession) {
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setAnkamaId(profession.getAnkamaId());
        return professionEntity;
    }

}
