/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.TogController;

import java.sql.SQLException;
import java.util.ArrayList;
import qlbhgg.dao.TypeOfGoodDao;
import qlbhgg.models.TypeOfGoods;

/**
 *
 * @author ADMIN
 */
public class TogController {
    public ArrayList<TypeOfGoods> getAllType() throws SQLException {
        TypeOfGoodDao dao = new TypeOfGoodDao();
        ArrayList<TypeOfGoods> list = new ArrayList();
        list = dao.findAll();
        return list;
    }
    public String getType(String typeCode) {
        TypeOfGoodDao tp = new TypeOfGoodDao();
        String name = "";
        name = tp.getType(typeCode);
        return name;
    }
}

