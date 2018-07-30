/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

/**
 *
 * @author Kirill
 */
public class SavingsAccount extends Account {
    private String accountType;
    
    public SavingsAccount(int accountID, int branchID, double amount) 
    {
        super(accountID, branchID, amount);
        accountType = "Savings";
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    @Override
    public String add() { 
        return String.format("%s has been added.", toString());
    }
    
    @Override
    public String update() {    
        return String.format("%s is now the current account.", toString());
    }
    
    @Override
    public String delete() {   
        return String.format("%s has been deleted.", toString());
    }
    
    @Override
    public String toString() {
        return String.format("%s of type %s", super.toString(), 
                getAccountType());
    }
}
