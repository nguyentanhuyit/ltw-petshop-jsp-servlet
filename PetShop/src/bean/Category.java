package bean;

import java.io.Serializable;

public class Category implements Serializable {
    private int category_id;
    private String category_name;
    private int species_id;
    private String photo;

    public Category(int category_id, String category_name, int species_id, String photo) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.species_id = species_id;
        this.photo = photo;
    }
    public Category(){}

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public int getSpecies_id() {
        return species_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setSpecies_id(int species_id) {
        this.species_id = species_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", species_id=" + species_id +
                '}';
    }
}
