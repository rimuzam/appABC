/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.admin;

import org.example.controllers.CategoryController;
import org.example.controllers.VenueController;
import org.example.dependencyInjection.CategoryControllerFactory;
import org.example.dependencyInjection.VenueControllerFactory;
import org.example.dtos.VenueResponse;
import org.example.models.Category;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fadhl
 */
public class VenuePage extends javax.swing.JFrame {
    private VenueControllerFactory factory = new VenueControllerFactory();
    private CategoryControllerFactory categoryControllerFactory = new CategoryControllerFactory();
    private VenueController controller = factory.controller();
    private CategoryController categoryController = categoryControllerFactory.controller();
    EditVenueView edit = new EditVenueView();
    private String id, name, description, price, category, status;
    private int open, close;
    public VenuePage() {
        initComponents();
        //custom
        fillComboBox();
        readTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenues = new javax.swing.JTable();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Halaman Lapangan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Halaman Lapangan");

        btnCreate.setText("Tambah Lapangan");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("Perbarui");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblVenues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nama", "Deskripsi", "Jam Buka", "Jam Tutup", "Harga", "Kategori", "Status"
            }
        ));
        tblVenues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVenuesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVenues);

//        cbCategory.addItemListener(new java.awt.event.ItemListener() {
//            public void itemStateChanged(java.awt.event.ItemEvent evt) {
//                cbCategoryItemStateChanged(evt);
//            }
//        });
        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter Berdasarkan Kategori");

        btnRefresh.setText("Segarkan");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAddCategory.setText("Tambah Kategori");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void fillComboBox(){
        List<Category> categories = categoryController.findAllCategories();
        cbCategory.addItem("Semua");
        for (Category category : categories) {
            cbCategory.addItem(category.getName());
        }
    }
    public void readTable(){
        DefaultTableModel model = (DefaultTableModel) tblVenues.getModel();
        int x = 0;
        List<VenueResponse> venues = null;

        String category = (String) cbCategory.getSelectedItem();
        if (category.equals("Semua")){
            venues = controller.findAllVenues();
        } else {
            Category categoryByName = categoryController.findCategoryByName(category);
            venues = controller.findVenueByCategory(categoryByName.getName());
        }

        model.setRowCount(venues.size());
        for (VenueResponse venue : venues) {
            model.setValueAt(venue.getId(), x, 0);
            model.setValueAt(venue.getName(), x, 1);
            model.setValueAt(venue.getDescription(), x, 2);
            model.setValueAt(venue.getOpen(), x, 3);
            model.setValueAt(venue.getClose(), x, 4);
            model.setValueAt(venue.getPrice(), x, 5);
            model.setValueAt(venue.getCategory(), x, 6);
            model.setValueAt(venue.isActive(), x, 7);
            x++;
        }
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        new CreateVenue().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (id != null) {
            edit.setVisible(true);
            fillEditForm();
            return;
        }
        JOptionPane.showMessageDialog(this, "Anda belum memilih lapangan", "warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
        readTable();
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        readTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        tblVenues.clearSelection();
        cbCategory.setSelectedItem("Semua");
        readTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblVenuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVenuesMouseClicked
        // TODO add your handling code here:
        int row = tblVenues.getSelectedRow();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int openHours ;
        int closeHours ;
        try {
            Date dateOpen = sdf.parse(tblVenues.getValueAt(row, 3).toString());
            Date dateClose = sdf.parse(tblVenues.getValueAt(row, 4).toString());
            openHours = dateOpen.getHours();
            closeHours = dateClose.getHours();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        id = (tblVenues.getValueAt(row, 0).toString());
        name = (tblVenues.getValueAt(row, 1).toString());
        description = (tblVenues.getValueAt(row, 2).toString());
        open = openHours;
        close = closeHours;
        price = (tblVenues.getValueAt(row, 5).toString());
        category = (tblVenues.getValueAt(row, 6).toString());
        status = (tblVenues.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblVenuesMouseClicked

    private void fillEditForm () {
        edit.txtIdEdtVenue.setText(id);
        edit.txtNameEdtVenue.setText(name);
        edit.txtDescriptionEdtVenue.setText(description);
        edit.jsOpenEdtVenue.setValue(open);
        edit.jsCloseEdtVenue.setValue(close);
        edit.txtPriceEdtVenue.setText(price);
        edit.cbCategoryEdtVenue.setSelectedItem(category);
        if (status.equals("Aktif")){
            edit.rbOpenEdtVenue.setSelected(true);
        } else {
            edit.rbCloseEdtVenue.setSelected(true);
        }
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminMenuView().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
        new CreateCategoryView().setVisible(true);
    }//GEN-LAST:event_btnAddCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(VenuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenuePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVenues;
    // End of variables declaration//GEN-END:variables
}
