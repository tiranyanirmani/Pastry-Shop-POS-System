package GUI;

import Model.MYSQLS;
import java.sql.Connection;
//import Model.Mysql;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CODER
 */
public class Saless extends javax.swing.JPanel {

    public static String Id = "0";

    public Saless() {
        initComponents();
        loadCustomers();
        loadProducts();
    }

    public void loadCustomers() {
        try {

            //Statement s = Mysql.dbcon().createStatement();
            ResultSet rs = MYSQLS.search("SELECT * FROM customer");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("Name"));

            }

            com_cus.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadProducts() {
        try {
            //Statement s = Mysql.dbcon().createStatement();
            ResultSet rs = MYSQLS.search("SELECT * FROM product");
            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("Name"));
                //DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                //com_pro.setModel(com);
            }
            com_pro.setModel(new DefaultComboBoxModel(v));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //load Invoice Numbers
        try {
            //Statement s = Mysql.dbcon().createStatement();
            ResultSet rs = MYSQLS.search("SELECT * FROM other WHERE other_id = 1");

            if (rs.next()) {
                inId.setText(rs.getString("value"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // new Invoice
        int i = Integer.valueOf(inId.getText());
        i++;
        inId.setText(String.valueOf(i));
    }

    public void productTotalcal() {
        //product calculations

        Double qty = Double.valueOf(p_qty.getText());
        Double price = Double.valueOf(u_price.getText());
        Double tot;

        tot = qty * price;
        tot_price.setText(String.valueOf(tot));
    }

    public void totalSave() {  //total save bills

        int numOfRows = jTable1.getRowCount();

        double total = 0;
        for (int i = 0; i < numOfRows; i++) {
            double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            total += value;
        }

        total_bill.setText(Double.toString(total));

        //Total Quauntity
        int numOfQtyRows = jTable1.getRowCount();

        double totalQty = 0;

        for (int i = 0; i < numOfQtyRows; i++) {
            double values = Double.valueOf(jTable1.getValueAt(i, 3).toString());
            totalQty += values;
        }

        total_qty.setText(Double.toString(totalQty));

    }

    public void tot() {

        Double paid = Double.valueOf(paid_amount.getText());
        Double tot = Double.valueOf(total_bill.getText());
        Double balance;

        balance = paid - tot;
        bal.setText(String.valueOf(balance));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        com_cus = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        com_pro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tot_price = new javax.swing.JLabel();
        p_qty = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        total_bill = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bal = new javax.swing.JLabel();
        paid_amount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        total_qty = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        inId = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(242, 219, 173));
        jPanel1.setPreferredSize(new java.awt.Dimension(992, 549));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Invoice No : ");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Point of Sales");

        jPanel4.setBackground(new java.awt.Color(224, 155, 121));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer : ");

        com_cus.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        com_cus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        com_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_cusActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Product :");

        com_pro.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        com_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        com_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_proActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantity :");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Unit Price : ");

        u_price.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        u_price.setForeground(new java.awt.Color(255, 255, 255));
        u_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        u_price.setText("00.00");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total Price : ");

        tot_price.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        tot_price.setForeground(new java.awt.Color(255, 255, 255));
        tot_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot_price.setText("00.00");

        p_qty.setBackground(new java.awt.Color(224, 155, 121));
        p_qty.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        p_qty.setForeground(new java.awt.Color(255, 255, 255));
        p_qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        p_qty.setText("00");
        p_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_qtyActionPerformed(evt);
            }
        });
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 153, 51));
        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(204, 0, 0));
        jButton9.setText("Remove Selected");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 255));
        jButton11.setText("Remove All");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(com_pro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addGap(20, 20, 20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Payment");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel19.setText("Total Payment");

        total_bill.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        total_bill.setText("00.00");

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel22.setText("Paid Amount");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel23.setText("Balance");

        bal.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        bal.setText("00.00");

        paid_amount.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        paid_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        paid_amount.setText("0.0");
        paid_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amountKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel20.setText("No of Items : ");

        total_qty.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        total_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_qty.setText("00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(38, 38, 38)
                        .addComponent(total_bill))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(81, 81, 81)
                        .addComponent(bal))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(40, 40, 40)
                        .addComponent(paid_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(total_bill)
                    .addComponent(jLabel20)
                    .addComponent(total_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(paid_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(bal))
                .addGap(27, 27, 27))
        );

        jButton15.setBackground(new java.awt.Color(153, 51, 0));
        jButton15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton15.setText("Pay");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Item_Name", "Quantity", "Unit_Price", "Total_Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        inId.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        inId.setText("01");

        jButton13.setBackground(new java.awt.Color(153, 51, 0));
        jButton13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton13.setText("View Sales Report");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inId))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inId)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {

            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            int row = jTable1.getSelectedRow();

            dt.removeRow(row);

            totalSave();

        } catch (Exception e) {

        }

        tot();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void com_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_proActionPerformed
        // TODO add your handling code here: 
        String name = com_pro.getSelectedItem().toString();

        try {
            //Statement s = Mysql.dbcon().createStatement();
            ResultSet rs = MYSQLS.search("SELECT Price FROM product WHERE Name = '" + name + "' ");

            if (rs.next()) {
                u_price.setText(rs.getString("Price"));
            }

            productTotalcal();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_com_proActionPerformed

    private void p_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_qtyActionPerformed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased
        // TODO add your handling code here:
        productTotalcal();
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        Vector v = new Vector();

        v.add(inId.getText());
        v.add(com_cus.getSelectedItem().toString()); //customer name
        v.add(com_pro.getSelectedItem().toString()); //product name
        v.add(p_qty.getText()); //qty
        v.add(u_price.getText()); //unitPrice
        v.add(tot_price.getText()); //gettotal

        v.add(total_bill.getText());// total payment
        v.add(bal.getText());// balance

        dt.addRow(v);

        totalSave();

        tot();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);

        totalSave();

        tot();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void paid_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amountKeyReleased
        // TODO add your handling code here:       
        tot();
    }//GEN-LAST:event_paid_amountKeyReleased

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:

        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            int rwC = dt.getRowCount();

            for (int i = 0; i < rwC; i++) {

                String inid = dt.getValueAt(i, 0).toString(); //inId
                String cname = dt.getValueAt(i, 1).toString();
                String pname = dt.getValueAt(i, 2).toString();
                String qty = dt.getValueAt(i, 3).toString();
                String UnitPrice = dt.getValueAt(i, 4).toString();
                String TotalPrice = dt.getValueAt(i, 5).toString();

                MYSQLS.iud("INSERT INTO sales (Inid, Customer_Name, Product_Name, Qty, UnitPrice, TotalPrice) VALUES ('" + inid + "','" + cname + "','" + pname + "','" + qty + "','" + UnitPrice + "','" + TotalPrice + "') ");
            }

            JOptionPane.showMessageDialog(null, "Successfully Paid");

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String inv_id = inId.getText();
            String Cus_Name = com_cus.getSelectedItem().toString();
            String Pro_Name = com_pro.getSelectedItem().toString();
            String qty = p_qty.getText();
            String uPrice = u_price.getText();
            String tPrice = tot_price.getText();
            //String Cus_Id = dt.getValueAt(i, 1).toString();
            String totqty = total_qty.getText();
            String totbill = total_bill.getText();
            String paidAmount = paid_amount.getText();
            //String Status = "Paid";
            String balance = bal.getText();

            //status
            Double tot = Double.valueOf(total_bill.getText());
            Double pid = Double.valueOf(paid_amount.getText());
            String Status = null;

            if (pid.equals(0.0)) {
                Status = "Unpaid";
            } else if (tot <= pid) {
                Status = "Paid";
            } else if (tot > pid) {
                Status = "Partial";
            }

            //Bill
            //Statement ss = Mysql.dbcon().createStatement();
            //String inid = null;
            MYSQLS.iud("INSERT INTO bill (INID, Cus_Id, Cus_Name, Product_Name, Quantity, Unit_Price, Total_Price, Total_Qty, Total_Bill, Status, Paid_Amount, Balance) VALUES ('" + inv_id + "','" + Id + "','" + Cus_Name + "','" + Pro_Name + "','" + qty + "','" + uPrice + "','" + tPrice + "','" + totqty + "','" + totbill + "','" + Status + "','" + paidAmount + "','" + balance + "') ");

        } catch (Exception e) {
            System.out.println(e);
        }

        // save invoiceNo
        try {
            String id = inId.getText();
            //Statement s = Mysql.dbcon().createStatement();
            MYSQLS.iud("UPDATE other SET value='" + id + "' WHERE other_id = 1");
            //s.executeUpdate("INSERT INTO other WHERE other_id = 1 ")

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void com_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_cusActionPerformed
        // TODO add your handling code here:

        String name = com_cus.getSelectedItem().toString();

        try {
            //Statement s = Mysql.dbcon().createStatement();
            ResultSet rs = MYSQLS.search("SELECT Id,Name FROM customer WHERE Name = '" + name + "' ");

            if (rs.next()) {
                Id = (rs.getString("Id"));
            }

            productTotalcal();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_com_cusActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         
        try {

            String path = "src//Reports//recipt_1.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(path);

            HashMap parameters = new HashMap();
            Connection dataSource = MYSQLS.getConnection();

            //JREmptyDataSource dataSource = new JREmptyDataSource();
            //TableModel tm = jTable1.getModel();

            //JRTableModelDataSource dataSource = new JRTableModelDataSource(tm);

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);

            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bal;
    private javax.swing.JComboBox<String> com_cus;
    private javax.swing.JComboBox<String> com_pro;
    private javax.swing.JLabel inId;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField p_qty;
    private javax.swing.JTextField paid_amount;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel total_bill;
    private javax.swing.JLabel total_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables
}
