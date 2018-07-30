/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author jeremye
 */
public class BankingApplication extends JFrame {
    AccountList accts = new AccountList(); //List for all the accounts
    //Kirill: New variable
    private static int accountNo = 1;
    
    String[] columns = new String[] {
            "account No", "accountType", "branch No", "amount"
        };
    DefaultTableModel model = new DefaultTableModel(columns,0);
    JTable table = new JTable(model);
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                       
        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankingApplication().setVisible(true);
            }
        });
        
    }
    
    //BankingApplication Constructor
    public BankingApplication(){
        
        initComponents();
        getRootPane().setDefaultButton(addAccountButton);
        pack();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
        
           
    }
    
    private void initComponents() {  
        
        GridBagConstraints c = new GridBagConstraints();
        
        mainPanel = new javax.swing.JPanel();
        
        addAccountButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        updateAccountButton = new javax.swing.JButton();
        
        setTitle("Banking Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
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
        
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                //call to modal to enter details
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
        
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                
                //remowe account from table
                int rowIndex = table.getSelectedRow();
                if(rowIndex == -1)return;
                                
                //remove account from arraylist
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
        
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //get value account from table
                int rowIndex = table.getSelectedRow();
                if(rowIndex == -1)return;
                                                
                //get account from arraylist
                int accountNo = AddModal.convertToInteger(model.getValueAt(rowIndex, 0).toString());
                
                try{
                    Account acc = accts.getAccountViaID(accountNo);


                    //call to update modal
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
         
        //add the table to the frame
        c.gridx = 0;
        c.gridy = 4;
        mainPanel.add(new JScrollPane(table),c);
        
    }    
     
    private static void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }  
    
    //Kirill: New Method
    public static int getAccountNo() {
        return accountNo;
    }
    
    //Kirill: New Method   
    public static void setAccountNo(int accountNo) {
        BankingApplication.accountNo = accountNo;
    }
    
    private javax.swing.JPanel mainPanel;
    
    private javax.swing.JButton addAccountButton;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton updateAccountButton;
}


