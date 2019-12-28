package fil.android.project.mydofusprofessions.presentation.detail.modelview;

import java.util.List;

import fil.android.project.mydofusprofessions.data.api.model.Harvest;

public class ProfessionDetailsViewModel {

    private String ankamaId;

    private String name;

    private String imgUrl;

    private String description;

    private List<Harvest> harvests;

    private boolean isLearned;

    private int personalLvl;


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

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<Harvest> harvests) {
        this.harvests = harvests;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }

    public int getPersonalLvl() {
        return personalLvl;
    }

    public void setPersonalLvl(int personalLvl) {
        this.personalLvl = personalLvl;
    }
}
