package bean;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable {
    private int cmt_id;
    private int account_id;
    private Date time_cmt;
    private String content;
    private int pet_id;
    private int like;
    private int dislike;
    private String photo;

    public Comment(int cmt_id, int account_id, Date time_cmt, String content, int pet_id, int like, int dislike, String photo) {
        this.cmt_id = cmt_id;
        this.account_id = account_id;
        this.time_cmt = time_cmt;
        this.content = content;
        this.pet_id = pet_id;
        this.like = like;
        this.dislike = dislike;
        this.photo = photo;
    }

    public Comment() {
    }

    public int getCmt_id() {
        return cmt_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public Date getTime_cmt() {
        return time_cmt;
    }

    public String getContent() {
        return content;
    }

    public int getPet_id() {
        return pet_id;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }

    public String getPhoto() {
        return photo;
    }

    public void setCmt_id(int cmt_id) {
        this.cmt_id = cmt_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setTime_cmt(Date time_cmt) {
        this.time_cmt = time_cmt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cmt_id=" + cmt_id +
                ", account_id=" + account_id +
                ", time_cmt=" + time_cmt +
                ", content='" + content + '\'' +
                ", pet_id=" + pet_id +
                ", like=" + like +
                ", dislike=" + dislike +
                ", photo='" + photo + '\'' +
                '}';
    }
}
