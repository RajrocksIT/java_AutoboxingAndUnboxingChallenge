package com.rajeshchinni;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    // Constructor
    public Branch(String branchName) {
        this.name = branchName;
        this.customers = new ArrayList<Customer>(); // manually done
    }

    // getter
    public String getname() {
        return name;
    }

    // getters
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // method
    public boolean newCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName, initialAmount));  // like a new instance
            return true;
        }
        return false;
    }

    //  method
    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null){
            existingCustomer.addTransaction(amount);  // addTransaction() is a method in Customer class
            return true;
        }
        return false;
    }

    // method
    private Customer findCustomer(String customerName){   // return type is Customer
        for (int i =0; i<this.customers.size(); i++){
            Customer checkedCustomer = this.customers.get(i); // unboxing
            if (checkedCustomer.getName().equals(customerName)){   // https://www.geeksforgeeks.org/difference-equals-method-java/
                return checkedCustomer;
            }
        }
        return null;
    }

}
