package com.blood.user.service.blooduserservice.Entity;

public class EyeRequestClass {

    private String eyeOrganizationEmail;
    private String patientName;
    private String patientNumber;
    private String patientAddress;
    private String patientGender;
    private int patientAge;
    private String patientBloodType;

    public EyeRequestClass() {
    }

    public EyeRequestClass(String eyeOrganizationEmail, String patientName, String patientNumber, String patientAddress, String patientGender, int patientAge, String patientBloodType) {
        this.eyeOrganizationEmail = eyeOrganizationEmail;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.patientAddress = patientAddress;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientBloodType = patientBloodType;
    }

    public String getEyeOrganizationEmail() {
        return eyeOrganizationEmail;
    }

    public void setEyeOrganizationEmail(String eyeOrganizationEmail) {
        this.eyeOrganizationEmail = eyeOrganizationEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientBloodType() {
        return patientBloodType;
    }

    public void setPatientBloodType(String patientBloodType) {
        this.patientBloodType = patientBloodType;
    }
}
