package com.rajeshchinni;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    // contructor
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>(); // manually done
    }

    //  method
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    //  method
    public boolean addCustomer(String branchName, String customerName, double intialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.newCustomer(customerName, intialAmount); // newCustomer() method in Branch class has a return type boolean
        }
        return false;
    }

    //  method
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerName, amount);  // addCustomerTransaction() method in Branch class has a return type boolean
        }
        return false;
    }

    // method
    private Branch findBranch(String branchName){     // return type is branch
        for (int i =0; i<this.branches.size(); i++){
            Branch checkedBranch = this.branches.get(i);  //unboxing
            if (checkedBranch.getname().equals(branchName)){    // https://www.geeksforgeeks.org/difference-equals-method-java/
                return checkedBranch;
            }
        }
        return null;
    }

    //  method
    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch specific_branch = findBranch(branchName);
        if (specific_branch != null){
            System.out.println("Customers details for branch: " + specific_branch.getname());
            ArrayList<Customer> specific_branch_Customers = specific_branch.getCustomers();  // getter called
            for (int i =0; i< specific_branch_Customers.size(); i++){
                Customer branchCust = specific_branch_Customers.get(i); // specific_branch_Customers.get(i) holds customer name and transactions
                System.out.println("Customer: " + branchCust.getName() + " [" + (i+1) + "]");
                if (showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCust.getTransactions();
                    for (int j = 0; j<transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] amount " + transactions.get(j)); // unboxing
                    }

                }
            }
            return true;
        }else {
            return false;
        }
    }



}
