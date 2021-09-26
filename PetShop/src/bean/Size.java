package bean;

import java.io.Serializable;

public class Size implements Serializable {
    private int size_id;
    private String size_name;

    public Size(int size_id, String size_name) {
        this.size_id = size_id;
        this.size_name = size_name;
    }

    public Size() {
    }

    public int getSize_id() {
        return size_id;
    }

    public String getSize_name() {
        return size_name;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    @Override
    public String toString() {
        return "Size{" +
                "size_id=" + size_id +
                ", size_name='" + size_name + '\'' +
                '}';
    }
}
