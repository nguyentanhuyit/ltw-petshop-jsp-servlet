package bean;

import java.io.Serializable;

public class Sale implements Serializable {
    private double rate;
    private int pet_id;
    private String begin_date;
    private String end_date;

    public Sale( double rate, int pet_id, String begin_date, String end_date) {
        this.rate = rate;
        this.pet_id = pet_id;
        this.begin_date = begin_date;
        this.end_date = end_date;
    }

    public Sale() {
    }


    public double getRate() {
        return rate;
    }

    public int getPet_id() {
        return pet_id;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }


    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRateSale(){
        return rate*100 + "%";
    }

    @Override
    public String toString() {
        return "Sale{" +
                "rate=" + rate +
                ", pet_id=" + pet_id +
                ", begin_date='" + begin_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}
