package com.example.assignment.services;

import com.example.assignment.model.*;
import com.example.assignment.repos.CheckoutRepo;
import com.example.assignment.repos.InputRepo;
import com.example.assignment.repos.ProfileRepo;
import com.example.assignment.repos.QuatationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Random;

@Service
public class CheckoutService {
    private CheckoutRepo checkoutRepo;
    private ProfileRepo profileRepo;
    private InputRepo inputRepo;
    private QuatationRepo quatationRepo;

    public CheckoutService(CheckoutRepo checkoutRepo, ProfileRepo profileRepo, InputRepo inputRepo, QuatationRepo quatationRepo) {
        this.checkoutRepo = checkoutRepo;
        this.profileRepo = profileRepo;
        this.inputRepo = inputRepo;
        this.quatationRepo = quatationRepo;
    }

    public String add(Checkout checkout) {
        Random temp = new Random();
        String checkoutId = String.valueOf(Math.abs(temp.nextLong()));
        System.out.println(checkoutId);
        checkout.setCheckoutId(checkoutId);
        checkoutRepo.save(checkout);
        return checkoutId;
    }

    public List<Checkout> getAllCheckouts() {
        return checkoutRepo.findAll();
    }

    public Checkout getCheckout(String requestId) {
        return checkoutRepo.findByRequestId(requestId);
    }

    public CheckoutResponce getAllDetails(String requestId) {
        Profile profile = profileRepo.findByRequestId(requestId);
        Checkout checkout = checkoutRepo.findByRequestId(profile.getRequestId());
        Quotation quotation = quatationRepo.findByResultId(checkout.getResultId());
        String insurerName = quotation.getInsurerName();
        String insurerPremium = quotation.getInsurerPremium();
        Insurer insurer = new Insurer(requestId,insurerName,insurerPremium);

        CheckoutResponce checkoutResponce = new CheckoutResponce(profile,insurer,checkout);
        return checkoutResponce;
    }
}
