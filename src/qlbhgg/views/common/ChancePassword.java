/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.common;

import qlbhgg.dao.UsersDao;
import qlbhgg.models.Users;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

/**
 *
 * @author acer
 */
public class ChancePassword extends javax.swing.JFrame {

    public Users user;
    public int pincode = 0;
    public ChancePassword(Users userChancePassword) {
        initComponents();
        user = userChancePassword;
        jLabelPassword.setVisible(false);
        jLabelPassword1.setVisible(false);
        jLabel2.setVisible(false);
    }
    
/**
     * Creates new form ChancePassword
     */
        private void enterPassword(){
        if(checkPincode(jTextFieldPincode.getText()) && checkPassword(String.valueOf(jPasswordFieldPassword.getPassword())) && checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))){
            UsersDao.chancePassword(user.getUsername(), String.valueOf(jPasswordFieldPassword.getPassword()));
            jLabel2.setText("Đổi mật khẩu thành công");
            jLabel2.setForeground(Color.green);
            jLabel2.setVisible(true);
        }
        else{
            jLabel2.setText("Mã xác nhận không đúng");
            jLabel2.setForeground(Color.red);
            jLabel2.setVisible(true);
        }
    }
    
    public static boolean checkPassword(String password) {
        return !password.equals("") && Pattern.matches("^[a-zA-Z0-9]+$", password);
    }
    public static boolean checkConfirmPassword(String confirmpassword, String password) {
        return !confirmpassword.equals("") && confirmpassword.equals(password);
    }
    
    private boolean checkPincode(String pin) {
        return pin.equals(String.valueOf(pincode));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        jPanelTitle = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelChancePassword = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldConfirmPassword = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelPassword1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jButtonOKPassword = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPincode = new javax.swing.JTextField();
        jButtonSendcode = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelBG.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBG.setPreferredSize(new java.awt.Dimension(450, 400));
        jPanelBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitle.setBackground(new java.awt.Color(0, 0, 0));

        lbExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbExit.setForeground(new java.awt.Color(0, 0, 0));
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png"))); // NOI18N
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbExitMouseExited(evt);
            }
        });

        jLabelTitle.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_overwolf_25px.png"))); // NOI18N
        jLabelTitle.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelBG.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 30));

        jPanelChancePassword.setBackground(new java.awt.Color(255, 255, 255));
        jPanelChancePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelChancePassword.setPreferredSize(new java.awt.Dimension(450, 250));
        jPanelChancePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Xác nhận mật khẩu mới:");
        jPanelChancePassword.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, -1));

        jPasswordFieldConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordFieldConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldConfirmPassword.setBorder(null);
        jPasswordFieldConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyReleased(evt);
            }
        });
        jPanelChancePassword.add(jPasswordFieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 390, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanelChancePassword.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 390, 10));

        jLabelPassword1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        jPanelChancePassword.add(jLabelPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 290, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanelChancePassword.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 390, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mật khẩu mới:");
        jPanelChancePassword.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 230, -1));

        jLabelPassword.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPassword.setText("Mật khẩu chỉ được bao gồm kí tự chữ hoặc số");
        jPanelChancePassword.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 290, -1));

        jButtonOKPassword.setBackground(new java.awt.Color(70, 163, 242));
        jButtonOKPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonOKPassword.setForeground(new java.awt.Color(0, 0, 0));
        jButtonOKPassword.setText("Xác nhận");
        jButtonOKPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOKPassword.setFocusable(false);
        jButtonOKPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonOKPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonOKPasswordMouseExited(evt);
            }
        });
        jButtonOKPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKPasswordActionPerformed(evt);
            }
        });
        jPanelChancePassword.add(jButtonOKPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 120, 40));

        jPasswordFieldPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordFieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordFieldPassword.setBorder(null);
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyReleased(evt);
            }
        });
        jPanelChancePassword.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 390, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nhập mã xác minh:");
        jPanelChancePassword.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 400, 30));

        jTextFieldPincode.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPincode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldPincode.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPincode.setBorder(null);
        jTextFieldPincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPincodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPincodeKeyTyped(evt);
            }
        });
        jPanelChancePassword.add(jTextFieldPincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 290, 30));

        jButtonSendcode.setBackground(new java.awt.Color(70, 163, 242));
        jButtonSendcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSendcode.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSendcode.setText("Gửi mã");
        jButtonSendcode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSendcode.setFocusable(false);
        jButtonSendcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSendcodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSendcodeMouseExited(evt);
            }
        });
        jButtonSendcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendcodeActionPerformed(evt);
            }
        });
        jPanelChancePassword.add(jButtonSendcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 100, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanelChancePassword.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 290, 10));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã xác minh không đúng");
        jPanelChancePassword.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 290, -1));

        jPanelBG.add(jPanelChancePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        
        this.dispose();
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseEntered
        
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_3.png")));
    }//GEN-LAST:event_lbExitMouseEntered

    private void lbExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseExited
        
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_close_window_25px_4.png")));
    }//GEN-LAST:event_lbExitMouseExited

    private void jPasswordFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyReleased
        if (!checkPassword(String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword.setVisible(true);
            jLabelPassword.setForeground(Color.red);
        } else {
            jLabelPassword.setVisible(false);
        }
        if (!checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword1.setVisible(true);
            jLabelPassword1.setForeground(Color.red);
            jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        } else {
            jLabelPassword1.setVisible(false);
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyReleased

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPassword();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jButtonOKPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKPasswordActionPerformed
        enterPassword();
    }//GEN-LAST:event_jButtonOKPasswordActionPerformed

    private void jButtonOKPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKPasswordMouseExited
        jButtonOKPassword.setBackground(new java.awt.Color(70, 163, 242));
    }//GEN-LAST:event_jButtonOKPasswordMouseExited

    private void jButtonOKPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKPasswordMouseEntered
        jButtonOKPassword.setBackground(new java.awt.Color(139, 195, 224));
    }//GEN-LAST:event_jButtonOKPasswordMouseEntered

    private void jPasswordFieldConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyReleased
        if (!checkConfirmPassword(String.valueOf(jPasswordFieldConfirmPassword.getPassword()), String.valueOf(jPasswordFieldPassword.getPassword()))) {
            jLabelPassword1.setVisible(true);
            jLabelPassword1.setForeground(Color.red);
            jLabelPassword1.setText("Mật khẩu xác nhận không trùng khớp");
        } else {
            jLabelPassword1.setVisible(false);
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyReleased

    private void jPasswordFieldConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPassword();
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyPressed
 
    private void jTextFieldPincodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPincodeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPassword();
        }
    }//GEN-LAST:event_jTextFieldPincodeKeyPressed

    private void jTextFieldPincodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPincodeKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPincodeKeyTyped

    private void jButtonSendcodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendcodeMouseEntered
        jButtonSendcode.setBackground(new java.awt.Color(139, 195, 224));
    }//GEN-LAST:event_jButtonSendcodeMouseEntered

    private void jButtonSendcodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendcodeMouseExited
        jButtonSendcode.setBackground(new java.awt.Color(70, 163, 242));
    }//GEN-LAST:event_jButtonSendcodeMouseExited

    private void jButtonSendcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendcodeActionPerformed
        pincode = qlbhgg.controller.mailhandle.MailHandle.SendPincode(user.getEmail(), "Đổi mật khẩu đăng nhập KMA-Gear");
    }//GEN-LAST:event_jButtonSendcodeActionPerformed

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
            java.util.logging.Logger.getLogger(ChancePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChancePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChancePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChancePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChancePassword(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOKPassword;
    private javax.swing.JButton jButtonSendcode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JPanel jPanelChancePassword;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordFieldConfirmPassword;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldPincode;
    private javax.swing.JLabel lbExit;
    // End of variables declaration//GEN-END:variables

    
}