/*
 Account.java
 Kirill Viktorovich Okhotnitski
 26 July 2018
 This package uses JDK v1.8.0_171
 */
package bankingapplication;

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
                    updateAccount(input, accts);
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
    
    public static int addAccount(Scanner input, int accountNo, AccountList accts){int status = 0; Account acc;
            
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
                    System.out.println(acc.add());
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
                    System.out.println(accts.getAccountViaID(accID).delete());
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
    
    public static int updateAccount(Scanner input, AccountList accts) {
        int status = 0;
        int accID = 0;
        int branchID = 0;
        do {
            System.out.print("Please enter the account ID:");
            accID = Integer.parseInt(input.nextLine());
            System.out.println("You are updating: " 
                    + accts.getAccountViaID(accID).toString());
            System.out.print("Please enter the updated amount:");
            String strAmount = input.nextLine();
            double amount = Double.parseDouble(strAmount);
            System.out.print("Update branch ID? (Y or N)");
            String confirm = input.nextLine();
            switch (confirm) {
                case "Y":
                    System.out.print("Please enter the updated branchID:");
                    String strBranchID = input.nextLine();
                    branchID = Integer.parseInt(strBranchID);
                    status = 1;
                    break;
                case "N":
                    branchID = accts.getAccountViaID(accID).getBranchID();
                    status = 2;
                    break;
                default:
                    break;
            }
            if (status != 0) {
                accts.updateAccount(accts.getAccountViaID(accID),branchID, 
                        amount);
            }
        } while (status == 0);
        System.out.println(accts.getAccountViaID(accID).update());
        return status;
    }//End of method updateAccounts
    
    public static void displayAccounts(AccountList accts) {
        System.out.print(accts.getAccounts());
    }//End of method displayAccounts
}//End of class BankingSystemTest
