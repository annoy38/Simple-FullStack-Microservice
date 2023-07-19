package com.blood.user.service.blooduserservice.Entity;

import java.util.List;

public class EyeOrganizationClass {

    private String eyeOrgId;
    private String eyeOrgName;
    private String eyeOrgEmail;
    private String eyeOrgDivision;
    private String eyeOrgDistric;
    private String eyeOrgUpazila;
//    private List<String> bloods;

    public EyeOrganizationClass() {
    }

    public EyeOrganizationClass(String eyeOrgId, String eyeOrgName, String eyeOrgEmail, String eyeOrgDivision, String eyeOrgDistric, String eyeOrgUpazila) {
        this.eyeOrgId = eyeOrgId;
        this.eyeOrgName = eyeOrgName;
        this.eyeOrgEmail = eyeOrgEmail;
        this.eyeOrgDivision = eyeOrgDivision;
        this.eyeOrgDistric = eyeOrgDistric;
        this.eyeOrgUpazila = eyeOrgUpazila;
//        this.bloods = bloods;
    }

    public String getEyeOrgId() {
        return eyeOrgId;
    }

    public void setEyeOrgId(String eyeOrgId) {
        this.eyeOrgId = eyeOrgId;
    }

    public String getEyeOrgName() {
        return eyeOrgName;
    }

    public void setEyeOrgName(String eyeOrgName) {
        this.eyeOrgName = eyeOrgName;
    }

    public String getEyeOrgEmail() {
        return eyeOrgEmail;
    }

    public void setEyeOrgEmail(String eyeOrgEmail) {
        this.eyeOrgEmail = eyeOrgEmail;
    }

    public String getEyeOrgDivision() {
        return eyeOrgDivision;
    }

    public void setEyeOrgDivision(String eyeOrgDivision) {
        this.eyeOrgDivision = eyeOrgDivision;
    }

    public String getEyeOrgDistric() {
        return eyeOrgDistric;
    }

    public void setEyeOrgDistric(String eyeOrgDistric) {
        this.eyeOrgDistric = eyeOrgDistric;
    }

    public String getEyeOrgUpazila() {
        return eyeOrgUpazila;
    }

    public void setEyeOrgUpazila(String eyeOrgUpazila) {
        this.eyeOrgUpazila = eyeOrgUpazila;
    }

//    public List<String> getBloods() {
//        return bloods;
//    }
//
//    public void setBloods(List<String> bloods) {
//        this.bloods = bloods;
//    }
}
