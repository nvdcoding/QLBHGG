/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author acer
 */
public class GetNextCodeDao {
    public static String getBillCode() throws SQLException {
        String bc = "B";
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM next_code";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                int code = resulSet.getInt("code_bill");
                String strCode = String.valueOf(code);
                for(int i = 0;i<9 - strCode.length();i++){
                    bc += "0";
                }
                bc += strCode;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
    public static void updateCodeBill() {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `next_code` SET `code_bill`= code_bill + 1";
            statement = connection.prepareCall(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getNextCodeProduct(String type) {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        int code = 0;
        try {
            statement = connection.createStatement();
            String sql = "SELECT " + type + " FROM next_code_good";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                code = resulSet.getInt(type);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }

    static void updateNextCode(String type) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `next_code_good` SET `"+ type +"`= `"+type+"`+ 1";
            statement = connection.prepareCall(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getNextCodeSupplier() {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        int code = 0;
        try {
            statement = connection.createStatement();
            String sql = "SELECT `code_company` FROM next_code";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                code = resulSet.getInt("code_company");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }
    public static void updateCodeSupplier() {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `next_code` SET `code_company`= code_company + 1";
            statement = connection.prepareCall(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
