package com.example.assignment.model;

public class CheckoutResponce {

    private  Profile profile;
    private  Insurer insurer;
    private  Checkout checkout;

    public CheckoutResponce(Profile profile, Insurer insurer, Checkout checkout) {
        this.profile = profile;
        this.insurer = insurer;
        this.checkout = checkout;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }
}
