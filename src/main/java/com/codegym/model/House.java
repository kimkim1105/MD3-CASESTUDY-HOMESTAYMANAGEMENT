package com.codegym.model;

public class House {
    private int id;
    private String name;
    private int typeId;
    private String designStyle;
    private String address;
    private int maxPeople;
    private String basicUtility;
    private int standardId;
    private String status;
    private String image;
    private float price;
    private String description;
    private String extraUtility;
    private float evalue;
    private int countsOfOder;

    public House() {
    }

    public House(String name, int typeId, String designStyle, String address, int maxPeople, String basicUtility, int standardId, String status, String image, float price, String description, String extraUtility, float evalue, int countsOfOder) {
        this.name = name;
        this.typeId = typeId;
        this.designStyle = designStyle;
        this.address = address;
        this.maxPeople = maxPeople;
        this.basicUtility = basicUtility;
        this.standardId = standardId;
        this.status = status;
        this.image = image;
        this.price = price;
        this.description = description;
        this.extraUtility = extraUtility;
        this.evalue = evalue;
        this.countsOfOder = countsOfOder;
    }

    public House(int id, String name, int typeId, String designStyle, String address, int maxPeople, String basicUtilityId, int standardId, String status, String image, float price, String description, String extraUtilityId, float evalue, int countsOfOder) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.designStyle = designStyle;
        this.address = address;
        this.maxPeople = maxPeople;
        this.basicUtility = basicUtilityId;
        this.standardId = standardId;
        this.status = status;
        this.image = image;
        this.price = price;
        this.description = description;
        this.extraUtility = extraUtilityId;
        this.evalue = evalue;
        this.countsOfOder = countsOfOder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDesignStyle() {
        return designStyle;
    }

    public void setDesignStyle(String designStyle) {
        this.designStyle = designStyle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getBasicUtility() {
        return basicUtility;
    }

    public void setBasicUtility(String basicUtility) {
        this.basicUtility = basicUtility;
    }

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtraUtility() {
        return extraUtility;
    }

    public void setExtraUtility(String extraUtility) {
        this.extraUtility = extraUtility;
    }

    public float getEvalue() {
        return evalue;
    }

    public void setEvalue(float evalue) {
        this.evalue = evalue;
    }

    public int getCountsOfOder() {
        return countsOfOder;
    }

    public void setCountsOfOder(int countsOfOder) {
        this.countsOfOder = countsOfOder;
    }
}
