package fil.android.project.mydofusprofessions.data.api.model;

import java.util.List;

public class Profession {

    private String ankamaId;

    private String name;

    private String imgUrl;

    private String description;

    private List<String> harvests;

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

    public List<String> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<String> harvests) {
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
