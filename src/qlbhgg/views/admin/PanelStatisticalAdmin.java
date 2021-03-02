/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import qlbhgg.controller.ProductController.ProductController;
import qlbhgg.controller.UserController.UserController;
import qlbhgg.dao.BillDao;
import qlbhgg.dao.GoodsDao;
import qlbhgg.dao.InvoicedetailsDao;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Goods;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class PanelStatisticalAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PanelStatistical
     */
    public ArrayList<Users> ListUser = new ArrayList<>();
    public ArrayList<Users> ListType = new ArrayList<>();
    public ArrayList<Users> ListTotalRevenue = new ArrayList<>();
    public ArrayList<Users> ListTotalFunds = new ArrayList<>();
    public ArrayList<Goods> ListGoodsTopPrice = new ArrayList<>();
    public ArrayList<Goods> ListGoodsTopAmount = new ArrayList<>();
    public int totalBill = 0;
    public float totalRevenue = 0;
    public int staffActive = UserController.countStaffActive();
    public int staffBlock = UserController.countStaffBlock();
    public int totalStaff = staffActive + staffBlock;
    public int totalProductWearHouse = ProductController.countProductWearHouse();
    public int totalProductSold = GoodsDao.countProductSold();
    private String toDate, fromDate;

    Calendar cal = new GregorianCalendar();
    private int selectedDay;
    private int selectedMonth;
    private int selectedYear;

    public PanelStatisticalAdmin() throws SQLException {
        initComponents();
        statingState();

    }

    public void statingState() throws SQLException {
        jRadioButtonExactDay.setSelected(true);
        jRadioButtonMonth.setSelected(true);
        jRadioButtonYear.setSelected(true);
        jLabelDay.setText(String.valueOf(selectedDay));
        jLabelDay.setEnabled(false);
        jLabelAddDay.setEnabled(false);
        jLabelMinusDay.setEnabled(false);

        jDateChooserFrom.setEnabled(false);
        jDateChooserTo.setEnabled(false);
        jLabelTo.setEnabled(false);

        jDateChooserFrom.setDateFormatString("yyyy-MM-dd");
        jDateChooserFrom.setDate(new java.util.Date());
        jDateChooserTo.setDateFormatString("yyyy-MM-dd");
        jDateChooserTo.setDate(new java.util.Date());

        selectedDay = cal.get(Calendar.DATE);
        selectedMonth = cal.get(Calendar.MONTH) + 1;
        selectedYear = cal.get(Calendar.YEAR);

        showStatictical();
    }

    public void showStatictical() throws SQLException {
        if (jRadioButtonExactDay.isSelected()) {
            datasetExactDay();
        } else {
            datasetPeriod();
        }
        createPie3DChartStaff();
        createPie3DChartWareHouse();
        createStackedAreaChart();
        createAreaChart();
        setTable();
        setTableTopPrice();
        setTableTopAmount();
        setTypeShow();
        setStaff();
        setRevenue();
    }

    public void datasetExactDay() throws SQLException {

        if (jRadioButtonMonth.isSelected()) {
            if (jRadioButtonDay.isSelected()) {
                actionDatasetExactDay(true, true);
            } else {
                actionDatasetExactDay(true, false);
            }
        } else {
            actionDatasetExactDay(false, false);
        }
    }

    public void datasetPeriod() throws SQLException {
        totalBill = BillDao.countTotalBillByPeriod(fromDate, toDate);
        totalRevenue = InvoicedetailsDao.countTotalRevenueByPeriod(fromDate, toDate);
        ListGoodsTopPrice = GoodsDao.getProductTopPriceByPeriod(fromDate, toDate);
        ListGoodsTopAmount = GoodsDao.getProductTopAmountByPeriod(fromDate, toDate);
        ListUser = UsersDao.getRevnueStaffByPeriod(fromDate, toDate);
        ListType = UsersDao.getRevnueProductByPeriod1(fromDate, toDate);
        ListTotalRevenue = UsersDao.getRevnueProductByPeriod(fromDate, toDate);
        ListTotalFunds = UsersDao.getTotalFundsByPeriod(fromDate, toDate);

    }

    public void actionDatasetExactDay(boolean m, boolean d) throws SQLException {
        totalBill = BillDao.countTotalBillByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        totalRevenue = InvoicedetailsDao.countTotalRevenueByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListGoodsTopPrice = GoodsDao.getProductTopPriceByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListGoodsTopAmount = GoodsDao.getProductTopAmountByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListUser = UsersDao.getRevnueStaffByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListType = UsersDao.getRevnueProductByDate1(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListTotalRevenue = UsersDao.getRevnueProductByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);
        ListTotalFunds = UsersDao.getTotalFundsByDate(String.valueOf(selectedYear), String.valueOf(selectedMonth), String.valueOf(selectedDay), m, d);

    }

    public void setRevenue() {
        jLabelTotalBill.setText(String.valueOf(totalBill));
        String str = String.format("%.0f", totalRevenue);
        if (str.length() > 9) {
            float totalRevenue1 = totalRevenue / 1000000000;
            str = String.format("%.1f", totalRevenue1) + "B";
        } else if (str.length() > 6) {
            float totalRevenue1 = totalRevenue / 1000000;
            str = String.format("%.1f", totalRevenue1) + "M";
        } else if (str.length() > 3) {
            float totalRevenue1 = totalRevenue / 1000;
            str = String.format("%.1f", totalRevenue1) + "K";
        }
        jLabelTotalRevenue.setText(str);
    }

    public void setStaff() {
        jLabelTotalStaff.setText(String.valueOf(totalStaff));
        jLabelStaffActive.setText(String.valueOf(staffActive));
        jLabelStaffBlock.setText(String.valueOf(staffBlock));
    }

    public void setTypeShow() {
        jLabelYear.setText(String.valueOf(selectedYear));
        jLabelMonth.setText(String.valueOf(selectedMonth));
        jLabelDay.setText(String.valueOf(selectedDay));
    }

    public void setTable() {

        jTableTopPrice.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableTopAmount.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableCellRenderer rendererFromHeader = jTableTopPrice.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        rendererFromHeader = jTableTopAmount.getTableHeader().getDefaultRenderer();
        headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        jTableTopPrice.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        jTableTopPrice.getTableHeader().setOpaque(false);
        jTableTopPrice.getTableHeader().setBackground(new Color(102, 178, 255));
        jTableTopPrice.setRowHeight(23);

        jTableTopPrice.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableTopPrice.getColumnModel().getColumn(1).setPreferredWidth(95);
        jTableTopPrice.getColumnModel().getColumn(2).setPreferredWidth(313);
        jTableTopPrice.getColumnModel().getColumn(3).setPreferredWidth(95);
        jTableTopPrice.getColumnModel().getColumn(4).setPreferredWidth(115);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTableTopPrice.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTableTopPrice.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTableTopPrice.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTableTopPrice.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTableTopPrice.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        jTableTopAmount.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        jTableTopAmount.getTableHeader().setOpaque(false);
        jTableTopAmount.getTableHeader().setBackground(new Color(102, 178, 255));
        jTableTopAmount.setRowHeight(23);

        jTableTopAmount.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableTopAmount.getColumnModel().getColumn(1).setPreferredWidth(95);
        jTableTopAmount.getColumnModel().getColumn(2).setPreferredWidth(313);
        jTableTopAmount.getColumnModel().getColumn(3).setPreferredWidth(95);
        jTableTopAmount.getColumnModel().getColumn(4).setPreferredWidth(105);
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTableTopAmount.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTableTopAmount.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTableTopAmount.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTableTopAmount.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTableTopAmount.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }

    public void createPie3DChartWareHouse() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Kho", totalProductWearHouse);
        dataset.setValue("Đã bán", totalProductSold);
        // create pir chart
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Thống kê hàng hóa", // chart title                   
                dataset, // data 
                true, // include legend                   
                true,
                false);
        // set chart properties
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(255, 255, 255));

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();

        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);
        plot.setBackgroundImageAlpha(0.60f);
        plot.setBackgroundPaint(Color.white);
        plot.setNoDataMessage("Không có dữ liệu để hiển thị");

        // create chart panel the add it to swing panel in  jframe
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(255, 255, 255));        // clear panel before add new chart
        jPanel6.removeAll();
        jPanel6.add(chartPanel, BorderLayout.CENTER);
        jPanel6.validate();
    }

    public void createPie3DChartStaff() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Users users : ListUser) {
            dataset.setValue(users.getFullname(), users.getBasicsalary());
        }
        // create pir chart
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Tỉ lệ bán hàng", // chart title                   
                dataset, // data 
                true, // include legend                   
                true,
                false);
        // set chart properties
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(255, 255, 255));

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();

        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);
        plot.setBackgroundImageAlpha(0.60f);
        plot.setBackgroundPaint(Color.white);

        plot.setNoDataMessage("Không có dữ liệu để hiển thị");
        // create chart panel the add it to swing panel in  jframe
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(255, 255, 255));
        jPanel2.removeAll();
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.validate();
    }

    public CategoryDataset createDatasetStackedAreaChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Users u : ListType) {
            dataset.addValue(u.getBasicsalary(), u.getFullname(), String.valueOf(u.getBirthday()));
        }
        return dataset;
    }

    public void createStackedAreaChart() {
        CategoryDataset dataset = createDatasetStackedAreaChart();
        JFreeChart chart = ChartFactory.createStackedAreaChart("Thị phần linh kiện", "Thời gian", "Tổng thu", dataset);
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setBackgroundPaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setDomainGridlinePaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setDomainGridlinesVisible(false);
        chart.getCategoryPlot().setOutlinePaint(new Color(255, 255, 255));

        final CategoryPlot plot = chart.getCategoryPlot();
//        plot.setForegroundAlpha(0.6f);

        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        plot.setNoDataMessage("Không có dữ liệu để hiển thị");

        ChartPanel cp = new ChartPanel(chart);
        cp.setBackground(new Color(255, 255, 255));

        jPanel3.removeAll();
        jPanel3.add(cp, BorderLayout.CENTER);
        jPanel3.validate();

    }

    private DefaultCategoryDataset createDatasetAreaChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Tổng bán
        for (Users u : ListTotalRevenue) {
//            dataset.addValue(u.getBasicsalary(), "Tổng bán", String.valueOf((u.getBirthday().getYear() + 1900) + "-" + (u.getBirthday().getMonth() + 1)));
            dataset.addValue(u.getBasicsalary(), "Tổng bán", String.valueOf(u.getBirthday()));
        }
        //Tổng vốn        
        for (Users u : ListTotalFunds) {
            dataset.addValue(u.getBasicsalary(), "Tổng vốn", String.valueOf(u.getBirthday()));
        }
        return dataset;
    }

    public void createAreaChart() {
        DefaultCategoryDataset dataset = createDatasetAreaChart();
        JFreeChart chart = ChartFactory.createAreaChart(
                "Thống kê dòng tiền",
                "Thời gian",
                "Tổng tiền",
                dataset);

        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setBackgroundPaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setDomainGridlinePaint(new Color(255, 255, 255));
        chart.getCategoryPlot().setDomainGridlinesVisible(false);
        chart.getCategoryPlot().setOutlinePaint(new Color(255, 255, 255));

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.6f);

        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        plot.setNoDataMessage("Không có dữ liệu để hiển thị");

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);

        panel.setBackground(new Color(255, 255, 255));

        jPanel1.removeAll();
        jPanel1.add(panel, BorderLayout.CENTER);
        jPanel1.validate();
    }

    public void setTableTopPrice() {
        DefaultTableModel tblModel = (DefaultTableModel) jTableTopPrice.getModel();
        tblModel.getDataVector().removeAllElements();
        revalidate();
        int stt = 1;
        for (Goods g : ListGoodsTopPrice) {
            String row[] = {String.valueOf(stt), g.getItemcode(), g.getItemname(), String.valueOf(g.getAmount()), String.format("%1$,.0f", g.getPrice())};
            tblModel.addRow(row);
            stt++;
        }
    }

    public void setTableTopAmount() {
        DefaultTableModel tblModel = (DefaultTableModel) jTableTopAmount.getModel();
        tblModel.getDataVector().removeAllElements();
        revalidate();
        int stt = 1;
        for (Goods g : ListGoodsTopAmount) {
            String row[] = {String.valueOf(stt), g.getItemcode(), g.getItemname(), String.valueOf(g.getAmount()), String.format("%1$,.0f", g.getPrice())};
            tblModel.addRow(row);
            stt++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTypeStatictical = new javax.swing.ButtonGroup();
        jDashboardTK = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabelTotalRevenue = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanelTopAmount = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTopAmount = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanelTopPrice = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTopPrice = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelDay = new javax.swing.JLabel();
        jLabelAddDay = new javax.swing.JLabel();
        jLabelMinusDay = new javax.swing.JLabel();
        jRadioButtonDay = new javax.swing.JRadioButton();
        jRadioButtonPeriod = new javax.swing.JRadioButton();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabelTo = new javax.swing.JLabel();
        jRadioButtonExactDay = new javax.swing.JRadioButton();
        jRadioButtonYear = new javax.swing.JRadioButton();
        jRadioButtonMonth = new javax.swing.JRadioButton();
        jLabelAddMonth = new javax.swing.JLabel();
        jLabelMonth = new javax.swing.JLabel();
        jLabelMinusMonth = new javax.swing.JLabel();
        jLabelAddYear = new javax.swing.JLabel();
        jLabelYear = new javax.swing.JLabel();
        jLabelMinusYear = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabelStaffBlock = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTotalStaff = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelStaffActive = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1330, 870));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDashboardTK.setBackground(new java.awt.Color(215, 220, 222));
        jDashboardTK.setPreferredSize(new java.awt.Dimension(1330, 870));
        jDashboardTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jDashboardTK.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 820, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusable(false);
        jPanel2.setLayout(new java.awt.BorderLayout());
        jDashboardTK.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 490, 300));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jDashboardTK.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 460, 270));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(102, 178, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tổng doanh thu");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabelTotalRevenue.setBackground(new java.awt.Color(102, 178, 255));
        jLabelTotalRevenue.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTotalRevenue.setForeground(new java.awt.Color(153, 153, 255));
        jLabelTotalRevenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalRevenue.setText("19,000,000,000");
        jLabelTotalRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelTotalRevenueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelTotalRevenueMouseExited(evt);
            }
        });
        jPanel5.add(jLabelTotalRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 180, 200));

        jLabel15.setBackground(new java.awt.Color(102, 178, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Tổng đơn hàng");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabelTotalBill.setBackground(new java.awt.Color(102, 178, 255));
        jLabelTotalBill.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTotalBill.setForeground(new java.awt.Color(102, 178, 255));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalBill.setText("522");
        jPanel5.add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 200));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 10, 190));

        jDashboardTK.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 350, 270));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());
        jDashboardTK.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 330, 160));

        jPanelTopAmount.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTopAmount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTopAmount.setBackground(new java.awt.Color(255, 255, 255));
        jTableTopAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableTopAmount.setForeground(new java.awt.Color(0, 0, 0));
        jTableTopAmount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán", "Tổng thu"
            }
        ));
        jTableTopAmount.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableTopAmount.setFocusable(false);
        jTableTopAmount.setRowHeight(25);
        jTableTopAmount.setSelectionBackground(new java.awt.Color(215, 220, 222));
        jTableTopAmount.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableTopAmount.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableTopAmount);

        jPanelTopAmount.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 650, 260));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Top 10 sản phẩm số lượng bán nhiều nhất");
        jPanelTopAmount.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        jDashboardTK.add(jPanelTopAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 590, 650, 280));

        jPanelTopPrice.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTopPrice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTopPrice.setBackground(new java.awt.Color(255, 255, 255));
        jTableTopPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableTopPrice.setForeground(new java.awt.Color(0, 0, 0));
        jTableTopPrice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán", "Tổng thu"
            }
        ));
        jTableTopPrice.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableTopPrice.setFocusable(false);
        jTableTopPrice.setMinimumSize(new java.awt.Dimension(0, 0));
        jTableTopPrice.setRowHeight(25);
        jTableTopPrice.setSelectionBackground(new java.awt.Color(215, 220, 222));
        jTableTopPrice.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableTopPrice.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableTopPrice);

        jPanelTopPrice.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 660, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Top 10 sản phẩm doanh thu cao nhất");
        jPanelTopPrice.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 20));

        jDashboardTK.add(jPanelTopPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 660, 280));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDay.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDay.setText("31");
        jPanel7.add(jLabelDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 40, 40));

        jLabelAddDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_3.png"))); // NOI18N
        jLabelAddDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddDayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddDayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddDayMouseExited(evt);
            }
        });
        jPanel7.add(jLabelAddDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 20, 20));

        jLabelMinusDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_20px_1.png"))); // NOI18N
        jLabelMinusDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusDayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusDayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusDayMouseExited(evt);
            }
        });
        jPanel7.add(jLabelMinusDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 20, 20));

        jRadioButtonDay.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonDay.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonDay.setText("Ngày");
        jRadioButtonDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonDay.setFocusable(false);
        jRadioButtonDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDayActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButtonDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 5, -1, -1));

        jRadioButtonPeriod.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupTypeStatictical.add(jRadioButtonPeriod);
        jRadioButtonPeriod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonPeriod.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonPeriod.setText("Khoảng thời gian:");
        jRadioButtonPeriod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonPeriod.setFocusable(false);
        jRadioButtonPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPeriodActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButtonPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 75, -1, -1));
        jPanel7.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 75, 100, -1));
        jPanel7.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 75, 100, -1));

        jLabelTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTo.setText("đến");
        jPanel7.add(jLabelTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 75, -1, 20));

        jRadioButtonExactDay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupTypeStatictical.add(jRadioButtonExactDay);
        jRadioButtonExactDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonExactDay.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonExactDay.setText("Ngày cụ thể:");
        jRadioButtonExactDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonExactDay.setFocusable(false);
        jRadioButtonExactDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExactDayActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButtonExactDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        jRadioButtonYear.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonYear.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonYear.setText("Năm");
        jRadioButtonYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonYear.setFocusable(false);
        jRadioButtonYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonYearActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButtonYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 5, -1, -1));

        jRadioButtonMonth.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMonth.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonMonth.setText("Tháng");
        jRadioButtonMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonMonth.setFocusable(false);
        jRadioButtonMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMonthActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButtonMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 5, -1, -1));

        jLabelAddMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_3.png"))); // NOI18N
        jLabelAddMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddMonthMouseExited(evt);
            }
        });
        jPanel7.add(jLabelAddMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 20, 20));

        jLabelMonth.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMonth.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMonth.setText("1");
        jPanel7.add(jLabelMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 40, 40));

        jLabelMinusMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_20px_1.png"))); // NOI18N
        jLabelMinusMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusMonthMouseExited(evt);
            }
        });
        jPanel7.add(jLabelMinusMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 20, 20));

        jLabelAddYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_3.png"))); // NOI18N
        jLabelAddYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddYearMouseExited(evt);
            }
        });
        jPanel7.add(jLabelAddYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 20, 20));

        jLabelYear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelYear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelYear.setText("2021");
        jPanel7.add(jLabelYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 40, 40));

        jLabelMinusYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_20px_1.png"))); // NOI18N
        jLabelMinusYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusYearMouseExited(evt);
            }
        });
        jPanel7.add(jLabelMinusYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 20, 20));

        jButton1.setBackground(new java.awt.Color(102, 178, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 75, 70, 20));

        jDashboardTK.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 100));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelStaffBlock.setBackground(new java.awt.Color(102, 178, 255));
        jLabelStaffBlock.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelStaffBlock.setForeground(new java.awt.Color(255, 0, 0));
        jLabelStaffBlock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStaffBlock.setText("30");
        jPanel8.add(jLabelStaffBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 60, 40));

        jLabel8.setBackground(new java.awt.Color(102, 178, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nhân viên");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Khóa");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 10, 80));

        jLabelTotalStaff.setBackground(new java.awt.Color(102, 178, 255));
        jLabelTotalStaff.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTotalStaff.setForeground(new java.awt.Color(102, 178, 255));
        jLabelTotalStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalStaff.setText("30");
        jPanel8.add(jLabelTotalStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 60, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tổng");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 60, -1));

        jLabelStaffActive.setBackground(new java.awt.Color(102, 178, 255));
        jLabelStaffActive.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelStaffActive.setForeground(new java.awt.Color(102, 255, 102));
        jLabelStaffActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStaffActive.setText("30");
        jPanel8.add(jLabelStaffActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 60, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hoạt động");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, -1));

        jDashboardTK.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 160));

        add(jDashboardTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddDayMouseClicked
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        selectedDay++;
        if (selectedDay > days) {
            selectedDay = 1;
            selectedMonth++;
            if (selectedMonth > 12) {
                selectedMonth = 1;
                selectedYear++;
            }
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddDayMouseClicked

    private void jLabelAddDayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddDayMouseEntered
        jLabelAddDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAddDayMouseEntered

    private void jLabelAddDayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddDayMouseExited
        jLabelAddDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_3.png")));
    }//GEN-LAST:event_jLabelAddDayMouseExited

    private void jLabelMinusDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusDayMouseClicked
        selectedDay--;
        if (selectedDay < 1) {
            selectedMonth--;
            GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
            int days = gCal.getActualMaximum(Calendar.DATE);
            selectedDay = days;
            if (selectedMonth < 1) {
                selectedMonth = 12;
                selectedYear--;
            }
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusDayMouseClicked

    private void jLabelMinusDayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusDayMouseEntered
        jLabelMinusDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px.png")));
    }//GEN-LAST:event_jLabelMinusDayMouseEntered

    private void jLabelMinusDayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusDayMouseExited
        jLabelMinusDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px_1.png")));
    }//GEN-LAST:event_jLabelMinusDayMouseExited

    private void jLabelAddMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMonthMouseClicked
        selectedMonth++;
        if (selectedMonth > 12) {
            selectedMonth = 1;
            selectedYear++;
        }
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        if (selectedDay > days) {
            selectedDay = days;
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddMonthMouseClicked

    private void jLabelAddMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMonthMouseEntered
        jLabelAddMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAddMonthMouseEntered

    private void jLabelAddMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMonthMouseExited
        jLabelAddMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_3.png")));
    }//GEN-LAST:event_jLabelAddMonthMouseExited

    private void jLabelMinusMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusMonthMouseClicked
        selectedMonth--;
        if (selectedMonth < 1) {
            selectedMonth = 12;
            selectedYear--;
        }
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        if (selectedDay > days) {
            selectedDay = days;
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusMonthMouseClicked

    private void jLabelMinusMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusMonthMouseEntered
        jLabelMinusMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px.png")));
    }//GEN-LAST:event_jLabelMinusMonthMouseEntered

    private void jLabelMinusMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusMonthMouseExited
        jLabelMinusMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px_1.png")));
    }//GEN-LAST:event_jLabelMinusMonthMouseExited

    private void jLabelAddYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddYearMouseClicked
        selectedYear++;
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        if (selectedDay > days) {
            selectedDay = days;
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddYearMouseClicked

    private void jLabelAddYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddYearMouseEntered
        jLabelAddYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAddYearMouseEntered

    private void jLabelAddYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddYearMouseExited
        jLabelAddYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_3.png")));
    }//GEN-LAST:event_jLabelAddYearMouseExited

    private void jLabelMinusYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusYearMouseClicked
        selectedYear--;
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        if (selectedDay > days) {
            selectedDay = days;
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusYearMouseClicked

    private void jLabelMinusYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusYearMouseEntered
        jLabelMinusYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px.png")));
    }//GEN-LAST:event_jLabelMinusYearMouseEntered

    private void jLabelMinusYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusYearMouseExited
        jLabelMinusYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_20px_1.png")));
    }//GEN-LAST:event_jLabelMinusYearMouseExited

    private void jRadioButtonExactDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExactDayActionPerformed
        jRadioButtonYear.setEnabled(true);
        jRadioButtonMonth.setEnabled(true);
        jRadioButtonDay.setEnabled(true);
        if (jRadioButtonYear.isSelected()) {
            jLabelYear.setEnabled(true);
            jLabelAddYear.setEnabled(true);
            jLabelMinusYear.setEnabled(true);
        }

        if (jRadioButtonMonth.isSelected()) {
            jLabelMonth.setEnabled(true);
            jLabelAddMonth.setEnabled(true);
            jLabelMinusMonth.setEnabled(true);
        }

        if (jRadioButtonDay.isSelected()) {
            jLabelDay.setEnabled(true);
            jLabelAddDay.setEnabled(true);
            jLabelMinusDay.setEnabled(true);
        }

        jDateChooserFrom.setEnabled(false);
        jDateChooserTo.setEnabled(false);
        jLabelTo.setEnabled(false);
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonExactDayActionPerformed

    private void jRadioButtonPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPeriodActionPerformed
        jRadioButtonYear.setEnabled(false);
        jRadioButtonMonth.setEnabled(false);
        jRadioButtonDay.setEnabled(false);
        jLabelYear.setEnabled(false);
        jLabelAddYear.setEnabled(false);
        jLabelMinusYear.setEnabled(false);
        jLabelMonth.setEnabled(false);
        jLabelAddMonth.setEnabled(false);
        jLabelMinusMonth.setEnabled(false);
        jLabelDay.setEnabled(false);
        jLabelAddDay.setEnabled(false);
        jLabelMinusDay.setEnabled(false);

        jDateChooserFrom.setEnabled(true);
        jDateChooserTo.setEnabled(true);
        jLabelTo.setEnabled(true);
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonPeriodActionPerformed

    private void jRadioButtonYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonYearActionPerformed
        if (!jRadioButtonYear.isSelected()) {
            jRadioButtonYear.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButtonYearActionPerformed

    private void jRadioButtonMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMonthActionPerformed
        if (jRadioButtonMonth.isSelected()) {
            jLabelMonth.setEnabled(true);
            jLabelAddMonth.setEnabled(true);
            jLabelMinusMonth.setEnabled(true);
        } else if (!jRadioButtonMonth.isSelected() && jRadioButtonDay.isSelected()) {
            jRadioButtonMonth.setSelected(true);
        } else {
            jLabelMonth.setEnabled(false);
            jLabelAddMonth.setEnabled(false);
            jLabelMinusMonth.setEnabled(false);
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMonthActionPerformed

    private void jRadioButtonDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDayActionPerformed
        if (jRadioButtonDay.isSelected()) {
            jLabelDay.setEnabled(true);
            jLabelAddDay.setEnabled(true);
            jLabelMinusDay.setEnabled(true);
        } else {
            jLabelDay.setEnabled(false);
            jLabelAddDay.setEnabled(false);
            jLabelMinusDay.setEnabled(false);
        }

        if (jRadioButtonDay.isSelected() && !jRadioButtonMonth.isSelected()) {
            jRadioButtonMonth.setSelected(true);
            jLabelMonth.setEnabled(true);
            jLabelAddMonth.setEnabled(true);
            jLabelMinusMonth.setEnabled(true);
        }
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth - 1, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        if (selectedDay > days) {
            selectedDay = days;
        }
        try {
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonDayActionPerformed

    private void jLabelTotalRevenueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalRevenueMouseEntered
        jLabelTotalRevenue.setFont(new java.awt.Font("Tahoma", 1, 19));
        String str = String.format("%1$,.0f", totalRevenue);
        jLabelTotalRevenue.setText(str);
    }//GEN-LAST:event_jLabelTotalRevenueMouseEntered

    private void jLabelTotalRevenueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalRevenueMouseExited
        jLabelTotalRevenue.setFont(new java.awt.Font("Tahoma", 1, 32));
        String str = String.format("%.0f", totalRevenue);
        if (str.length() > 9) {
            float totalRevenue1 = totalRevenue / 1000000000;
            str = String.format("%.1f", totalRevenue1) + "B";
        } else if (str.length() > 6) {
            float totalRevenue1 = totalRevenue / 1000000;
            str = String.format("%.1f", totalRevenue1) + "M";
        } else if (str.length() > 3) {
            float totalRevenue1 = totalRevenue / 1000;
            str = String.format("%.1f", totalRevenue1) + "K";
        }
        jLabelTotalRevenue.setText(str);
    }//GEN-LAST:event_jLabelTotalRevenueMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date fDate = jDateChooserFrom.getDate();
        fromDate = fDate.getYear() + 1900 + "-" + fDate.getMonth() + 1 + "-" + fDate.getDate();
        Date tDate = jDateChooserTo.getDate();
        toDate = tDate.getYear() + 1900 + "-" + tDate.getMonth() + 1 + "-" + tDate.getDate();
        try {
            datasetPeriod();
            showStatictical();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStatisticalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTypeStatictical;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jDashboardTK;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddDay;
    private javax.swing.JLabel jLabelAddMonth;
    private javax.swing.JLabel jLabelAddYear;
    private javax.swing.JLabel jLabelDay;
    private javax.swing.JLabel jLabelMinusDay;
    private javax.swing.JLabel jLabelMinusMonth;
    private javax.swing.JLabel jLabelMinusYear;
    private javax.swing.JLabel jLabelMonth;
    private javax.swing.JLabel jLabelStaffActive;
    private javax.swing.JLabel jLabelStaffBlock;
    private javax.swing.JLabel jLabelTo;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JLabel jLabelTotalRevenue;
    private javax.swing.JLabel jLabelTotalStaff;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelTopAmount;
    private javax.swing.JPanel jPanelTopPrice;
    private javax.swing.JRadioButton jRadioButtonDay;
    private javax.swing.JRadioButton jRadioButtonExactDay;
    private javax.swing.JRadioButton jRadioButtonMonth;
    private javax.swing.JRadioButton jRadioButtonPeriod;
    private javax.swing.JRadioButton jRadioButtonYear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableTopAmount;
    private javax.swing.JTable jTableTopPrice;
    // End of variables declaration//GEN-END:variables
}
