/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.personalia;

import org.example.controllers.EmployeeController;
import org.example.dependencyInjection.EmployeeControllerFactory;
import org.example.models.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fadhl
 */
public class EditEmployeeData extends javax.swing.JFrame {
    private EmployeeControllerFactory factory = new EmployeeControllerFactory();
    private EmployeeController controller = factory.controller();

    public EditEmployeeData() {
        initComponents();
        txtEmployeeIdEdit.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenu1 = new javax.swing.JMenu();
        bgSex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNameEdit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddressEdit = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtDateOfBirthEdit = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtPhoneNumberEdit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPositionEdit = new javax.swing.JTextField();
        btnSaveEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmployeeIdEdit = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rbManEdit = new javax.swing.JRadioButton();
        rbWomenEdit = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Data Karyawan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 112, -1, -1));

        txtNameEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameEditKeyPressed(evt);
            }
        });
        getContentPane().add(txtNameEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 109, 153, -1));

        jLabel2.setText("Alamat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 169, -1, -1));

        txtAddressEdit.setColumns(20);
        txtAddressEdit.setRows(5);
        txtAddressEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressEditKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtAddressEdit);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 143, -1, 98));

        jLabel3.setText("Tanggal Lahir");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 247, -1, -1));
        getContentPane().add(txtDateOfBirthEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 247, 156, -1));

        jLabel4.setText("Nomor Hp");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 290, -1, -1));

        txtPhoneNumberEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneNumberEditKeyPressed(evt);
            }
        });
        getContentPane().add(txtPhoneNumberEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 287, 156, -1));

        jLabel5.setText("Jabatan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 330, -1, -1));

        txtPositionEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPositionEditKeyPressed(evt);
            }
        });
        getContentPane().add(txtPositionEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 327, 156, -1));

        btnSaveEdit.setBackground(new java.awt.Color(0, 102, 0));
        btnSaveEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEdit.setText("Simpan Perubahan");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 406, 156, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Perbarui Data Karyawan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel7.setText("Id Karyawan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 72, -1, -1));
        getContentPane().add(txtEmployeeIdEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 69, 153, -1));

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 435, 156, -1));

        jLabel8.setText("Jenis Kelamin");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 369, -1, -1));

        bgSex.add(rbManEdit);
        rbManEdit.setText("Laki-Laki");
        getContentPane().add(rbManEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 367, -1, -1));

        bgSex.add(rbWomenEdit);
        rbWomenEdit.setText("Perempuan");
        rbWomenEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWomenEditActionPerformed(evt);
            }
        });
        getContentPane().add(rbWomenEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 367, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test1.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        // TODO add your handling code here:
        txtEmployeeIdEdit.setEnabled(false);
        String id = txtEmployeeIdEdit.getText();
        String name = txtNameEdit.getText();
        String address = txtAddressEdit.getText();
        Date birthDate = txtDateOfBirthEdit.getDate();
        String phoneNumber = txtPhoneNumberEdit.getText();
        String position = txtPositionEdit.getText();
        String sex = "";
        if (rbManEdit.isSelected()){
            sex = "Laki-Laki";
        } else if (rbWomenEdit.isSelected()) {
            sex = "Perempuan";
        }
        // Konversi tanggal ke dalam string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateString = dateFormat.format(birthDate);

        Employee employee = new Employee(id, name, address, phoneNumber, position, birthDateString, sex);
        controller.updateEmployee(employee);
        JOptionPane.showMessageDialog(this, "Berhasil memperbarui data");
        this.dispose();
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void rbWomenEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWomenEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbWomenEditActionPerformed

    private void txtNameEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameEditKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameEditKeyPressed

    private void txtAddressEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressEditKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressEditKeyPressed

    private void txtPhoneNumberEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberEditKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberEditKeyPressed

    private void txtPositionEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPositionEditKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionEditKeyPressed

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
            java.util.logging.Logger.getLogger(EditEmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditEmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditEmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditEmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditEmployeeData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSex;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JRadioButton rbManEdit;
    protected javax.swing.JRadioButton rbWomenEdit;
    protected javax.swing.JTextArea txtAddressEdit;
    protected com.toedter.calendar.JDateChooser txtDateOfBirthEdit;
    protected javax.swing.JTextField txtEmployeeIdEdit;
    protected javax.swing.JTextField txtNameEdit;
    protected javax.swing.JTextField txtPhoneNumberEdit;
    protected javax.swing.JTextField txtPositionEdit;
    // End of variables declaration//GEN-END:variables
}
