/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements BankOperations {
    private List<Account> accounts = new ArrayList<Account>();
    
    public AccountList() {
        
    }
    
    @Override
    public void addAccount(Account a) {
        a.add();
        accounts.add(a);
    }
    
    @Override
    public void deleteAccount(Account a) {
        a.delete();
        accounts.removeIf((Account acc) -> acc.getAccountID() == a.getAccountID());
    }
    
    //TODO: Finish this method
    @Override
    public void updateAccount(Account a) {
        a.update();
    }
    
    public Account getAccountViaID(int accID) {
        for (Account a : accounts) {
            if(a.getAccountID() == accID) {
                return a;
            }
        }
        return null;
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
