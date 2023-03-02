/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.querycsvusingsql;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author almadb
 */
public class SelectCsvFromDatalake extends javax.swing.JFrame {

    /**
     * Creates new form SelectCsvFromDatalake
     */
    public SelectCsvFromDatalake() {
        initComponents();
        labelInfo.setText("Datalake info not provided");
    }
    
    public void setDatalake(Datalake datalake){
        this.datalake = datalake;
        csvFiles = datalake.getCsvFromDatalake();
        System.out.println("\n\n\nnumber of itens on datalake: " + csvFiles.size());
        selectedFiles = new boolean[csvFiles.size()];
        labelInfo.setText(datalake.toString());
        fillTable(csvFiles, "Files on Datalake", tableDatalake, false);
    }
    
    private Datalake datalake;
    private List<String> csvFiles;
    private boolean selectedFiles[];
    private List<String> selectedFilesList;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatalake = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProject = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buttonRemoveItem = new javax.swing.JButton();
        buttonAddItem1 = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableDatalake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDatalake);

        jLabel1.setText("Datalake info:");

        jLabel2.setText("Csv files in the Datalake ");

        tableProject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableProject);

        jLabel3.setText("Csv files in the project");

        buttonRemoveItem.setText("<<");
        buttonRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveItemActionPerformed(evt);
            }
        });

        buttonAddItem1.setText(">>");
        buttonAddItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddItem1ActionPerformed(evt);
            }
        });

        buttonOk.setText("Ok");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(labelInfo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonAddItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonAddItem1)
                        .addGap(37, 37, 37)
                        .addComponent(buttonRemoveItem)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(buttonOk)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddItem1ActionPerformed
        boolean isRowSelected = !tableDatalake.getSelectionModel().isSelectionEmpty();
        if(isRowSelected){
            // get first column value from selected row
            int selectedRow = tableDatalake.getSelectedRow();
            selectedFiles[selectedRow] = !selectedFiles[selectedRow];
            fillTable(csvFiles, "Files on Datalake", tableDatalake, false);
            fillTable(csvFiles, "Files on Datalake", tableProject, true);
        }
    }//GEN-LAST:event_buttonAddItem1ActionPerformed

    private void buttonRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveItemActionPerformed
        boolean isRowSelected = !tableProject.getSelectionModel().isSelectionEmpty();
        if(isRowSelected){
            // get first column value from selected row
            int selectedRow = tableProject.getSelectedRow();
            selectedFiles[selectedRow] = !selectedFiles[selectedRow];
            fillTable(csvFiles, "Files on Datalake", tableDatalake, false);
            fillTable(csvFiles, "Files on Datalake", tableProject, true);
        }
    }//GEN-LAST:event_buttonRemoveItemActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        if(tableProject.getRowCount() < 1){
            JOptionPane.showMessageDialog(null, "Select at least one CSV file!", "Error at selecting CSV file", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        getSelectedFiles();
        this.setVisible(false);
        InputStream is = datalake.getObject("patientcsv", getSelectedFilesList().get(0));
        File outputFile = new File("/tmp/temp.csv");
        try {
            FileUtils.copyInputStreamToFile(is, outputFile);
        }
        catch(Exception e){
            System.err.println("Cannot save csv file. " + e.getMessage());
        }
    }//GEN-LAST:event_buttonOkActionPerformed

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
            java.util.logging.Logger.getLogger(SelectCsvFromDatalake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectCsvFromDatalake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectCsvFromDatalake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectCsvFromDatalake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectCsvFromDatalake().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddItem1;
    private javax.swing.JButton buttonOk;
    private javax.swing.JButton buttonRemoveItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JTable tableDatalake;
    private javax.swing.JTable tableProject;
    // End of variables declaration//GEN-END:variables

    public void fillTable(List<String> items, String columnTitle, JTable targetTable, boolean selected){
        String col[] = {columnTitle};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
        if(items == null) return;
        
        for(int i = 0; i < csvFiles.size(); i++){
            if(selectedFiles[i] == selected){ // only adds to the table the selected csv files
                Object[] obj = { csvFiles.get(i) };
                tableModel.addRow(obj);
            }
        }
        
        targetTable.setModel(tableModel);
        targetTable.setAutoCreateRowSorter(true);
    }
    
    private void getSelectedFiles(){
        selectedFilesList = new ArrayList<>();
        for(int i = 0; i < csvFiles.size(); i++){
            if(selectedFiles[i]){
                selectedFilesList.add(csvFiles.get(i));
            }
        }
    }
    
    public List<String> getSelectedFilesList(){
        return selectedFilesList;
    }
}