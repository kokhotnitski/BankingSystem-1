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
    
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    
    private final AccountList accList;
    private final String modalType;
        
    public InputModals(AccountList accList, String modalType){

        this.accList = accList;
        this.modalType = modalType;
        
    }    
    
    @Override
    public void AddModal() {
        
        AddModal addModal = new AddModal();
        addModal.showModal();
    }

    @Override
    public void DeleteModal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateModal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DidsplayModal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}





