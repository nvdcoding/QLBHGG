/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.WorkDay;
import qlbhgg.models.Users;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class WorkDayDao {

    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findAll() throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListWorkDay;
    }

    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findByUsername(Users user) throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping WHERE id_user = '" + user.getId() + "' AND time_working >= 28800";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListWorkDay;
    }

    public static int findTimeWorking(String id, int day, int month, int year) throws SQLException {
        int timeWorking = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM `timekeeping` WHERE id_user = '" + id + "' and day(work_day) = " + day + " and month(work_day) = " + month + " and year(work_day) = " + year;
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                timeWorking = resulSet.getInt("time_working");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeWorking;
    }

    @SuppressWarnings("empty-statement")
    public static int countWorkDay(String id, int month, int year) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(work_day) as count_day FROM `timekeeping` WHERE id_user = '" + id + "' and month(work_day) = " + month + " and year(work_day) = " + year + " AND time_working >= 28800";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_day");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void addWorkDay(String id) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO `timekeeping`(`id_user`, `work_day`, `time_working`) VALUES (?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, id);
            java.util.Date now = new java.util.Date();
            java.sql.Date creationDate = new java.sql.Date(now.getTime());
            statement.setDate(2, creationDate);
            statement.setInt(3, 1);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTimeWorking(String id, int time, int day, int month, int year) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `timekeeping` SET `time_working`= ? WHERE `id_user` = ? and day(work_day) = ? and month(work_day) = ? and year(work_day) = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, time);
            statement.setString(2, id);
            statement.setInt(3, day);
            statement.setInt(4, month);
            statement.setInt(5, year);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        int timeWorking = findTimeWorking("US00000002", 3, 1, 2021);
        System.out.println(timeWorking);
    }
}
