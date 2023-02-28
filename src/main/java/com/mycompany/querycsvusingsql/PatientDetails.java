/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.querycsvusingsql;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;
import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;
import org.dcm4che3.tool.dcm2jpg.ImageView;

/**
 *
 * @author almadb
 */
public class PatientDetails extends javax.swing.JFrame {

    /**
     * Creates new form PatientDetails
     */
    public PatientDetails() {
        initComponents();
        datalake = null;
        imageIcon = null;
    }
    
    public PatientDetails(Datalake datalake) {
        this();
        this.datalake = datalake;
    }
    
    private Datalake datalake;
    private ImageIcon imageIcon;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldPatientID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListImages = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labelPreview = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PatientID");

        textFieldPatientID.setEnabled(false);

        tableListImages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableListImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListImagesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListImages);

        jLabel2.setText("Acquisition Date");

        jButton1.setText("Preview Image Selected");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(labelPreview)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPreview, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableListImagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListImagesMouseClicked
        //labelPreview.setIcon(new ImageIcon("preview.jpg"));
        
    }//GEN-LAST:event_tableListImagesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isRowSelected = !tableListImages.getSelectionModel().isSelectionEmpty();
        if(isRowSelected && datalake != null){ // only works if there is a row selected and there's an instance of the datalake
            String imageSelected = tableListImages.getValueAt(tableListImages.getSelectedRow(), 0).toString();
            System.out.println(imageSelected);
            InputStream imageFromDatalake = datalake.getObject("patientimages", imageSelected);
            File outputFile = new File("temp.dcm");
            try {
                FileUtils.copyInputStreamToFile(imageFromDatalake, outputFile);
                Dcm2Jpg.convertDcm2Jpg("temp.dcm","preview.jpg");
                ImageView imageView = new ImageView();
                imageView.setTitle(imageSelected);
                if(imageIcon != null) imageIcon.getImage().flush();
                imageIcon = new ImageIcon("preview.jpg");
                imageView.setContentPane(new JLabel(imageIcon));
                imageView.setVisible(true);
                imageView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            catch(Exception e){
                System.err.println("Cannot preview image. " + e.getMessage());
            }
            
        }
        else {
            JOptionPane.showMessageDialog(null, "No image selected", "Error at selecting image", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPreview;
    private javax.swing.JTable tableListImages;
    private javax.swing.JTextField textFieldPatientID;
    // End of variables declaration//GEN-END:variables

    public void fillTable(String patientId, List<String> imagesList){
        textFieldPatientID.setText(patientId);
        String col[] = {"Images of patient " + patientId};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
        for(String imageName: imagesList){
            Object[] obj = {
                imageName
            };
            tableModel.addRow(obj);
        }
        
        tableListImages.setModel(tableModel);
        tableListImages.setAutoCreateRowSorter(true);
    }
}
