package bean;

import java.io.Serializable;
import java.sql.Date;

public class SubComment implements Serializable {
    private int sub_cmt_id;
    private  String sub_cmt_content;
    private Date sub_cmt_date;
    private int account_id;
    private int cmt_id;
    private String photo;
    private int like;
    private int dislike;

    public SubComment(int sub_cmt_id, String sub_cmt_content, Date sub_cmt_date, int account_id,int cmt_id, String photo, int like, int dislike) {
        this.sub_cmt_id = sub_cmt_id;
        this.sub_cmt_content = sub_cmt_content;
        this.sub_cmt_date = sub_cmt_date;
        this.cmt_id = cmt_id;
        this.account_id = account_id;
        this.photo = photo;
        this.like = like;
        this.dislike = dislike;
    }

    public SubComment() {
    }

    public int getSub_cmt_id() {
        return sub_cmt_id;
    }

    public String getSub_cmt_content() {
        return sub_cmt_content;
    }

    public Date getSub_cmt_date() {
        return sub_cmt_date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getPhoto() {
        return photo;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setSub_cmt_id(int sub_cmt_id) {
        this.sub_cmt_id = sub_cmt_id;
    }

    public void setSub_cmt_content(String sub_cmt_content) {
        this.sub_cmt_content = sub_cmt_content;
    }

    public void setSub_cmt_date(Date sub_cmt_date) {
        this.sub_cmt_date = sub_cmt_date;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getCmt_id() {
        return cmt_id;
    }

    public void setCmt_id(int cmt_id) {
        this.cmt_id = cmt_id;
    }
}
