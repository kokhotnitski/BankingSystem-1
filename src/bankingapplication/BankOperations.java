/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

public interface BankOperations {
    public void addAccount(Account a);
    public void deleteAccount(Account a);
    public void updateAccount(Account a, int branchID, double amount);
}
