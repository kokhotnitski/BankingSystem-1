/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

public class ChequingAccount extends Account {
    
    private String accountType;
    
    public ChequingAccount(int accountID, int branchID, double amount) 
    {
        super(accountID, branchID, amount);
        accountType = "Chequing";
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
