/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.dao.Database;
import qlbhgg.models.Bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class BillDao {

    @SuppressWarnings("empty-statement")

    public static ArrayList<Bill> findAllBill() throws SQLException {
        ArrayList<Bill> ListBill = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM `bill` ORDER BY `bill`.`code_bill` DESC";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Bill b = Bill.getFromResultSet(resulSet);
                ListBill.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListBill;
    }

    @SuppressWarnings("empty-statement")
    public static int countBill() throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select count(code_bill) as count_bill from bill";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_bill");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static ArrayList<Bill> searchBill(String str) {
        ArrayList<Bill> ListBills = new ArrayList<Bill>();
        Connection connection = Database.getInstance().getConnection();
        try {
            String sql = "SELECT DISTINCT bill.code_bill, bill.customer_code, bill.id_user, bill.id_user, bill.invoice_creation_date, bill.note FROM ((((bill JOIN invoicedetails on bill.code_bill = invoicedetails.code_bill) JOIN users on users.id_user = bill.id_user) JOIN goods on goods.item_code = invoicedetails.item_code) JOIN supplier ON supplier.company_code = goods.company_code) JOIN typeofgoods on typeofgoods.type_code = goods.type_code WHERE (bill.code_bill LIKE '%" + str + "%' OR bill.customer_code LIKE '%" + str + "%' OR bill.id_user LIKE '%" + str + "%' OR bill.invoice_creation_date LIKE '%" + str + "%' OR invoicedetails.price LIKE '%" + str + "%' OR invoicedetails.amount LIKE '%" + str + "%' OR goods.item_name LIKE '%" + str + "%' OR goods.company_code LIKE '%" + str + "%' OR goods.type_code LIKE '%" + str + "%' OR supplier.company_name LIKE '%" + str + "%' OR typeofgoods.type_name LIKE '%" + str + "%' OR users.full_name LIKE '%" + str + "%')";
            Statement statement = connection.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Bill b = Bill.getFromResultSet(resulSet);
                ListBills.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListBills;
    }

    public static int countsearchBill(String str) {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "SELECT count(bill.code_bill) as count_searchbill FROM ((((bill JOIN invoicedetails on bill.code_bill = invoicedetails.code_bill) JOIN users on users.id_user = bill.id_user) JOIN goods on goods.item_code = invoicedetails.item_code) JOIN supplier ON supplier.company_code = goods.company_code) JOIN typeofgoods on typeofgoods.type_code = goods.type_code WHERE (bill.code_bill LIKE '%" + str + "%' OR bill.customer_code LIKE '%" + str + "%' OR bill.id_user LIKE '%" + str + "%' OR bill.invoice_creation_date LIKE '%" + str + "%' OR invoicedetails.price LIKE '%" + str + "%' OR invoicedetails.amount LIKE '%" + str + "%' OR goods.item_name LIKE '%" + str + "%' OR goods.company_code LIKE '%" + str + "%' OR goods.type_code LIKE '%" + str + "%' OR supplier.company_name LIKE '%" + str + "%' OR typeofgoods.type_name LIKE '%" + str + "%' OR users.full_name LIKE '%" + str + "%')";
            Statement statement = connection.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_searchbill");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void addBill(Bill b) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO `bill`(`code_bill`, `customer_code`, `id_user`, `note`) VALUES (?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, b.getCodebill());
            statement.setString(2, b.getCustomercode());
            statement.setString(3, b.getIduser());
            statement.setString(4, b.getNote());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBill(String codeBill) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM `bill` WHERE `code_bill` = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, codeBill);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bill getBill(String codeBill) {
        Bill bill = new Bill();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM `bill` WHERE `code_bill` = '" + codeBill + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                bill = Bill.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    public static void updateBill(Bill bill, String codeBill) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update `bill` set `id_user` = ?, `note` = ? where code_bill = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, bill.getIduser());
            statement.setNString(2, bill.getNote());
            statement.setString(3, codeBill);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countTotalBillByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        int totalBill = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(code_bill) as 'date' FROM `bill` WHERE YEAR(invoice_creation_date) = '" + year + "'";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "'";
            }
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalBill = resulSet.getInt("date");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBill;
    }

    public static int countTotalBillByPeriod(String fromDate, String toDate) throws SQLException {
        int totalBill = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(code_bill) as 'date' FROM `bill` WHERE date(invoice_creation_date) >= '" + fromDate + "' and date(invoice_creation_date) <= '" + toDate + "'";

            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalBill = resulSet.getInt("date");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBill;
    }

    public static int countTotalBillByDateForStaff(String year, String month, String day, boolean m, boolean d, String id) throws SQLException {
        int totalBill = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(code_bill) as 'date' FROM `bill` WHERE bill.id_user = '" + id + "' and YEAR(invoice_creation_date) = '" + year + "'";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "'";
            }
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalBill = resulSet.getInt("date");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBill;
    }

    public static int countTotalBillByPeriodForStaff(String fromDate, String toDate, String id) throws SQLException {
        int totalBill = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(code_bill) as 'date' FROM `bill` WHERE bill.id_user = '" + id + "' and date(invoice_creation_date) >= '" + fromDate + "' and date(invoice_creation_date) <= '" + toDate + "'";

            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalBill = resulSet.getInt("date");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBill;
    }
    
    public static void main(String[] args) throws SQLException {
        int n = countTotalBillByDateForStaff("2021", "1", "1", false, false, "US00000004");
        System.out.println(n);
    }
}
