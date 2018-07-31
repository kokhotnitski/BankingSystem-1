/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeremye
 */
public class UpdateModal extends DataTypeConvertor {
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
     
    public void showUpdateModal(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex){
                
        showUpdateFrame textFieldFrame = new showUpdateFrame(accList, acc, table, model, rowIndex);
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 300);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);
    }
    
}

class showUpdateFrame extends JFrame {
    
    private final  JLabel label1;
    private final  JLabel label2;
    private final  JLabel label3;
    private final  JButton addDetails;
    
    public showUpdateFrame(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex){
        
        //still busy wtih this development
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        
        //this is a label
        label1 = new JLabel("Type of account:");
        add(label1);
        
        //this is a textfield to input values
        UpdateModal.textField1 = new JTextField(10);
        add(UpdateModal.textField1); // add textField1 to J
        
         //this is a label
        label2 = new JLabel("Enter the amount");
        add(label2);
        
        //this is a textfield to input values
        UpdateModal.textField2 = new JTextField(10);
        add(UpdateModal.textField2);
        
         //this is a label
        label3 = new JLabel("enter the branch ID");
        add(label3);
        
        //this is a textfield to input values
        UpdateModal.textField3 = new JTextField(10);
        add(UpdateModal.textField3);
        
        //this is to preset the values at the text fields
        setText(acc, model, rowIndex);
        
        //this is a button to submit details
        addDetails = new JButton("Update");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        
        addDetails.addActionListener(new java.awt.event.ActionListener() {
            
            //Kirill: Edited this method
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                boolean status = true; //control for adding the data
                
                accList.deleteAccount(acc);
                
                if(UpdateModal.CheckInteger(UpdateModal.textField3.getText()) == false)return;
                if(UpdateModal.CheckDouble(UpdateModal.textField2.getText()) == false)return;
                
                int accountNo = acc.getAccountID();
                int branchId = UpdateModal.convertToInteger(UpdateModal.textField3.getText());
                Double amount = UpdateModal.convertToDouble(UpdateModal.textField2.getText());
                String accountType = UpdateModal.textField1.getText();
                Account acc;
                switch(accountType.toLowerCase()) {
                    case "chequing":
                        //insert data into arraylist
                        
                        acc = new ChequingAccount(accountNo, branchId, amount);
                        accList.addAccount(acc);
                        break;
                    case "credit":
                        acc = new CreditAccount(accountNo, branchId, amount);
                        accList.addAccount(acc);
                        break;
                    case "loan":
                        acc = new LoanAccount(accountNo, branchId, amount);
                        accList.addAccount(acc);
                        break;
                    case "savings":
                        acc = new SavingsAccount(accountNo, branchId, amount);
                        accList.addAccount(acc);
                        break;
                    default:
                        status = false;
                        break;
                }
                
                if(status == true){
                    //add imput values to the table
                    String[] row = {Integer.toString(accountNo) , accountType,
                        UpdateModal.textField3.getText(), 
                        UpdateModal.textField2.getText()};
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    
                    model.removeRow(rowIndex);
                    model.insertRow(rowIndex, row);
                    
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "The inputted account "
                            + "type is unknown.", "Unknown account type", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    private void setText(Account acc, DefaultTableModel model, int rowIndex){
        
        String accountType  = model.getValueAt(rowIndex, 1).toString();
        
        if("chequing".equals(accountType)){
            ChequingAccount chequeAcc = (ChequingAccount) acc;
            UpdateModal.textField1.setText(chequeAcc.getAccountType());
        }
        if("credit".equals(accountType)){
            CreditAccount creditAcc = (CreditAccount) acc;
            UpdateModal.textField1.setText(creditAcc.getAccountType());
        }
        if("loan".equals(accountType)){
            LoanAccount loanAcc = (LoanAccount) acc;
            UpdateModal.textField1.setText(loanAcc.getAccountType());
        }
        if("savings".equals(accountType)){
            SavingsAccount savingAcc = (SavingsAccount) acc;
            UpdateModal.textField1.setText(savingAcc.getAccountType());
        }
        
        UpdateModal.textField2.setText(AddModal.convertToString(acc.getAmount()));
        UpdateModal.textField3.setText(AddModal.convertToString(acc.getBranchID()));

        
        
    }
    
    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

}
