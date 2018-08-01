/*
 AddModal.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class handles the add account action from the static main class. It 
 displays a window where the user is given a choice of what account they want to
 add and takes the data from their input to create a new account. Account type
 input is made in a combo box, the branch number and amount is taken from 
 textboxes and the account number is called from the BankingApplication class.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddModal extends DataTypeConvertor{
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    
    //Method creates an instance of the window, sizes it up and displays it.
    public void showAddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model) {        
        showFrame textFieldFrame = new showFrame(accList, modalType, table, model);
        textFieldFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 300);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);      
    }  
}

//Private class to create the window.
class showFrame extends JFrame {
    
    private final  JLabel label1;
    private final  JLabel label2;
    private final  JLabel label3;
    private final  JLabel spaceLabel1;
    private final  JLabel spaceLabel2;
    private final  JButton addDetails;
    private final  JComboBox<String> accountTypeComboBox;
    
    private static final String SPACE = "               ";
    private static final String[] ACCOUNTTYPES = {"chequing", "credit", "loan",
    "savings"};
    
    public showFrame(AccountList accList, String modalType, JTable table, DefaultTableModel model) {
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        //Account type label.
        label1 = new JLabel("Enter the account type:");
        add(label1);
        
        //Account type combo box.
        accountTypeComboBox = new JComboBox<String>(ACCOUNTTYPES);
        accountTypeComboBox.setMaximumRowCount(4);
        add(accountTypeComboBox);
        
        //Space label for proper sizing of components.
        spaceLabel1 = new JLabel(SPACE);
        add(spaceLabel1);
        
        //Amount label.
        label2 = new JLabel("Enter the amount:");
        add(label2);
        
        //Amount textfield.
        AddModal.textField2 = new JTextField(10);
        add(AddModal.textField2);
        
        //Branch number label.
        label3 = new JLabel("Enter the branch No:");
        add(label3);
        
        //Branch number textfield.
        AddModal.textField3 = new JTextField(10);
        add(AddModal.textField3);
        
        //Space label for proper sizing of components.
        spaceLabel2 = new JLabel(SPACE);
        add(spaceLabel2);

        //Submit button.
        addDetails = new JButton("Submit");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        addDetails.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                boolean status = true; //Control for adding the data.
                
                //Handles improper type.
                if(AddModal.CheckInteger(AddModal.textField3.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "The inputted branch No"
                            + " must be a whole number.", "Improper branch No", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                int branchId = AddModal.convertToInteger(AddModal.textField3.getText());
                //Handles a negative value.
                if(branchId < 0) {
                    JOptionPane.showMessageDialog(null, "The inputted branch No"
                            + " must be positive.", "Negative branch No", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                
                //Handles improper type.
                if(AddModal.CheckDouble(AddModal.textField2.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "The inputted amount"
                            + " must be a proper number.", "Improper amount", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                Double amount = AddModal.convertToDouble(AddModal.textField2.getText());
                
                String accountType = accountTypeComboBox.getSelectedItem().toString();//AddModal.textField1.getText();
                int accountNo = BankingApplication.getAccountNo();
                Account acc;
                
                //Account type decision.
                switch(accountType.toLowerCase()) {
                    case "chequing":
                        //Insert data into arraylist.
                        acc = new ChequingAccount(accountNo, branchId, amount);
                        amount = acc.getAmount();
                        accList.addAccount(acc);
                        break;
                    case "credit":
                        acc = new CreditAccount(accountNo, branchId, amount);
                        amount = acc.getAmount();
                        accList.addAccount(acc);
                        break;
                    case "loan":
                        acc = new LoanAccount(accountNo, branchId, amount);
                        amount = acc.getAmount();
                        accList.addAccount(acc);
                        break;
                    case "savings":
                        acc = new SavingsAccount(accountNo, branchId, amount);
                        amount = acc.getAmount();
                        accList.addAccount(acc);
                        break;
                    default:
                        status = false; //Variable used to handle improper choice.
                        break;
                }
                
                if(status == true){
                    //add input values to the table.
                    String[] row = {Integer.toString(accountNo) , accountType,
                        AddModal.textField3.getText(), 
                        String.format("%.2f", amount)
                    };
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    BankingApplication.setAccountNo(++accountNo);
                    dispose();
                } else { //Handles improper choice should it ever occurred.
                    JOptionPane.showMessageDialog(null, "The inputted account "
                            + "type is unknown.", "Unknown account type", 
                            JOptionPane.ERROR_MESSAGE);    
                }
            }
        });  
    }
    
    //Method to center the window.
    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
