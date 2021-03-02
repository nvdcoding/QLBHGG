/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.CustomerController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.dao.CustomerDao;
import qlbhgg.models.Customers;
import qlbhgg.views.admin.bill.EditBill;
import qlbhgg.views.admin.customer.ChangeCustomer;
import qlbhgg.views.admin.customer.PanelCustomer;

/**
 *
 * @author ADMIN
 */
public class CustomerController {
    
    public ArrayList<Customers> getAll() throws SQLException {
        ArrayList<Customers> list = null;
        list = CustomerDao.findAllCustomer();
        return list;
    }
    public Customers getOneById(String customerCode) throws SQLException {
        CustomerDao cd = new CustomerDao();
        Customers customer = new Customers();
        customer = cd.findCustomerById(customerCode);
        return customer;
    }
    public ArrayList<Customers> searchCustomer(String key) {
        ArrayList<Customers> listCustomers = null; 
        try {
            listCustomers = CustomerDao.searchCustomer(key);
            return listCustomers;
                    
        } catch (SQLException ex) {
            Logger.getLogger(PanelCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addCustomer(ChangeCustomer changeCustomer) throws SQLException {
        CustomerDao cd = new CustomerDao();
        Customers customer = changeCustomer.getCustomer();
        cd.addCustomer(customer);
    }
    public void updateCustomer(ChangeCustomer changeCustomer, String customerCode) throws SQLException {
        CustomerDao cd = new CustomerDao();
        Customers customer = changeCustomer.getCustomer();
        cd.updateCustomer(customer, customerCode);
    }
    public void updateCustomerBill(EditBill editBill, String customerCode) throws SQLException {
        CustomerDao cd = new CustomerDao();
        Customers customer = editBill.getCustomer();
        cd.updateCustomerBill(customer, customerCode);
    }
    public void deleteCustomer(String customerCode) {
        CustomerDao cd = new CustomerDao();
        cd.deleteCustomer(customerCode);
    }
    public static Customers findCustomerById(String id) throws SQLException {
        Customers customer = new Customers();
        customer = CustomerDao.findCustomerById(id);
        return customer;
    }
    
}
