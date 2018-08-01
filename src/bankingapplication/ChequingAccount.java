/*
 ChequingAccount.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class is a concrete class of Account.java. It adds the variable 
 accountType and overrides the abstract classes of Account.java.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

public class ChequingAccount extends Account {
    
    private String accountType;
    
    //Constructor.
    public ChequingAccount(int accountID, int branchID, double amount) 
    {
        super(accountID, branchID, amount);
        accountType = "Chequing";
    }
    
    //Getters and setters.
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    //Overriden methods.
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
