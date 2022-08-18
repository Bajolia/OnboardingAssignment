package com.example.assignment.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "checkout")
public class Checkout {

    private String checkoutId;
    private String name;
    private String email;
    private String phone;

    private String requestId;
    private String resultId;

    public Checkout(String checkoutId, String name, String email, String phone, String requestId, String resultId) {
        this.checkoutId = checkoutId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.requestId = requestId;
        this.resultId = resultId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
}
