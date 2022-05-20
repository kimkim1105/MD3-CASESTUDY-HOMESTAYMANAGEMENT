package com.codegym.model;

public class BasicUtility {
    private int id;
    private String utility;

    public BasicUtility() {
    }

    public BasicUtility(int id, String utility) {
        this.id = id;
        this.utility = utility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }
}
