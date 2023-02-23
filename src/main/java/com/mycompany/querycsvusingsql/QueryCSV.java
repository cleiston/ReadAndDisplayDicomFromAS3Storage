/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.querycsvusingsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author almadb
 */
public class QueryCSV {
    private String pathToFile;
    private Connection conn;

    public QueryCSV(String pathToFile) {
        this.pathToFile = pathToFile;
        String url = "jdbc:relique:csv:" + pathToFile + "?" + "separator=," + "&" + "fileExtension=.csv";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Can't connect to database.\n" + e.getMessage());
            conn = null;
        }
    }
    
    public void close(){
        if(conn != null)
            try {
                conn.close();
        } catch (SQLException e) {
            System.err.println("Can't close connection.\n" + e.getMessage());
        }
    }
    
    private void mapPatient(ResultSet rs, Patient p) throws SQLException{
        while(rs.next()){
                p.setPatientID(rs.getString("PatientID"));
                p.setSex(rs.getString("Sex"));
                p.setAcquisitionYear(rs.getInt("AcquisitionYear"));
                p.setBirthYear(rs.getInt("BirthYear"));
                p.setAge(rs.getInt("Age"));
                p.setHeight(rs.getFloat("Height"));
                p.setWeight(rs.getFloat("Weight"));
                p.setSide(rs.getString("Side"));
                p.setFractureStatus(rs.getBoolean("FractureStatus"));
                p.setCalibration_a(rs.getDouble("Calibration_a"));
                p.setCalibration_num(rs.getDouble("Calibration_num"));
                p.setArfo(rs.getDouble("ARF0"));
                p.setMsf(rs.getDouble("MSF"));
                p.setFailureAngle(rs.getString("FailureAngle"));
            }
    }
    
    public List<Patient> findAll(){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData ORDER BY Height");
            Patient p = new Patient();
            mapPatient(rs, p);
            patients.add(p);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
}
