/*
 BankOperations.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This interface is used for handling operations on account objects.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

public interface BankOperations {
    public void addAccount(Account a);
    public void deleteAccount(Account a);
    public void updateAccount(Account a, int branchID, double amount);
}
