package bean;

import java.io.Serializable;
import java.text.DecimalFormat;

public class DiscountCode implements Serializable {
    String code;
    double rate;

    public DiscountCode(String code, double rate) {
        this.code = code;
        this.rate = rate;
    }

    public DiscountCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "DiscountCode{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                '}';
    }

    public static String percentFormat(double rate) {
        String pattern = "###.##%";
        DecimalFormat format = new DecimalFormat(pattern);
        String stringPercent = format.format(rate);

        return stringPercent;
    }

    public static void main(String[] args) {
        double rate = 0.02;
        System.out.println(percentFormat(rate));
    }
}
