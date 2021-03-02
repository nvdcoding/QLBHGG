/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.InvoiceDetailsController;

import java.sql.SQLException;
import java.util.ArrayList;
import qlbhgg.dao.InvoicedetailsDao;
import qlbhgg.models.Invoicedetails;

/**
 *
 * @author ADMIN
 */
public class InvoiceController {
    public static ArrayList<Invoicedetails> findInvoicedetailsByIdBill(String id) throws SQLException {
        ArrayList<Invoicedetails> ListInvoicedetails = new ArrayList<>();
        ListInvoicedetails = InvoicedetailsDao.findInvoicedetailsByIdBill(id);
        return ListInvoicedetails;
    }
}
