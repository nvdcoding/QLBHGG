/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.warehouse;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.TypeOfGoodDao;
import qlbhgg.models.Goods;
import qlbhgg.views.admin.AdminForm;
import qlbhgg.views.common.DisplayImage;

/**
 *
 * @author acer
 */
public class PanelWarehouse extends javax.swing.JPanel {

    /**
     * Creates new form PanelWarehouse
     */
    public ArrayList<Goods> ListGoods = GoodsDao.findAll();
    public int countProduct = GoodsDao.countProduct();
    public int setPageProduct;

    public PanelWarehouse() throws SQLException {
        initComponents();
        TypeOfGoodDao.setComboboxType(jComboBoxType);
        showProducts(ListGoods, countProduct);
    }

    public void startingStateQLK() {
        jPanelGood1.setVisible(false);
        jPanelGood2.setVisible(false);
        jPanelGood3.setVisible(false);
        jPanelGood4.setVisible(false);
        jPanelGood5.setVisible(false);
        jPanelGood6.setVisible(false);
        jPanelGood7.setVisible(false);
        jPanelGood8.setVisible(false);
        jPanelGood9.setVisible(false);
    }
    public void update() throws SQLException {
        ListGoods = GoodsDao.findAll();
        countProduct = GoodsDao.countProduct();
        showProducts(ListGoods, countProduct);
    }
    public int setPageWarehouse(){
        setPageProduct = (countProduct % 9 == 0) ? 0 : 1;
        jLabelPageProduct.setText("/" + String.valueOf(countProduct / 9 + setPageProduct));
        int pageProduct = (Integer.parseInt(jTextFieldPageProduct.getText()) - 1) * 9;
        return  pageProduct;
    }

