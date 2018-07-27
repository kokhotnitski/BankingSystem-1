/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jeremye
 */
public class InputModal extends JFrame {
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
        
    public InputModal(){
                
        showModal textFieldFrame = new showModal();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 200);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);
                
    }    
       
}

class showModal extends JFrame {
    
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    
    private final JButton addDetails;
    
    public showModal(){
    
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        //here I am creating the components for my Iframe panel
        
        //this is a label
        label1 = new JLabel("Start time   ");
        add(label1);
        //this is a textfiels to input values
        InputModal.textField1 = new JTextField(10);
        add(InputModal.textField1); // add textField1 to JFrame
        
         //this is a label
        label2 = new JLabel("End time     ");
        add(label2);
        //this is a textfiels to input values
        InputModal.textField2 = new JTextField(10);
        add(InputModal.textField2);
        
         //this is a label
        label3 = new JLabel("Description");
        add(label3);
        //this is a textfiels to input values
        InputModal.textField3 = new JTextField(10);
        add(InputModal.textField3);
        
        //this is a button to submit details
        addDetails = new JButton("Add details");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        
        
        //this a a eventhanlder that monitors any click action on the button
        AddAppointmentButtonHandler addAppointmentButtonHandler = new AddAppointmentButtonHandler();
        addAppointmentButton.addActionListener(addAppointmentButtonHandler);
        
            

    }

    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

}

// inner class for button event handling
class AddAppointmentButtonHandler implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event) {
        
       
    }
    
}
