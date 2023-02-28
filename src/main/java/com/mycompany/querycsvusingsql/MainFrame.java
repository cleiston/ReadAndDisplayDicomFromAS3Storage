/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.querycsvusingsql;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author almadb
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        filtersString = "";
        ff = new FiltersFrame(this);
        datalake = null;
    }
    
    private String filtersString;
    private FiltersFrame ff;
    private Datalake datalake;

    public void setFiltersString(String filtersString) {
        this.filtersString = filtersString;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePatients = new javax.swing.JTable();
        labelFiltersSet = new javax.swing.JLabel();
        jButtonPatientDetails = new javax.swing.JButton();
        labelConnectedDatalake = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuLoadCsv = new javax.swing.JMenuItem();
        menuAddFilters = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuRemoveFilters = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePatients);

        jButtonPatientDetails.setText("View patient details");
        jButtonPatientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatientDetailsActionPerformed(evt);
            }
        });

        jMenu3.setText("File");

        menuLoadCsv.setText("Load CSV file into table");
        menuLoadCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadCsvActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadCsv);

        menuAddFilters.setText("Add filters");
        menuAddFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddFiltersActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddFilters);

        jMenuItem1.setText("Connect datalake");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        menuRemoveFilters.setText("Remove filters");
        menuRemoveFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveFiltersActionPerformed(evt);
            }
        });
        jMenu3.add(menuRemoveFilters);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFiltersSet)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelConnectedDatalake)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPatientDetails))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelFiltersSet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPatientDetails)
                    .addComponent(labelConnectedDatalake))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void fillTable(){
        String col[] = {"Patient ID","Sex","Birth Year", "Height", "Weight", "Is Fractured"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
        QueryCSV qcsv = new QueryCSV("/home/almadb/Downloads/");
        List<Patient> patients;
        
        if(filtersString.length() > 0){
            patients = qcsv.findByQuery(filtersString);
        }
        else {
            patients = qcsv.findAll();
            System.out.println("tamano da string: " + filtersString);
        }
        
        if(patients == null) return;
        
        for(Patient patient: patients){
            Object[] obj = {
                patient.getPatientID(), 
                patient.getSex().equals("M") ? "Masculine" : "Feminine", 
                patient.getBirthYear(), 
                patient.getHeight(), 
                patient.getWeight(),
                patient.isFractureStatus() ? "Yes" : "No"
            };
            tableModel.addRow(obj);
        }
        
        tablePatients.setModel(tableModel);
        tablePatients.setAutoCreateRowSorter(true);
    }
    
    
    private void menuLoadCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadCsvActionPerformed
        fillTable();
    }//GEN-LAST:event_menuLoadCsvActionPerformed

    private void menuAddFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddFiltersActionPerformed
        ff.setVisible(true);
        ff.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        labelFiltersSet.setText("Filters might have been in place!");
    }//GEN-LAST:event_menuAddFiltersActionPerformed

    private void menuRemoveFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveFiltersActionPerformed
        filtersString = "";
        ff.dispose();
    }//GEN-LAST:event_menuRemoveFiltersActionPerformed

    private void jButtonPatientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatientDetailsActionPerformed
        boolean isRowSelected = !tablePatients.getSelectionModel().isSelectionEmpty();
        if(isRowSelected){
            // get first column value from selected row
            String patientSelected = tablePatients.getValueAt(tablePatients.getSelectedRow(), 0).toString();
            //JOptionPane.showMessageDialog(null, "You selected patient " + patientSelected, "Patient selected", JOptionPane.WARNING_MESSAGE);
            PatientDetails pd = new PatientDetails(datalake);
            
            List<String> imagesList = new ArrayList<>();
            if(datalake == null){
                imagesList.add("No images to show.");
            }
            else {
                imagesList = datalake.getPatientFromBucket("patientimages", patientSelected);
            }
            
            pd.fillTable(patientSelected, imagesList);
            pd.setVisible(true);
            pd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You must select one patient.", "Patient not selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPatientDetailsActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        datalake = new Datalake();
        if(datalake.bucketExists("patientimages"))
            labelConnectedDatalake.setText("Connected to datalake");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPatientDetails;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConnectedDatalake;
    private javax.swing.JLabel labelFiltersSet;
    private javax.swing.JMenuItem menuAddFilters;
    private javax.swing.JMenuItem menuLoadCsv;
    private javax.swing.JMenuItem menuRemoveFilters;
    private javax.swing.JTable tablePatients;
    // End of variables declaration//GEN-END:variables
}
