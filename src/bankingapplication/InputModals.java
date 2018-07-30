/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeremye
 */
public class InputModals implements ModalMethodsInterface {
        
    public InputModals(){
 
    }    
    
    @Override
    public void AddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model) {
        
        AddModal addModal = new AddModal();
        addModal.showAddModal(accList, modalType, table, model);
        
    }

    @Override
    public void UpdateModal(AccountList accList, String modalType, JTable table, DefaultTableModel model) {
        AddModal addModal = new AddModal();
        addModal.showAddModal(accList, modalType, table, model);
        //addModal.showModal();
    }
   
}





