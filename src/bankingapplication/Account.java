/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

public abstract class Account {
    private int accountID; 
    private int branchID;
    private double amount;
    
    //constructor
    public Account(int accountID, int branchID, double amount) {
        this.accountID = accountID;
        this.branchID = branchID;
        this.amount = amount;
    }
    
    public int getAccountID() {
        return accountID;
    }
    
    public int getBranchID() {
        return branchID;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public abstract String add();
    public abstract String update();
    public abstract String delete();
    
    @Override
    public String toString() {
        return String.format("Account: %d from branch %d, amount: %.2f", 
                getAccountID(), getBranchID(), getAmount());
    }
}
