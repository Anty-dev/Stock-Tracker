package com.tracker.stocktracker;

public class ETF extends Stock {

    private double expenseRatio;

    public ETF(String symbol, double price, int quantity) {
        super(symbol, price, quantity);
        this.expenseRatio = 0;
    }



}
