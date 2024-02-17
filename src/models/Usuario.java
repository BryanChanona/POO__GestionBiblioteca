package models;

public class Usuario {
    private String userName;
    private String passwordUser;

    public Usuario(String userName, String passwordUser) {
        this.userName = userName;
        this.passwordUser = passwordUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
