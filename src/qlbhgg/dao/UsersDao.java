/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class UsersDao {

    Connection connection = Database.getInstance().getConnection();

    /**
     *
     * @return @throws SQLException
     */
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findAll() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findUserLogin(String username) throws SQLException {
        ArrayList<Users> ListUsers = new ArrayList<Users>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users where user_name = '" + username + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users u = Users.getFromResultSet(resulSet);
                ListUsers.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListUsers;
    }
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findStaff() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users where role = 'Nhân viên'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findStaffActive() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users where role = 'Nhân viên' and status = 'Hoạt động'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countUserBy(String str) throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods JOIN typeofgoods ON goods.type_code = typeofgoods.type_code WHERE typeofgoods.type_name = '" + str + "';";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countStaff() throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(user_name) as count_staff from users WHERE role = 'Nhân viên'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_staff");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    
    public static void updateStatus(Users us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "update users set status = ? where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getStatus());
            statement.setString(2, us.getUsername());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static Users findStaffByUsername(String username) throws SQLException {
        Users user = new Users();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users where role = 'Nhân viên' and user_name = '" + username + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return user;
    }
    
    
    public static void deleteStaff(Users us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "DELETE FROM `users` WHERE `users`.`user_name` = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getUsername());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> searchStaff(String str) throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and (id_user LIKE '%" + str + "%' or user_name LIKE '%" + str + "%' or full_name LIKE '%" + str + "%' or gender LIKE '%" + str + "%' or birthday LIKE '%" + str + "%' or start_date LIKE '%" + str + "%' or address LIKE '%" + str + "%' or phone_number LIKE '%" + str + "%' or email LIKE '%" + str + "%' or basic_salary LIKE '%" + str + "%' or allowance LIKE '%" + str + "%' or status LIKE '%" + str + "%')";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countStaffSearch(String str) throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(user_name) as count_staff from users WHERE role = 'Nhân viên' and (id_user LIKE '%" + str + "%' or user_name LIKE '%" + str + "%' or full_name LIKE '%" + str + "%' or gender LIKE '%" + str + "%' or birthday LIKE '%" + str + "%' or start_date LIKE '%" + str + "%' or address LIKE '%" + str + "%' or phone_number LIKE '%" + str + "%' or email LIKE '%" + str + "%' or basic_salary LIKE '%" + str + "%' or allowance LIKE '%" + str + "%' or status LIKE '%" + str + "%')";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_staff");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    
    public static void insertStaff(Users us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "INSERT INTO `users` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getId());
            statement.setString(2, us.getUsername());
            statement.setString(3, us.getPassword());
            statement.setString(4, us.getRole());
            statement.setString(5, us.getFullname());
            statement.setString(6, us.getGender());
            
            java.sql.Date birthday =  new java.sql.Date(us.getBirthday().getTime());
            java.sql.Date startdate = new java.sql.Date(us.getStartdate().getTime());
            
            statement.setDate(7, birthday);
            statement.setDate(8, startdate);
            statement.setString(9, us.getAddress());
            statement.setString(10, us.getPhonenumber());
            statement.setString(11, us.getEmail());
            statement.setFloat(12, us.getBasicsalary());
            statement.setFloat(13, us.getAllowance());
            statement.setString(14, us.getImage_user());
            statement.setString(15, us.getStatus());

            statement.execute();
            System.out.println("Insert successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findStaffBy(String id, String username, String phonenumber, String email) throws SQLException {
        ArrayList<Users> users = new ArrayList<Users>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and (id_user = '" + id + "' or user_name = '" + username + "' or  phone_number = '" + phonenumber + "' or email = '" + email + "')";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> checkEmail(String email) throws SQLException {
        ArrayList<Users> users = new ArrayList<Users>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and email = '" + email + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return users;
    }
    
    public static void updateStaff(Users us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "update users set full_name = ?, gender = ?, birthday = ?, start_date = ?, address = ?, basic_salary = ?, allowance = ?, image_user = ?, role = ? where user_name = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getFullname());
            statement.setString(2, us.getGender());
            
            java.sql.Date birthday =  new java.sql.Date(us.getBirthday().getTime());
            java.sql.Date startdate = new java.sql.Date(us.getStartdate().getTime());
            
            statement.setDate(3, birthday);
            statement.setDate(4, startdate);
            statement.setString(5, us.getAddress());
            statement.setFloat(6, us.getBasicsalary());
            statement.setFloat(7, us.getAllowance());
            statement.setString(8, us.getImage_user());
            statement.setString(9, us.getRole());
            statement.setString(10, us.getUsername());

            statement.execute();
            System.out.println("Insert successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @SuppressWarnings("empty-statement")
    public static Users findStaffById(String id) throws SQLException {
        Users user = new Users();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and id_user = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user = Users.getFromResultSet(resulSet);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return user;
    }
    
    public static void chancePassword(String username, String password) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "update users set password = ? where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, password);
            statement.setString(2, username);
            
            statement.execute();
            System.out.println("Chance password successful!");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static Users findUserLogin(String username, String password) throws SQLException {
        Users user = new Users();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "select * from users where user_name = '" + username + "' AND password = '" + password +"'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user = user.getFromResultSet(resulSet);
                return user;
            }
            resulSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getRevnueStaffByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT users.id_user, users.full_name, SUM(price*amount/100*(100-discount)) as 'revenue' FROM `invoicedetails` JOIN `bill` ON invoicedetails.code_bill = bill.code_bill JOIN users ON bill.id_user = users.id_user WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY users.id_user, users.full_name";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("full_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getRevnueStaffByPeriod(String fromDate, String toDate) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT users.id_user, users.full_name, SUM(price*amount/100*(100-discount)) as 'revenue' FROM `invoicedetails` JOIN `bill` ON invoicedetails.code_bill = bill.code_bill JOIN users ON bill.id_user = users.id_user WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY users.id_user, users.full_name";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("full_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getRevnueProductByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT typeofgoods.type_name, date(bill.invoice_creation_date) as 'date', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM invoicedetails JOIN goods ON invoicedetails.item_code = goods.item_code JOIN typeofgoods ON goods.type_code = typeofgoods.type_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY date";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("type_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Users> getRevnueProductByPeriod(String fromDate, String toDate) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT typeofgoods.type_name, date(bill.invoice_creation_date) as 'date', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM invoicedetails JOIN goods ON invoicedetails.item_code = goods.item_code JOIN typeofgoods ON goods.type_code = typeofgoods.type_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY date";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("type_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getRevnueProductByDate1(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT typeofgoods.type_name, date(bill.invoice_creation_date) as 'date', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM invoicedetails JOIN goods ON invoicedetails.item_code = goods.item_code JOIN typeofgoods ON goods.type_code = typeofgoods.type_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY date, typeofgoods.type_name";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("type_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getRevnueProductByPeriod1(String fromDate, String toDate) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT typeofgoods.type_name, date(bill.invoice_creation_date) as 'date', SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM invoicedetails JOIN goods ON invoicedetails.item_code = goods.item_code JOIN typeofgoods ON goods.type_code = typeofgoods.type_code JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY date, typeofgoods.type_name";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setFullname(resulSet.getNString("type_name"));
                u.setBasicsalary(resulSet.getFloat("revenue"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static ArrayList<Users> getTotalRevnueByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT date(bill.invoice_creation_date) as date, SUM(invoicedetails.price*invoicedetails.amount/100*(100-invoicedetails.discount)) as 'revenue' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY date";
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setBasicsalary(resulSet.getFloat("revenue"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getTotalFundsByDate(String year, String month, String day, boolean m, boolean d) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT date(bill.invoice_creation_date) as date, SUM(goods.import_price*invoicedetails.amount) as 'funds' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill JOIN goods ON invoicedetails.item_code = goods.item_code WHERE YEAR(invoice_creation_date) = '" + year + "' ";
            if (m) {
                sql += " and month(invoice_creation_date) = '" + month + "'";
            }
            if (d) {
                sql += " and day(invoice_creation_date) = '" + day + "' ";
            }
            sql += " GROUP BY date";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setBasicsalary(resulSet.getFloat("funds"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Users> getTotalFundsByPeriod(String fromDate, String toDate) throws SQLException {
        ArrayList<Users> lu = new ArrayList<>();
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT date(bill.invoice_creation_date) as date, SUM(goods.import_price*invoicedetails.amount) as 'funds' FROM `invoicedetails` JOIN bill ON invoicedetails.code_bill = bill.code_bill JOIN goods ON invoicedetails.item_code = goods.item_code WHERE date(invoice_creation_date) >= '" + fromDate +"' and date(invoice_creation_date) <= '" + toDate + "' ";
            
            sql += " GROUP BY date";
            
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Users u = new Users();
                u.setBasicsalary(resulSet.getFloat("funds"));
                u.setBirthday(resulSet.getDate("date"));
                lu.add(u);
            }
            resulSet.close();
            return lu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int countStaffActive() throws SQLException {
        int staffActive = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(id_user) as 'staff_active' FROM `users` WHERE role = 'Nhân viên' and status = 'Hoạt động'";
            ResultSet resulSet = statement.executeQuery(sql);
            if(resulSet.next()){
                staffActive = resulSet.getInt("staff_active");
            }
            resulSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffActive;
    }
    public static int countStaffBlock() throws SQLException {
        int staffActive = 0;
        Statement statement = null;
        try {
            Connection connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(id_user) as 'staff_block' FROM `users` WHERE role = 'Nhân viên' and status = 'Khóa'";
            ResultSet resulSet = statement.executeQuery(sql);
            if(resulSet.next()){
                staffActive = resulSet.getInt("staff_block");
            }
            resulSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffActive;
    }
    
    public static void main(String[] args) throws SQLException {
        int n = countStaffActive();
        System.out.println(n);
    }
}

