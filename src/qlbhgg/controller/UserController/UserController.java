/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.UserController;

import java.sql.SQLException;
import java.util.ArrayList;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Users;

/**
 *
 * @author ADMIN
 */
public class UserController {
    public ArrayList<Users> getUsers() throws SQLException {
        UsersDao ud = new UsersDao();
        ArrayList<Users> list = ud.findStaff();
        return list;
    } 
    public static Users findStaffById(String id) throws SQLException {
        Users user = new Users();
        user = UsersDao.findStaffById(id);
        return user;
    }
    public static void insertStaff(Users us) {
        UsersDao.insertStaff(us);
    }
    public static void updateStaff(Users us) {
        UsersDao.updateStaff(us);
    }
    public static ArrayList<Users> findStaff() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        users = UsersDao.findStaff();
        return users;
    }
    public static int countStaff() throws SQLException {
        int count = 0;
        count = UsersDao.countStaff();
        return count;
    }
    public static int countStaffActive() throws SQLException {
        int staffActive = 0;
        staffActive = UsersDao.countStaffActive();
        return staffActive;
    }
    public static int countStaffBlock() throws SQLException {
        int staffBlock = 0;
        staffBlock = UsersDao.countStaffBlock();
        return staffBlock;
    }
}
