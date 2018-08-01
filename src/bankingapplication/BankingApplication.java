/*
 BankingApplication.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This application runs a bank account management GUI. The GUI displays several
 accounts that shows the account number, account type, branch number and the 
 amount. Accounts can be added, updated and deleted and are always displayed on
 the main window. This class is the static main class that begins the 
 application. It handles the main window, and calls upon the other classes to
 handle the rest of the operations.
 This application uses JDK v1.8.0_171
 */
package bankingapplication;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class BankingApplication extends JFrame {
    AccountList accts = new AccountList(); //List for all the accounts.
    private static int accountNo = 1;
    
    String[] columns = new String[] {
            "account No", "accountType", "branch No", "amount"
        };
    DefaultTableModel model = new DefaultTableModel(columns,0);
    JTable table = new JTable(model);
    
    //Application begins here:
    public static void main(String[] args) {
        //Create and display the form.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankingApplication().setVisible(true);
            }
        });  
    }
    
    //BankingApplication Constructor.
    public BankingApplication(){
        
        initComponents();
        getRootPane().setDefaultButton(addAccountButton);
        pack();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));     
    }
    
    //This method initiates all the buttons, button events and the table. 
    private void initComponents() {  
        
        GridBagConstraints c = new GridBagConstraints();
        
        mainPanel = new javax.swing.JPanel();
        
        addAccountButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        updateAccountButton = new javax.swing.JButton();
        
        setTitle("Banking Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setLayout(new java.awt.GridBagLayout());
        mainPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(12, 12, 12, 12)));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        
        c.insets = new Insets(0, 0, 10, 0);
        
        table.setModel(model);
        
        addAccountButton.setText("Add Account");
        addAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        
               
        addAccountButton.setPreferredSize(new Dimension(200, 30));
        addAccountButton.setToolTipText("Add account.");
        
        //Add account action.
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                //Calls add modal to handle the add account button event.
                InputModals inputModal = new InputModals();
                inputModal.AddModal(accts, "add", table, model);
                
            }
        });

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(addAccountButton, c);
                
        deleteAccountButton.setText("Delete Account");
        deleteAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        deleteAccountButton.setPreferredSize(new Dimension(200, 30));
        deleteAccountButton.setToolTipText("Delete account.");
        
        //Delete account action.
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                
                //Removes the account from the table.
                int rowIndex = table.getSelectedRow();
                if(rowIndex == -1)return; //Exception if there is no account.
                                
                //Remove account from account list.
                int accountNo = AddModal.convertToInteger(model.getValueAt(rowIndex, 0).toString());
                
                try{
                
                    Account acc = accts.getAccountViaID(accountNo);
                    accts.deleteAccount(acc);

                    model.removeRow(rowIndex);
                    
                }catch(CustomExceptions e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Incorrect input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(deleteAccountButton, c);
        
        updateAccountButton.setText("Update Account");
        updateAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        updateAccountButton.setPreferredSize(new Dimension(200, 30));
        updateAccountButton.setToolTipText("Update account.");
        
        //Update account action.
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //Get value account from table.
                int rowIndex = table.getSelectedRow();
                if(rowIndex == -1)return;
                                                
                //Get account from account list.
                int accountNo = AddModal.convertToInteger(model.getValueAt(rowIndex, 0).toString());
                
                try{
                    Account acc = accts.getAccountViaID(accountNo);

                    //Call update modal to handle update action.
                    InputModals inputModal = new InputModals();
                    inputModal.UpdateModal(accts, acc, table, model, rowIndex);
                
                }catch(CustomExceptions e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Incorrect input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(updateAccountButton, c);
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
         
        //Add the table to the frame.
        c.gridx = 0;
        c.gridy = 4;
        mainPanel.add(new JScrollPane(table),c);
    }    
     
    private static void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }  
    
    public static int getAccountNo() {
        return accountNo;
    }
  
    public static void setAccountNo(int accountNo) {
        BankingApplication.accountNo = accountNo;
    }
    
    private javax.swing.JPanel mainPanel;
    
    private javax.swing.JButton addAccountButton;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton updateAccountButton;
}
