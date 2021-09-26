package bean;

import java.io.Serializable;

public class Species implements Serializable {
    private int species_id;
    private String species_name;

    public Species() {
    }

    public Species(int species_id, String species_name) {
        this.species_id = species_id;
        this.species_name = species_name;
    }

    public int getSpecies_id() {
        return species_id;
    }

    public String getSpecies_name() {
        return species_name;
    }

    public void setSpecies_id(int species_id) {
        this.species_id = species_id;
    }

    public void setSpecies_name(String species_name) {
        this.species_name = species_name;
    }

    @Override
    public String toString() {
        return "Species{" +
                "species_id=" + species_id +
                ", species_name='" + species_name + '\'' +
                '}';
    }
}
