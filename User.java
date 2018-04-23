package com.example.benjamin.databasemanager;

public class User {

    private String user;
    private String email;
    private String password;

    public User(String usernamePassed, String emailPassed, String passwordPassed) {
        user = usernamePassed;
        email = emailPassed;
        password = passwordPassed;
    }

    public String getName() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String namePassed) {
        user = namePassed;
    }

    public void setEmail(String emailPassed) {
        email = emailPassed;
    }

    public void setPassword(String passwordPassed) {
        password = passwordPassed;
    }

}
