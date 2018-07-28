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
import javax.swing.JTextField;

/**
 *
 * @author jeremye
 */
public class AddModal extends JFrame {
    
    private  JLabel label1;
    private  JLabel label2;
    private  JLabel label3;
    private  JButton addDetails;
    
    
    public AddModal (){
        

        show textFieldFrame = new show();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 300);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);
        
    }
    
    
    
    public void showModal(){
        
        
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        
        //this is a label
        label1 = new JLabel("Type of account:");
        add(label1);
        
        //this is a textfield to input values
        AddModal.textField1 = new JTextField(10);
        add(InputModals.textField1); // add textField1 to JFrame
        
         //this is a label
        label2 = new JLabel("Enter the amount");
        add(label2);
        
        //this is a textfield to input values
        InputModals.textField2 = new JTextField(10);
        add(InputModals.textField2);
        
         //this is a label
        label3 = new JLabel("enter the branch ID");
        add(label3);
        
        //this is a textfield to input values
        InputModals.textField3 = new JTextField(10);
        add(InputModals.textField3);
        
        //this is a button to submit details
        addDetails = new JButton("Submit");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        
        addDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //call to modal to enter details
                //Account acc = new ChequingAccount(accountNo, branchID, amt);
                    //this.accList.addAccount(acc);
                
                               
                
            }
        });
        
    }
    
}
class show extends JFrame{
    
    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

}


