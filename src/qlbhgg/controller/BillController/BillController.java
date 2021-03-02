/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.BillController;

import java.sql.SQLException;
import java.util.ArrayList;
import qlbhgg.dao.BillDao;
import qlbhgg.models.Bill;

/**
 *
 * @author ADMIN
 */
public class BillController {
    
    public void deleteBill(String codeBill) {
        BillDao bd = new BillDao();
        bd.deleteBill(codeBill);
    }
    public Bill getBill(String codeBill) {
        Bill bill = new Bill();
        BillDao bd = new BillDao();
        bill =  bd.getBill(codeBill);
        return bill;
    }
    public void updateBill(Bill bill, String codeBill) throws SQLException {
        BillDao bd = new BillDao();
        bd.updateBill(bill, codeBill);
    }
    public static ArrayList<Bill> findAllBill() throws SQLException{
        ArrayList<Bill> ListBill = new ArrayList<>();
        ListBill = BillDao.findAllBill();
        return ListBill;
    }
    public static int countBill() throws SQLException {
        int count = 0;
        count = BillDao.countBill();
        return count;
    }
    public static ArrayList<Bill> searchBill(String str) {
        ArrayList<Bill> ListBills = new ArrayList<Bill>();
        ListBills = BillDao.searchBill(str);
        return ListBills;
    }
    public static int countsearchBill(String str) {
        int count = 0;
        count = BillDao.countsearchBill(str);
        return count;
    }
}
