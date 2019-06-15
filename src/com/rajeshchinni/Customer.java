package com.rajeshchinni;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

//    public Customer(String name, ArrayList<Double> transactions) {
//        this.name = name;
//        this.transactions = transactions;
//    }

    // constructor
    public Customer(String name, double initialAmount) { // initialAmount is manually added
        this.name = name;
        this.transactions = new ArrayList<Double>(); // manually done
        addTransaction(initialAmount); // calling the method
    }

    //getter
    public String getName() {
        return name;
    }

    //getter
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    // method
    public void addTransaction(double amount){
        this.transactions.add(amount); // this is autoboxing
    }
}
