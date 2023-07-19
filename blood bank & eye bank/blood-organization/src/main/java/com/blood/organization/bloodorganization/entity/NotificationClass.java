package com.blood.organization.bloodorganization.entity;

public class NotificationClass {
    private int requestId;
    private String patientName;
    private String patientNumber;
    private String hospitalName;
    private String requestedBloodType;

    public NotificationClass(int requestId, String patientName, String patientNumber, String hospitalName, String requestedBloodType) {
        this.requestId = requestId;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.hospitalName = hospitalName;
        this.requestedBloodType = requestedBloodType;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getRequestedBloodType() {
        return requestedBloodType;
    }

    public void setRequestedBloodType(String requestedBloodType) {
        this.requestedBloodType = requestedBloodType;
    }
}
