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
public class CreateVenue extends javax.swing.JFrame {
    private VenueControllerFactory factory = new VenueControllerFactory();
    private CategoryControllerFactory categoryControllerFactory = new CategoryControllerFactory();
    private CategoryController categoryController = categoryControllerFactory.controller();
    private VenueController controller = factory.controller();
    public CreateVenue() {
        initComponents();
        fillCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgStatus = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jsOpen = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jsClose = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        rbOpen = new javax.swing.JRadioButton();
        rbClose = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Input Lapangan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Input Lapangan");

        jLabel2.setText("Id");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        jLabel3.setText("Nama");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        jLabel4.setText("Deskripsi");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        jLabel5.setText("Jam Buka");

        jsOpen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jsOpenKeyPressed(evt);
            }
        });

        jLabel6.setText("Jam Tutup");

        jsClose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jsCloseKeyPressed(evt);
            }
        });

        jLabel7.setText("Harga");

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
        });

        jLabel8.setText("Kategori");

        jLabel9.setText("Status");

        bgStatus.add(rbOpen);
        rbOpen.setText("Buka");

        bgStatus.add(rbClose);
        rbClose.setText("Tutup");
        rbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCloseActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 153, 51));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnReset.setText("Bersihkan");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(82, 82, 82)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jsOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsClose, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbOpen)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbClose))
                                .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbOpen)
                    .addComponent(rbClose))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCloseActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new VenuePage().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    public void fillCombo(){
        List<Category> categories = categoryController.findAllCategories();
        cbCategory.addItem("Pilih Kategori");
        for (Category category : categories) {
            cbCategory.addItem(category.getName());
        }
    }
    private void reset(){
        txtId.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        jsOpen.setValue(0);
        jsClose.setValue(0);
        rbOpen.setSelected(false);
        rbClose.setSelected(false);
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Time open = Time.valueOf(""+jsOpen.getValue()+":00:00");
        Time close = Time.valueOf(""+jsClose.getValue()+":00:00");
        String categoryName = (String) cbCategory.getSelectedItem();
        Category category = categoryController.findCategoryByName(categoryName);
        boolean status = true;

        if (rbOpen.isSelected()){
            status = true;
        } else  if (rbClose.isSelected()){
            status = false;
        }

        Venue venue = new Venue();
        venue.setId(txtId.getText());
        venue.setName(txtName.getText());
        venue.setDescription(txtDescription.getText());
        venue.setPrice(Long.parseLong(txtPrice.getText()));
        venue.setOpen(open);
        venue.setClose(close);
        venue.setCategory(category.getId());
        venue.setActive(status);
        controller.createVenue(venue);
        JOptionPane.showMessageDialog(this, "Berhasil menambah lapangan");
        reset();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER) {
            txtDescription.requestFocus();
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jsOpen.requestFocus();
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void jsOpenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsOpenKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jsClose.requestFocus();
        }
    }//GEN-LAST:event_jsOpenKeyPressed

    private void jsCloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsCloseKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPrice.requestFocus();
        }
    }//GEN-LAST:event_jsCloseKeyPressed

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbCategory.requestFocus();
        }
    }//GEN-LAST:event_txtPriceKeyPressed

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
            java.util.logging.Logger.getLogger(CreateVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateVenue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgStatus;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCategory;
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
    private javax.swing.JSpinner jsClose;
    private javax.swing.JSpinner jsOpen;
    private javax.swing.JRadioButton rbClose;
    private javax.swing.JRadioButton rbOpen;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
