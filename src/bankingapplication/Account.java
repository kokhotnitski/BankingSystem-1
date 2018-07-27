/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingsystem;

public abstract class Account {
    private final int accountID;
    private final String accountType;
    private final int branchID;
    
    //constructor
    public Account(int accountID, String accountType, int branchID) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.branchID = branchID;
    }
    
    public int getAccountID() {
        return accountID;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public int getBranchID() {
        return branchID;
    }
    
    public abstract void add();
    public abstract void update();
    public abstract void delete();
    
    //TODO: include methods from interface to work on database.
    @Override
    public String toString() {
        return String.format("Account: %d of type %s from branch %d", accountID,
        accountType, branchID);
    }
}
