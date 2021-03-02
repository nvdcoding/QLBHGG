/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.ProductController;

import java.sql.SQLException;
import qlbhgg.dao.GoodsDao;
import qlbhgg.models.Goods;
import qlbhgg.views.admin.warehouse.ChangeProduct;
/**
 *
 * @author ADMIN
 */
public class ProductController {
    public Goods getProduct(String itemCode) throws SQLException {
        Goods product = new Goods();
        GoodsDao gd = new GoodsDao();
        product = gd.getOne(itemCode);
        return product;
    }
    public void addProduct(ChangeProduct view) throws SQLException {
        GoodsDao gd = new GoodsDao();
        Goods product = view.getProduct();
        gd.addProduct(product);
    }
    public void updateProduct(ChangeProduct view, String codeProduct) {
        GoodsDao gd = new GoodsDao();
        Goods product = view.getProduct();
        gd.updateProduct(product, codeProduct);
    }
    public void deleteProduct(String codeProduct) {
        GoodsDao gd = new GoodsDao();
        gd.deleteProduct(codeProduct);
    }
    public static Goods findProductForBill(String id) throws SQLException {
        Goods g  = new Goods();
        g = GoodsDao.findProductForBill(id);
        return g;
    }
    public static int countProductWearHouse() throws SQLException {
        int count = 0;
        count = GoodsDao.countProductWearHouse();
        return count;
    }
    public static int countProductSold() throws SQLException {
        int count = 0;
        count = GoodsDao.countProductSold();
        return count;
    }
}
