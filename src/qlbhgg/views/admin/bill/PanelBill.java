/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.bill;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.controller.BillController.BillController;
import qlbhgg.controller.CustomerController.CustomerController;
import qlbhgg.controller.InvoiceDetailsController.InvoiceController;
import qlbhgg.controller.ProductController.ProductController;
import qlbhgg.controller.UserController.UserController;
import qlbhgg.dao.BillDao;
import qlbhgg.dao.CustomerDao;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.InvoicedetailsDao;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Bill;
import qlbhgg.models.Customers;
import qlbhgg.models.Invoicedetails;
import qlbhgg.models.Users;
import qlbhgg.views.admin.AdminForm;

/**
 *
 * @author acer
 */
public class PanelBill extends javax.swing.JPanel {

    /**
     * Creates new form PanelBill
     */
    public ArrayList<Bill> ListBills = BillController.findAllBill();
    public int countBill = BillController.countBill();
    public int setPageBill;

    public PanelBill() throws SQLException {
        initComponents();
        showBillList(ListBills, countBill);
    }

    public void startingStateQLHD() {
        jPanelBill1.setVisible(false);
        jPanelBill2.setVisible(false);
        jPanelBill3.setVisible(false);
        jPanelBill4.setVisible(false);
        jPanelBill5.setVisible(false);
        jPanelBill6.setVisible(false);
    }

    public int getPageBill() {
        setPageBill = (countBill % 6 == 0) ? 0 : 1;
        jLabelPageBill.setText("/" + String.valueOf(countBill / 6 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill.getText()) - 1) * 6;
        return pageBill;
    }

    public void update() throws SQLException {
        ListBills = BillController.findAllBill();
        countBill = BillController.countBill();
        showBillList(ListBills, countBill);
    }

