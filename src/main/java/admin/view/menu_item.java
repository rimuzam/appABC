package admin.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author Rimuza
 */
public class menu_item extends javax.swing.JPanel {

    /**
    * @return the submenu
    */

    public ArrayList<menu_item> getsubmenu() {
        return submenu;
    }


    private final ArrayList<menu_item> submenu = new ArrayList<>();

    private ActionListener act;

    public menu_item(Icon icon, boolean sbm, Icon iconSub, String menuname, ActionListener act, menu_item...submenu) {
        initComponents();

        lb_icon.setIcon(icon);
        lb_menuname.setText(menuname);
        lb_iconsub.setIcon(iconSub);
        lb_iconsub.setVisible(sbm);

        if (act !=null) {
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (int i = 0; i < submenu.length; i++) {
            this.submenu.add(submenu[i]);
            submenu[i].setVisible(false);
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

        lb_iconsub = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();
        lb_menuname = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(lb_iconsub, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_menuname, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_iconsub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_menuname, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (showing) {
            hidemenu();
        } else {
            showmenu();
        }
        if (act != null) {
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_iconsub;
    private javax.swing.JLabel lb_menuname;
    // End of variables declaration//GEN-END:variables

    private void hidemenu() {
      new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = submenu.size() - 1; i >= 0; i--)   {
                  sleep();
                  submenu.get(i).setVisible(false);
                  submenu.get(i).hidemenu();
              }
              getParent().repaint();
              getParent().revalidate();
              showing = false;
          }
      }).start();
    }

    private void showmenu() {
      new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i < submenu.size(); i++)   {
                  sleep();
                  submenu.get(i).setVisible(true);
              }
              showing = true;
              getParent().repaint();
              getParent().revalidate();
          }
      }).start();
    }

    private void sleep()    {
        try {
            Thread.sleep(20);
        } catch (Exception e)   {
        }
    }
}