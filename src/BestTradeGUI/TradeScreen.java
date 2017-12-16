/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BestTradeGUI;

import static BestTradeGUI.LoginPanel.*;
import static BestTradeGUI.UIManager.*;
import Database.Database;
import ModelClasses.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TradeScreen extends javax.swing.JPanel {

    
    Client client;
    ArrayList <Item> items;
    ArrayList <Message> messages;
    Database db;
    /**
     * Creates new form TradeScreen
     */
    public TradeScreen(Database db) {
        
        this.db=db;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        viewMyProfileButton = new javax.swing.JButton();
        searchForProductButton = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();

        backButton.setText("BACK");
        backButton.setPreferredSize(new java.awt.Dimension(80, 35));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        viewMyProfileButton.setText("View My Profile");
        viewMyProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMyProfileButtonMouseClicked(evt);
            }
        });

        searchForProductButton.setText("Search For Product");
        searchForProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchForProductButtonMouseClicked(evt);
            }
        });

        addItemButton.setText("Add Product to Sell");
        addItemButton.setActionCommand("");
        addItemButton.setMaximumSize(new java.awt.Dimension(161, 29));
        addItemButton.setMinimumSize(new java.awt.Dimension(161, 29));
        addItemButton.setPreferredSize(new java.awt.Dimension(161, 29));
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchForProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewMyProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 83, Short.MAX_VALUE)
                .addComponent(searchForProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewMyProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchForProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchForProductButtonMouseClicked
        // TODO add your handling code here:
        SearchItemScreen searchItemScreen = new SearchItemScreen(db);
        UIManager.frame.add(searchItemScreen);
        setVisible(false);
        searchItemScreen.setVisible(true);
    }//GEN-LAST:event_searchForProductButtonMouseClicked

    private void viewMyProfileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMyProfileButtonMouseClicked
        // TODO add your handling code here:
        MyProfilePanel myProfilePanel = new MyProfilePanel(db);
        UIManager.frame.add(myProfilePanel);
        
        setVisible(false);
        myProfilePanel.setVisible(true);
    }//GEN-LAST:event_viewMyProfileButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        LoginPanel loginPanel = new LoginPanel();
        UIManager.frame.add(loginPanel);
        setVisible(false);
        loginPanel.setVisible(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        AddItemScreen addItemScreen = new AddItemScreen(db);
        UIManager.frame.add(addItemScreen);
        setVisible(false);
        addItemScreen.setVisible(true);
    }//GEN-LAST:event_addItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    public javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton searchForProductButton;
    public javax.swing.JButton viewMyProfileButton;
    // End of variables declaration//GEN-END:variables
}