    public void showBillList(ArrayList<Bill> ListBills, int countBill) throws SQLException {
        startingStateQLHD();
        int pageBill = getPageBill();
        if (pageBill < countBill) {
            renderJPanelBill(ListBills.get(pageBill), pageBill + 1, jPanelBill1, jLabelNumOrder1, jLabelIdBill1, jLabelDateBill1, jLabelTimeBill1, jLabelIDStaffBill1, jLabelNameStaffBill1, jLabelCustomerNameBill1, jLabelCustomerPhonenumberBill1, jLabelCustomerAddressBill1, jLabelProductBill1, jLabelPriceBill1, jLabelDiscountBill1, jLabelTotalPriceBill1, jLabelNoteBill1);
        } else {
            jPanelBill1.setVisible(false);
        }
        if (pageBill + 1 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 1), pageBill + 2, jPanelBill2, jLabelNumOrder2, jLabelIdBill2, jLabelDateBill2, jLabelTimeBill2, jLabelIDStaffBill2, jLabelNameStaffBill2, jLabelCustomerNameBill2, jLabelCustomerPhonenumberBill2, jLabelCustomerAddressBill2, jLabelProductBill2, jLabelPriceBill2, jLabelDiscountBill2, jLabelTotalPriceBill2, jLabelNoteBill2);
        } else {
            jPanelBill2.setVisible(false);
        }
        if (pageBill + 2 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 2), pageBill + 3, jPanelBill3, jLabelNumOrder3, jLabelIdBill3, jLabelDateBill3, jLabelTimeBill3, jLabelIDStaffBill3, jLabelNameStaffBill3, jLabelCustomerNameBill3, jLabelCustomerPhonenumberBill3, jLabelCustomerAddressBill3, jLabelProductBill3, jLabelPriceBill3, jLabelDiscountBill3, jLabelTotalPriceBill3, jLabelNoteBill3);
        } else {
            jPanelBill3.setVisible(false);
        }
        if (pageBill + 3 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 3), pageBill + 4, jPanelBill4, jLabelNumOrder4, jLabelIdBill4, jLabelDateBill4, jLabelTimeBill4, jLabelIDStaffBill4, jLabelNameStaffBill4, jLabelCustomerNameBill4, jLabelCustomerPhonenumberBill4, jLabelCustomerAddressBill4, jLabelProductBill4, jLabelPriceBill4, jLabelDiscountBill4, jLabelTotalPriceBill4, jLabelNoteBill4);
        } else {
            jPanelBill4.setVisible(false);
        }
        if (pageBill + 4 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 4), pageBill + 5, jPanelBill5, jLabelNumOrder5, jLabelIdBill5, jLabelDateBill5, jLabelTimeBill5, jLabelIDStaffBill5, jLabelNameStaffBill5, jLabelCustomerNameBill5, jLabelCustomerPhonenumberBill5, jLabelCustomerAddressBill5, jLabelProductBill5, jLabelPriceBill5, jLabelDiscountBill5, jLabelTotalPriceBill5, jLabelNoteBill5);
        } else {
            jPanelBill5.setVisible(false);
        }
        if (pageBill + 5 < countBill) {
            renderJPanelBill(ListBills.get(pageBill + 5), pageBill + 6, jPanelBill6, jLabelNumOrder6, jLabelIdBill6, jLabelDateBill6, jLabelTimeBill6, jLabelIDStaffBill6, jLabelNameStaffBill6, jLabelCustomerNameBill6, jLabelCustomerPhonenumberBill6, jLabelCustomerAddressBill6, jLabelProductBill6, jLabelPriceBill6, jLabelDiscountBill6, jLabelTotalPriceBill6, jLabelNoteBill6);
        } else {
            jPanelBill6.setVisible(false);
        }
        jLabelFrameSearchBill.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelBill(Bill b, int numOrder, JPanel jpanel, JLabel jlabelNumOrder, JLabel jlabelIdBill, JLabel jlabelDateBill, JLabel jlabelTimeBill, JLabel jlabelIdStaffBill, JLabel jlabelNameStaffBill, JLabel jlabelCustomerNameBill, JLabel jlabelCustomerPhonenumberBill, JLabel jlabelCustomerAddressBill, JLabel jlabelProductBill, JLabel jlabelPriceBill, JLabel jlabelDiscountBill, JLabel jlabelTotalPriceBill, JLabel jlabelNoteBill) throws SQLException {
        jpanel.setVisible(true);
        jlabelNumOrder.setText(String.valueOf(numOrder));
        jlabelIdBill.setText("ID:" + b.getCodebill());
        jlabelDateBill.setText(b.getCreationdate().toString());
        jlabelTimeBill.setText(b.getCreationtime().toString());
        Users userCreateBill = UserController.findStaffById(b.getIduser());
        Customers customerBill = CustomerController.findCustomerById(b.getCustomercode());
        ArrayList<Invoicedetails> ListInvoicedetailses = InvoiceController.findInvoicedetailsByIdBill(b.getCodebill());
        jlabelIdStaffBill.setText(userCreateBill.getId());
        jlabelNameStaffBill.setText(userCreateBill.getFullname());
        jlabelCustomerNameBill.setText(customerBill.getCustomername());
        jlabelCustomerPhonenumberBill.setText(customerBill.getPhonenumber());
        jlabelCustomerAddressBill.setText("<html>" + customerBill.getAddress() + "</html>");
        String productbill = "<html>";
        int count = 0;
        float price = 0, discount = 0;
        for (Invoicedetails iv : ListInvoicedetailses) {
            if (count < 3) {
                productbill += " - " + ProductController.findProductForBill(iv.getItemcode()).getItemname() + "<br>";
                count++;
            }
            price += iv.getPrice() * iv.getAmount();
            discount += (iv.getPrice() * iv.getAmount()) / 100 * iv.getDiscount();
        }
        productbill += "</html>";
        jlabelProductBill.setText(productbill);
        jlabelPriceBill.setText(String.format("%1$,.0f", price));
        jlabelDiscountBill.setText(String.format("%1$,.0f", discount));
        jlabelTotalPriceBill.setText(String.format("%1$,.0f", price - discount));
        if (b.getNote().equals("")) {
            jlabelNoteBill.setText("--------------------------");
        } else {
            jlabelNoteBill.setText(b.getNote());
        }
    }

    private ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private void handleEvent(JLabel jl) throws SQLException {
        String codeBill = jl.getText().substring(3);
        ShowBill sb = new ShowBill(this, codeBill);
        sb.setDefaultCloseOperation(sb.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLDH = new javax.swing.JPanel();
        jPanelBill6 = new javax.swing.JPanel();
        jLabelPriceBill6 = new javax.swing.JLabel();
        jLabelDiscountBill6 = new javax.swing.JLabel();
        jLabelTotalPriceBill6 = new javax.swing.JLabel();
        jLabelNoteBill6 = new javax.swing.JLabel();
        jLabelSettingBill6 = new javax.swing.JLabel();
        jPanelTTBill6 = new javax.swing.JPanel();
        jLabelDateBill6 = new javax.swing.JLabel();
        jLabelIdBill6 = new javax.swing.JLabel();
        jLabelTimeBill6 = new javax.swing.JLabel();
        jPanelTTStaffBill6 = new javax.swing.JPanel();
        jLabelNameStaffBill6 = new javax.swing.JLabel();
        jLabelIDStaffBill6 = new javax.swing.JLabel();
        jPanelCustomerBill6 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill6 = new javax.swing.JLabel();
        jLabelCustomerNameBill6 = new javax.swing.JLabel();
        jLabelCustomerAddressBill6 = new javax.swing.JLabel();
        jPanelProductBill6 = new javax.swing.JPanel();
        jLabelProductBill6 = new javax.swing.JLabel();
        jLabelNumOrder6 = new javax.swing.JLabel();
        jPanelBill5 = new javax.swing.JPanel();
        jLabelPriceBill5 = new javax.swing.JLabel();
        jLabelDiscountBill5 = new javax.swing.JLabel();
        jLabelTotalPriceBill5 = new javax.swing.JLabel();
        jLabelNoteBill5 = new javax.swing.JLabel();
        jLabelSettingBill5 = new javax.swing.JLabel();
        jPanelTTBill5 = new javax.swing.JPanel();
        jLabelDateBill5 = new javax.swing.JLabel();
        jLabelIdBill5 = new javax.swing.JLabel();
        jLabelTimeBill5 = new javax.swing.JLabel();
        jPanelTTStaffBill5 = new javax.swing.JPanel();
        jLabelNameStaffBill5 = new javax.swing.JLabel();
        jLabelIDStaffBill5 = new javax.swing.JLabel();
        jPanelCustomerBill5 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill5 = new javax.swing.JLabel();
        jLabelCustomerNameBill5 = new javax.swing.JLabel();
        jLabelCustomerAddressBill5 = new javax.swing.JLabel();
        jPanelProductBill5 = new javax.swing.JPanel();
        jLabelProductBill5 = new javax.swing.JLabel();
        jLabelNumOrder5 = new javax.swing.JLabel();
        jPanelBill4 = new javax.swing.JPanel();
        jLabelPriceBill4 = new javax.swing.JLabel();
        jLabelDiscountBill4 = new javax.swing.JLabel();
        jLabelTotalPriceBill4 = new javax.swing.JLabel();
        jLabelNoteBill4 = new javax.swing.JLabel();
        jLabelSettingBill4 = new javax.swing.JLabel();
        jPanelTTBill4 = new javax.swing.JPanel();
        jLabelDateBill4 = new javax.swing.JLabel();
        jLabelIdBill4 = new javax.swing.JLabel();
        jLabelTimeBill4 = new javax.swing.JLabel();
        jPanelTTStaffBill4 = new javax.swing.JPanel();
        jLabelNameStaffBill4 = new javax.swing.JLabel();
        jLabelIDStaffBill4 = new javax.swing.JLabel();
        jPanelCustomerBill4 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill4 = new javax.swing.JLabel();
        jLabelCustomerNameBill4 = new javax.swing.JLabel();
        jLabelCustomerAddressBill4 = new javax.swing.JLabel();
        jPanelProductBill4 = new javax.swing.JPanel();
        jLabelProductBill4 = new javax.swing.JLabel();
        jLabelNumOrder4 = new javax.swing.JLabel();
        jPanelBill3 = new javax.swing.JPanel();
        jLabelPriceBill3 = new javax.swing.JLabel();
        jLabelDiscountBill3 = new javax.swing.JLabel();
        jLabelTotalPriceBill3 = new javax.swing.JLabel();
        jLabelNoteBill3 = new javax.swing.JLabel();
        jLabelSettingBill3 = new javax.swing.JLabel();
        jPanelTTBill3 = new javax.swing.JPanel();
        jLabelDateBill3 = new javax.swing.JLabel();
        jLabelIdBill3 = new javax.swing.JLabel();
        jLabelTimeBill3 = new javax.swing.JLabel();
        jPanelTTStaffBill3 = new javax.swing.JPanel();
        jLabelNameStaffBill3 = new javax.swing.JLabel();
        jLabelIDStaffBill3 = new javax.swing.JLabel();
        jPanelCustomerBill3 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill3 = new javax.swing.JLabel();
        jLabelCustomerNameBill3 = new javax.swing.JLabel();
        jLabelCustomerAddressBill3 = new javax.swing.JLabel();
        jPanelProductBill3 = new javax.swing.JPanel();
        jLabelProductBill3 = new javax.swing.JLabel();
        jLabelNumOrder3 = new javax.swing.JLabel();
        jPanelBill2 = new javax.swing.JPanel();
        jLabelPriceBill2 = new javax.swing.JLabel();
        jLabelDiscountBill2 = new javax.swing.JLabel();
        jLabelTotalPriceBill2 = new javax.swing.JLabel();
        jLabelNoteBill2 = new javax.swing.JLabel();
        jLabelSettingBill2 = new javax.swing.JLabel();
        jPanelTTBill2 = new javax.swing.JPanel();
        jLabelDateBill2 = new javax.swing.JLabel();
        jLabelIdBill2 = new javax.swing.JLabel();
        jLabelTimeBill2 = new javax.swing.JLabel();
        jPanelTTStaffBill2 = new javax.swing.JPanel();
        jLabelNameStaffBill2 = new javax.swing.JLabel();
        jLabelIDStaffBill2 = new javax.swing.JLabel();
        jPanelCustomerBill2 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill2 = new javax.swing.JLabel();
        jLabelCustomerNameBill2 = new javax.swing.JLabel();
        jLabelCustomerAddressBill2 = new javax.swing.JLabel();
        jPanelProductBill2 = new javax.swing.JPanel();
        jLabelProductBill2 = new javax.swing.JLabel();
        jLabelNumOrder2 = new javax.swing.JLabel();
        jPanelBill1 = new javax.swing.JPanel();
        jLabelPriceBill1 = new javax.swing.JLabel();
        jLabelDiscountBill1 = new javax.swing.JLabel();
        jLabelTotalPriceBill1 = new javax.swing.JLabel();
        jLabelNoteBill1 = new javax.swing.JLabel();
        jLabelSettingBill1 = new javax.swing.JLabel();
        jPanelTTBill1 = new javax.swing.JPanel();
        jLabelDateBill1 = new javax.swing.JLabel();
        jLabelIdBill1 = new javax.swing.JLabel();
        jLabelTimeBill1 = new javax.swing.JLabel();
        jPanelTTStaffBill1 = new javax.swing.JPanel();
        jLabelNameStaffBill1 = new javax.swing.JLabel();
        jLabelIDStaffBill1 = new javax.swing.JLabel();
        jPanelCustomerBill1 = new javax.swing.JPanel();
        jLabelCustomerPhonenumberBill1 = new javax.swing.JLabel();
        jLabelCustomerNameBill1 = new javax.swing.JLabel();
        jLabelCustomerAddressBill1 = new javax.swing.JLabel();
        jPanelProductBill1 = new javax.swing.JPanel();
        jLabelProductBill1 = new javax.swing.JLabel();
        jLabelNumOrder1 = new javax.swing.JLabel();
        jPanelHeaderBill = new javax.swing.JPanel();
        jLabelTTBill = new javax.swing.JLabel();
        jLabelStaffBill = new javax.swing.JLabel();
        jLabelCustomerBill = new javax.swing.JLabel();
        jLabelProductBill = new javax.swing.JLabel();
        jLabelPriceBill = new javax.swing.JLabel();
        jLabelDiscountBill = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabelNoteBill = new javax.swing.JLabel();
        jLabelSettingBill = new javax.swing.JLabel();
        jLabelNumOrder = new javax.swing.JLabel();
        jPanelControlPageBill = new javax.swing.JPanel();
        jTextFieldPageBill = new javax.swing.JTextField();
        jLabelPageBill = new javax.swing.JLabel();
        jLabelRightPageBill = new javax.swing.JLabel();
        jLabelLeftPageBill = new javax.swing.JLabel();
        jLabelSkipToEndPageBill = new javax.swing.JLabel();
        jLabelSkipToStartPageBill = new javax.swing.JLabel();
        jLabelSearchBill = new javax.swing.JLabel();
        jTextFieldSearchBill = new javax.swing.JTextField();
        jLabelFrameSearchBill = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDashboardQLDH.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLDH.setForeground(new java.awt.Color(153, 255, 153));
        jDashboardQLDH.setPreferredSize(new java.awt.Dimension(1330, 870));
        jDashboardQLDH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill6.setText("Thành tiền");
        jLabelPriceBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill6.add(jLabelPriceBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill6.setText("Chiết khấu");
        jPanelBill6.add(jLabelDiscountBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill6.setText("Tổng thu");
        jLabelTotalPriceBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill6.add(jLabelTotalPriceBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill6.setText("Ghi chú");
        jPanelBill6.add(jLabelNoteBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill6MouseExited(evt);
            }
        });
        jPanelBill6.add(jLabelSettingBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill6.setText("2020-12-14");
        jPanelTTBill6.add(jLabelDateBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill6.add(jLabelIdBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill6.setText("00:00:00");
        jPanelTTBill6.add(jLabelTimeBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill6.add(jPanelTTBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill6.setText("Phạm Duy Tài");
        jPanelTTStaffBill6.add(jLabelNameStaffBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill6.setText("ID:US?");
        jPanelTTStaffBill6.add(jLabelIDStaffBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill6.add(jPanelTTStaffBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill6.setText("Số điện thoại");
        jPanelCustomerBill6.add(jLabelCustomerPhonenumberBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill6.setText("Tên khách hàng");
        jPanelCustomerBill6.add(jLabelCustomerNameBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill6.setText("Địa chỉ");
        jPanelCustomerBill6.add(jLabelCustomerAddressBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill6.add(jPanelCustomerBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelProductBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill6.setText("Sản phẩm");
        jPanelProductBill6.add(jLabelProductBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill6.add(jPanelProductBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder6.setText("1");
        jPanelBill6.add(jLabelNumOrder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, -1, 120));

        jPanelBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill5.setText("Thành tiền");
        jLabelPriceBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.add(jLabelPriceBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill5.setText("Chiết khấu");
        jPanelBill5.add(jLabelDiscountBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill5.setText("Tổng thu");
        jLabelTotalPriceBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill5.add(jLabelTotalPriceBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill5.setText("Ghi chú");
        jPanelBill5.add(jLabelNoteBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill5MouseExited(evt);
            }
        });
        jPanelBill5.add(jLabelSettingBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill5.setText("2020-12-14");
        jPanelTTBill5.add(jLabelDateBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill5.add(jLabelIdBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill5.setText("00:00:00");
        jPanelTTBill5.add(jLabelTimeBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill5.add(jPanelTTBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill5.setText("Phạm Duy Tài");
        jPanelTTStaffBill5.add(jLabelNameStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill5.setText("ID:US?");
        jPanelTTStaffBill5.add(jLabelIDStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill5.add(jPanelTTStaffBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill5.setText("Số điện thoại");
        jPanelCustomerBill5.add(jLabelCustomerPhonenumberBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill5.setText("Tên khách hàng");
        jPanelCustomerBill5.add(jLabelCustomerNameBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill5.setText("Địa chỉ");
        jPanelCustomerBill5.add(jLabelCustomerAddressBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill5.add(jPanelCustomerBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill5.setText("Sản phẩm");
        jPanelProductBill5.add(jLabelProductBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill5.add(jPanelProductBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder5.setText("1");
        jPanelBill5.add(jLabelNumOrder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, -1, 120));

        jPanelBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill4.setText("Thành tiền");
        jLabelPriceBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.add(jLabelPriceBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill4.setText("Chiết khấu");
        jPanelBill4.add(jLabelDiscountBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill4.setText("Tổng thu");
        jLabelTotalPriceBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill4.add(jLabelTotalPriceBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill4.setText("Ghi chú");
        jPanelBill4.add(jLabelNoteBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill4MouseExited(evt);
            }
        });
        jPanelBill4.add(jLabelSettingBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelTTBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill4.setText("2020-12-14");
        jPanelTTBill4.add(jLabelDateBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill4.add(jLabelIdBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill4.setText("00:00:00");
        jPanelTTBill4.add(jLabelTimeBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill4.add(jPanelTTBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill4.setText("Phạm Duy Tài");
        jPanelTTStaffBill4.add(jLabelNameStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill4.setText("ID:US?");
        jPanelTTStaffBill4.add(jLabelIDStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill4.add(jPanelTTStaffBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill4.setText("Số điện thoại");
        jPanelCustomerBill4.add(jLabelCustomerPhonenumberBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill4.setText("Tên khách hàng");
        jPanelCustomerBill4.add(jLabelCustomerNameBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill4.setText("Địa chỉ");
        jPanelCustomerBill4.add(jLabelCustomerAddressBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill4.add(jPanelCustomerBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelProductBill4.setForeground(new java.awt.Color(215, 220, 222));
        jPanelProductBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill4.setText("Sản phẩm");
        jPanelProductBill4.add(jLabelProductBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill4.add(jPanelProductBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder4.setText("1");
        jPanelBill4.add(jLabelNumOrder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, 120));

        jPanelBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill3.setText("Thành tiền");
        jLabelPriceBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.add(jLabelPriceBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill3.setText("Chiết khấu");
        jPanelBill3.add(jLabelDiscountBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill3.setText("Tổng thu");
        jLabelTotalPriceBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill3.add(jLabelTotalPriceBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill3.setText("Ghi chú");
        jPanelBill3.add(jLabelNoteBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill3MouseExited(evt);
            }
        });
        jPanelBill3.add(jLabelSettingBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill3.setText("2020-12-14");
        jPanelTTBill3.add(jLabelDateBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill3.add(jLabelIdBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill3.setText("00:00:00");
        jPanelTTBill3.add(jLabelTimeBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill3.add(jPanelTTBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill3.setText("Phạm Duy Tài");
        jPanelTTStaffBill3.add(jLabelNameStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill3.setText("ID:US?");
        jPanelTTStaffBill3.add(jLabelIDStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill3.add(jPanelTTStaffBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill3.setText("Số điện thoại");
        jPanelCustomerBill3.add(jLabelCustomerPhonenumberBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill3.setText("Tên khách hàng");
        jPanelCustomerBill3.add(jLabelCustomerNameBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill3.setText("Địa chỉ");
        jPanelCustomerBill3.add(jLabelCustomerAddressBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill3.add(jPanelCustomerBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill3.setText("Sản phẩm");
        jPanelProductBill3.add(jLabelProductBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill3.add(jPanelProductBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder3.setText("1");
        jPanelBill3.add(jLabelNumOrder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, 120));

        jPanelBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill2.setText("Thành tiền");
        jLabelPriceBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.add(jLabelPriceBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill2.setText("Chiết khấu");
        jPanelBill2.add(jLabelDiscountBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill2.setText("Tổng thu");
        jLabelTotalPriceBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill2.add(jLabelTotalPriceBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill2.setText("Ghi chú");
        jPanelBill2.add(jLabelNoteBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill2MouseExited(evt);
            }
        });
        jPanelBill2.add(jLabelSettingBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill2.setText("2020-12-14");
        jPanelTTBill2.add(jLabelDateBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill2.add(jLabelIdBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill2.setText("00:00:00");
        jPanelTTBill2.add(jLabelTimeBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill2.add(jPanelTTBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelTTStaffBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill2.setText("Phạm Duy Tài");
        jPanelTTStaffBill2.add(jLabelNameStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill2.setText("ID:US?");
        jPanelTTStaffBill2.add(jLabelIDStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill2.add(jPanelTTStaffBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelCustomerBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill2.setText("Số điện thoại");
        jPanelCustomerBill2.add(jLabelCustomerPhonenumberBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill2.setText("Tên khách hàng");
        jPanelCustomerBill2.add(jLabelCustomerNameBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill2.setText("Địa chỉ");
        jPanelCustomerBill2.add(jLabelCustomerAddressBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill2.add(jPanelCustomerBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelProductBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill2.setText("Sản phẩm");
        jPanelProductBill2.add(jLabelProductBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill2.add(jPanelProductBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder2.setText("1");
        jPanelBill2.add(jLabelNumOrder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 120));

        jPanelBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPriceBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPriceBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill1.setText("Thành tiền");
        jLabelPriceBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.add(jLabelPriceBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 120));

        jLabelDiscountBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill1.setText("Chiết khấu");
        jPanelBill1.add(jLabelDiscountBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 120));

        jLabelTotalPriceBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPriceBill1.setText("Tổng thu");
        jLabelTotalPriceBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBill1.add(jLabelTotalPriceBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 120));

        jLabelNoteBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNoteBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill1.setText("--------------------------");
        jPanelBill1.add(jLabelNoteBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 120));

        jLabelSettingBill1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelSettingBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSettingBill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSettingBill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSettingBill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSettingBill1MouseExited(evt);
            }
        });
        jPanelBill1.add(jLabelSettingBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 120));

        jPanelTTBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTTBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDateBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDateBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDateBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDateBill1.setText("2020-12-14");
        jPanelTTBill1.add(jLabelDateBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 30));

        jLabelIdBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIdBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelTTBill1.add(jLabelIdBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 140, 30));

        jLabelTimeBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTimeBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTimeBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTimeBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeBill1.setText("00:00:00");
        jPanelTTBill1.add(jLabelTimeBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        jPanelBill1.add(jPanelTTBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 120));

        jPanelTTStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTTStaffBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNameStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaffBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameStaffBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameStaffBill1.setText("Phạm Duy Tài");
        jPanelTTStaffBill1.add(jLabelNameStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabelIDStaffBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDStaffBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIDStaffBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDStaffBill1.setText("ID:US?");
        jPanelTTStaffBill1.add(jLabelIDStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 30));

        jPanelBill1.add(jPanelTTStaffBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 1, 158, 118));

        jPanelCustomerBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelCustomerBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCustomerBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerPhonenumberBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhonenumberBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPhonenumberBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerPhonenumberBill1.setText("Số điện thoại");
        jPanelCustomerBill1.add(jLabelCustomerPhonenumberBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 30));

        jLabelCustomerNameBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNameBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNameBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerNameBill1.setText("Tên khách hàng");
        jPanelCustomerBill1.add(jLabelCustomerNameBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        jLabelCustomerAddressBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerAddressBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerAddressBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerAddressBill1.setText("Địa chỉ");
        jPanelCustomerBill1.add(jLabelCustomerAddressBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 60));

        jPanelBill1.add(jPanelCustomerBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 120));

        jPanelProductBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelProductBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProductBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill1.setText("Sản phẩm");
        jPanelProductBill1.add(jLabelProductBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 120));

        jPanelBill1.add(jPanelProductBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 1, 248, 118));

        jLabelNumOrder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder1.setText("1");
        jPanelBill1.add(jLabelNumOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 120));

        jDashboardQLDH.add(jPanelBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, 120));

        jPanelHeaderBill.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeaderBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeaderBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTTBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTTBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTTBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTTBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTBill.setText("Hóa đơn");
        jLabelTTBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelTTBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        jLabelStaffBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStaffBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelStaffBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaffBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStaffBill.setText("Nhân viên");
        jPanelHeaderBill.add(jLabelStaffBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 160, 40));

        jLabelCustomerBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCustomerBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerBill.setText("Khách hàng");
        jLabelCustomerBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelCustomerBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 180, 40));

        jLabelProductBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProductBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductBill.setText("Sản phẩm");
        jPanelHeaderBill.add(jLabelProductBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 250, 40));

        jLabelPriceBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPriceBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPriceBill.setText("Thành tiền");
        jLabelPriceBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelPriceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 110, 40));

        jLabelDiscountBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDiscountBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscountBill.setText("Chiết khấu");
        jPanelHeaderBill.add(jLabelDiscountBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 110, 40));

        jLabelTotalBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("Tổng thu");
        jLabelTotalBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelTotalBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelHeaderBill.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 40));

        jLabelNoteBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNoteBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNoteBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNoteBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoteBill.setText("Ghi chú");
        jPanelHeaderBill.add(jLabelNoteBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 170, 40));

        jLabelSettingBill.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSettingBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettingBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSettingBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png"))); // NOI18N
        jLabelSettingBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeaderBill.add(jLabelSettingBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, 40));

        jLabelNumOrder.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNumOrder.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder.setText("STT");
        jPanelHeaderBill.add(jLabelNumOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jDashboardQLDH.add(jPanelHeaderBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanelControlPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlPageBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPageBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageBill.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageBill.setText("1");
        jTextFieldPageBill.setBorder(null);
        jTextFieldPageBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPageBillKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPageBillKeyTyped(evt);
            }
        });
        jPanelControlPageBill.add(jTextFieldPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 27, 40, -1));

        jLabelPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageBill.setText("/4");
        jPanelControlPageBill.add(jLabelPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 27, 40, -1));

        jLabelRightPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightPageBillMouseExited(evt);
            }
        });
        jPanelControlPageBill.add(jLabelRightPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 24, -1, -1));

        jLabelLeftPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBillMouseExited(evt);
            }
        });
        jPanelControlPageBill.add(jLabelLeftPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 24, -1, -1));

        jLabelSkipToEndPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBillMouseExited(evt);
            }
        });
        jPanelControlPageBill.add(jLabelSkipToEndPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 24, -1, -1));

        jLabelSkipToStartPageBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartPageBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartPageBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBillMouseExited(evt);
            }
        });
        jPanelControlPageBill.add(jLabelSkipToStartPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 24, -1, -1));

        jDashboardQLDH.add(jPanelControlPageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 1330, 50));

        jLabelSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchBill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchBill.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jDashboardQLDH.add(jLabelSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 30));

        jTextFieldSearchBill.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchBill.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchBill.setText("Tìm kiếm");
        jTextFieldSearchBill.setBorder(null);
        jTextFieldSearchBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchBill.setOpaque(false);
        jTextFieldSearchBill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBillFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBillFocusLost(evt);
            }
        });
        jTextFieldSearchBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchBillActionPerformed(evt);
            }
        });
        jTextFieldSearchBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchBillKeyReleased(evt);
            }
        });
        jDashboardQLDH.add(jTextFieldSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 240, 30));

        jLabelFrameSearchBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDashboardQLDH.add(jLabelFrameSearchBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 280, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách hóa đơn");
        jDashboardQLDH.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        add(jDashboardQLDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageBillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBillKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Integer.parseInt(jTextFieldPageBill.getText()) > countBill / 6 + setPageBill) {
                jTextFieldPageBill.setText(String.valueOf(countBill / 6 + setPageBill));
            } else if (Integer.parseInt(jTextFieldPageBill.getText()) < 1) {
                jTextFieldPageBill.setText("1");
            }
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldPageBillKeyPressed

    private void jLabelRightPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill.getText());
        int jlabelrightb = countBill / 6 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill.getText()) + 1));

            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabelRightPageBillMouseClicked

    private void jLabelRightPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseEntered

        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightPageBillMouseEntered

    private void jLabelRightPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBillMouseExited

        jLabelRightPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightPageBillMouseExited

    private void jLabelLeftPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseClicked
        if (Integer.parseInt(jTextFieldPageBill.getText()) > 1) {
            jTextFieldPageBill.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill.getText()) - 1));
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftPageBillMouseClicked

    private void jLabelLeftPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseEntered

        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftPageBillMouseEntered

    private void jLabelLeftPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBillMouseExited

        jLabelLeftPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftPageBillMouseExited

    private void jLabelSkipToEndPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill.getText());
        int jlabelrightb = countBill / 6 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill.setText(String.valueOf(countBill / 6 + setPageBill));
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseClicked

    private void jLabelSkipToEndPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseEntered

        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseEntered

    private void jLabelSkipToEndPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBillMouseExited

        jLabelSkipToEndPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBillMouseExited

    private void jLabelSkipToStartPageBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseClicked
        if (Integer.parseInt(jTextFieldPageBill.getText()) > 1) {
            jTextFieldPageBill.setText("1");
            try {
                showBillList(ListBills, countBill);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseClicked

    private void jLabelSkipToStartPageBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseEntered

        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseEntered

    private void jLabelSkipToStartPageBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBillMouseExited

        jLabelSkipToStartPageBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBillMouseExited

    private void jTextFieldSearchBillFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillFocusGained
        jTextFieldSearchBill.setText("");
    }//GEN-LAST:event_jTextFieldSearchBillFocusGained

    private void jTextFieldSearchBillFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillFocusLost
        if (jTextFieldPageBill.getText().equals("")) {
            jTextFieldPageBill.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchBillFocusLost

    private void jTextFieldSearchBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillKeyReleased
        if (jTextFieldSearchBill.getText().equals("")) {
            try {
                ListBills = BillController.findAllBill();
                countBill = BillController.countBill();
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        } else {
            try {
                ListBills = BillController.searchBill(jTextFieldSearchBill.getText());
                countBill = BillController.countsearchBill(jTextFieldSearchBill.getText());
                showBillList(ListBills, countBill);
                jTextFieldPageBill.setText("1");
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldSearchBillKeyReleased

    private void jTextFieldPageBillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBillKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPageBillKeyTyped

    private void jTextFieldSearchBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchBillActionPerformed

    private void jLabelSettingBill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill1MouseClicked
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill1);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill1MouseClicked

    private void jLabelSettingBill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill2);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill2MouseClicked

    private void jLabelSettingBill3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill3MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill3);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill3MouseClicked

    private void jLabelSettingBill4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill4MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill4);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill4MouseClicked

    private void jLabelSettingBill5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill5MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill5);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill5MouseClicked

    private void jLabelSettingBill6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill6MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            handleEvent(jLabelIdBill6);
        } catch (SQLException ex) {
            Logger.getLogger(PanelBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSettingBill6MouseClicked

    private void jLabelSettingBill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill1MouseEntered
        jLabelSettingBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));
    }//GEN-LAST:event_jLabelSettingBill1MouseEntered

    private void jLabelSettingBill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill1MouseExited
        jLabelSettingBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));    }//GEN-LAST:event_jLabelSettingBill1MouseExited

    private void jLabelSettingBill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill2MouseEntered
        jLabelSettingBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));    }//GEN-LAST:event_jLabelSettingBill2MouseEntered

    private void jLabelSettingBill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill2MouseExited
        jLabelSettingBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));
    }//GEN-LAST:event_jLabelSettingBill2MouseExited

    private void jLabelSettingBill3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill3MouseEntered
        jLabelSettingBill3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));    }//GEN-LAST:event_jLabelSettingBill3MouseEntered

    private void jLabelSettingBill3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill3MouseExited
        jLabelSettingBill3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));    }//GEN-LAST:event_jLabelSettingBill3MouseExited

    private void jLabelSettingBill4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill4MouseEntered
        jLabelSettingBill4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));    }//GEN-LAST:event_jLabelSettingBill4MouseEntered

    private void jLabelSettingBill4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill4MouseExited
        jLabelSettingBill4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));
    }//GEN-LAST:event_jLabelSettingBill4MouseExited

    private void jLabelSettingBill5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill5MouseEntered
        jLabelSettingBill5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));
    }//GEN-LAST:event_jLabelSettingBill5MouseEntered

    private void jLabelSettingBill5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill5MouseExited
        jLabelSettingBill5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));
    }//GEN-LAST:event_jLabelSettingBill5MouseExited

    private void jLabelSettingBill6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill6MouseEntered
        jLabelSettingBill6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px_1.png")));
    }//GEN-LAST:event_jLabelSettingBill6MouseEntered

    private void jLabelSettingBill6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSettingBill6MouseExited
        jLabelSettingBill6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_settings_20px.png")));
    }//GEN-LAST:event_jLabelSettingBill6MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDashboardQLDH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCustomerAddressBill1;
    private javax.swing.JLabel jLabelCustomerAddressBill2;
    private javax.swing.JLabel jLabelCustomerAddressBill3;
    private javax.swing.JLabel jLabelCustomerAddressBill4;
    private javax.swing.JLabel jLabelCustomerAddressBill5;
    private javax.swing.JLabel jLabelCustomerAddressBill6;
    private javax.swing.JLabel jLabelCustomerBill;
    private javax.swing.JLabel jLabelCustomerNameBill1;
    private javax.swing.JLabel jLabelCustomerNameBill2;
    private javax.swing.JLabel jLabelCustomerNameBill3;
    private javax.swing.JLabel jLabelCustomerNameBill4;
    private javax.swing.JLabel jLabelCustomerNameBill5;
    private javax.swing.JLabel jLabelCustomerNameBill6;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill1;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill2;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill3;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill4;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill5;
    private javax.swing.JLabel jLabelCustomerPhonenumberBill6;
    private javax.swing.JLabel jLabelDateBill1;
    private javax.swing.JLabel jLabelDateBill2;
    private javax.swing.JLabel jLabelDateBill3;
    private javax.swing.JLabel jLabelDateBill4;
    private javax.swing.JLabel jLabelDateBill5;
    private javax.swing.JLabel jLabelDateBill6;
    private javax.swing.JLabel jLabelDiscountBill;
    private javax.swing.JLabel jLabelDiscountBill1;
    private javax.swing.JLabel jLabelDiscountBill2;
    private javax.swing.JLabel jLabelDiscountBill3;
    private javax.swing.JLabel jLabelDiscountBill4;
    private javax.swing.JLabel jLabelDiscountBill5;
    private javax.swing.JLabel jLabelDiscountBill6;
    private javax.swing.JLabel jLabelFrameSearchBill;
    private javax.swing.JLabel jLabelIDStaffBill1;
    private javax.swing.JLabel jLabelIDStaffBill2;
    private javax.swing.JLabel jLabelIDStaffBill3;
    private javax.swing.JLabel jLabelIDStaffBill4;
    private javax.swing.JLabel jLabelIDStaffBill5;
    private javax.swing.JLabel jLabelIDStaffBill6;
    private javax.swing.JLabel jLabelIdBill1;
    private javax.swing.JLabel jLabelIdBill2;
    private javax.swing.JLabel jLabelIdBill3;
    private javax.swing.JLabel jLabelIdBill4;
    private javax.swing.JLabel jLabelIdBill5;
    private javax.swing.JLabel jLabelIdBill6;
    private javax.swing.JLabel jLabelLeftPageBill;
    private javax.swing.JLabel jLabelNameStaffBill1;
    private javax.swing.JLabel jLabelNameStaffBill2;
    private javax.swing.JLabel jLabelNameStaffBill3;
    private javax.swing.JLabel jLabelNameStaffBill4;
    private javax.swing.JLabel jLabelNameStaffBill5;
    private javax.swing.JLabel jLabelNameStaffBill6;
    private javax.swing.JLabel jLabelNoteBill;
    private javax.swing.JLabel jLabelNoteBill1;
    private javax.swing.JLabel jLabelNoteBill2;
    private javax.swing.JLabel jLabelNoteBill3;
    private javax.swing.JLabel jLabelNoteBill4;
    private javax.swing.JLabel jLabelNoteBill5;
    private javax.swing.JLabel jLabelNoteBill6;
    private javax.swing.JLabel jLabelNumOrder;
    private javax.swing.JLabel jLabelNumOrder1;
    private javax.swing.JLabel jLabelNumOrder2;
    private javax.swing.JLabel jLabelNumOrder3;
    private javax.swing.JLabel jLabelNumOrder4;
    private javax.swing.JLabel jLabelNumOrder5;
    private javax.swing.JLabel jLabelNumOrder6;
    private javax.swing.JLabel jLabelPageBill;
    private javax.swing.JLabel jLabelPriceBill;
    private javax.swing.JLabel jLabelPriceBill1;
    private javax.swing.JLabel jLabelPriceBill2;
    private javax.swing.JLabel jLabelPriceBill3;
    private javax.swing.JLabel jLabelPriceBill4;
    private javax.swing.JLabel jLabelPriceBill5;
    private javax.swing.JLabel jLabelPriceBill6;
    private javax.swing.JLabel jLabelProductBill;
    private javax.swing.JLabel jLabelProductBill1;
    private javax.swing.JLabel jLabelProductBill2;
    private javax.swing.JLabel jLabelProductBill3;
    private javax.swing.JLabel jLabelProductBill4;
    private javax.swing.JLabel jLabelProductBill5;
    private javax.swing.JLabel jLabelProductBill6;
    private javax.swing.JLabel jLabelRightPageBill;
    private javax.swing.JLabel jLabelSearchBill;
    private javax.swing.JLabel jLabelSettingBill;
    private javax.swing.JLabel jLabelSettingBill1;
    private javax.swing.JLabel jLabelSettingBill2;
    private javax.swing.JLabel jLabelSettingBill3;
    private javax.swing.JLabel jLabelSettingBill4;
    private javax.swing.JLabel jLabelSettingBill5;
    private javax.swing.JLabel jLabelSettingBill6;
    private javax.swing.JLabel jLabelSkipToEndPageBill;
    private javax.swing.JLabel jLabelSkipToStartPageBill;
    private javax.swing.JLabel jLabelStaffBill;
    private javax.swing.JLabel jLabelTTBill;
    private javax.swing.JLabel jLabelTimeBill1;
    private javax.swing.JLabel jLabelTimeBill2;
    private javax.swing.JLabel jLabelTimeBill3;
    private javax.swing.JLabel jLabelTimeBill4;
    private javax.swing.JLabel jLabelTimeBill5;
    private javax.swing.JLabel jLabelTimeBill6;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelTotalPriceBill1;
    private javax.swing.JLabel jLabelTotalPriceBill2;
    private javax.swing.JLabel jLabelTotalPriceBill3;
    private javax.swing.JLabel jLabelTotalPriceBill4;
    private javax.swing.JLabel jLabelTotalPriceBill5;
    private javax.swing.JLabel jLabelTotalPriceBill6;
    private javax.swing.JPanel jPanelBill1;
    private javax.swing.JPanel jPanelBill2;
    private javax.swing.JPanel jPanelBill3;
    private javax.swing.JPanel jPanelBill4;
    private javax.swing.JPanel jPanelBill5;
    private javax.swing.JPanel jPanelBill6;
    private javax.swing.JPanel jPanelControlPageBill;
    private javax.swing.JPanel jPanelCustomerBill1;
    private javax.swing.JPanel jPanelCustomerBill2;
    private javax.swing.JPanel jPanelCustomerBill3;
    private javax.swing.JPanel jPanelCustomerBill4;
    private javax.swing.JPanel jPanelCustomerBill5;
    private javax.swing.JPanel jPanelCustomerBill6;
    private javax.swing.JPanel jPanelHeaderBill;
    private javax.swing.JPanel jPanelProductBill1;
    private javax.swing.JPanel jPanelProductBill2;
    private javax.swing.JPanel jPanelProductBill3;
    private javax.swing.JPanel jPanelProductBill4;
    private javax.swing.JPanel jPanelProductBill5;
    private javax.swing.JPanel jPanelProductBill6;
    private javax.swing.JPanel jPanelTTBill1;
    private javax.swing.JPanel jPanelTTBill2;
    private javax.swing.JPanel jPanelTTBill3;
    private javax.swing.JPanel jPanelTTBill4;
    private javax.swing.JPanel jPanelTTBill5;
    private javax.swing.JPanel jPanelTTBill6;
    private javax.swing.JPanel jPanelTTStaffBill1;
    private javax.swing.JPanel jPanelTTStaffBill2;
    private javax.swing.JPanel jPanelTTStaffBill3;
    private javax.swing.JPanel jPanelTTStaffBill4;
    private javax.swing.JPanel jPanelTTStaffBill5;
    private javax.swing.JPanel jPanelTTStaffBill6;
    private javax.swing.JTextField jTextFieldPageBill;
    private javax.swing.JTextField jTextFieldSearchBill;
    // End of variables declaration//GEN-END:variables
}
