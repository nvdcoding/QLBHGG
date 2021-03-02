/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import qlbhgg.models.Suppliers;
import qlbhgg.models.TypeOfGoods;

/**
 *
 * @author acer
 */
public class TypeOfGoodDao {
    public static void setComboboxType(JComboBox cbb) throws SQLException{
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT type_name FROM typeofgoods";
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                cbb.addItem(resulSet.getNString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<TypeOfGoods> findAll() throws SQLException {
        ArrayList<TypeOfGoods> list = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from typeofgoods";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                TypeOfGoods s = TypeOfGoods.getFromResultSet(resulSet);
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String getType(String typeCode) {
        String type = "";
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * FROM typeofgoods WHERE `type_code` = '" + typeCode +"'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                type = TypeOfGoods.getFromResultSet(resulSet).getTypename();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
