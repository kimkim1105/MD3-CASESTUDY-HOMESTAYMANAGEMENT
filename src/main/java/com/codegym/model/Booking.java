package com.codegym.model;

import java.util.Date;

public class Booking {
    private int id;
    private int houseId;
    private Date startTime;
    private Date endTime;
    private String status;

    public Booking() {
    }

    public Booking(int id, int houseId, Date startTime, Date endTime, String status) {
        this.id = id;
        this.houseId = houseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
