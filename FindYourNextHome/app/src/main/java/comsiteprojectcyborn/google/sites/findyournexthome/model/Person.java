package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/20/16.
 */

public class Person {
    private String fullName;
    private String nId;
    private String mobileNum;
    private String phoneNum;
    private String city;
    private String area;

    public Person(){

    }

    public Person(String fullName, String nId, String mobileNum, String phoneNum, String city, String area) {
        this.fullName = fullName;
        this.nId = nId;
        this.mobileNum = mobileNum;
        this.phoneNum = phoneNum;
        this.city = city;
        this.area = area;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
