/*
 ModalMethodsInterface.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This interface is used for handling operations on modal objects.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface ModalMethodsInterface {
    public void AddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model);
    public void UpdateModal(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex);
        
}
