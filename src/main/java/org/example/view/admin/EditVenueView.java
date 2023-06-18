/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.admin;

import org.example.controllers.CategoryController;
import org.example.controllers.VenueController;
import org.example.dependencyInjection.CategoryControllerFactory;
import org.example.dependencyInjection.VenueControllerFactory;
import org.example.models.Category;
import org.example.models.Venue;

import javax.swing.*;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author fadhl
 */
public class EditVenueView extends javax.swing.JFrame {

    private VenueControllerFactory factory = new VenueControllerFactory();
    private CategoryControllerFactory categoryControllerFactory = new CategoryControllerFactory();
    private CategoryController categoryController = categoryControllerFactory.controller();
    private VenueController controller = factory.controller();
    public EditVenueView() {
        initComponents();
        // custom
        txtIdEdtVenue.setEnabled(false);
        fillComboBox();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatusGroup = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        txtIdEdtVenue = new javax.swing.JTextField();
        txtPriceEdtVenue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNameEdtVenue = new javax.swing.JTextField();
        cbCategoryEdtVenue = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescriptionEdtVenue = new javax.swing.JTextArea();
        rbOpenEdtVenue = new javax.swing.JRadioButton();
        rbCloseEdtVenue = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        btnSaveEdtVenue = new javax.swing.JButton();
        jsOpenEdtVenue = new javax.swing.JSpinner();
        btnCancelEdtVenue = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jsCloseEdtVenue = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perbarui Lapangan");

        jLabel7.setText("Harga");

        jLabel3.setText("Nama");

        jLabel8.setText("Kategori");

        jLabel4.setText("Deskripsi");

        jLabel9.setText("Status");

        txtDescriptionEdtVenue.setColumns(20);
        txtDescriptionEdtVenue.setRows(5);
        jScrollPane1.setViewportView(txtDescriptionEdtVenue);

        StatusGroup.add(rbOpenEdtVenue);
        rbOpenEdtVenue.setText("Aktif");

        StatusGroup.add(rbCloseEdtVenue);
        rbCloseEdtVenue.setText("Non Aktif");
        rbCloseEdtVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCloseEdtVenueActionPerformed(evt);
            }
        });

        jLabel5.setText("Jam Buka");

        btnSaveEdtVenue.setBackground(new java.awt.Color(0, 153, 51));
        btnSaveEdtVenue.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEdtVenue.setText("Simpan Perubahan");
        btnSaveEdtVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEdtVenueActionPerformed(evt);
            }
        });

        btnCancelEdtVenue.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelEdtVenue.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelEdtVenue.setText("Batal");
        btnCancelEdtVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEdtVenueActionPerformed(evt);
            }
        });

        jLabel6.setText("Jam Tutup");

        jLabel2.setText("Id");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Perbarui Lapangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsOpenEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsCloseEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbCategoryEdtVenue, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPriceEdtVenue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSaveEdtVenue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbOpenEdtVenue)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbCloseEdtVenue))
                                .addComponent(btnCancelEdtVenue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(82, 82, 82)
                                .addComponent(txtNameEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsOpenEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsCloseEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPriceEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoryEdtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbOpenEdtVenue)
                    .addComponent(rbCloseEdtVenue))
                .addGap(35, 35, 35)
                .addComponent(btnSaveEdtVenue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelEdtVenue)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reset(){
        txtIdEdtVenue.setText("");
        txtNameEdtVenue.setText("");
        txtDescriptionEdtVenue.setText("");
        txtPriceEdtVenue.setText("");
        rbCloseEdtVenue.setSelected(false);
        rbOpenEdtVenue.setSelected(false);
    }
    private void rbCloseEdtVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCloseEdtVenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCloseEdtVenueActionPerformed

    public void fillComboBox(){
        List<Category> categories = categoryController.findAllCategories();
        cbCategoryEdtVenue.addItem("Pilih Kategori");
        for (Category category : categories) {
            cbCategoryEdtVenue.addItem(category.getName());
        }
    }
    private void btnSaveEdtVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEdtVenueActionPerformed
        // TODO add your handling code here:
        Time open = Time.valueOf(""+jsOpenEdtVenue.getValue()+":00:00");
        Time close = Time.valueOf(""+jsCloseEdtVenue.getValue()+":00:00");
        String categoryName = (String) cbCategoryEdtVenue.getSelectedItem();
        Category category = categoryController.findCategoryByName(categoryName);
        String categoryId = category.getId();

        boolean status = true;
        if (rbOpenEdtVenue.isSelected()){
            status = true;
        } else  if (rbCloseEdtVenue.isSelected()){
            status = false;
        }

        Venue venue = new Venue();
        venue.setId(txtIdEdtVenue.getText());
        venue.setName(txtNameEdtVenue.getText());
        venue.setDescription(txtDescriptionEdtVenue.getText());
        venue.setPrice(Long.parseLong(txtPriceEdtVenue.getText()));
        venue.setOpen(open);
        venue.setClose(close);
        venue.setCategory(categoryId);
        venue.setActive(status);
        controller.updateVenue(venue);
        JOptionPane.showMessageDialog(this, "Data berhasil di perbaharui");
        this.dispose();
    }//GEN-LAST:event_btnSaveEdtVenueActionPerformed

    private void btnCancelEdtVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEdtVenueActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelEdtVenueActionPerformed

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
            java.util.logging.Logger.getLogger(EditVenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditVenueView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup StatusGroup;
    private javax.swing.JButton btnCancelEdtVenue;
    private javax.swing.JButton btnSaveEdtVenue;
    public javax.swing.JComboBox<String> cbCategoryEdtVenue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSpinner jsCloseEdtVenue;
    public javax.swing.JSpinner jsOpenEdtVenue;
    public javax.swing.JRadioButton rbCloseEdtVenue;
    public javax.swing.JRadioButton rbOpenEdtVenue;
    public javax.swing.JTextArea txtDescriptionEdtVenue;
    public javax.swing.JTextField txtIdEdtVenue;
    public javax.swing.JTextField txtNameEdtVenue;
    public javax.swing.JTextField txtPriceEdtVenue;
    // End of variables declaration//GEN-END:variables
}
