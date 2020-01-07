package fil.android.project.mydofusprofessions.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProfessionEntity {

    @PrimaryKey
    @ColumnInfo(name = "ankama_id")
    @NonNull
    public String ankamaId;

    @NonNull
    public String getAnkamaId() {
        return ankamaId;
    }

    public void setAnkamaId(@NonNull String ankamaId) {
        this.ankamaId = ankamaId;
    }
}
