package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/20/16.
 */

public class Person {
    private String fullName;
    private String nId;
    private String mobileNum;

    public Person(String fullName, String nId, String mobileNum) {
        this.fullName = fullName;
        this.nId = nId;
        this.mobileNum = mobileNum;
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
}
