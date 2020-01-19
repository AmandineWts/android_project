package fil.android.project.mydofusprofessions.data.api.model;

import java.util.List;

/**
 * Object received from the API to represent a profession
 */
public class Profession {

    private String ankamaId;

    private String name;

    private String imgUrl;

    private String description;

    private boolean isLearned;

    private List<Harvest> harvests;


    public String getAnkamaId() {
        return ankamaId;
    }

    public void setAnkamaId(String ankamaId) {
        this.ankamaId = ankamaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }


    public List<Harvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<Harvest> harvests) {
        this.harvests = harvests;
    }
}
