package com.eye.organization.eyeorganization.entity;

import javax.persistence.*;

@Entity
@Table(name = "delivery_requestTB")
public class DeliveryRequestClass {
    @Id
    private String deliverId;
    @Column(name = "organization_id")
    private String organizationId;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "organization_number")
    private String organizationNumber;
    @Column(name = "organization_location")
    private String organizationLocation;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_number")
    private String patientNumber;
    @Column(name = "hospital_name")
    private String hospitalName;
    @Column(name = "delivery_item")
    private String deliverItem;

    @Column(name = "delivery_status")
    private String status;
    public DeliveryRequestClass() {
    }

    public DeliveryRequestClass(String deliverId, String organizationId,  String organizationName, String organizationNumber, String organizationLocation, String patientName, String patientNumber, String hospitalName, String deliverItem, String status) {
        this.deliverId = deliverId;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.organizationNumber = organizationNumber;
        this.organizationLocation = organizationLocation;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.hospitalName = hospitalName;
        this.deliverItem = deliverItem;
        this.status = status;
    }

    public String getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(String deliverId) {
        this.deliverId = deliverId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getOrganizationLocation() {
        return organizationLocation;
    }

    public void setOrganizationLocation(String organizationLocation) {
        this.organizationLocation = organizationLocation;
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

    public String getDeliverItem() {
        return deliverItem;
    }

    public void setDeliverItem(String deliverItem) {
        this.deliverItem = deliverItem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
