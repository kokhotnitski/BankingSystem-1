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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeremye
 */
public class AddModal extends DataTypeConvertor{
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    
    
    public void showAddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model){
                
        showFrame textFieldFrame = new showFrame(accList, modalType, table, model);
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 300);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);
    }
    
}
class showFrame extends JFrame {
    
    private final  JLabel label1;
    private final  JLabel label2;
    private final  JLabel label3;
    private final  JButton addDetails;
    
    public showFrame(AccountList accList, String modalType, JTable table, DefaultTableModel model){
        
        //still busy wtih this development
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        
        //this is a label
        label1 = new JLabel("Type of account:");
        add(label1);
        
        //this is a textfield to input values
        AddModal.textField1 = new JTextField(10);
        add(AddModal.textField1); // add textField1 to JFrame
        
         //this is a label
        label2 = new JLabel("Enter the amount");
        add(label2);
        
        //this is a textfield to input values
        AddModal.textField2 = new JTextField(10);
        add(AddModal.textField2);
        
         //this is a label
        label3 = new JLabel("enter the branch ID");
        add(label3);
        
        //this is a textfield to input values
        AddModal.textField3 = new JTextField(10);
        add(AddModal.textField3);
        
        //this is a button to submit details
        addDetails = new JButton("Submit");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        
        addDetails.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //this still has to be created with the class waiting for Kirill
                int accountNo = 123456;
                int branchId = 1111111;
                //***********************************************
                
                String accountType = AddModal.textField1.getText();
                Double amount = AddModal.convertToDouble(AddModal.textField3.getText());
                
                //insert data into arraylist
                Account acc = new ChequingAccount(accountNo, branchId, amount);
                accList.addAccount(acc);
                
                //add imput values to the table
                String[] row = {"123456" , accountType, AddModal.textField3.getText()};
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(row);
                
                dispose();
                
            }
            
        });
        
    }
    
    
    
    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

}


