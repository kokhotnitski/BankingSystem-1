/*
 UpdateModal.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class handles the update account action from the static main class. It 
 displays a window where the user is given a choice of what account they want to
 add and takes the data from their input to update the chosen account. The 
 current account type is shown in a combobox, the current amount and branch 
 number is shown on textboxes and the current account number is shown as a 
 label.
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

public class UpdateModal extends DataTypeConvertor {
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    
    //Method creates an instance of the window, sizes it up and displays it.
    public void showUpdateModal(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex){
                
        showUpdateFrame textFieldFrame = new showUpdateFrame(accList, acc, table, model, rowIndex);
        textFieldFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textFieldFrame.setResizable(false);
        textFieldFrame.setSize(250, 300);
        textFieldFrame.setLocation();
        textFieldFrame.setVisible(true);
    }
    
}

//Private class to create the window.
class showUpdateFrame extends JFrame {
    
    private final  JLabel label1;
    private final  JLabel label2;
    private final  JLabel label3;
    private final  JLabel label4;
    private final  JLabel spaceLabel1;
    private final  JLabel spaceLabel2;
    private final  JLabel spaceLabel3;
    private final  JButton addDetails;
    private final  JComboBox<String> accountTypeComboBox;
    
    private static final String SPACE = "               ";
    private static final String[] ACCOUNTTYPES = {"chequing", "credit", "loan",
    "savings"};
    
    public showUpdateFrame(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex){
        
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
        UpdateModal.textField2 = new JTextField(10);
        add(UpdateModal.textField2);
        
        //Branch number label.
        label3 = new JLabel("Enter the branch No:");
        add(label3);
        
        //Branch number textfield.
        UpdateModal.textField3 = new JTextField(10);
        add(UpdateModal.textField3);
        
        //Space label for proper sizing of components.
        spaceLabel2 = new JLabel(SPACE);
        add(spaceLabel2);
        
        //Account number label.
        label4 = new JLabel(String.format("Account No: %d       ", 
                acc.getAccountID()));
        add(label4);
        
        //Space label for proper sizing of components.
        spaceLabel3 = new JLabel(SPACE);
        add(spaceLabel3);
        
        //This is to preset the values at the text fields.
        setText(acc, model, rowIndex);
        
        //Submit button.
        addDetails = new JButton("Update");
        addDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addDetails);
        
        
        addDetails.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                boolean status = true; //Control for adding the data.
                
                accList.deleteAccount(acc);
                
                if(UpdateModal.CheckInteger(UpdateModal.textField3.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "The inputted branch No"
                            + " must be a whole number.", "Improper branch No", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                int branchId = UpdateModal.convertToInteger(UpdateModal.textField3.getText());
                //Handles a negative value.
                if(branchId < 0) {
                    JOptionPane.showMessageDialog(null, "The inputted branch No"
                            + " must be positive.", "Negative branch No", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                
                //Handles improper type.
                if(UpdateModal.CheckDouble(UpdateModal.textField2.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "The inputted amount"
                            + " must be a proper number.", "Improper amount", 
                            JOptionPane.ERROR_MESSAGE);  
                    return;
                }
                
                int accountNo = acc.getAccountID();
                
                Double amount = UpdateModal.convertToDouble(UpdateModal.textField2.getText());
                String accountType = accountTypeComboBox.getSelectedItem().toString();
                Account acc;
                
                //Account type decision.
                switch(accountType.toLowerCase()) {
                    case "chequing":
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
                    //Add input values to the table.
                    String[] row = {Integer.toString(accountNo) , accountType,
                        UpdateModal.textField3.getText(), 
                        String.format("%.2f", amount)};
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(rowIndex);
                    model.insertRow(rowIndex, row);
                    dispose();
                } else { //Handles improper choice should it ever occurred.
                    JOptionPane.showMessageDialog(null, "The inputted account "
                            + "type is unknown.", "Unknown account type", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    //Method used to setup the existing variables on the window.
    private void setText(Account acc, DefaultTableModel model, int rowIndex){
        
        String accountType  = model.getValueAt(rowIndex, 1).toString();
        
        if("chequing".equals(accountType)){
            accountTypeComboBox.setSelectedIndex(0);
        }
        if("credit".equals(accountType)){
            accountTypeComboBox.setSelectedIndex(1);
        }
        if("loan".equals(accountType)){
            accountTypeComboBox.setSelectedIndex(2);
        }
        if("savings".equals(accountType)){
            accountTypeComboBox.setSelectedIndex(3);
        }
        
        UpdateModal.textField2.setText(AddModal.convertToString(acc.getAmount()));
        UpdateModal.textField3.setText(AddModal.convertToString(acc.getBranchID()));   
    }
    
    //Method to center the window.
    void setLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
