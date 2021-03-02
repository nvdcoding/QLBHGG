/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import Helpers.Helper;
import qlbhgg.models.Suppliers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;


/**
 *
 * @author acer
 */
public class SupplierDao {
    public static String getSupplier(String companyCode) {
        String supplier = "";
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * FROM supplier WHERE `company_code` = '" + companyCode +"'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                supplier = Suppliers.getFromResultSet(resulSet).getCompanyname();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }
    public static Suppliers getSupplierO(String companyCode) {
        Suppliers supplier = new Suppliers();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * FROM supplier WHERE `company_code` = '" + companyCode +"'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                supplier = Suppliers.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }
    @SuppressWarnings("empty-statement")
    public static ArrayList<Suppliers> findAllSupplier() throws SQLException {
        ArrayList<Suppliers> ListSupplier = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Suppliers s = Suppliers.getFromResultSet(resulSet);
                ListSupplier.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListSupplier;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countSupplier() throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select count(company_code) as count_supplier from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_supplier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public void addSupplier(Suppliers s) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        Helper helper = new Helper();
        try {
            int nextCode = GetNextCodeDao.getNextCodeSupplier();
            String code = helper.getNextCode("CC", nextCode);
            String sql = "INSERT INTO `supplier` VALUES (?,?,?,?,?,?,?);";
            statement = connection.prepareCall(sql);
            statement.setNString(1, code);
            statement.setNString(2, s.getCompanyname());
            statement.setNString(3, s.getTradingname());
            statement.setNString(4, s.getAddress());
            statement.setNString(5, s.getEmail());
            statement.setNString(6, s.getPhonenumber());
            statement.setNString(7, s.getLogo());
            statement.executeUpdate();
            GetNextCodeDao.updateCodeSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateSupplier(Suppliers s, String codeSupplier) {
         Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update `supplier` set `company_name` = ?, `trading_name` = ?, `address` = ?, email = ?, phone_number = ?, logo_supplier = ? where company_code = ?";
            statement = connection.prepareCall(sql);

            statement.setNString(1, s.getCompanyname());
            statement.setNString(2, s.getTradingname());
            statement.setNString(3, s.getAddress());
            statement.setNString(4, s.getEmail());
            statement.setNString(5, s.getPhonenumber());
            statement.setNString(6, s.getLogo());
            statement.setNString(7, codeSupplier);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) throws SQLException {
        ArrayList<Suppliers> ListSupplier = SupplierDao.findAllSupplier();
        ListSupplier.forEach(suppliers -> {
            System.out.println(suppliers.toString());
        });
        int count = SupplierDao.countSupplier();
        System.out.println(count);
    }
}
