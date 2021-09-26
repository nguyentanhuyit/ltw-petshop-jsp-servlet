package bean;

import java.io.Serializable;

public class Address implements Serializable {
    int address_id;
    String address_detail;
    String ward;
    String district;
    String province;

    public Address(int address_id, String address_detail, String ward, String district, String province) {
        this.address_id = address_id;
        this.address_detail = address_detail;
        this.ward = ward;
        this.district = district;
        this.province = province;
    }

    public Address(int address_id, String address_detail, String district, String province) {
        this.address_id = address_id;
        this.address_detail = address_detail;
        this.district = district;
        this.province = province;
    }

    public Address() {
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id='" + address_id + '\'' +
                ", address_detail='" + address_detail + '\'' +
                ", ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
