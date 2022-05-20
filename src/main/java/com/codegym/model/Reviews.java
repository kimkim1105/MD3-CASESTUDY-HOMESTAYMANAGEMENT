package com.codegym.model;

public class Reviews {
    private int id;
    private int houseId;
    private int userId;
    private int evalue;
    private String review;

    public Reviews() {
    }

    public Reviews(int id, int houseId, int userId, int evalue, String review) {
        this.id = id;
        this.houseId = houseId;
        this.userId = userId;
        this.evalue = evalue;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEvalue() {
        return evalue;
    }

    public void setEvalue(int evalue) {
        this.evalue = evalue;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
