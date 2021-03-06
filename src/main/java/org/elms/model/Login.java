package org.elms.model;

public class Login {

    private int id;
    private String userName;
    private String password;
    private String firstName;

    public Login(){

    }

    public Login(int id, String userName, String password, String firstName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString(){
        return "Login{" +
                "id" + id
                +", userName='" + userName + '\''
                +", password='"+ password + '\''
                +", firstName='"+ firstName + '\''
                +'}';
    }

}
