/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BestTradeGUI;

import static BestTradeGUI.UIManager.*;
import static BestTradeGUI.UIManager.frame;
import Database.Database;
import ModelClasses.Item;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ezgicakir
 */
public class EditItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form EditItem
     */
    private Database database;
    private ImageIcon photo;
    Item item;
    private static JFileChooser chooser; 													
    private int chooserStatus;
    String path;
    
    public EditItemPanel(Database db, int whichLabel, int countClick) {
        //this.item = loginPanel.item;
        database = db;
        initComponents();
        
        int labelNo=7;
        
        int lastpage = database.itemsList.size() / labelNo;
        if(countClick > lastpage)
            countClick = lastpage;
        if(countClick < 0)
            countClick = 0;
        int index = countClick*labelNo + whichLabel-1;
        
        item = database.itemsList.get(index);
        int condition =0;
        if(item.getCondition()== "Zero")
            condition =0;
        else{
            condition = 1;
        }
       int category =0;
        switch(item.getCategory()){
            case "Book":
                category =0;
                break;
            case "Notes":
                category =1;
                break;    
            case "Furniture":
                category =2;
                break;
            case "Others":
                category =3;
                break;
        }
        conditionCombo.setSelectedIndex(condition);
        titleTextField.setText(item.getTitle());
        descripTxt.setText(item.getDescription());
        categoryCombo.setSelectedIndex(category);
        priceTxt.setText((item.getPrice()+""));
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
        jLabel1 = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        conditionCombo = new javax.swing.JComboBox<>();
        descripTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        saveBut = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        jLabel1.setText("Category");

        categoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book", "Notes", "Furniture", "Others" }));
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        jLabel2.setText("Price");

        jLabel3.setText("Condition");

        jLabel4.setText("Description");

        priceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTxtActionPerformed(evt);
            }
        });

        conditionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zero", "Second Hand" }));
        conditionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conditionComboActionPerformed(evt);
            }
        });

        descripTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Upload Photo");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        saveBut.setText("Save");
        saveBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete ");
        deleteButton.setPreferredSize(new java.awt.Dimension(75, 29));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Title");

        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("TL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conditionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(categoryCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(80, 80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(conditionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGap(9, 9, 9))
        );

        backButton.setText("BACK");
        backButton.setPreferredSize(new java.awt.Dimension(85, 35));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboActionPerformed
        
    }//GEN-LAST:event_categoryComboActionPerformed

    private void priceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTxtActionPerformed
        // TODO add your handling code here:
        priceTxt.setText("");
    }//GEN-LAST:event_priceTxtActionPerformed

    private void conditionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conditionComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conditionComboActionPerformed

    private void descripTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripTxtActionPerformed
        // TODO add your handling code here:
        descripTxt.setText("");
    }//GEN-LAST:event_descripTxtActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
         File folder = new File("C:\\Users");
        chooser = new JFileChooser(folder);
	chooserStatus = chooser.showOpenDialog(null);
        
            File filename = chooser.getSelectedFile();
	    path = chooser.getSelectedFile().getAbsolutePath();
            System.out.println(path);
    }//GEN-LAST:event_okButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MyProductsPanel myProductsPanel = new MyProductsPanel(database);
        UIManager.frame.add(myProductsPanel);
        setVisible(false);
        myProductsPanel.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        database.deleteItem(item.getItemId());
        MyProductsPanel myProductsPanel = new MyProductsPanel(database);
        UIManager.frame.add(myProductsPanel);
        setVisible(false);
        myProductsPanel.setVisible(true);
                                      
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButActionPerformed
        // TODO add your handling code here:
        
        String category = categoryCombo.getSelectedItem().toString();
        String description;
        String price;
        String conditionStr = conditionCombo.getSelectedItem().toString();
        String titleName = titleTextField.getText();
        
       if(priceTxt.getText() != ""){
            price = priceTxt.getText();
        }
        else{
            price = item.getPrice()+"";
        }
       
        if(descripTxt.getText() != ""){
            description =descripTxt.getText();
        }
        else{
            description = item.getDescription();
        }
        
        if(titleTextField.getText() != ""){
            titleName = titleTextField.getText();
        }
        else{
            titleName =item.getTitle();
        }
        if(category==null)
            JOptionPane.showMessageDialog(null, "Category,have to be selected");
        if(conditionStr==null)
            JOptionPane.showMessageDialog(null, "Condition,have to be selected");
        if(titleName==null)
            JOptionPane.showMessageDialog(null, "Title,have to be selected");
        
        if(category!=null && conditionStr!=null &&titleName!=null){
          
            database.editItem(titleName, price, item.getItemId(), category, conditionStr, description, path);
        }
        try {
            database.refresh();
        } catch (IOException ex) {
            Logger.getLogger(EditItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        MyProductsPanel myProductsPanel = new MyProductsPanel(database);
        UIManager.frame.add(myProductsPanel);
        setVisible(false);
        myProductsPanel.setVisible(true);
                                         
    }//GEN-LAST:event_saveButActionPerformed

    private void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextFieldActionPerformed
        // TODO add your handling code here:
        titleTextField.setText("");
    }//GEN-LAST:event_titleTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    public javax.swing.JComboBox<String> categoryCombo;
    public javax.swing.JComboBox<String> conditionCombo;
    public javax.swing.JButton deleteButton;
    public javax.swing.JTextField descripTxt;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JButton okButton;
    public javax.swing.JTextField priceTxt;
    public javax.swing.JButton saveBut;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
