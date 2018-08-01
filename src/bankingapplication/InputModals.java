/*
 InputModals.java
 Jeremy Engelbrecht
 Kirill Viktorovich Okhotnitski
 1 August 2018
 This class is the abstract class for all types of input modals. It implements
 ModalMethodsInterface and overrides it's methods to instantiate modal objects
 for use in the program.
 This application uses JDK v1.8.0_171.
 */
package bankingapplication;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InputModals implements ModalMethodsInterface {
        
    public InputModals(){
    }    
    
    @Override
    public void AddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model)  {
        
        AddModal addModal = new AddModal();
        addModal.showAddModal(accList, modalType, table, model);    
    }
    
    @Override
    public void UpdateModal(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex) {
        UpdateModal addModal = new UpdateModal();
        addModal.showUpdateModal(accList, acc, table, model, rowIndex);    
    }
}
