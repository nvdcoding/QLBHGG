/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.SupplierController;

import java.util.ArrayList;
import java.sql.SQLException;
import qlbhgg.dao.SupplierDao;
import qlbhgg.models.Suppliers;
import qlbhgg.views.admin.supplier.ChangeSupplier;

/**
 *
 * @author ADMIN
 */
public class SupplierController {
    public ArrayList<Suppliers> getAllSupplier() throws SQLException {
        SupplierDao sd = new SupplierDao();
        ArrayList<Suppliers> list = new ArrayList();
        list = sd.findAllSupplier();
        return list;
    }
    public String getSupplier(String companyCode) throws SQLException {
        SupplierDao sd = new SupplierDao();
        String name = "";
        name = sd.getSupplier(companyCode);
        return name;
    }
    public Suppliers getSupplierObject(String companyCode) throws SQLException {
        Suppliers s = new Suppliers();
        SupplierDao sd = new SupplierDao();
        s = sd.getSupplierO(companyCode);
        return s;
    }
    public void addSupplier(ChangeSupplier view) {
        SupplierDao sd = new SupplierDao();
        Suppliers s = view.getSupplier();
        sd.addSupplier(s);
    }
    public void updateSupplier(ChangeSupplier view, String supplierCode) {
        SupplierDao gd = new SupplierDao();
        Suppliers s = view.getSupplier();
        gd.updateSupplier(s, supplierCode);
    }
    public static int countSupplier() throws SQLException {
        SupplierDao sd = new SupplierDao();
        int count = sd.countSupplier();
        return count;
    }
}
