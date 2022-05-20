package com.codegym.model;

public class Account {
    private String username;
    private String password;
    private String firstname;
    private String role;

    public Account() {
    }

    public Account(String username, String password, String firstname, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.role = role;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
