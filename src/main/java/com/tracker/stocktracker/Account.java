package com.tracker.stocktracker;

public class Account {

    private String name;
    private double balance;
    private Stock[] portfolio;
    private int pointer;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.pointer = 0;
        this.portfolio = new Stock[5];
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (this.balance >= amount) {

            this.balance -= amount;
        }
        else {
            // throw some exception
        }
    }

    public Stock[] getPort() {

        Stock[] temp = new Stock[this.pointer];

        for (int i = 0; i < this.pointer; i++) {
            temp[i] = this.portfolio[i];

        }
        return temp;
    }

    public void Buy(String s, int quantity, boolean isETF) {

        if (this.pointer == this.portfolio.length) {
            //throw Max portfolio size exception
        }

        StockApi api = new StockApi();
        Stock stock = api.fetch(s, quantity, isETF);

        this.portfolio[this.pointer] = stock;
        this.pointer++;
    }

}
