/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.supplier;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.controller.SupplierController.SupplierController;
import qlbhgg.dao.SupplierDao;
import qlbhgg.models.Suppliers;
import qlbhgg.views.admin.AdminForm;

/**
 *
 * @author acer
 */
public class PanelSupplier extends javax.swing.JPanel {

    /**
     * Creates new form PanelSupplier
     */
    private SupplierController sc = new SupplierController();
    public ArrayList<Suppliers> ListSuppliers = sc.getAllSupplier();
    public int countSupplier = sc.countSupplier();
    public int setPageSupplier;

    public PanelSupplier() throws SQLException {
        initComponents();
        showSupplierList(ListSuppliers, countSupplier);
    }

    public void startingStateQLNCC() {
        jPanelSupplier1.setVisible(false);
        jPanelSupplier2.setVisible(false);
        jPanelSupplier3.setVisible(false);
        jPanelSupplier4.setVisible(false);
        jPanelSupplier5.setVisible(false);
        jPanelSupplier6.setVisible(false);
        jPanelSupplier7.setVisible(false);
        jPanelSupplier8.setVisible(false);
        jPanelSupplier9.setVisible(false);
    }
    
    public int setPageSupplier(){
        setPageSupplier = (countSupplier % 9 == 0) ? 0 : 1;
        jLabelPageSupplier.setText("/" + String.valueOf(countSupplier / 9 + setPageSupplier));
        int pageSupplier = (Integer.parseInt(jTextFieldPageSupplier.getText()) - 1) * 9;
        return pageSupplier;
    }
    public void update() throws SQLException {
        ListSuppliers = SupplierDao.findAllSupplier();
        countSupplier = SupplierDao.countSupplier();
        showSupplierList(ListSuppliers, countSupplier);
    }
    public void showSupplierList(ArrayList<Suppliers> ListSuppliers, int countSupplier) throws SQLException {
        startingStateQLNCC();
        int pageSupplier = setPageSupplier();
        if (pageSupplier < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier), pageSupplier + 1, jPanelSupplier1, jLabelNumOrder1, jLabelIdSupplier1, jLabelNameSupplier1, jLabelLogoSupplier1, jLabelNameTrading1, jLabelAddressSupplier1, jLabelEmailSupplier1, jLabelPhonenumberSupplier1);
        } else {
            jPanelSupplier1.setVisible(false);
        }
        if (pageSupplier + 1 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 1), pageSupplier + 2, jPanelSupplier2, jLabelNumOrder2, jLabelIdSupplier2, jLabelNameSupplier2, jLabelLogoSupplier2, jLabelNameTrading2, jLabelAddressSupplier2, jLabelEmailSupplier2, jLabelPhonenumberSupplier2);
        } else {
            jPanelSupplier2.setVisible(false);
        }
        if (pageSupplier + 2 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 2), pageSupplier + 3, jPanelSupplier3, jLabelNumOrder3, jLabelIdSupplier3, jLabelNameSupplier3, jLabelLogoSupplier3, jLabelNameTrading3, jLabelAddressSupplier3, jLabelEmailSupplier3, jLabelPhonenumberSupplier3);
        } else {
            jPanelSupplier3.setVisible(false);
        }
        if (pageSupplier + 3 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 3), pageSupplier + 4, jPanelSupplier4, jLabelNumOrder4, jLabelIdSupplier4, jLabelNameSupplier4, jLabelLogoSupplier4, jLabelNameTrading4, jLabelAddressSupplier4, jLabelEmailSupplier4, jLabelPhonenumberSupplier4);
        } else {
            jPanelSupplier4.setVisible(false);
        }
        if (pageSupplier + 4 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 4), pageSupplier + 5, jPanelSupplier5, jLabelNumOrder5, jLabelIdSupplier5, jLabelNameSupplier5, jLabelLogoSupplier5, jLabelNameTrading5, jLabelAddressSupplier5, jLabelEmailSupplier5, jLabelPhonenumberSupplier5);
        } else {
            jPanelSupplier5.setVisible(false);
        }
        if (pageSupplier + 5 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 5), pageSupplier + 6, jPanelSupplier6, jLabelNumOrder6, jLabelIdSupplier6, jLabelNameSupplier6, jLabelLogoSupplier6, jLabelNameTrading6, jLabelAddressSupplier6, jLabelEmailSupplier6, jLabelPhonenumberSupplier6);
        } else {
            jPanelSupplier6.setVisible(false);
        }
        if (pageSupplier + 6 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 6), pageSupplier + 7, jPanelSupplier7, jLabelNumOrder7, jLabelIdSupplier7, jLabelNameSupplier7, jLabelLogoSupplier7, jLabelNameTrading7, jLabelAddressSupplier7, jLabelEmailSupplier7, jLabelPhonenumberSupplier7);
        } else {
            jPanelSupplier7.setVisible(false);
        }
        if (pageSupplier + 7 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 7), pageSupplier + 8, jPanelSupplier8, jLabelNumOrder8, jLabelIdSupplier8, jLabelNameSupplier8, jLabelLogoSupplier8, jLabelNameTrading8, jLabelAddressSupplier8, jLabelEmailSupplier8, jLabelPhonenumberSupplier8);
        } else {
            jPanelSupplier8.setVisible(false);
        }
        if (pageSupplier + 8 < countSupplier) {
            renderJPanelSupplier(ListSuppliers.get(pageSupplier + 8), pageSupplier + 9, jPanelSupplier9, jLabelNumOrder9, jLabelIdSupplier9, jLabelNameSupplier9, jLabelLogoSupplier9, jLabelNameTrading9, jLabelAddressSupplier9, jLabelEmailSupplier9, jLabelPhonenumberSupplier9);
        } else {
            jPanelSupplier9.setVisible(false);
        }
        jLabelFrameSearchSupplier.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelSupplier(Suppliers s, int numOrder, JPanel jpanel, JLabel jlabelNumOrder, JLabel jlabelIdSupplier, JLabel jlabelNameSupplier, JLabel jlabelLogoSupplier, JLabel jlabelNameTradingSupplier, JLabel jlabelAddressSupplier, JLabel jlabelEmailSupplier, JLabel jlabelPhonenumberSupplier) {
        jpanel.setVisible(true);
        jlabelNumOrder.setText(String.valueOf(numOrder));
        jlabelIdSupplier.setText(s.getCompanycode());
        jlabelNameSupplier.setText(s.getCompanyname());
        jlabelLogoSupplier.setIcon(scaleImageProduct(s.getLogo()));
        jlabelNameTradingSupplier.setText("<html>" + s.getTradingname() + "</html>");
        jlabelEmailSupplier.setText(s.getEmail());
        jlabelAddressSupplier.setText("<html>" + s.getAddress() + "</html>");
        jlabelPhonenumberSupplier.setText(s.getPhonenumber());
    }

    public ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public ImageIcon scaleImageProduct(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(78, 78, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }
    private void handleEvent(JLabel jl) throws SQLException {
        String code = jl.getText();
        ChangeSupplier changeSupplier = new ChangeSupplier("update", this, code);
        changeSupplier.setDefaultCloseOperation(changeSupplier.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLNCC = new javax.swing.JPanel();
        jPanelSupplier9 = new javax.swing.JPanel();
        jLabelIdSupplier9 = new javax.swing.JLabel();
        jLabelNameSupplier9 = new javax.swing.JLabel();
        jLabelLogoSupplier9 = new javax.swing.JLabel();
        jLabelNameTrading9 = new javax.swing.JLabel();
        jLabelAddressSupplier9 = new javax.swing.JLabel();
        jLabelEmailSupplier9 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier9 = new javax.swing.JLabel();
        jLabelSettingSupplier9 = new javax.swing.JLabel();
        jLabelNumOrder9 = new javax.swing.JLabel();
        jPanelSupplier8 = new javax.swing.JPanel();
        jLabelIdSupplier8 = new javax.swing.JLabel();
        jLabelNameSupplier8 = new javax.swing.JLabel();
        jLabelLogoSupplier8 = new javax.swing.JLabel();
        jLabelNameTrading8 = new javax.swing.JLabel();
        jLabelAddressSupplier8 = new javax.swing.JLabel();
        jLabelEmailSupplier8 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier8 = new javax.swing.JLabel();
        jLabelSettingSupplier8 = new javax.swing.JLabel();
        jLabelNumOrder8 = new javax.swing.JLabel();
        jPanelSupplier7 = new javax.swing.JPanel();
        jLabelIdSupplier7 = new javax.swing.JLabel();
        jLabelNameSupplier7 = new javax.swing.JLabel();
        jLabelLogoSupplier7 = new javax.swing.JLabel();
        jLabelNameTrading7 = new javax.swing.JLabel();
        jLabelAddressSupplier7 = new javax.swing.JLabel();
        jLabelEmailSupplier7 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier7 = new javax.swing.JLabel();
        jLabelSettingSupplier7 = new javax.swing.JLabel();
        jLabelNumOrder7 = new javax.swing.JLabel();
        jPanelSupplier6 = new javax.swing.JPanel();
        jLabelIdSupplier6 = new javax.swing.JLabel();
        jLabelNameSupplier6 = new javax.swing.JLabel();
        jLabelLogoSupplier6 = new javax.swing.JLabel();
        jLabelNameTrading6 = new javax.swing.JLabel();
        jLabelAddressSupplier6 = new javax.swing.JLabel();
        jLabelEmailSupplier6 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier6 = new javax.swing.JLabel();
        jLabelSettingSupplier6 = new javax.swing.JLabel();
        jLabelNumOrder6 = new javax.swing.JLabel();
        jPanelSupplier5 = new javax.swing.JPanel();
        jLabelIdSupplier5 = new javax.swing.JLabel();
        jLabelNameSupplier5 = new javax.swing.JLabel();
        jLabelLogoSupplier5 = new javax.swing.JLabel();
        jLabelNameTrading5 = new javax.swing.JLabel();
        jLabelAddressSupplier5 = new javax.swing.JLabel();
        jLabelEmailSupplier5 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier5 = new javax.swing.JLabel();
        jLabelSettingSupplier5 = new javax.swing.JLabel();
        jLabelNumOrder5 = new javax.swing.JLabel();
        jPanelSupplier4 = new javax.swing.JPanel();
        jLabelIdSupplier4 = new javax.swing.JLabel();
        jLabelNameSupplier4 = new javax.swing.JLabel();
        jLabelLogoSupplier4 = new javax.swing.JLabel();
        jLabelNameTrading4 = new javax.swing.JLabel();
        jLabelAddressSupplier4 = new javax.swing.JLabel();
        jLabelEmailSupplier4 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier4 = new javax.swing.JLabel();
        jLabelSettingSupplier4 = new javax.swing.JLabel();
        jLabelNumOrder4 = new javax.swing.JLabel();
        jPanelSupplier3 = new javax.swing.JPanel();
        jLabelIdSupplier3 = new javax.swing.JLabel();
        jLabelNameSupplier3 = new javax.swing.JLabel();
        jLabelLogoSupplier3 = new javax.swing.JLabel();
        jLabelNameTrading3 = new javax.swing.JLabel();
        jLabelAddressSupplier3 = new javax.swing.JLabel();
        jLabelEmailSupplier3 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier3 = new javax.swing.JLabel();
        jLabelSettingSupplier3 = new javax.swing.JLabel();
        jLabelNumOrder3 = new javax.swing.JLabel();
        jPanelSupplier2 = new javax.swing.JPanel();
        jLabelIdSupplier2 = new javax.swing.JLabel();
        jLabelNameSupplier2 = new javax.swing.JLabel();
        jLabelLogoSupplier2 = new javax.swing.JLabel();
        jLabelNameTrading2 = new javax.swing.JLabel();
        jLabelAddressSupplier2 = new javax.swing.JLabel();
        jLabelEmailSupplier2 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier2 = new javax.swing.JLabel();
        jLabelSettingSupplier2 = new javax.swing.JLabel();
        jLabelNumOrder2 = new javax.swing.JLabel();
        jPanelSupplier1 = new javax.swing.JPanel();
        jLabelIdSupplier1 = new javax.swing.JLabel();
        jLabelNameSupplier1 = new javax.swing.JLabel();
        jLabelLogoSupplier1 = new javax.swing.JLabel();
        jLabelNameTrading1 = new javax.swing.JLabel();
        jLabelAddressSupplier1 = new javax.swing.JLabel();
        jLabelEmailSupplier1 = new javax.swing.JLabel();
        jLabelPhonenumberSupplier1 = new javax.swing.JLabel();
        jLabelSettingSupplier1 = new javax.swing.JLabel();
        jLabelNumOrder1 = new javax.swing.JLabel();
        jPanelHeaderSupplier = new javax.swing.JPanel();
        jLabelMaSP1 = new javax.swing.JLabel();
        jLabelImage8 = new javax.swing.JLabel();
        jLabelName8 = new javax.swing.JLabel();
        jLabelType8 = new javax.swing.JLabel();
        jLabelCompany8 = new javax.swing.JLabel();
        jLabelPriceImport1 = new javax.swing.JLabel();
        jLabelPrice8 = new javax.swing.JLabel();
        jLabelSettings1 = new javax.swing.JLabel();
        jLabelNumOrder = new javax.swing.JLabel();
        jPanelControlPageSupplier = new javax.swing.JPanel();
        jTextFieldPageSupplier = new javax.swing.JTextField();
        jLabelPageSupplier = new javax.swing.JLabel();
        jLabelRightSupplier = new javax.swing.JLabel();
        jLabelLeftSupplier = new javax.swing.JLabel();
        jLabelSkipToEndSupplier = new javax.swing.JLabel();
        jLabelSkipToStartSupplier = new javax.swing.JLabel();
        jTextFieldSearchSupplier = new javax.swing.JTextField();
        jLabelSearchSupplier = new javax.swing.JLabel();
        jLabelFrameSearchSupplier = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1330, 870));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDashboardQLNCC.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLNCC.setForeground(new java.awt.Color(255, 153, 153));
        jDashboardQLNCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier9.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier9.setText("Mã nhà cung cấp");
        jLabelIdSupplier9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier9.add(jLabelIdSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier9.setText("Tên nhà cung cấp");
        jPanelSupplier9.add(jLabelNameSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier9.add(jLabelLogoSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading9.setText("Tên giao dịch");
        jPanelSupplier9.add(jLabelNameTrading9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier9.setText("Địa chỉ");
        jLabelAddressSupplier9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier9.add(jLabelAddressSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier9.setText("Email");
        jPanelSupplier9.add(jLabelEmailSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier9.setText("Số điện thoại");
        jLabelPhonenumberSupplier9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier9.add(jLabelPhonenumberSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier9.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier9MouseClicked(evt);
            }
        });
        jPanelSupplier9.add(jLabelSettingSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder9.setText("1");
        jPanelSupplier9.add(jLabelNumOrder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1330, 80));

        jPanelSupplier8.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier8.setText("Mã nhà cung cấp");
        jLabelIdSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelIdSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier8.setText("Tên nhà cung cấp");
        jPanelSupplier8.add(jLabelNameSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelLogoSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading8.setText("Tên giao dịch");
        jPanelSupplier8.add(jLabelNameTrading8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier8.setText("Địa chỉ");
        jLabelAddressSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelAddressSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier8.setText("Email");
        jPanelSupplier8.add(jLabelEmailSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier8.setText("Số điện thoại");
        jLabelPhonenumberSupplier8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier8.add(jLabelPhonenumberSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier8.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier8MouseClicked(evt);
            }
        });
        jPanelSupplier8.add(jLabelSettingSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder8.setText("1");
        jPanelSupplier8.add(jLabelNumOrder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1330, 80));

        jPanelSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier7.setText("Mã nhà cung cấp");
        jLabelIdSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelIdSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier7.setText("Tên nhà cung cấp");
        jPanelSupplier7.add(jLabelNameSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelLogoSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading7.setText("Tên giao dịch");
        jPanelSupplier7.add(jLabelNameTrading7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier7.setText("Địa chỉ");
        jLabelAddressSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelAddressSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier7.setText("Email");
        jPanelSupplier7.add(jLabelEmailSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier7.setText("Số điện thoại");
        jLabelPhonenumberSupplier7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier7.add(jLabelPhonenumberSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier7.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier7MouseClicked(evt);
            }
        });
        jPanelSupplier7.add(jLabelSettingSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder7.setText("1");
        jPanelSupplier7.add(jLabelNumOrder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1330, 80));

        jPanelSupplier6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier6.setText("Mã nhà cung cấp");
        jLabelIdSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelIdSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier6.setText("Tên nhà cung cấp");
        jPanelSupplier6.add(jLabelNameSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelLogoSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading6.setText("Tên giao dịch");
        jPanelSupplier6.add(jLabelNameTrading6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier6.setText("Địa chỉ");
        jLabelAddressSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelAddressSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier6.setText("Email");
        jPanelSupplier6.add(jLabelEmailSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier6.setText("Số điện thoại");
        jLabelPhonenumberSupplier6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier6.add(jLabelPhonenumberSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier6MouseClicked(evt);
            }
        });
        jPanelSupplier6.add(jLabelSettingSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder6.setText("1");
        jPanelSupplier6.add(jLabelNumOrder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1330, 80));

        jPanelSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier5.setText("Mã nhà cung cấp");
        jLabelIdSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelIdSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier5.setText("Tên nhà cung cấp");
        jPanelSupplier5.add(jLabelNameSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelLogoSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading5.setText("Tên giao dịch");
        jPanelSupplier5.add(jLabelNameTrading5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier5.setText("Địa chỉ");
        jLabelAddressSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelAddressSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier5.setText("Email");
        jPanelSupplier5.add(jLabelEmailSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier5.setText("Số điện thoại");
        jLabelPhonenumberSupplier5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier5.add(jLabelPhonenumberSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier5MouseClicked(evt);
            }
        });
        jPanelSupplier5.add(jLabelSettingSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder5.setText("1");
        jPanelSupplier5.add(jLabelNumOrder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1330, 80));

        jPanelSupplier4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier4.setText("Mã nhà cung cấp");
        jLabelIdSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelIdSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier4.setText("Tên nhà cung cấp");
        jPanelSupplier4.add(jLabelNameSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelLogoSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading4.setText("Tên giao dịch");
        jPanelSupplier4.add(jLabelNameTrading4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier4.setText("Địa chỉ");
        jLabelAddressSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelAddressSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier4.setText("Email");
        jPanelSupplier4.add(jLabelEmailSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier4.setText("Số điện thoại");
        jLabelPhonenumberSupplier4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier4.add(jLabelPhonenumberSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier4MouseClicked(evt);
            }
        });
        jPanelSupplier4.add(jLabelSettingSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder4.setText("1");
        jPanelSupplier4.add(jLabelNumOrder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1330, 80));

        jPanelSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier3.setText("Mã nhà cung cấp");
        jLabelIdSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelIdSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier3.setText("Tên nhà cung cấp");
        jPanelSupplier3.add(jLabelNameSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelLogoSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading3.setText("Tên giao dịch");
        jPanelSupplier3.add(jLabelNameTrading3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier3.setText("Địa chỉ");
        jLabelAddressSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelAddressSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier3.setText("Email");
        jPanelSupplier3.add(jLabelEmailSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier3.setText("Số điện thoại");
        jLabelPhonenumberSupplier3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier3.add(jLabelPhonenumberSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier3MouseClicked(evt);
            }
        });
        jPanelSupplier3.add(jLabelSettingSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder3.setText("1");
        jPanelSupplier3.add(jLabelNumOrder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1330, 80));

        jPanelSupplier2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier2.setText("Mã nhà cung cấp");
        jLabelIdSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelIdSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier2.setText("Tên nhà cung cấp");
        jPanelSupplier2.add(jLabelNameSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelLogoSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading2.setText("Tên giao dịch");
        jPanelSupplier2.add(jLabelNameTrading2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier2.setText("Địa chỉ");
        jLabelAddressSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelAddressSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier2.setText("Email");
        jPanelSupplier2.add(jLabelEmailSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier2.setText("Số điện thoại");
        jLabelPhonenumberSupplier2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier2.add(jLabelPhonenumberSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier2MouseClicked(evt);
            }
        });
        jPanelSupplier2.add(jLabelSettingSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder2.setText("1");
        jPanelSupplier2.add(jLabelNumOrder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1330, 80));

        jPanelSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelSupplier1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIdSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelIdSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIdSupplier1.setText("Mã nhà cung cấp");
        jLabelIdSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelIdSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelNameSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameSupplier1.setText("Tên nhà cung cấp");
        jPanelSupplier1.add(jLabelNameSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 80));

        jLabelLogoSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogoSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogoSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelLogoSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 80));

        jLabelNameTrading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameTrading1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNameTrading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameTrading1.setText("Tên giao dịch");
        jPanelSupplier1.add(jLabelNameTrading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 80));

        jLabelAddressSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAddressSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddressSupplier1.setText("Địa chỉ");
        jLabelAddressSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelAddressSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 80));

        jLabelEmailSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmailSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmailSupplier1.setText("Email");
        jPanelSupplier1.add(jLabelEmailSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 80));

        jLabelPhonenumberSupplier1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhonenumberSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPhonenumberSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhonenumberSupplier1.setText("Số điện thoại");
        jLabelPhonenumberSupplier1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSupplier1.add(jLabelPhonenumberSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 80));

        jLabelSettingSupplier1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingSupplier1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingSupplier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingSupplier1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingSupplier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingSupplier1MouseClicked(evt);
            }
        });
        jPanelSupplier1.add(jLabelSettingSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 80));

        jLabelNumOrder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder1.setText("1");
        jPanelSupplier1.add(jLabelNumOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jDashboardQLNCC.add(jPanelSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1330, 80));

        jPanelHeaderSupplier.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeaderSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeaderSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMaSP1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMaSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaSP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaSP1.setText("Mã nhà cung cấp");
        jLabelMaSP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelMaSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelImage8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage8.setText("Tên nhà cung cấp");
        jPanelHeaderSupplier.add(jLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 40));

        jLabelName8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName8.setText("Logo");
        jLabelName8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 40));

        jLabelType8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelType8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType8.setText("Tên giao dịch");
        jPanelHeaderSupplier.add(jLabelType8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 210, 40));

        jLabelCompany8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCompany8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany8.setText("Địa chỉ");
        jLabelCompany8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelCompany8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 40));

        jLabelPriceImport1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceImport1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceImport1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceImport1.setText("Email");
        jPanelHeaderSupplier.add(jLabelPriceImport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 240, 40));

        jLabelPrice8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice8.setText("Số điện thoại");
        jLabelPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderSupplier.add(jLabelPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 140, 40));

        jLabelSettings1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettings1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettings1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelHeaderSupplier.add(jLabelSettings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 70, 40));

        jLabelNumOrder.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNumOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder.setText("STT");
        jPanelHeaderSupplier.add(jLabelNumOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jDashboardQLNCC.add(jPanelHeaderSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanelControlPageSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlPageSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPageSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageSupplier.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageSupplier.setText("1");
        jTextFieldPageSupplier.setBorder(null);
        jTextFieldPageSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageSupplierKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPageSupplierKeyTyped(evt);
            }
        });
        jPanelControlPageSupplier.add(jTextFieldPageSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 27, 40, -1));

        jLabelPageSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageSupplier.setText("/4");
        jPanelControlPageSupplier.add(jLabelPageSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 27, 40, -1));

        jLabelRightSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightSupplierMouseExited(evt);
            }
        });
        jPanelControlPageSupplier.add(jLabelRightSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 24, -1, -1));

        jLabelLeftSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftSupplierMouseExited(evt);
            }
        });
        jPanelControlPageSupplier.add(jLabelLeftSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 24, -1, -1));

        jLabelSkipToEndSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndSupplierMouseExited(evt);
            }
        });
        jPanelControlPageSupplier.add(jLabelSkipToEndSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 24, -1, -1));

        jLabelSkipToStartSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartSupplierMouseExited(evt);
            }
        });
        jPanelControlPageSupplier.add(jLabelSkipToStartSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 24, -1, -1));

        jDashboardQLNCC.add(jPanelControlPageSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 1330, 50));

        jTextFieldSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchSupplier.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchSupplier.setText("Tìm kiếm");
        jTextFieldSearchSupplier.setBorder(null);
        jTextFieldSearchSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchSupplier.setOpaque(false);
        jTextFieldSearchSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchSupplierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchSupplierFocusLost(evt);
            }
        });
        jTextFieldSearchSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchSupplierActionPerformed(evt);
            }
        });
        jTextFieldSearchSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchSupplierKeyReleased(evt);
            }
        });
        jDashboardQLNCC.add(jTextFieldSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 240, 30));

        jLabelSearchSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchSupplier.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLNCC.add(jLabelSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 30));

        jLabelFrameSearchSupplier.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLNCC.add(jLabelFrameSearchSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 280, 30));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Thêm");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDashboardQLNCC.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách nhà cung cấp");
        jDashboardQLNCC.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        add(jDashboardQLNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Integer.parseInt(jTextFieldPageSupplier.getText()) > countSupplier / 9 + setPageSupplier) {
                jTextFieldPageSupplier.setText(String.valueOf(countSupplier / 9 + setPageSupplier));
            } else if (Integer.parseInt(jTextFieldPageSupplier.getText()) < 1) {
                jTextFieldPageSupplier.setText("1");
            }
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldPageSupplierKeyPressed

    private void jLabelRightSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageSupplier.getText());
        int jlabelrightb = countSupplier / 9 + setPageSupplier;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageSupplier.setText(String.valueOf(Integer.parseInt(jTextFieldPageSupplier.getText()) + 1));

            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabelRightSupplierMouseClicked

    private void jLabelRightSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseEntered
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightSupplierMouseEntered

    private void jLabelRightSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSupplierMouseExited
        jLabelRightSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightSupplierMouseExited

    private void jLabelLeftSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseClicked
        if (Integer.parseInt(jTextFieldPageSupplier.getText()) > 1) {
            jTextFieldPageSupplier.setText(String.valueOf(Integer.parseInt(jTextFieldPageSupplier.getText()) - 1));
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftSupplierMouseClicked

    private void jLabelLeftSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseEntered
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftSupplierMouseEntered

    private void jLabelLeftSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSupplierMouseExited
        jLabelLeftSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftSupplierMouseExited

    private void jLabelSkipToEndSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageSupplier.getText());
        int jlabelrightb = countSupplier / 9 + setPageSupplier;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageSupplier.setText(String.valueOf(countSupplier / 9 + setPageSupplier));
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseClicked

    private void jLabelSkipToEndSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseEntered
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseEntered

    private void jLabelSkipToEndSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndSupplierMouseExited
        jLabelSkipToEndSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndSupplierMouseExited

    private void jLabelSkipToStartSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseClicked
        if (Integer.parseInt(jTextFieldPageSupplier.getText()) > 1) {
            jTextFieldPageSupplier.setText("1");
            try {
                showSupplierList(ListSuppliers, countSupplier);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseClicked

    private void jLabelSkipToStartSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseEntered
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseEntered

    private void jLabelSkipToStartSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartSupplierMouseExited
        jLabelSkipToStartSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartSupplierMouseExited

    private void jTextFieldSearchSupplierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierFocusGained

    }//GEN-LAST:event_jTextFieldSearchSupplierFocusGained

    private void jTextFieldSearchSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierFocusLost

    }//GEN-LAST:event_jTextFieldSearchSupplierFocusLost

    private void jTextFieldSearchSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierKeyReleased

    }//GEN-LAST:event_jTextFieldSearchSupplierKeyReleased

    private void jTextFieldPageSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageSupplierKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPageSupplierKeyTyped

    private void jTextFieldSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchSupplierActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ChangeSupplier changeSupplier = new ChangeSupplier("add", this);
        changeSupplier.setDefaultCloseOperation(changeSupplier.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelSettingSupplier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier1MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier1);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier1MouseClicked

    private void jLabelSettingSupplier2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier2MouseClicked
        try {
            // TODO add your handling code here:\
            handleEvent(jLabelIdSupplier2);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier2MouseClicked

    private void jLabelSettingSupplier3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier3MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier3);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier3MouseClicked

    private void jLabelSettingSupplier4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier4MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier4);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier4MouseClicked

    private void jLabelSettingSupplier5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier5MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier5);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier5MouseClicked

    private void jLabelSettingSupplier6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier6MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier6);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier6MouseClicked

    private void jLabelSettingSupplier7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier7MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier7);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier7MouseClicked

    private void jLabelSettingSupplier8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier8MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier8);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier8MouseClicked

    private void jLabelSettingSupplier9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingSupplier9MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdSupplier9);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingSupplier9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jDashboardQLNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddressSupplier1;
    private javax.swing.JLabel jLabelAddressSupplier2;
    private javax.swing.JLabel jLabelAddressSupplier3;
    private javax.swing.JLabel jLabelAddressSupplier4;
    private javax.swing.JLabel jLabelAddressSupplier5;
    private javax.swing.JLabel jLabelAddressSupplier6;
    private javax.swing.JLabel jLabelAddressSupplier7;
    private javax.swing.JLabel jLabelAddressSupplier8;
    private javax.swing.JLabel jLabelAddressSupplier9;
    private javax.swing.JLabel jLabelCompany8;
    private javax.swing.JLabel jLabelEmailSupplier1;
    private javax.swing.JLabel jLabelEmailSupplier2;
    private javax.swing.JLabel jLabelEmailSupplier3;
    private javax.swing.JLabel jLabelEmailSupplier4;
    private javax.swing.JLabel jLabelEmailSupplier5;
    private javax.swing.JLabel jLabelEmailSupplier6;
    private javax.swing.JLabel jLabelEmailSupplier7;
    private javax.swing.JLabel jLabelEmailSupplier8;
    private javax.swing.JLabel jLabelEmailSupplier9;
    private javax.swing.JLabel jLabelFrameSearchSupplier;
    private javax.swing.JLabel jLabelIdSupplier1;
    private javax.swing.JLabel jLabelIdSupplier2;
    private javax.swing.JLabel jLabelIdSupplier3;
    private javax.swing.JLabel jLabelIdSupplier4;
    private javax.swing.JLabel jLabelIdSupplier5;
    private javax.swing.JLabel jLabelIdSupplier6;
    private javax.swing.JLabel jLabelIdSupplier7;
    private javax.swing.JLabel jLabelIdSupplier8;
    private javax.swing.JLabel jLabelIdSupplier9;
    private javax.swing.JLabel jLabelImage8;
    private javax.swing.JLabel jLabelLeftSupplier;
    private javax.swing.JLabel jLabelLogoSupplier1;
    private javax.swing.JLabel jLabelLogoSupplier2;
    private javax.swing.JLabel jLabelLogoSupplier3;
    private javax.swing.JLabel jLabelLogoSupplier4;
    private javax.swing.JLabel jLabelLogoSupplier5;
    private javax.swing.JLabel jLabelLogoSupplier6;
    private javax.swing.JLabel jLabelLogoSupplier7;
    private javax.swing.JLabel jLabelLogoSupplier8;
    private javax.swing.JLabel jLabelLogoSupplier9;
    private javax.swing.JLabel jLabelMaSP1;
    private javax.swing.JLabel jLabelName8;
    private javax.swing.JLabel jLabelNameSupplier1;
    private javax.swing.JLabel jLabelNameSupplier2;
    private javax.swing.JLabel jLabelNameSupplier3;
    private javax.swing.JLabel jLabelNameSupplier4;
    private javax.swing.JLabel jLabelNameSupplier5;
    private javax.swing.JLabel jLabelNameSupplier6;
    private javax.swing.JLabel jLabelNameSupplier7;
    private javax.swing.JLabel jLabelNameSupplier8;
    private javax.swing.JLabel jLabelNameSupplier9;
    private javax.swing.JLabel jLabelNameTrading1;
    private javax.swing.JLabel jLabelNameTrading2;
    private javax.swing.JLabel jLabelNameTrading3;
    private javax.swing.JLabel jLabelNameTrading4;
    private javax.swing.JLabel jLabelNameTrading5;
    private javax.swing.JLabel jLabelNameTrading6;
    private javax.swing.JLabel jLabelNameTrading7;
    private javax.swing.JLabel jLabelNameTrading8;
    private javax.swing.JLabel jLabelNameTrading9;
    private javax.swing.JLabel jLabelNumOrder;
    private javax.swing.JLabel jLabelNumOrder1;
    private javax.swing.JLabel jLabelNumOrder2;
    private javax.swing.JLabel jLabelNumOrder3;
    private javax.swing.JLabel jLabelNumOrder4;
    private javax.swing.JLabel jLabelNumOrder5;
    private javax.swing.JLabel jLabelNumOrder6;
    private javax.swing.JLabel jLabelNumOrder7;
    private javax.swing.JLabel jLabelNumOrder8;
    private javax.swing.JLabel jLabelNumOrder9;
    private javax.swing.JLabel jLabelPageSupplier;
    private javax.swing.JLabel jLabelPhonenumberSupplier1;
    private javax.swing.JLabel jLabelPhonenumberSupplier2;
    private javax.swing.JLabel jLabelPhonenumberSupplier3;
    private javax.swing.JLabel jLabelPhonenumberSupplier4;
    private javax.swing.JLabel jLabelPhonenumberSupplier5;
    private javax.swing.JLabel jLabelPhonenumberSupplier6;
    private javax.swing.JLabel jLabelPhonenumberSupplier7;
    private javax.swing.JLabel jLabelPhonenumberSupplier8;
    private javax.swing.JLabel jLabelPhonenumberSupplier9;
    private javax.swing.JLabel jLabelPrice8;
    private javax.swing.JLabel jLabelPriceImport1;
    private javax.swing.JLabel jLabelRightSupplier;
    private javax.swing.JLabel jLabelSearchSupplier;
    private javax.swing.JLabel jLabelSettingSupplier1;
    private javax.swing.JLabel jLabelSettingSupplier2;
    private javax.swing.JLabel jLabelSettingSupplier3;
    private javax.swing.JLabel jLabelSettingSupplier4;
    private javax.swing.JLabel jLabelSettingSupplier5;
    private javax.swing.JLabel jLabelSettingSupplier6;
    private javax.swing.JLabel jLabelSettingSupplier7;
    private javax.swing.JLabel jLabelSettingSupplier8;
    private javax.swing.JLabel jLabelSettingSupplier9;
    private javax.swing.JLabel jLabelSettings1;
    private javax.swing.JLabel jLabelSkipToEndSupplier;
    private javax.swing.JLabel jLabelSkipToStartSupplier;
    private javax.swing.JLabel jLabelType8;
    private javax.swing.JPanel jPanelControlPageSupplier;
    private javax.swing.JPanel jPanelHeaderSupplier;
    private javax.swing.JPanel jPanelSupplier1;
    private javax.swing.JPanel jPanelSupplier2;
    private javax.swing.JPanel jPanelSupplier3;
    private javax.swing.JPanel jPanelSupplier4;
    private javax.swing.JPanel jPanelSupplier5;
    private javax.swing.JPanel jPanelSupplier6;
    private javax.swing.JPanel jPanelSupplier7;
    private javax.swing.JPanel jPanelSupplier8;
    private javax.swing.JPanel jPanelSupplier9;
    private javax.swing.JTextField jTextFieldPageSupplier;
    private javax.swing.JTextField jTextFieldSearchSupplier;
    // End of variables declaration//GEN-END:variables

}
