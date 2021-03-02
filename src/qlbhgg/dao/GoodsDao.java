/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import Helpers.Helper;
import qlbhgg.models.Goods;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class GoodsDao {

    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> findAll() throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT item_code, item_name, supplier.company_name as company_code, typeofgoods.type_name as type_code, amount,unit,import_price,price, image_item from goods, supplier, typeofgoods WHERE goods.company_code = supplier.company_code and goods.type_code = typeofgoods.type_code";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods good = Goods.getFromResultSet(resulSet);
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
    public static Goods getOne(String itemCode) throws SQLException {
        Goods good = new Goods();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM goods WHERE `item_code` = '" + itemCode + "';";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                good = good.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return good;
    }
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static int countProduct() throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> findBy(String str) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT item_code, item_name, supplier.company_name as company_code, typeofgoods.type_name as type_code, amount,unit,import_price,price, image_item from goods, supplier, typeofgoods WHERE goods.company_code = supplier.company_code and goods.type_code = typeofgoods.type_code and typeofgoods.type_name = '" + str +"';";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods good = Goods.getFromResultSet(resulSet);
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
    @SuppressWarnings("empty-statement")
    public static int countProductBy(String str) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods JOIN typeofgoods ON goods.type_code = typeofgoods.type_code WHERE typeofgoods.type_name = '" + str + "';";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> searchProduct(String str) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM (goods join supplier on supplier.company_code = goods.company_code) join typeofgoods on typeofgoods.type_code = goods.type_code WHERE item_code LIKE '%" + str + "%' or item_name LIKE '%" + str + "%' or supplier.company_name LIKE '%" + str + "%' or supplier.company_code LIKE '%" + str + "%' or goods.type_code LIKE '%" + str + "%' or typeofgoods.type_name LIKE '%" + str + "%' or amount LIKE '%" + str + "%' or import_price LIKE '%" + str + "%' or price LIKE '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = Goods.getFromResultSet(resulSet);
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
    
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static int countSearchProduct(String str) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM (goods join supplier on supplier.company_code = goods.company_code) join typeofgoods on typeofgoods.type_code = goods.type_code WHERE item_code LIKE '%" + str + "%' or item_name LIKE '%" + str + "%' or supplier.company_name LIKE '%" + str + "%' or supplier.company_code LIKE '%" + str + "%' or goods.type_code LIKE '%" + str + "%' or typeofgoods.type_name LIKE '%" + str + "%' or amount LIKE '%" + str + "%' or import_price LIKE '%" + str + "%' or price LIKE '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static Goods findProductForBill(String id) throws SQLException {
        Goods g  = new Goods();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from goods where item_code = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                g = Goods.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
    public static void minusGood(int i, String item_code) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `goods` SET `amount`= amount - ? WHERE `item_code` = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, i);
            statement.setString(2, item_code);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addProduct(Goods product) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        Helper helper = new Helper();
        try {
            String type = getProductType(product);
            int nextCode = GetNextCodeDao.getNextCodeProduct(type);
            String code = helper.getNextCode(type, nextCode);
            String sql = "INSERT INTO `goods` VALUES (?,?,?,?,?,?,?,?,?);";
            statement = connection.prepareCall(sql);
            statement.setString(1, code);
            statement.setString(2, product.getItemname());
            statement.setString(3, product.getCompanycode());
            statement.setString(4, product.getTypecode());
            statement.setInt(5, product.getAmount());
            statement.setString(6, product.getUnit());
            statement.setFloat(7, product.getImportprice());
            statement.setFloat(8, product.getPrice());
            statement.setString(9, product.getImageitem());
            statement.executeUpdate();
            GetNextCodeDao.updateNextCode(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProduct(Goods product, String codeProduct) {
         Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update `goods` set `item_name` = ?, `company_code` = ?, `type_code` = ?, amount = ?, unit = ?, import_price = ?, price = ?, image_item = ? where item_code = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, product.getItemname());
            statement.setString(2, product.getCompanycode());
            statement.setString(3, product.getTypecode());
            statement.setInt(4, product.getAmount());
            statement.setString(5, product.getUnit());
            statement.setFloat(6, product.getImportprice());
            statement.setFloat(7, product.getPrice());
            statement.setString(8, product.getImageitem());
            statement.setString(9, codeProduct);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void deleteProduct(String codeProduct) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM `goods` WHERE `item_code` = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, codeProduct);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String getProductType(Goods product) {
        switch(product.getTypecode()) {
            case "L000000001":
                return "VGA";
            case "L000000002":
                return "BP";
            case "L000000003":
                return "CG";
            case "L000000004":
                return "HP";
            case "L000000005":
                return "GHE";
            case "L000000006":
                return "MH";
            case "L000000007":
                return "LT";
            case "L000000008":
                return "MN";
            case "L000000009":
                return "CPU";
            case "L000000010":
                return "RAM";
            case "L000000011":
                return "SSD";
            case "L000000012":
                return "HHD";
            case "L000000013":
                return "CS";
            case "L000000014":
                return "PSU";
            case "L000000015":
                return "FAN";
        }
        return "";
    }
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
   
    public static ArrayList<Goods> getProductTopPriceByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT invoicedetails.item_code, goods.item_name, SUM(invoicedetails.amount) as 'amount', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN goods ON invoicedetails.item_code = goods.item_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY invoicedetails.item_code ORDER BY revenue DESC LIMIT 10;";

            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = new Goods();
                g.setItemcode(resulSet.getString("item_code"));
                g.setItemname(resulSet.getNString("item_name"));
                g.setAmount(resulSet.getInt("amount"));
                g.setPrice(resulSet.getFloat("revenue"));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return goods;
    }
    public static ArrayList<Goods> getProductTopPriceByPeriod(String fromDate, String toDate) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT invoicedetails.item_code, goods.item_name, SUM(invoicedetails.amount) as 'amount', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN goods ON invoicedetails.item_code = goods.item_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY invoicedetails.item_code ORDER BY revenue DESC LIMIT 10;";

            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = new Goods();
                g.setItemcode(resulSet.getString("item_code"));
                g.setItemname(resulSet.getNString("item_name"));
                g.setAmount(resulSet.getInt("amount"));
                g.setPrice(resulSet.getFloat("revenue"));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return goods;
    }

    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> getProductTopAmountByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT invoicedetails.item_code, goods.item_name, SUM(invoicedetails.amount) as 'amount', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN goods ON invoicedetails.item_code = goods.item_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY invoicedetails.item_code ORDER BY amount DESC LIMIT 10;";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = new Goods();
                g.setItemcode(resulSet.getString("item_code"));
                g.setItemname(resulSet.getNString("item_name"));
                g.setAmount(resulSet.getInt("amount"));
                g.setPrice(resulSet.getFloat("revenue"));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return goods;
    }
    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> getProductTopAmountByPeriod(String fromDate, String toDate) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT invoicedetails.item_code, goods.item_name, SUM(invoicedetails.amount) as 'amount', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN goods ON invoicedetails.item_code = goods.item_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY invoicedetails.item_code ORDER BY amount DESC LIMIT 10;";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = new Goods();
                g.setItemcode(resulSet.getString("item_code"));
                g.setItemname(resulSet.getNString("item_name"));
                g.setAmount(resulSet.getInt("amount"));
                g.setPrice(resulSet.getFloat("revenue"));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return goods;
    }

    public static int countProductWearHouse() throws SQLException {
        int count = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(amount) as 'amount' FROM `goods` WHERE 1";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("amount");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countProductSold() throws SQLException {
        int count = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT SUM(amount) as amount FROM `invoicedetails` WHERE 1";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("amount");
            }
            resulSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public static void main(String[] args) throws SQLException {
    }
}