    private void showProducts(ArrayList<Goods> ListGoods, int countProduct) throws SQLException {
        startingStateQLK();
        int pageProduct = setPageWarehouse();
        if (pageProduct < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct), jPanelGood1, pageProduct + 1, jLabelNumOrder1, jLabelMSP1, jLabelImage1, jLabelName1, jLabelType1, jLabelCompany1, jLabelImportPrice1, jLabelPrice1, jLabelAmount1, jLabelUnit1);
        } else {
            jPanelGood1.setVisible(false);
        }
        if (pageProduct + 1 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 1), jPanelGood2, pageProduct + 2, jLabelNumOrder2, jLabelMSP2, jLabelImage2, jLabelName2, jLabelType2, jLabelCompany2, jLabelImportPrice2, jLabelPrice2, jLabelAmount2, jLabelUnit2);
        } else {
            jPanelGood2.setVisible(false);
        }
        if (pageProduct + 2 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 2), jPanelGood3, pageProduct + 3, jLabelNumOrder3, jLabelMSP3, jLabelImage3, jLabelName3, jLabelType3, jLabelCompany3, jLabelImportPrice3, jLabelPrice3, jLabelAmount3, jLabelUnit3);
        } else {
            jPanelGood3.setVisible(false);
        }
        if (pageProduct + 3 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 3), jPanelGood4, pageProduct + 4, jLabelNumOrder4, jLabelMSP4, jLabelImage4, jLabelName4, jLabelType4, jLabelCompany4, jLabelImportPrice4, jLabelPrice4, jLabelAmount4, jLabelUnit4);
        } else {
            jPanelGood4.setVisible(false);
        }
        if (pageProduct + 4 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 4), jPanelGood5, pageProduct + 5, jLabelNumOrder5, jLabelMSP5, jLabelImage5, jLabelName5, jLabelType5, jLabelCompany5, jLabelImportPrice5, jLabelPrice5, jLabelAmount5, jLabelUnit5);
        } else {
            jPanelGood5.setVisible(false);
        }
        if (pageProduct + 5 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 5), jPanelGood6, pageProduct + 6, jLabelNumOrder6, jLabelMSP6, jLabelImage6, jLabelName6, jLabelType6, jLabelCompany6, jLabelImportPrice6, jLabelPrice6, jLabelAmount6, jLabelUnit6);
        } else {
            jPanelGood6.setVisible(false);
        }
        if (pageProduct + 6 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 6), jPanelGood7, pageProduct + 7, jLabelNumOrder7, jLabelMSP7, jLabelImage7, jLabelName7, jLabelType7, jLabelCompany7, jLabelImportPrice7, jLabelPrice7, jLabelAmount7, jLabelUnit7);
        } else {
            jPanelGood7.setVisible(false);
        }
        if (pageProduct + 7 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 7), jPanelGood8, pageProduct + 8, jLabelNumOrder8, jLabelMSP8, jLabelImage8, jLabelName8, jLabelType8, jLabelCompany8, jLabelImportPrice8, jLabelPrice8, jLabelAmount8, jLabelUnit8);
        } else {
            jPanelGood8.setVisible(false);
        }
        if (pageProduct + 8 < countProduct) {
            renderJPanelGood(ListGoods.get(pageProduct + 8), jPanelGood9, pageProduct + 9, jLabelNumOrder9, jLabelMSP9, jLabelImage9, jLabelName9, jLabelType9, jLabelCompany9, jLabelImportPrice9, jLabelPrice9, jLabelAmount9, jLabelUnit9);
        } else {
            jPanelGood9.setVisible(false);
        }
        jLabelFrameSearchProduct.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelGood(Goods g, JPanel jpanel, int numOrder, JLabel jlabelNumOrder, JLabel jlabelMSP, JLabel jlabelImage, JLabel jlabelName, JLabel jlabelType, JLabel jlabelCompany, JLabel jlabelImportPrice, JLabel jlabelPrice, JLabel jlabelAmount, JLabel jlabelUnit) {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        jlabelNumOrder.setText(String.valueOf(numOrder));
        jlabelMSP.setText(g.getItemcode());
        jlabelImage.setIcon(scaleImageProduct(g.getImageitem()));
        String productName = "<html>" + g.getItemname() + "</html>";
        jlabelName.setText(productName);
        jlabelType.setText("<html>" + g.getTypecode() + "</html>");
        jlabelCompany.setText(g.getCompanycode());
        jlabelImportPrice.setText(String.format("%1$,.0f", g.getImportprice()));
        jlabelPrice.setText(String.format("%1$,.0f", g.getPrice()));
        jlabelAmount.setText(Integer.toString(g.getAmount()));
        jlabelUnit.setText(g.getUnit());
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

    public void popUpImageProduct(int n) {
        int pageProduct = setPageWarehouse();
        Goods g = ListGoods.get(pageProduct + n);
        DisplayImage di = new DisplayImage(g.getItemname(), g.getImageitem());
        di.setVisible(true);
        di.pack();
        di.setLocationRelativeTo(null);
    }
    private void handleEvent(JLabel jl) {
        String code = jl.getText();
        ChangeProduct changeProduct = new ChangeProduct("update", this, code);
        changeProduct.setDefaultCloseOperation(changeProduct.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLK = new javax.swing.JPanel();
        jPanelSelectPage = new javax.swing.JPanel();
        jPanelControlPageProduct = new javax.swing.JPanel();
        jTextFieldPageProduct = new javax.swing.JTextField();
        jLabelPageProduct = new javax.swing.JLabel();
        jLabelRight = new javax.swing.JLabel();
        jLabelLeft = new javax.swing.JLabel();
        jLabelSkipToEnd = new javax.swing.JLabel();
        jLabelSkipToStart = new javax.swing.JLabel();
        jPanelGood9 = new javax.swing.JPanel();
        jLabelMSP9 = new javax.swing.JLabel();
        jLabelImage9 = new javax.swing.JLabel();
        jLabelName9 = new javax.swing.JLabel();
        jLabelType9 = new javax.swing.JLabel();
        jLabelCompany9 = new javax.swing.JLabel();
        jLabelImportPrice9 = new javax.swing.JLabel();
        jLabelPrice9 = new javax.swing.JLabel();
        jLabelAmount9 = new javax.swing.JLabel();
        jLabelUnit9 = new javax.swing.JLabel();
        jLabelSetting9 = new javax.swing.JLabel();
        jLabelNumOrder9 = new javax.swing.JLabel();
        jPanelGood8 = new javax.swing.JPanel();
        jLabelMSP8 = new javax.swing.JLabel();
        jLabelImage8 = new javax.swing.JLabel();
        jLabelName8 = new javax.swing.JLabel();
        jLabelType8 = new javax.swing.JLabel();
        jLabelCompany8 = new javax.swing.JLabel();
        jLabelImportPrice8 = new javax.swing.JLabel();
        jLabelPrice8 = new javax.swing.JLabel();
        jLabelAmount8 = new javax.swing.JLabel();
        jLabelUnit8 = new javax.swing.JLabel();
        jLabelSetting8 = new javax.swing.JLabel();
        jLabelNumOrder8 = new javax.swing.JLabel();
        jPanelGood7 = new javax.swing.JPanel();
        jLabelMSP7 = new javax.swing.JLabel();
        jLabelImage7 = new javax.swing.JLabel();
        jLabelName7 = new javax.swing.JLabel();
        jLabelType7 = new javax.swing.JLabel();
        jLabelCompany7 = new javax.swing.JLabel();
        jLabelImportPrice7 = new javax.swing.JLabel();
        jLabelPrice7 = new javax.swing.JLabel();
        jLabelAmount7 = new javax.swing.JLabel();
        jLabelUnit7 = new javax.swing.JLabel();
        jLabelSetting7 = new javax.swing.JLabel();
        jLabelNumOrder7 = new javax.swing.JLabel();
        jPanelGood6 = new javax.swing.JPanel();
        jLabelMSP6 = new javax.swing.JLabel();
        jLabelImage6 = new javax.swing.JLabel();
        jLabelName6 = new javax.swing.JLabel();
        jLabelType6 = new javax.swing.JLabel();
        jLabelCompany6 = new javax.swing.JLabel();
        jLabelImportPrice6 = new javax.swing.JLabel();
        jLabelPrice6 = new javax.swing.JLabel();
        jLabelAmount6 = new javax.swing.JLabel();
        jLabelUnit6 = new javax.swing.JLabel();
        jLabelSetting6 = new javax.swing.JLabel();
        jLabelNumOrder6 = new javax.swing.JLabel();
        jPanelGood5 = new javax.swing.JPanel();
        jLabelMSP5 = new javax.swing.JLabel();
        jLabelImage5 = new javax.swing.JLabel();
        jLabelName5 = new javax.swing.JLabel();
        jLabelType5 = new javax.swing.JLabel();
        jLabelCompany5 = new javax.swing.JLabel();
        jLabelImportPrice5 = new javax.swing.JLabel();
        jLabelPrice5 = new javax.swing.JLabel();
        jLabelAmount5 = new javax.swing.JLabel();
        jLabelUnit5 = new javax.swing.JLabel();
        jLabelSetting5 = new javax.swing.JLabel();
        jLabelNumOrder5 = new javax.swing.JLabel();
        jPanelGood4 = new javax.swing.JPanel();
        jLabelMSP4 = new javax.swing.JLabel();
        jLabelImage4 = new javax.swing.JLabel();
        jLabelName4 = new javax.swing.JLabel();
        jLabelType4 = new javax.swing.JLabel();
        jLabelCompany4 = new javax.swing.JLabel();
        jLabelImportPrice4 = new javax.swing.JLabel();
        jLabelPrice4 = new javax.swing.JLabel();
        jLabelAmount4 = new javax.swing.JLabel();
        jLabelUnit4 = new javax.swing.JLabel();
        jLabelSetting4 = new javax.swing.JLabel();
        jLabelNumOrder4 = new javax.swing.JLabel();
        jPanelGood3 = new javax.swing.JPanel();
        jLabelMSP3 = new javax.swing.JLabel();
        jLabelImage3 = new javax.swing.JLabel();
        jLabelName3 = new javax.swing.JLabel();
        jLabelType3 = new javax.swing.JLabel();
        jLabelCompany3 = new javax.swing.JLabel();
        jLabelImportPrice3 = new javax.swing.JLabel();
        jLabelPrice3 = new javax.swing.JLabel();
        jLabelAmount3 = new javax.swing.JLabel();
        jLabelUnit3 = new javax.swing.JLabel();
        jLabelSetting3 = new javax.swing.JLabel();
        jLabelNumOrder3 = new javax.swing.JLabel();
        jPanelGood2 = new javax.swing.JPanel();
        jLabelMSP2 = new javax.swing.JLabel();
        jLabelImage2 = new javax.swing.JLabel();
        jLabelName2 = new javax.swing.JLabel();
        jLabelType2 = new javax.swing.JLabel();
        jLabelCompany2 = new javax.swing.JLabel();
        jLabelImportPrice2 = new javax.swing.JLabel();
        jLabelPrice2 = new javax.swing.JLabel();
        jLabelAmount2 = new javax.swing.JLabel();
        jLabelUnit2 = new javax.swing.JLabel();
        jLabelSetting2 = new javax.swing.JLabel();
        jLabelNumOrder2 = new javax.swing.JLabel();
        jPanelGood1 = new javax.swing.JPanel();
        jLabelMSP1 = new javax.swing.JLabel();
        jLabelImage1 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jLabelType1 = new javax.swing.JLabel();
        jLabelCompany1 = new javax.swing.JLabel();
        jLabelImportPrice1 = new javax.swing.JLabel();
        jLabelPrice1 = new javax.swing.JLabel();
        jLabelAmount1 = new javax.swing.JLabel();
        jLabelUnit1 = new javax.swing.JLabel();
        jLabelSetting1 = new javax.swing.JLabel();
        jLabelNumOrder1 = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelMaSP = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelCompany = new javax.swing.JLabel();
        jLabelPriceImport = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelUnit = new javax.swing.JLabel();
        jLabelSettings = new javax.swing.JLabel();
        jLabelNumOrder = new javax.swing.JLabel();
        jPanelControlQLK = new javax.swing.JPanel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jTextFieldSearchProduct = new javax.swing.JTextField();
        jLabelSearchProduct = new javax.swing.JLabel();
        jLabelFrameSearchProduct = new javax.swing.JLabel();
        jButtonAddCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jDashboardQLK.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setForeground(new java.awt.Color(255, 255, 255));
        jDashboardQLK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSelectPage.setBackground(new java.awt.Color(255, 255, 255));

        jPanelControlPageProduct.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlPageProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPageProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageProduct.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPageProduct.setText("1");
        jTextFieldPageProduct.setBorder(null);
        jTextFieldPageProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageProductKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPageProductKeyTyped(evt);
            }
        });
        jPanelControlPageProduct.add(jTextFieldPageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 778, 40, -1));

        jLabelPageProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageProduct.setText("/4");
        jPanelControlPageProduct.add(jLabelPageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 778, 40, -1));

        jLabelRight.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRight.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightMouseExited(evt);
            }
        });
        jPanelControlPageProduct.add(jLabelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 775, -1, -1));

        jLabelLeft.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftMouseExited(evt);
            }
        });
        jPanelControlPageProduct.add(jLabelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 775, -1, -1));

        jLabelSkipToEnd.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndMouseExited(evt);
            }
        });
        jPanelControlPageProduct.add(jLabelSkipToEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 775, -1, -1));

        jLabelSkipToStart.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartMouseExited(evt);
            }
        });
        jPanelControlPageProduct.add(jLabelSkipToStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 775, -1, -1));

        jPanelGood9.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP9.setText("Mã sản phẩm");
        jLabelMSP9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.add(jLabelMSP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage9MouseClicked(evt);
            }
        });
        jPanelGood9.add(jLabelImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName9.setText("Tên sản phẩm");
        jLabelName9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.add(jLabelName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType9.setText("Loại");
        jPanelGood9.add(jLabelType9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany9.setText("Nhà cung cấp");
        jLabelCompany9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.add(jLabelCompany9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice9.setText("Giá vốn");
        jPanelGood9.add(jLabelImportPrice9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice9.setText("Giá bán");
        jLabelPrice9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.add(jLabelPrice9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount9.setText("Số lượng");
        jPanelGood9.add(jLabelAmount9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit9.setText("Đơn vị tính");
        jLabelUnit9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood9.add(jLabelUnit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting9.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting9MouseClicked(evt);
            }
        });
        jPanelGood9.add(jLabelSetting9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder9.setText("9");
        jPanelGood9.add(jLabelNumOrder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jPanelGood8.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP8.setText("Mã sản phẩm");
        jLabelMSP8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.add(jLabelMSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage8MouseClicked(evt);
            }
        });
        jPanelGood8.add(jLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName8.setText("Tên sản phẩm");
        jLabelName8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.add(jLabelName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType8.setText("Loại");
        jPanelGood8.add(jLabelType8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany8.setText("Nhà cung cấp");
        jLabelCompany8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.add(jLabelCompany8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice8.setText("Giá vốn");
        jPanelGood8.add(jLabelImportPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice8.setText("Giá bán");
        jLabelPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.add(jLabelPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount8.setText("Số lượng");
        jPanelGood8.add(jLabelAmount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit8.setText("Đơn vị tính");
        jLabelUnit8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood8.add(jLabelUnit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting8.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting8MouseClicked(evt);
            }
        });
        jPanelGood8.add(jLabelSetting8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder8.setText("8");
        jPanelGood8.add(jLabelNumOrder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        jPanelGood7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP7.setText("Mã sản phẩm");
        jLabelMSP7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelMSP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage7MouseClicked(evt);
            }
        });
        jPanelGood7.add(jLabelImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName7.setText("Tên sản phẩm");
        jLabelName7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType7.setText("Loại");
        jPanelGood7.add(jLabelType7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany7.setText("Nhà cung cấp");
        jLabelCompany7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelCompany7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice7.setText("Giá vốn");
        jPanelGood7.add(jLabelImportPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice7.setText("Giá bán");
        jLabelPrice7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount7.setText("Số lượng");
        jPanelGood7.add(jLabelAmount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit7.setText("Đơn vị tính");
        jLabelUnit7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood7.add(jLabelUnit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting7.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting7MouseClicked(evt);
            }
        });
        jPanelGood7.add(jLabelSetting7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder7.setText("7");
        jPanelGood7.add(jLabelNumOrder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        jPanelGood6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP6.setText("Mã sản phẩm");
        jLabelMSP6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelMSP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage6MouseClicked(evt);
            }
        });
        jPanelGood6.add(jLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName6.setText("Tên sản phẩm");
        jLabelName6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType6.setText("Loại");
        jPanelGood6.add(jLabelType6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany6.setText("Nhà cung cấp");
        jLabelCompany6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelCompany6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice6.setText("Giá vốn");
        jPanelGood6.add(jLabelImportPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice6.setText("Giá bán");
        jLabelPrice6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount6.setText("Số lượng");
        jPanelGood6.add(jLabelAmount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit6.setText("Đơn vị tính");
        jLabelUnit6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood6.add(jLabelUnit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting6MouseClicked(evt);
            }
        });
        jPanelGood6.add(jLabelSetting6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder6.setText("6");
        jPanelGood6.add(jLabelNumOrder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        jPanelGood5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP5.setText("Mã sản phẩm");
        jLabelMSP5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelMSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage5MouseClicked(evt);
            }
        });
        jPanelGood5.add(jLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName5.setText("Tên sản phẩm");
        jLabelName5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType5.setText("Loại");
        jPanelGood5.add(jLabelType5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany5.setText("Nhà cung cấp");
        jLabelCompany5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelCompany5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice5.setText("Giá vốn");
        jPanelGood5.add(jLabelImportPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice5.setText("Giá bán");
        jLabelPrice5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount5.setText("Số lượng");
        jPanelGood5.add(jLabelAmount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit5.setText("Đơn vị tính");
        jLabelUnit5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood5.add(jLabelUnit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting5MouseClicked(evt);
            }
        });
        jPanelGood5.add(jLabelSetting5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder5.setText("5");
        jPanelGood5.add(jLabelNumOrder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        jPanelGood4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP4.setText("Mã sản phẩm");
        jLabelMSP4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelMSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage4MouseClicked(evt);
            }
        });
        jPanelGood4.add(jLabelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName4.setText("Tên sản phẩm");
        jLabelName4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType4.setText("Loại");
        jPanelGood4.add(jLabelType4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany4.setText("Nhà cung cấp");
        jLabelCompany4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelCompany4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice4.setText("Giá vốn");
        jPanelGood4.add(jLabelImportPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice4.setText("Giá bán");
        jLabelPrice4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount4.setText("Số lượng");
        jPanelGood4.add(jLabelAmount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit4.setText("Đơn vị tính");
        jLabelUnit4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood4.add(jLabelUnit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting4MouseClicked(evt);
            }
        });
        jPanelGood4.add(jLabelSetting4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder4.setText("4");
        jPanelGood4.add(jLabelNumOrder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        jPanelGood3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP3.setText("Mã sản phẩm");
        jLabelMSP3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelMSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage3MouseClicked(evt);
            }
        });
        jPanelGood3.add(jLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName3.setText("Tên sản phẩm");
        jLabelName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType3.setText("Loại");
        jPanelGood3.add(jLabelType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany3.setText("Nhà cung cấp");
        jLabelCompany3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelCompany3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice3.setText("Giá vốn");
        jPanelGood3.add(jLabelImportPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice3.setText("Giá bán");
        jLabelPrice3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount3.setText("Số lượng");
        jPanelGood3.add(jLabelAmount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit3.setText("Đơn vị tính");
        jLabelUnit3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood3.add(jLabelUnit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting3MouseClicked(evt);
            }
        });
        jPanelGood3.add(jLabelSetting3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder3.setText("3");
        jPanelGood3.add(jLabelNumOrder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        jPanelGood2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelGood2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP2.setText("Mã sản phẩm");
        jLabelMSP2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelMSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseClicked(evt);
            }
        });
        jPanelGood2.add(jLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName2.setText("Tên sản phẩm");
        jLabelName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType2.setText("Loại");
        jPanelGood2.add(jLabelType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany2.setText("Nhà cung cấp");
        jLabelCompany2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelCompany2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice2.setText("Giá vốn");
        jPanelGood2.add(jLabelImportPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice2.setText("Giá bán");
        jLabelPrice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount2.setText("Số lượng");
        jPanelGood2.add(jLabelAmount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit2.setText("Đơn vị tính");
        jLabelUnit2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood2.add(jLabelUnit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSetting2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting2MouseClicked(evt);
            }
        });
        jPanelGood2.add(jLabelSetting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder2.setText("2");
        jPanelGood2.add(jLabelNumOrder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jPanelGood1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGood1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelGood1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMSP1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMSP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMSP1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMSP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMSP1.setText("Mã sản phẩm");
        jLabelMSP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelMSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 80));

        jLabelImage1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseClicked(evt);
            }
        });
        jPanelGood1.add(jLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 80));

        jLabelName1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName1.setText("Tên sản phẩm");
        jLabelName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 80));

        jLabelType1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelType1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType1.setText("Loại");
        jPanelGood1.add(jLabelType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 80));

        jLabelCompany1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCompany1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany1.setText("Nhà cung cấp");
        jLabelCompany1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelCompany1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 80));

        jLabelImportPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImportPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImportPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImportPrice1.setText("Giá vốn");
        jPanelGood1.add(jLabelImportPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 80));

        jLabelPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice1.setText("Giá bán");
        jLabelPrice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 80));

        jLabelAmount1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAmount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount1.setText("Số lượng");
        jPanelGood1.add(jLabelAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 80));

        jLabelUnit1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUnit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit1.setText("Đơn vị tính");
        jLabelUnit1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGood1.add(jLabelUnit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 80));

        jLabelSetting1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetting1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSetting1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSetting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSetting1.setLabelFor(jLabelMSP1);
        jLabelSetting1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSetting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetting1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSetting1MouseEntered(evt);
            }
        });
        jPanelGood1.add(jLabelSetting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 80));

        jLabelNumOrder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder1.setText("1");
        jPanelGood1.add(jLabelNumOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelControlPageProduct.add(jPanelGood1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jPanelHeader.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMaSP.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMaSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaSP.setText("Mã sản phẩm");
        jLabelMaSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelImage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage.setText("Ảnh");
        jPanelHeader.add(jLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 40));

        jLabelName.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Tên sản phẩm");
        jLabelName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 40));

        jLabelType.setBackground(new java.awt.Color(255, 255, 255));
        jLabelType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelType.setText("Loại");
        jPanelHeader.add(jLabelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 110, 40));

        jLabelCompany.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCompany.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCompany.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompany.setText("Nhà cung cấp");
        jLabelCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 210, 40));

        jLabelPriceImport.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceImport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceImport.setText("Giá vốn");
        jPanelHeader.add(jLabelPriceImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 150, 40));

        jLabelPrice.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice.setText("Giá bán");
        jLabelPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 150, 40));

        jLabelAmount.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount.setText("Số lượng");
        jPanelHeader.add(jLabelAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 90, 40));

        jLabelUnit.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUnit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUnit.setText("Đơn vị tính");
        jLabelUnit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 100, 40));

        jLabelSettings.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jPanelHeader.add(jLabelSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 80, 40));

        jLabelNumOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNumOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder.setText("STT");
        jPanelHeader.add(jLabelNumOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanelControlPageProduct.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanelSelectPageLayout = new javax.swing.GroupLayout(jPanelSelectPage);
        jPanelSelectPage.setLayout(jPanelSelectPageLayout);
        jPanelSelectPageLayout.setHorizontalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSelectPageLayout.createSequentialGroup()
                .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelSelectPageLayout.setVerticalGroup(
            jPanelSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSelectPageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelControlPageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDashboardQLK.add(jPanelSelectPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1330, 810));

        jPanelControlQLK.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlQLK.setForeground(new java.awt.Color(255, 255, 255));
        jPanelControlQLK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxType.setToolTipText("");
        jComboBoxType.setBorder(null);
        jComboBoxType.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxType.setName(""); // NOI18N
        jComboBoxType.setRequestFocusEnabled(true);
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });
        jPanelControlQLK.add(jComboBoxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jTextFieldSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchProduct.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchProduct.setText("Tìm kiếm");
        jTextFieldSearchProduct.setBorder(null);
        jTextFieldSearchProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchProduct.setOpaque(false);
        jTextFieldSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchProductFocusLost(evt);
            }
        });
        jTextFieldSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchProductKeyReleased(evt);
            }
        });
        jPanelControlQLK.add(jTextFieldSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 240, 30));

        jLabelSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchProduct.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelControlQLK.add(jLabelSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 30));

        jLabelFrameSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelControlQLK.add(jLabelFrameSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 280, 30));

        jButtonAddCustomer.setBackground(new java.awt.Color(102, 178, 255));
        jButtonAddCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonAddCustomer.setText("Thêm");
        jButtonAddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddCustomer.setOpaque(true);
        jButtonAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCustomerActionPerformed(evt);
            }
        });
        jPanelControlQLK.add(jButtonAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách nhà cung cấp");
        jPanelControlQLK.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jDashboardQLK.add(jPanelControlQLK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDashboardQLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDashboardQLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageProductKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Integer.parseInt(jTextFieldPageProduct.getText()) > countProduct / 9 + setPageProduct) {
                jTextFieldPageProduct.setText(String.valueOf(countProduct / 9 + setPageProduct));
            } else if (Integer.parseInt(jTextFieldPageProduct.getText()) < 1) {
                jTextFieldPageProduct.setText("1");
            }
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(PanelWarehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldPageProductKeyPressed

    private void jLabelRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseClicked

        int jlabelrighta = Integer.parseInt(jTextFieldPageProduct.getText());
        int jlabelrightb = countProduct / 9 + setPageProduct;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageProduct.setText(String.valueOf(Integer.parseInt(jTextFieldPageProduct.getText()) + 1));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRightMouseClicked

    private void jLabelRightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseEntered

        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightMouseEntered

    private void jLabelRightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightMouseExited

        jLabelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightMouseExited

    private void jLabelLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseClicked

        if (Integer.parseInt(jTextFieldPageProduct.getText()) > 1) {
            jTextFieldPageProduct.setText(String.valueOf(Integer.parseInt(jTextFieldPageProduct.getText()) - 1));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftMouseClicked

    private void jLabelLeftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseEntered

        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftMouseEntered

    private void jLabelLeftMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftMouseExited

        jLabelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftMouseExited

    private void jLabelSkipToEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseClicked

        int jlabelrighta = Integer.parseInt(jTextFieldPageProduct.getText());
        int jlabelrightb = countProduct / 9 + setPageProduct;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageProduct.setText(String.valueOf(countProduct / 9 + setPageProduct));
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndMouseClicked

    private void jLabelSkipToEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseEntered

        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndMouseEntered

    private void jLabelSkipToEndMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndMouseExited

        jLabelSkipToEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndMouseExited

    private void jLabelSkipToStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseClicked

        if (Integer.parseInt(jTextFieldPageProduct.getText()) > 1) {
            jTextFieldPageProduct.setText("1");
            try {
                showProducts(ListGoods, countProduct);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartMouseClicked

    private void jLabelSkipToStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseEntered

        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartMouseEntered

    private void jLabelSkipToStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartMouseExited

        jLabelSkipToStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartMouseExited

    private void jLabelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseClicked

        popUpImageProduct(0);
    }//GEN-LAST:event_jLabelImage1MouseClicked

    private void jLabelImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseClicked

        popUpImageProduct(1);
    }//GEN-LAST:event_jLabelImage2MouseClicked

    private void jLabelImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage3MouseClicked

        popUpImageProduct(2);
    }//GEN-LAST:event_jLabelImage3MouseClicked

    private void jLabelImage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage4MouseClicked

        popUpImageProduct(3);
    }//GEN-LAST:event_jLabelImage4MouseClicked

    private void jLabelImage5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage5MouseClicked

        popUpImageProduct(4);
    }//GEN-LAST:event_jLabelImage5MouseClicked

    private void jLabelImage6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage6MouseClicked

        popUpImageProduct(5);
    }//GEN-LAST:event_jLabelImage6MouseClicked

    private void jLabelImage7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage7MouseClicked

        popUpImageProduct(6);
    }//GEN-LAST:event_jLabelImage7MouseClicked

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        if (jComboBoxType.getSelectedItem().toString().equals("Tất cả")) {
            try {
                ListGoods = GoodsDao.findAll();
                countProduct = GoodsDao.countProduct();
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                ListGoods = GoodsDao.findBy(jComboBoxType.getSelectedItem().toString());
                countProduct = GoodsDao.countProductBy(jComboBoxType.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        jComboBoxType.getSelectedIndex();
        try {
            showProducts(ListGoods, countProduct);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxTypeActionPerformed

    private void jTextFieldSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusGained
        jTextFieldSearchProduct.setText("");
    }//GEN-LAST:event_jTextFieldSearchProductFocusGained

    private void jTextFieldSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusLost
        if (jTextFieldSearchProduct.getText().equals("")) {
            jTextFieldSearchProduct.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchProductFocusLost

    private void jTextFieldSearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductKeyReleased
        try {
            ListGoods = GoodsDao.searchProduct(jTextFieldSearchProduct.getText());
            countProduct = GoodsDao.countSearchProduct(jTextFieldSearchProduct.getText());
            showProducts(ListGoods, countProduct);
            jTextFieldPageProduct.setText("1");
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchProductKeyReleased

    private void jTextFieldPageProductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageProductKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPageProductKeyTyped

    private void jLabelImage8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage8MouseClicked
        popUpImageProduct(7);
    }//GEN-LAST:event_jLabelImage8MouseClicked

    private void jLabelImage9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage9MouseClicked
        popUpImageProduct(8);
    }//GEN-LAST:event_jLabelImage9MouseClicked

    private void jLabelSetting1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting1MouseEntered
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jLabelSetting1MouseEntered

    private void jLabelSetting1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting1MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP1);
    }//GEN-LAST:event_jLabelSetting1MouseClicked

    private void jButtonAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCustomerActionPerformed
        // TODO add your handling code here:
        ChangeProduct changeProduct = new ChangeProduct("add", this);
        changeProduct.setDefaultCloseOperation(changeProduct.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonAddCustomerActionPerformed

    private void jLabelSetting2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting2MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP2);
    }//GEN-LAST:event_jLabelSetting2MouseClicked

    private void jLabelSetting3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting3MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP3);
    }//GEN-LAST:event_jLabelSetting3MouseClicked

    private void jLabelSetting4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting4MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP4);
    }//GEN-LAST:event_jLabelSetting4MouseClicked

    private void jLabelSetting5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting5MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP5);
    }//GEN-LAST:event_jLabelSetting5MouseClicked

    private void jLabelSetting6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting6MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP6);
    }//GEN-LAST:event_jLabelSetting6MouseClicked

    private void jLabelSetting7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting7MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP7);
    }//GEN-LAST:event_jLabelSetting7MouseClicked

    private void jLabelSetting8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting8MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP8);
    }//GEN-LAST:event_jLabelSetting8MouseClicked

    private void jLabelSetting9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetting9MouseClicked
        // TODO add your handling code here:
        handleEvent(jLabelMSP9);
    }//GEN-LAST:event_jLabelSetting9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCustomer;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JPanel jDashboardQLK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelAmount1;
    private javax.swing.JLabel jLabelAmount2;
    private javax.swing.JLabel jLabelAmount3;
    private javax.swing.JLabel jLabelAmount4;
    private javax.swing.JLabel jLabelAmount5;
    private javax.swing.JLabel jLabelAmount6;
    private javax.swing.JLabel jLabelAmount7;
    private javax.swing.JLabel jLabelAmount8;
    private javax.swing.JLabel jLabelAmount9;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelCompany1;
    private javax.swing.JLabel jLabelCompany2;
    private javax.swing.JLabel jLabelCompany3;
    private javax.swing.JLabel jLabelCompany4;
    private javax.swing.JLabel jLabelCompany5;
    private javax.swing.JLabel jLabelCompany6;
    private javax.swing.JLabel jLabelCompany7;
    private javax.swing.JLabel jLabelCompany8;
    private javax.swing.JLabel jLabelCompany9;
    private javax.swing.JLabel jLabelFrameSearchProduct;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelImage4;
    private javax.swing.JLabel jLabelImage5;
    private javax.swing.JLabel jLabelImage6;
    private javax.swing.JLabel jLabelImage7;
    private javax.swing.JLabel jLabelImage8;
    private javax.swing.JLabel jLabelImage9;
    private javax.swing.JLabel jLabelImportPrice1;
    private javax.swing.JLabel jLabelImportPrice2;
    private javax.swing.JLabel jLabelImportPrice3;
    private javax.swing.JLabel jLabelImportPrice4;
    private javax.swing.JLabel jLabelImportPrice5;
    private javax.swing.JLabel jLabelImportPrice6;
    private javax.swing.JLabel jLabelImportPrice7;
    private javax.swing.JLabel jLabelImportPrice8;
    private javax.swing.JLabel jLabelImportPrice9;
    private javax.swing.JLabel jLabelLeft;
    private javax.swing.JLabel jLabelMSP1;
    private javax.swing.JLabel jLabelMSP2;
    private javax.swing.JLabel jLabelMSP3;
    private javax.swing.JLabel jLabelMSP4;
    private javax.swing.JLabel jLabelMSP5;
    private javax.swing.JLabel jLabelMSP6;
    private javax.swing.JLabel jLabelMSP7;
    private javax.swing.JLabel jLabelMSP8;
    private javax.swing.JLabel jLabelMSP9;
    private javax.swing.JLabel jLabelMaSP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelName3;
    private javax.swing.JLabel jLabelName4;
    private javax.swing.JLabel jLabelName5;
    private javax.swing.JLabel jLabelName6;
    private javax.swing.JLabel jLabelName7;
    private javax.swing.JLabel jLabelName8;
    private javax.swing.JLabel jLabelName9;
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
    private javax.swing.JLabel jLabelPageProduct;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelPrice1;
    private javax.swing.JLabel jLabelPrice2;
    private javax.swing.JLabel jLabelPrice3;
    private javax.swing.JLabel jLabelPrice4;
    private javax.swing.JLabel jLabelPrice5;
    private javax.swing.JLabel jLabelPrice6;
    private javax.swing.JLabel jLabelPrice7;
    private javax.swing.JLabel jLabelPrice8;
    private javax.swing.JLabel jLabelPrice9;
    private javax.swing.JLabel jLabelPriceImport;
    private javax.swing.JLabel jLabelRight;
    private javax.swing.JLabel jLabelSearchProduct;
    private javax.swing.JLabel jLabelSetting1;
    private javax.swing.JLabel jLabelSetting2;
    private javax.swing.JLabel jLabelSetting3;
    private javax.swing.JLabel jLabelSetting4;
    private javax.swing.JLabel jLabelSetting5;
    private javax.swing.JLabel jLabelSetting6;
    private javax.swing.JLabel jLabelSetting7;
    private javax.swing.JLabel jLabelSetting8;
    private javax.swing.JLabel jLabelSetting9;
    private javax.swing.JLabel jLabelSettings;
    private javax.swing.JLabel jLabelSkipToEnd;
    private javax.swing.JLabel jLabelSkipToStart;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelType1;
    private javax.swing.JLabel jLabelType2;
    private javax.swing.JLabel jLabelType3;
    private javax.swing.JLabel jLabelType4;
    private javax.swing.JLabel jLabelType5;
    private javax.swing.JLabel jLabelType6;
    private javax.swing.JLabel jLabelType7;
    private javax.swing.JLabel jLabelType8;
    private javax.swing.JLabel jLabelType9;
    private javax.swing.JLabel jLabelUnit;
    private javax.swing.JLabel jLabelUnit1;
    private javax.swing.JLabel jLabelUnit2;
    private javax.swing.JLabel jLabelUnit3;
    private javax.swing.JLabel jLabelUnit4;
    private javax.swing.JLabel jLabelUnit5;
    private javax.swing.JLabel jLabelUnit6;
    private javax.swing.JLabel jLabelUnit7;
    private javax.swing.JLabel jLabelUnit8;
    private javax.swing.JLabel jLabelUnit9;
    private javax.swing.JPanel jPanelControlPageProduct;
    private javax.swing.JPanel jPanelControlQLK;
    private javax.swing.JPanel jPanelGood1;
    private javax.swing.JPanel jPanelGood2;
    private javax.swing.JPanel jPanelGood3;
    private javax.swing.JPanel jPanelGood4;
    private javax.swing.JPanel jPanelGood5;
    private javax.swing.JPanel jPanelGood6;
    private javax.swing.JPanel jPanelGood7;
    private javax.swing.JPanel jPanelGood8;
    private javax.swing.JPanel jPanelGood9;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelSelectPage;
    private javax.swing.JTextField jTextFieldPageProduct;
    private javax.swing.JTextField jTextFieldSearchProduct;
    // End of variables declaration//GEN-END:variables
}
