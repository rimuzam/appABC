/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.personalia;

import org.example.controllers.AbsentController;
import org.example.dependencyInjection.AbsentControllerFactory;
import org.example.models.Absent;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fadhl
 */
public class AbsentFormView extends javax.swing.JFrame {

    private AbsentControllerFactory factory = new AbsentControllerFactory();
    private AbsentController controller = factory.controller();
    public AbsentFormView() {
        initComponents();
        fillComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEmployees = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbInformation = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Absen Karyawan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Input Absen Karyawan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setText("Nama Karyawan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 64, -1, -1));
        getContentPane().add(cbEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 61, 160, -1));

        jLabel3.setText("Tanggal ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 101, -1, -1));
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 101, 160, -1));

        jLabel4.setText("Keterangan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 141, -1, -1));

        cbInformation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Keterangan", "Alpa", "Sakit", "Cuti", "Izin" }));
        getContentPane().add(cbInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 141, 160, -1));

        btnSave.setBackground(new java.awt.Color(0, 153, 51));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 181, 160, -1));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 216, 160, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test1.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fillComboBox(){
        List<String> employees = controller.getIdNameEmployees();
        cbEmployees.addItem("Pilih Karyawan");
        for (String employee : employees) {
            cbEmployees.addItem(employee);
        }
    }
    private void saveData(){
        if (cbEmployees.getSelectedItem().equals("Pilih Karyawan") || cbInformation.getSelectedItem().equals("Pilih Keterangan")
        || txtDate.getDate() == null){
            JOptionPane.showMessageDialog(null, "Input tidak boleh kosong !", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String employee = (String) cbEmployees.getSelectedItem();
        String[] split = employee.split("-");
        String employeeId = split[0];
        Date date = txtDate.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateString = dateFormat.format(date);
        String information = (String) cbInformation.getSelectedItem();
        Absent absent = new Absent();
        absent.setDate(birthDateString);
        absent.setEmployeeId(employeeId);
        absent.setInformation(information);
        controller.createAbsent(absent);
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
    }
    private void clear(){
        txtDate.setDate(null);
        cbEmployees.setSelectedItem("Pilih Karyawan");
        cbInformation.setSelectedItem("Pilih Keterangan");
    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveData();
        clear();
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(AbsentFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbsentFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbsentFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbsentFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbsentFormView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbEmployees;
    private javax.swing.JComboBox<String> cbInformation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables
}
