package bean;

import java.io.Serializable;

public class LoveList implements Serializable {
    private int love_id;
    private int account_id;
    private int pet_id;
    public LoveList(){
    }

    public LoveList(int love_id, int account_id, int pet_id) {
        this.love_id = love_id;
        this.account_id = account_id;
        this.pet_id = pet_id;
    }

    public int getLove_id() {
        return love_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getPet() {
        return pet_id;
    }

    public void setLove_id(int love_id) {
        this.love_id = love_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setPet(int pet_id) {
        this.pet_id = pet_id;
    }
}
