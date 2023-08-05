package designs;

import java.awt.HeadlessException;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class CustomerMasterForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomerMasterForm
     */
    Connection connection = null;    

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

    public CustomerMasterForm() {
        initComponents();
        getConnected();
        autoSetFields();
        saveButton.setEnabled(true);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
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
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        separator = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        formLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        ageLabel = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Master Form");
        setName("customerDetails"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1070, 640));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 640));

        saveButton.setBackground(new java.awt.Color(255, 255, 204));
        saveButton.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(255, 255, 204));
        resetButton.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        separator.setBackground(new java.awt.Color(0, 153, 0));
        separator.setPreferredSize(new java.awt.Dimension(1070, 6));

        javax.swing.GroupLayout separatorLayout = new javax.swing.GroupLayout(separator);
        separator.setLayout(separatorLayout);
        separatorLayout.setHorizontalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separatorLayout.setVerticalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(1070, 90));

        formLabel.setFont(new java.awt.Font("Quicksand Medium", 1, 36)); // NOI18N
        formLabel.setForeground(new java.awt.Color(255, 255, 255));
        formLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formLabel.setText("ADD CUSTOMER DETAILS");
        formLabel.setFocusable(false);
        formLabel.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formLabel)
                .addGap(290, 290, 290))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        idLabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        idLabel.setText("ID");

        id.setEditable(false);
        id.setPreferredSize(new java.awt.Dimension(265, 25));

        nameLabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        nameLabel.setText("Name");
        nameLabel.setPreferredSize(new java.awt.Dimension(88, 32));

        name.setPreferredSize(new java.awt.Dimension(265, 25));

        phoneLabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        phoneLabel.setText("Phone");

        addressLabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        addressLabel.setText("Address");

        address.setColumns(20);
        address.setRows(5);
        address.setPreferredSize(new java.awt.Dimension(265, 25));
        jScrollPane1.setViewportView(address);

        ageLabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        ageLabel.setText("Age");
        ageLabel.setPreferredSize(new java.awt.Dimension(32, 16));

        age.setMinimumSize(new java.awt.Dimension(64, 32));
        age.setPreferredSize(new java.awt.Dimension(265, 25));

        phone.setPreferredSize(new java.awt.Dimension(265, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(age, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addressLabel, ageLabel, idLabel, nameLabel, phoneLabel});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {age, id, name, phone});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addGap(45, 45, 45))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addressLabel, ageLabel, idLabel, nameLabel, phoneLabel});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {age, id, name, phone});

        updateButton.setBackground(new java.awt.Color(255, 255, 204));
        updateButton.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 204));
        deleteButton.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        searchList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchListItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchList, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
            .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(searchList, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:        
        try {
            validateForm();
            String sqlQuery = " INSERT INTO customer_master( cid, \"cname\", \"phone\", age, \"address\")	VALUES ( ?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, Integer.valueOf(id.getText()));
            preparedStatement.setString(2, name.getText());
            preparedStatement.setString(3, phone.getText());
            preparedStatement.setInt(4, Integer.valueOf(age.getText()));
            preparedStatement.setString(5, address.getText());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Added");
            reset();
        } catch (HeadlessException | NumberFormatException | SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        boolean isSelected = searchList.getSelectedIndex() > 0;
        if (isSelected) {
            try {
                int cid = Integer.parseInt(id.getText());
                validateForm();
                int confirmation = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Update?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    String query = "UPDATE customer_master "
                            + "SET cname = ?, "
                            + "address = ?, "
                            + "phone = ?, "
                            + "age = ? "
                            + "WHERE cid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, name.getText());
                    preparedStatement.setString(2, address.getText());
                    preparedStatement.setString(3, phone.getText());
                    preparedStatement.setInt(4, Integer.valueOf(age.getText()));
                    preparedStatement.setInt(5, cid);

                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows == 1) {
                        JOptionPane.showMessageDialog(null, "Updated A Record");
                    }
                    reset();
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
                // System.out.println(exception.getCause());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select A Customer!!!");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        boolean isSelected = searchList.getSelectedIndex() > 0;
        if (isSelected) {
            int cid = Integer.parseInt(id.getText());
            int confirmation = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    String query = "DELETE FROM customer_master WHERE cid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, cid);

                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows == 1) {
                        JOptionPane.showMessageDialog(null, "Deleted A Record");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineMasterForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                reset();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select A Customer!!!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchListItemStateChanged
        // TODO add your handling code here:
        String cname = (String) searchList.getSelectedItem();
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM customer_master WHERE cname = \'" + cname + "\'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                id.setText("" + resultSet.getInt("cid"));
                name.setText(resultSet.getString("cname"));
                address.setText(resultSet.getString("address"));
                phone.setText(resultSet.getString("phone"));
                age.setText("" + resultSet.getInt("age"));
            }
            saveButton.setEnabled(false);

        } catch (SQLException ex) {
            Logger.getLogger(MedicineMasterForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchListItemStateChanged

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
            java.util.logging.Logger.getLogger(CustomerMasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMasterForm().setVisible(true);
            }
        });
    }

    public void reset() {
        autoSetFields();
        name.setText("");
        phone.setText("");
        age.setText("");
        address.setText("");
        searchList.setSelectedIndex(0);
        saveButton.setEnabled(true);
    }

    public void autoSetFields() {
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT cid, cname FROM customer_master ORDER BY cid";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            searchList.removeAllItems();
            searchList.addItem("Search");
            int lastId = 0;

            while (resultSet.next()) {
                searchList.addItem(resultSet.getString("cname"));
                lastId = resultSet.getInt("cid");
            }
            if (lastId == 0) {
                id.setText("" + 1001);
            } else {
                id.setText("" + (lastId + 1));
            }

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException);
        }
    }

    public void validateForm() throws Exception {
        if (name.getText().isBlank()) {
            throw new Exception("Enter Valid Name!!!");
        }

        if (phone.getText().length() != 10 || phone.getText().isBlank()) {
            throw new Exception("Enter Valid Phone Number!!!");
        }

        if (age.getText().isBlank() || Integer.parseInt(age.getText()) <= 0 || Integer.parseInt(age.getText()) > 120) {
            throw new Exception("Enter Valid Age!!!");
        }

        if (address.getText().isBlank()) {
            throw new Exception("Enter Valid Address!!!");
        }

        //        saveButton.setEnabled(
        //                !(name.getText().isEmpty()
        //                || phone.getText().isEmpty()
        //                || age.getText().isEmpty()
        //                || address.getText().isEmpty()));
        //    }
        //
        //    resetButton.setEnabled (
        //            
        //
        //!(name.getText().isEmpty()
        //                && phone.getText().isEmpty()
        //                && age.getText().isEmpty()
        //                && address.getText().isEmpty()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField age;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel formLabel;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> searchList;
    private javax.swing.JPanel separator;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
