package com.admin.service.AdminService.entity;

import java.util.List;

public class BloodOrgModel {
        private String bloodOrganizationId;
        private String bloodOrganizationName;
        private String bloodOrganizationEmail;
        private String bloodOrganizationDivision;
        private String bloodOrganizationDistric;
        private String bloodOrganizationUpozila;
        private String bloods;

        public BloodOrgModel() {
        }

        public BloodOrgModel(String bloodOrganizationId, String bloodOrganizationName, String bloodOrganizationEmail, String bloodOrganizationDivision, String bloodOrganizationDistric, String bloodOrganizationUpozila, String bloods) {
            this.bloodOrganizationId = bloodOrganizationId;
            this.bloodOrganizationName = bloodOrganizationName;
            this.bloodOrganizationEmail = bloodOrganizationEmail;
            this.bloodOrganizationDivision = bloodOrganizationDivision;
            this.bloodOrganizationDistric = bloodOrganizationDistric;
            this.bloodOrganizationUpozila = bloodOrganizationUpozila;
            this.bloods = bloods;
        }

        public String getBloodOrganizationId() {
            return bloodOrganizationId;
        }

        public void setBloodOrganizationId(String bloodOrganizationId) {
            this.bloodOrganizationId = bloodOrganizationId;
        }

        public String getBloodOrganizationName() {
            return bloodOrganizationName;
        }

        public void setBloodOrganizationName(String bloodOrganizationName) {
            this.bloodOrganizationName = bloodOrganizationName;
        }

        public String getBloodOrganizationEmail() {
            return bloodOrganizationEmail;
        }

        public void setBloodOrganizationEmail(String bloodOrganizationEmail) {
            this.bloodOrganizationEmail = bloodOrganizationEmail;
        }

        public String getBloodOrganizationDivision() {
            return bloodOrganizationDivision;
        }

        public void setBloodOrganizationDivision(String bloodOrganizationDivision) {
            this.bloodOrganizationDivision = bloodOrganizationDivision;
        }

        public String getBloodOrganizationDistric() {
            return bloodOrganizationDistric;
        }

        public void setBloodOrganizationDistric(String bloodOrganizationDistric) {
            this.bloodOrganizationDistric = bloodOrganizationDistric;
        }

        public String getBloodOrganizationUpozila() {
            return bloodOrganizationUpozila;
        }

        public void setBloodOrganizationUpozila(String bloodOrganizationUpozila) {
            this.bloodOrganizationUpozila = bloodOrganizationUpozila;
        }

        public String getBloods() {
            return bloods;
        }

        public void setBloods(String bloods) {
            this.bloods = bloods;
        }
    }

