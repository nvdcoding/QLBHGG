/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Invoicedetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class InvoicedetailsDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Invoicedetails> findInvoicedetailsByIdBill(String id) throws SQLException {
        ArrayList<Invoicedetails> ListInvoicedetails = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from invoicedetails where code_bill = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Invoicedetails iv = Invoicedetails.getFromResultSet(resulSet);
                ListInvoicedetails.add(iv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return ListInvoicedetails;
    }
    
    public static void addInvoicedetails(Invoicedetails i) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO `invoicedetails`(`code_bill`, `item_code`, `price`, `amount`, `discount`) VALUES (?,?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, i.getCodebill());
            statement.setString(2, i.getItemcode());
            statement.setFloat(3, i.getPrice());
            statement.setInt(4, i.getAmount());
            statement.setInt(5, i.getDiscount());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static float countTotalRevenueByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "'";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "'";
            }
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    
    public static float countTotalRevenueByPeriod(String fromDate, String toDate) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "'";
            
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    
    public static float countTotalRevenueByDateForStaff(String year, String month, String day, boolean m, boolean d, String id) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE bill.id_user = '" + id + "' and YEAR(invoice_creation_date) = '" + year + "'";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "'";
            }
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    public static float countTotalRevenueByDateAll(String year, String month, String day, boolean m, boolean d, String id) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE bill.id_user <> '" + id + "' and YEAR(invoice_creation_date) = '" + year + "'";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "'";
            }
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    
    public static float countTotalRevenueByPeriodForStaff(String fromDate, String toDate, String id) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE bill.id_user = '" + id + "' and date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "'";
            
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    public static float countTotalRevenueByPeriodAll(String fromDate, String toDate, String id) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE bill.id_user <> '" + id + "' and date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "'";
            
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    
    public static float totalRevenueByStaff(String year, String month, String id) throws SQLException {
        float totalRevenue = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE year(bill.invoice_creation_date) = '" + year + "' AND month(bill.invoice_creation_date) = '"+ month + "' and bill.id_user = '" + id + "'";
            
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                totalRevenue = resulSet.getFloat("revenue");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
    
    public static void main(String[] args) throws SQLException {
        
    }
}
