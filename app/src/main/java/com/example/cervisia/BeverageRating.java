package com.example.cervisia;

public class BeverageRating {

    //Attributes
    private String beverageName;
    private String beveragePrice;

    //Constructors
    public BeverageRating(String beverageName) {
        this.beverageName = beverageName;
    }

    public BeverageRating(String beverageName, String beveragePrice) {
        this.beverageName = beverageName;
        this.beveragePrice = beveragePrice;
    }

    //Getter and Setter
    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public String getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(String beveragePrice) {
        this.beveragePrice = beveragePrice;
    }
}
