package fil.android.project.mydofusprofessions.presentation.list.adapter;

/**
 * profession item view model to display profession in the lists
 */
public class ProfessionItemViewModel {

    private String id;

    private String name;

    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}