/*
 AccountList.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class holds a list of all the accounts. It implements the BankOperations
 interface to handle operations to the list. Has get methods to get a specific
 account.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements BankOperations{
    private List<Account> accounts = new ArrayList<Account>();
    
    //Constructor.
    public AccountList() {    
    }
    
    //Interface methods.
    @Override
    public void addAccount(Account a) {
        accounts.add(a);
    }
    
    @Override
    public void deleteAccount(Account a) {
        accounts.removeIf((Account acc) -> acc.getAccountID() == a.getAccountID());
    }
    
    @Override
    public void updateAccount(Account a, int branchID,
            double amount) {
        a.setBranchID(branchID);
        a.setAmount(amount);
    }
    
    //Get Methods.
    public Account getAccountViaID(int accID) throws CustomExceptions{
        for (Account a : accounts) {
            if(a.getAccountID() == accID) {
                return a;
            }
        }
        throw new CustomExceptions("there is a problem please check again");
        //return null;
    }
    
    public String getAccounts() {
        StringBuilder info = new StringBuilder();
        String infoOut;
        for (Account a : accounts) {
            info.append(a.toString()).append("\n");
        }
        infoOut = info.toString();
        return infoOut;
    } 
}
