package com.codegym.model;

public class ExtraUtility {
    private int id;
    private String extraUtility;

    public ExtraUtility() {
    }

    public ExtraUtility(int id, String extraUtility) {
        this.id = id;
        this.extraUtility = extraUtility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtraUtility() {
        return extraUtility;
    }

    public void setExtraUtility(String extraUtility) {
        this.extraUtility = extraUtility;
    }
}
