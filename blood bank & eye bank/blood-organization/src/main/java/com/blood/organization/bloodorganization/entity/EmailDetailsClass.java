package com.blood.organization.bloodorganization.entity;

public class EmailDetailsClass {
    private String fromMail = "saleh35-2938@diu.edu.bd";
    private String toMail;

    public EmailDetailsClass() {
    }

    public EmailDetailsClass(String toMail) {
        this.toMail = toMail;
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail){
        this.fromMail = fromMail;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }
}
