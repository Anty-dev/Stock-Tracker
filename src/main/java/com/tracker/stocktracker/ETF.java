package com.tracker.stocktracker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ETF extends Stock {

    @JsonProperty("net_expense_ratio")
    private double expenseRatio;

    public ETF() {
        super();
        this.expenseRatio = 0;
    }

    public ETF(String symbol, double price, int quantity) {
        super(symbol, price, quantity);
        this.expenseRatio = 0;
    }

    public ETF(Stock s, int quantity) {
        super(s.getSymbol(), s.getPrice(), quantity);
        this.expenseRatio = 0;
    }

    public double getExpenseRatio() {
        return expenseRatio;
    }

    public void setExpenseRatio(double expenseRatio) {
        this.expenseRatio = expenseRatio;
    }

}
