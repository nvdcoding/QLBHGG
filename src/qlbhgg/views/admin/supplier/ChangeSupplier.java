/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.supplier;

import Helpers.Helper;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import qlbhgg.controller.SupplierController.SupplierController;
import qlbhgg.models.Suppliers;

/**
 *
 * @author acer
 */
public class ChangeSupplier extends javax.swing.JFrame {

    /**
     * Creates new form AddCustomer
     */
    private static String key;
    private static String code;
    private String path = "";
    private static PanelSupplier ps;
    private int XX, YY;

    public ChangeSupplier(String key, PanelSupplier ps, String code) throws SQLException {
        initComponents();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        this.key = key;
        this.code = code;
        this.ps = ps;
        setProduct(this.code);
    }

    public ChangeSupplier(String key, PanelSupplier ps) {
        initComponents();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        path = "";
        this.key = key;
        this.ps = ps;
    }

    public Suppliers getSupplier() {
        Suppliers supplier = new Suppliers();
        supplier.setCompanyname(txtCompanyName.getText());
        supplier.setAddress(txtCompanyAddress.getText());
        supplier.setTradingname(txtCompanyTrade.getText());
        supplier.setEmail(txtCompanyEmail.getText());
        supplier.setPhonenumber(txtCompanyPhone.getText());
        supplier.setLogo(path);
        return supplier;
    }

    private void setProduct(String code) throws SQLException {
        SupplierController supplierController = new SupplierController();

        Suppliers s = new Suppliers();
        s = supplierController.getSupplierObject(code);
        txtCompanyName.setText(s.getCompanyname());
        txtCompanyAddress.setText(s.getAddress());
        txtCompanyTrade.setText(s.getTradingname());
        txtCompanyEmail.setText(s.getEmail());
        txtCompanyPhone.setText(s.getPhonenumber());
        path = s.getLogo();
        ImageIcon icon = new ImageIcon(getClass().getResource(s.getLogo()));
        Image image = icon.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        jLabel9.setIcon(scaledIcon);
    }

    private boolean isEmpty() {
        if (txtCompanyName.getText().equals("") || txtCompanyAddress.getText().equals("") || txtCompanyTrade.getText().equals("") || txtCompanyEmail.getText().equals("") || txtCompanyPhone.getText().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtCompanyAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyTrade = new javax.swing.JTextField();
        txtCompanyEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCompanyPhone = new javax.swing.JTextField();
        jButtonSaveSupplier = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonSelectLogo = new javax.swing.JButton();
        lbNotice = new javax.swing.JLabel();
        jPanelTitle = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên nhà cung cấp:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        txtCompanyName.setBackground(new java.awt.Color(255, 255, 255));
        txtCompanyName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 180, -1));

        txtCompanyAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtCompanyAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtCompanyAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 180, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Địa chỉ:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Giao dịch:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtCompanyTrade.setBackground(new java.awt.Color(255, 255, 255));
        txtCompanyTrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtCompanyTrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 320, 60));

        txtCompanyEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtCompanyEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtCompanyEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 180, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Email:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 70, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Số điện thoại:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        txtCompanyPhone.setBackground(new java.awt.Color(255, 255, 255));
        txtCompanyPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCompanyPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompanyPhoneKeyTyped(evt);
            }
        });
        jPanel1.add(txtCompanyPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 180, -1));

        jButtonSaveSupplier.setBackground(new java.awt.Color(102, 178, 255));
        jButtonSaveSupplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSaveSupplier.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSaveSupplier.setText("Lưu");
        jButtonSaveSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSaveSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 110, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Logo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 70, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Show lgo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 150, 150));

        jButtonSelectLogo.setBackground(new java.awt.Color(102, 178, 255));
        jButtonSelectLogo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSelectLogo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSelectLogo.setText("Chọn");
        jButtonSelectLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelectLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectLogoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSelectLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 80, 30));

        lbNotice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNotice.setForeground(new java.awt.Color(255, 0, 51));
        lbNotice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbNotice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 320, 20));

        jPanelTitle.setBackground(new java.awt.Color(0, 0, 0));
        jPanelTitle.setForeground(new java.awt.Color(0, 0, 0));

        jLabelExit.setBackground(new java.awt.Color(0, 0, 0));
        jLabelExit.setForeground(new java.awt.Color(0, 0, 0));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png"))); // NOI18N
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_overwolf_25px.png"))); // NOI18N
        jLabelTitle.setText("Sửa thông tin nhà cung cấp");
        jLabelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabelTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelTitleMouseDragged(evt);
            }
        });
        jLabelTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTitleMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelExit))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSupplierActionPerformed
        try {
            // TODO add your handling code here:
            Helper helper = new Helper();
            if (isEmpty()) {
                helper.sendMessage("Vui lòng nhập đủ thông tin");
                return;
            }
            if (!helper.validateMail(txtCompanyEmail.getText())) {
                lbNotice.setText("Vui lòng nhập đúng định dạng email !!!");
                return;
            }
            if (path.equals("")) {
                helper.sendMessage("Vui lòng chọn ảnh");
                return;
            }
            SupplierController sc = new SupplierController();
            switch (key) {
                case "add":
                    sc.addSupplier(this);
                    helper.sendMessage("Thêm nhà cung cấp thành công");
                    ps.update();
                    this.dispose();
                    break;
                case "update":
                    sc.updateSupplier(this, code);
                    helper.sendMessage("Cập nhật nhà cung cấp thành công");
                    ps.update();
                    this.dispose();
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangeSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonSaveSupplierActionPerformed

    private void jButtonSelectLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectLogoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i >= 0) {
            extension = filename.substring(i + 1);
        }
        if (extension.equals("png") || extension.equals("jpg")) {
            String[] parts = filename.split("\\\\");
            boolean check = false;
            for (String item : parts) {
                if (item.equals("LogoSupplier") || check) {
                    path += "/" + item;
                    check = true;
                }
            }
            ImageIcon icon = new ImageIcon(filename);
            Image image = icon.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            jLabel9.setIcon(scaledIcon);
        } else {
            Helper helper = new Helper();
            helper.sendMessage("Vui lòng chọn định dạng file png hoặc jpg");
            return;
        }
    }//GEN-LAST:event_jButtonSelectLogoActionPerformed

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered

        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited

        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png")));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTitleMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - XX, y - YY);
    }//GEN-LAST:event_jLabelTitleMouseDragged

    private void jLabelTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTitleMousePressed
        XX = evt.getX();
        YY = evt.getY();
    }//GEN-LAST:event_jLabelTitleMousePressed

    private void txtCompanyPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyPhoneKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCompanyPhoneKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChangeSupplier(key, ps, code).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ChangeSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveSupplier;
    private javax.swing.JButton jButtonSelectLogo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JLabel lbNotice;
    private javax.swing.JTextField txtCompanyAddress;
    private javax.swing.JTextField txtCompanyEmail;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtCompanyPhone;
    private javax.swing.JTextField txtCompanyTrade;
    // End of variables declaration//GEN-END:variables
}