package fil.android.project.mydofusprofessions.data.api.model;

import java.util.List;

/**
 * Object received from the API to represent a harvest
 */
public class Harvest {

    private String imgUrl;

    private String name;

    private int ankamaId;

    private int level;

    private List<String> location;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnkamaId() {
        return ankamaId;
    }

    public void setAnkamaId(int ankamaId) {
        this.ankamaId = ankamaId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }
}
