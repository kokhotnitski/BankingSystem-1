/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jeremye
 */
public class InputModals extends JFrame implements ModalMethodsInterface {
    
    
    private final AccountList accList;
    private final String modalType;
        
    public InputModals(AccountList accList, String modalType){

        this.accList = accList;
        this.modalType = modalType;
        
    }    
    
    @Override
    public void AddModal() {
        
        AddModal addModal = new AddModal();
        addModal.showAddModal(this.accList, this.modalType);
    }

    @Override
    public void DeleteModal() {
        DeleteModal deleteModal = new DeleteModal();
        deleteModal.showDeleteModal();
    }

    @Override
    public void UpdateModal() {
        AddModal addModal = new AddModal();
        //addModal.showModal();
    }

    @Override
    public void DidsplayModal() {
        AddModal addModal = new AddModal();
        //addModal.showModal();
    }
       
}





