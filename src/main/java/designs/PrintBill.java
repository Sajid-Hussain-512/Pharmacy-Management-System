package designs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrintBill extends javax.swing.JFrame {

    Connection connection = null;
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    

    public Connection getConnected() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null, classNotFoundException);
        }

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "postgres";

            connection = getConnection(url, user, password);
            // JOptionPane.showMessageDialog(null, "Connected");
        } catch (SQLException ex) {
            Logger.getLogger(MedicineMasterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public PrintBill() {
        initComponents();
        getConnected();
        getDetails();
    }

    public void getDetails() {
        
        // Declarations
        int oid = 0, cid = 0, age = 0;
        double price = 0.0, total = 0.0, totalCost = 0.0, discount = 0.0, toPay = 0.0;
        String doctorName = null, customerName = null, phone = null, oDate = null, medName = null;
        DefaultTableModel tableModel = (DefaultTableModel) orderTable.getModel();
        
        
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT oid, cid, d_name, o_date FROM c_order_master ORDER BY oid DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                oid = resultSet.getInt("oid");
                cid = resultSet.getInt("cid");
                doctorName = resultSet.getString("d_name");
                java.sql.Date date = resultSet.getDate("o_date");
                oDate = dateFormat.format(date);
            }

            selectQuery = "SELECT cname, phone, age FROM customer_master WHERE cid = " + cid;
            resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                customerName = resultSet.getString("cname");
                phone = resultSet.getString("phone");
                age = resultSet.getInt("age");
            }
            // Setting Customer Details
            nameLabel.setText(customerName);
            ageLabel.setText("" + age);
            phoneLabel.setText(phone);
            orderIDLabel.setText("" + oid);
            doctorLabel.setText(doctorName);
            dateLabel.setText(oDate);

            int serialNumber = 0;
            totalCost = 0.0;
            selectQuery = "SELECT mid, quantity, delivered, d_date FROM c_order_details WHERE oid = " + oid;
            resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int mid = resultSet.getInt("mid");
                int units = resultSet.getInt("quantity");
                boolean delivered = resultSet.getBoolean("delivered");
                java.sql.Date date = resultSet.getDate("d_date");
                String dDate = dateFormat.format(date);
                
                Statement statement1 = connection.createStatement();
                selectQuery = "SELECT mname, price FROM medicine_master WHERE mid = " + mid;
                ResultSet result = statement1.executeQuery(selectQuery);
                if (result.next()) {
                    medName = result.getString("mname");
                    price = result.getDouble("price");
                    total = price * units;
                
                    // Setting Table Details
                    Object[] rowToAdd = {++serialNumber, medName, currencyInstance.format(price), units, dDate, delivered, currencyInstance.format(total)};
                    tableModel.addRow(rowToAdd);
                    
                    totalCost += total;
                    discount = 0.15 * totalCost;
                    toPay = (int) (totalCost - discount);
                }
            }
            // Setting Payment Details
            totalLabel.setText(currencyInstance.format(totalCost));
            discountLabel.setText(currencyInstance.format(discount));
            toPayLabel.setText(currencyInstance.format(toPay));

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException);
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

        printBill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        doctorLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        toPayLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        orderIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        printBill.setText("Print Bill");
        printBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillActionPerformed(evt);
            }
        });

        BillPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Central Medico");

        jLabel2.setFont(new java.awt.Font("Kalam", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("A one stop Medical Shop");

        jLabel3.setFont(new java.awt.Font("Lemon", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Main Bazaar, Central Road, Central City");

        jPanel3.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Age");

        nameLabel.setText("name");

        ageLabel.setText("age");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Phone");

        phoneLabel.setText("phone");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Doctor");

        doctorLabel.setText("doctor");

        jSeparator1.setBackground(new java.awt.Color(0, 204, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 204, 0));

        jLabel12.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Total");

        jLabel13.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Discount");

        totalLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        discountLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        discountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel14.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("To Pay");

        toPayLabel.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        toPayLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jSeparator3.setBackground(new java.awt.Color(0, 204, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 204, 0));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No.", "Medicine", "Rate", "Units", "Delivery Date", "Available", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Date");

        dateLabel.setText("date");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel19.setText("PROPRIETOR");

        jSeparator2.setBackground(new java.awt.Color(0, 204, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 204, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Order ID");

        orderIDLabel.setText("order ID");

        javax.swing.GroupLayout BillPanelLayout = new javax.swing.GroupLayout(BillPanel);
        BillPanel.setLayout(BillPanelLayout);
        BillPanelLayout.setHorizontalGroup(
            BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BillPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doctorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillPanelLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toPayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(91, 91, 91))
            .addGroup(BillPanelLayout.createSequentialGroup()
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel19))
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1))
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel3))
                    .addGroup(BillPanelLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BillPanelLayout.setVerticalGroup(
            BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(doctorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(BillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toPayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel19)
                .addGap(38, 38, 38))
        );

        jScrollPane1.setViewportView(BillPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printBill, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBillActionPerformed
        // TODO add your handling code here
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47, 0.47);
                BillPanel.print(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_printBillActionPerformed

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
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrintBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BillPanel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel orderIDLabel;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton printBill;
    private javax.swing.JLabel toPayLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
