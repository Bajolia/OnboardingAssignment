package com.example.assignment.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Result")
public class Quotation {
    private String requestId;
    private Profile profile;
    private String resultId;
    private  String insurerName;
    private String insurerPremium;

    public Quotation(String requestId, Profile profile, String resultId, String insurerName, String insurerPremium) {
        this.requestId = requestId;
        this.profile = profile;
        this.resultId = resultId;
        this.insurerName = insurerName;
        this.insurerPremium = insurerPremium;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(String insurerPremium) {
        this.insurerPremium = insurerPremium;
    }
}
