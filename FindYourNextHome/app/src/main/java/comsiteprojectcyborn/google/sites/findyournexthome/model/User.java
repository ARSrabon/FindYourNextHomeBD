package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/14/16.
 */

public class User extends Person {
    public String username;
    public String password;

    public User(String fullName, String nId, String mobileNum, String username, String password) {
        super(fullName, nId, mobileNum);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
