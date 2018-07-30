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
public interface ModalMethodsInterface {
    public void AddModal(AccountList accList, String modalType, JTable table, DefaultTableModel model);
    public void UpdateModal(AccountList accList, Account acc, JTable table, DefaultTableModel model, int rowIndex);
        
}
