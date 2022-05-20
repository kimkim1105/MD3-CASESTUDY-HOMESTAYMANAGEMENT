package com.codegym.model;

import java.util.Date;

public class Orders {
    private int id;
    private int houseId;
    private int useId;
    private String rentType;
    private float rentalCost;
    private Date startTime;
    private Date endTime;
    private float total;
    private String payments;

    public Orders() {
    }

    public Orders(int id, int houseId, int useId, String rentType, float rentalCost, Date startTime, Date endTime, float total, String payments) {
        this.id = id;
        this.houseId = houseId;
        this.useId = useId;
        this.rentType = rentType;
        this.rentalCost = rentalCost;
        this.startTime = startTime;
        this.endTime = endTime;
        this.total = total;
        this.payments = payments;
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

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public float getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }
}
