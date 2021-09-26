package bean;

import java.io.Serializable;

public class Photo implements Serializable {
    private int photo_id;
    private String photo_main;
    private String photo_main_1;
    private String photo_main_2;
    private String photo_main_3;
    private String photo_main_4;

    public Photo() {
    }

    public Photo(int photo_id, String photo_main, String photo_main_1, String photo_main_2, String photo_main_3, String photo_main_4) {
        this.photo_id = photo_id;
        this.photo_main = photo_main;
        this.photo_main_1 = photo_main_1;
        this.photo_main_2 = photo_main_2;
        this.photo_main_3 = photo_main_3;
        this.photo_main_4 = photo_main_4;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public String getPhoto_main() {
        return photo_main;
    }

    public String getPhoto_main_1() {
        return photo_main_1;
    }

    public String getPhoto_main_2() {
        return photo_main_2;
    }

    public String getPhoto_main_3() {
        return photo_main_3;
    }

    public String getPhoto_main_4() {
        return photo_main_4;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public void setPhoto_main(String photo_main) {
        this.photo_main = photo_main;
    }

    public void setPhoto_main_1(String photo_main_1) {
        this.photo_main_1 = photo_main_1;
    }

    public void setPhoto_main_2(String photo_main_2) {
        this.photo_main_2 = photo_main_2;
    }

    public void setPhoto_main_3(String photo_main_3) {
        this.photo_main_3 = photo_main_3;
    }

    public void setPhoto_main_4(String photo_main_4) {
        this.photo_main_4 = photo_main_4;
    }


}
