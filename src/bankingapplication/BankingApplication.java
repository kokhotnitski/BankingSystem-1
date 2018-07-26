/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jeremye
 */
public class BankingApplication extends JFrame {
    
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
        
        //java.awt.GridBagConstraints gridBagConstraints;
        GridBagConstraints c = new GridBagConstraints();
        
        
        
        mainPanel = new javax.swing.JPanel();
        addAccountLabel = new javax.swing.JLabel();
        deleteAccountLabel = new javax.swing.JLabel();
        updateAccountLabel = new javax.swing.JLabel();
        displayAccountLabel = new javax.swing.JLabel();
        
        addAccountButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        updateAccountButton = new javax.swing.JButton();
        displayAccountButton = new javax.swing.JButton();
        
        setTitle("Banking Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setLayout(new java.awt.GridBagLayout());
        mainPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(12, 12, 12, 12)));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        
        addAccountLabel.setText("Add Account Details");
        addAccountLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(addAccountLabel, c);
        
        deleteAccountLabel.setText("Delete Account Details  ");
        deleteAccountLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(deleteAccountLabel, c);
        
        updateAccountLabel.setText("Update Account Details");
        updateAccountLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(updateAccountLabel, c);
        
        displayAccountLabel.setText("Display Account Details");
        displayAccountLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(displayAccountLabel, c);
        
        
        
        addAccountButton.setText("Add Account");
        addAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        
        
        addAccountButton.setPreferredSize(new Dimension(200, 30));
        addAccountButton.setToolTipText("Add account.");
        
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //call to modal to enter details
                InputModal inputModal = new InputModal();
                               
                
            }
        });

        c.gridx = 1;
        c.gridy = 0;
        //c.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(addAccountButton, c);
                
        deleteAccountButton.setText("Delete Account");
        deleteAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        deleteAccountButton.setPreferredSize(new Dimension(200, 30));
        deleteAccountButton.setToolTipText("Add account.");
        
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //call to request delete modal 
                InputModal inputModal = new InputModal();
                
                
            }
        });

        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(deleteAccountButton, c);
        
        
        
        updateAccountButton.setText("Update Account");
        updateAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        updateAccountButton.setPreferredSize(new Dimension(200, 30));
        updateAccountButton.setToolTipText("Add account.");
        
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //call to update modal
                InputModal inputModal = new InputModal();
                
            }
        });

        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(updateAccountButton, c);
        
        displayAccountButton.setText("Display Account");
        displayAccountButton.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        displayAccountButton.setPreferredSize(new Dimension(200, 30));
        displayAccountButton.setToolTipText("Add account.");
        
        displayAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //call to display details modal
                InputModal inputModal = new InputModal();
                
            }
        });

        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(displayAccountButton, c);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

    }                        
     
    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }  
    
    private javax.swing.JPanel mainPanel;
    
    private javax.swing.JButton addAccountButton;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton updateAccountButton;
    private javax.swing.JButton displayAccountButton;
    
    private javax.swing.JLabel addAccountLabel;
    private javax.swing.JLabel deleteAccountLabel;
    private javax.swing.JLabel updateAccountLabel;
    private javax.swing.JLabel displayAccountLabel;
               

}


