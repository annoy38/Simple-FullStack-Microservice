package com.blood.user.service.blooduserservice.Entity;

public class BloodRequestClass {
    private String bloodOrganizationEmail;
    private String patientName;
    private String patientNumber;
    private String patientAddress;
    private String requestBloodType;

    public BloodRequestClass() {
    }

    public BloodRequestClass(String bloodOrganizationEmail, String patientName, String patientNumber, String patientAddress, String requestBloodType) {
        this.bloodOrganizationEmail = bloodOrganizationEmail;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.patientAddress = patientAddress;
        this.requestBloodType = requestBloodType;
    }

    public String getBloodOrganizationEmail() {
        return bloodOrganizationEmail;
    }

    public void setBloodOrganizationEmail(String bloodOrganizationEmail) {
        this.bloodOrganizationEmail = bloodOrganizationEmail;
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

    public String getRequestBloodType() {
        return requestBloodType;
    }

    public void setRequestBloodType(String requestBloodType) {
        this.requestBloodType = requestBloodType;
    }
}
