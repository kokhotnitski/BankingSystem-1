/*
 Account.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class is the abstract class for all types of accounts. It holds the 
 account number, branch number and amount variables. As well it has getters and
 setters for the variables.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

public abstract class Account {
    private int accountID; 
    private int branchID;
    private double amount;
    
    //Constructor.
    public Account(int accountID, int branchID, double amount) {
        this.accountID = accountID;
        this.branchID = branchID;
        //Accepts positive and negative amounts, truncates value to 2 decimal
        //places.
        if(amount >= 0) {
            this.amount = Math.floor(amount * 100) / 100;
        } else {
            this.amount = Math.ceil(amount * 100) / 100;
        }
    }
    
    //Getters and setters.
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
    
    //Abstract methods.
    public abstract String add();
    public abstract String update();
    public abstract String delete();
    
    @Override
    public String toString() {
        return String.format("Account: %d from branch %d, amount: %.2f", 
                getAccountID(), getBranchID(), getAmount());
    }
}
