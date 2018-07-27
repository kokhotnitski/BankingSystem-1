/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

public class ChequingAccount extends Account {
    private double amount;
    
    public ChequingAccount(int accountID, int branchID, 
            double amount) {
        super(accountID, "Chequing", branchID);
        //TODO: Insert applicable exceptions here
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    //TODO: Add string output for the inherited methods...
    @Override
    public void add() { 
        //TODO: here
    }
    
    @Override
    public void update() {    
        //TODO: here
    }
    
    @Override
    public void delete() {   
        //TODO: and here
    }
    
    @Override
    public String toString() {
        return String.format("%s, amount: %.2f", super.toString(), getAmount());
    }
}
