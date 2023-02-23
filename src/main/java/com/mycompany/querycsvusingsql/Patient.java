/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.querycsvusingsql;

/**
 *
 * @author almadb
 */
public class Patient {
    private String patientID;
    private String sex;
    private int acquisitionYear;
    private int birthYear;
    private int age;
    private int height;
    private int weight;
    private String side;
    private boolean fractureStatus;
    private double calibration_a;
    private double calibration_num;
    private double arfo;
    private double msf;
    private String failureAngle;

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAcquisitionYear() {
        return acquisitionYear;
    }

    public void setAcquisitionYear(int acquisitionYear) {
        this.acquisitionYear = acquisitionYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public boolean isFractureStatus() {
        return fractureStatus;
    }

    public void setFractureStatus(boolean fractureStatus) {
        this.fractureStatus = fractureStatus;
    }

    public double getCalibration_a() {
        return calibration_a;
    }

    public void setCalibration_a(double calibration_a) {
        this.calibration_a = calibration_a;
    }

    public double getCalibration_num() {
        return calibration_num;
    }

    public void setCalibration_num(double calibration_num) {
        this.calibration_num = calibration_num;
    }

    public double getArfo() {
        return arfo;
    }

    public void setArfo(double arfo) {
        this.arfo = arfo;
    }

    public double getMsf() {
        return msf;
    }

    public void setMsf(double msf) {
        this.msf = msf;
    }

    public String getFailureAngle() {
        return failureAngle;
    }

    public void setFailureAngle(String failureAngle) {
        this.failureAngle = failureAngle;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
