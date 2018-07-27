/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingsystem;

import java.util.Scanner;

public class BankingSystemTest {

    public static void main(String[] args) {
        AccountList accts = new AccountList(); //List for all the accounts
        inputMenu(accts);
    }

    //TODO: Handle possible exceptions
    public static void inputMenu(AccountList accts) {
        int accountNo = 1; //Used to assign ID to the accounts
        Boolean status = true; //status for the following do while loop
        Scanner input = new Scanner(System.in);
        String command;
        do {
            System.out.print("Enter command:");
            command = input.nextLine(); 
            switch(command)
            {
                case "add":
                    int ret = addAccount(input, accountNo, accts);
                    if(ret == 1) { //a value of 1 means the user did not cancel
                        accountNo++; //midway through adding an account
                    }
                    break;
                case "delete":
                    deleteAccount(input, accts);
                    break;
                case "display":
                    displayAccounts(accts);
                    break;
                case "update":
                    //TODO: the update method
                    break;
                case "cancel":
                    status = false;
                    break;
                default:
                    break;
            }
        } while (status);
        System.out.println("Program terminated.");
    }//End of method inputMenu
    
    public static int addAccount(Scanner input, int accountNo, 
            AccountList accts){
        int status = 0;
        Account acc;
        do {
            System.out.print("Please enter the type of account:");
            String command = input.nextLine(); 
            //TODO: Include the rest of the accounts once implemented
            switch(command)
            {
                case "chequing":
                    System.out.print("Please enter the amount (double):");
                    Double amt = input.nextDouble();
                    System.out.print("Please enter the branch ID (int):");
                    int branchID = input.nextInt();
                    acc = new ChequingAccount(accountNo, branchID, amt);
                    accts.addAccount(acc);
                    System.out.println(acc.toString());
                    status = 1;
                    break;
                case "cancel":
                    status = 2;
                    break;
                default:
                    break;
            }
        } while (status == 0);
        return status;
    }//End of method addAccount
    
    public static int deleteAccount(Scanner input, AccountList accts) {
        int status = 0;
        do {
            System.out.print("Please enter the account ID:");
            int accID = Integer.parseInt(input.nextLine());
            System.out.println("Are you sure you want to delete: " 
                    + accts.getAccountViaID(accID).toString() + " ? (Y or N)");
            String confirm = input.nextLine();
            switch (confirm) {
                case "Y":
                    accts.deleteAccount(accts.getAccountViaID(accID));
                    status = 1;
                    break;
                case "N":
                    status = 2;
                    break;
                default:
                    break;
            }
        } while (status == 0);
        return status;
    }//End of method deleteAccount
    
    public static void displayAccounts(AccountList accts) {
        System.out.print(accts.getAccounts());
    }//End of method displayAccounts
}//End of class BankingSystemTest
