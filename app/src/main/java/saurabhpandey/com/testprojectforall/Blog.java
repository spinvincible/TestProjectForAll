package saurabhpandey.com.testprojectforall;

/**
 * Created by Nixxmare on 1/3/2017.
 */

public class Blog {

private String Desc, Title, imageUrl;

    public Blog(String desc, String title, String imageUrl) {
        Desc = desc;
        Title = title;
        this.imageUrl = imageUrl;
    }

    public Blog(){

    }
    public String getDesc() {
        return Desc;
    }


    public String getTitle() {
        return Title;
    }


    public String getImageUrl() {
        return imageUrl;
    }

}
