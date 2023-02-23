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
    
    private void mapPatients(ResultSet rs, List<Patient> patients) throws SQLException{
        while(rs.next()){
                Patient p = new Patient();
                p.setPatientID(rs.getString("PatientID"));
                p.setSex(rs.getString("Sex"));
                p.setAcquisitionYear(rs.getInt("AcquisitionYear"));
                p.setBirthYear(rs.getInt("BirthYear"));
                p.setAge(rs.getInt("Age"));
                p.setHeight(rs.getInt("Height"));
                p.setWeight(rs.getInt("Weight"));
                p.setSide(rs.getString("Side"));
                p.setFractureStatus(rs.getBoolean("FractureStatus"));
                p.setCalibration_a(rs.getDouble("Calibration_a"));
                p.setCalibration_num(rs.getDouble("Calibration_num"));
                p.setArfo(rs.getDouble("ARF0"));
                p.setMsf(rs.getDouble("MSF"));
                p.setFailureAngle(rs.getString("FailureAngle"));
                
                patients.add(p);
            }
    }
    
    public List<Patient> findAll(){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByAge(int age){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Age='" + age + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByAge(int ageMin, int ageMax){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Age>='" + ageMin + "' AND Age<='" + ageMax + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByPatientID(String patientId){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE PatientID='" + patientId + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByHeight(int height){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Height='" + height + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByHeight(int minHeight, int maxHeight){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Height>='" + minHeight + "' AND Height<='" + maxHeight + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByWeight(int weight){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Weight='" + weight + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByBirthYear(int minBirthYear, int maxBirthYear){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE BirthYear>='" + minBirthYear + "' AND BirthYear<='" + maxBirthYear + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByBirthYear(int birthYear){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE BirthYear='" + birthYear + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    public List<Patient> findByWeight(int minWeight, int maxWeight){
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM SampleCohort_patData WHERE Weight>='" + minWeight + "' AND Weight<='" + maxWeight + "'");
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
    
    
    // user must inform the sql condition. Ex: "Wheight >= '100' AND height < '170'"
    public List<Patient> findByQuery(String subquery){
        if(subquery.length() <= 3){ // no column is less than 3 characters
            return null;
        }
        
        String query = "SELECT * FROM SampleCohort_patData WHERE " + subquery;
        Statement stmt;
        List<Patient> patients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            mapPatients(rs, patients);
            
        } catch (SQLException e) {
            System.err.println("Can't create statement. " + e.getMessage());
            patients = null;
        }    
        return patients;
    }
    
}
