package com.tracker.stocktracker;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Stock {

    @JsonProperty("01. symbol")
    private String symbol;
    @JsonProperty("05. price")
    private double price;
    private int quantity;
    private int totalShares;


    // Still considering if totalPrice should be here or in account class

    public Stock() {
        this.symbol = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Stock(String symbol, double price, int quantity) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.totalShares = quantity;
        //this.totalPrice = price * quantity;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addShares(int total) {
        this.totalShares += total;
    }

    public void removeShares(int total) {
        if (this.totalShares - total < 0) {
            // throw some exception
        }
        else {
            this.totalShares -= total;
        }
    }





}
