/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import Helpers.Helper;
import java.sql.Connection;
import java.sql.Statement;
import qlbhgg.models.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
@SuppressWarnings("empty-statement")
public class CustomerDao {
    @SuppressWarnings("empty-statement")
    public static Customers findCustomerById(String id) throws SQLException {
        Customers customer = new Customers();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from customer where customer_code = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                customer = Customers.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    @SuppressWarnings("empty-statement")
    public static ArrayList<Customers> findAllCustomer() throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
    public static ArrayList<Customers> searchCustomer(String str) throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from customer where customer_code like '%" + str + "%' or customer_name like '%" + str + "%' or trading_name like '%" + str + "%' or address like '%" + str + "%' or email like '%" + str + "%' or phone_number like '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    private static int getNextCode() {
        Connection connection = Database.getInstance().getConnection();
        int nextCode = 0;
        try {
            Statement statement = connection.createStatement();
            String sql = "select `code_customer` from `next_code`;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                nextCode = resultSet.getInt("code_customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextCode;
    }
    
    private static void updateNextCode() {
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            int nextCode = getNextCode() + 1;
            String sql = "UPDATE `next_code` SET `code_customer` = '" + nextCode +"'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void addCustomer(Customers customer) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        Helper helper = new Helper();
        try {
            int nextCode = getNextCode();
            String code = helper.getNextCode("CM", nextCode);
            String sql = "INSERT INTO `customer` VALUES (?,?,?,?,?,?);";
            statement = connection.prepareCall(sql);
            statement.setString(1, code);
            statement.setString(2, customer.getCustomername());
            statement.setString(3, customer.getTradingname());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPhonenumber());
            statement.executeUpdate();
            updateNextCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateCustomer(Customers customer, String customerCode) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update `customer` set `customer_name` = ?, `trading_name` = ?, `address` = ?, email = ?, phone_number = ? where customer_code = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, customer.getCustomername());
            statement.setString(2, customer.getTradingname());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhonenumber());
            statement.setString(6, customerCode);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateCustomerBill(Customers customer, String customerCode) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update `customer` set `customer_name` = ?, `address` = ?, email = ?, phone_number = ? where customer_code = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, customer.getCustomername());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhonenumber());
            statement.setString(5, customerCode);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCustomer(String customerCode) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM `customer` WHERE `customer`.`customer_code` = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, customerCode);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        ArrayList<Customers> lc = CustomerDao.searchCustomer("build bộ pc");
        for (Customers customers : lc) {
            System.out.println(customers.toString());
        }
   }
}
