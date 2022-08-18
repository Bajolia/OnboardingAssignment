package com.example.assignment.services;

import com.example.assignment.model.*;
import com.example.assignment.repos.CheckoutRepo;
import com.example.assignment.repos.InputRepo;
import com.example.assignment.repos.ProfileRepo;
import com.example.assignment.repos.QuatationRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class CheckoutService {
    private CheckoutRepo checkoutRepo;
    private ProfileRepo profileRepo;
    private InputRepo inputRepo;
    private QuatationRepo quatationRepo;

    private CheckoutResponce checkoutResponce;
//    private  ProfileService profileService;

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


    public Map<String,String> getAllDetails(String requestId) {

//        Profile profile = profileService.getProfile(requestId);



        Map<String,String> allCustomerDetails= new HashMap<>();
        if(requestId == null){
            allCustomerDetails.put("Error : ", "RequestId is Null");
        }

        Profile profile = profileRepo.findByRequestId(requestId);
        String vertical = profile.getVertical();
        String make = profile.getMake();
        String model = profile.getModel();
        Checkout checkout = checkoutRepo.findByRequestId(profile.getRequestId());
        Quotation quotation = quatationRepo.findByResultId(checkout.getResultId());
//
//        Checkout checkout = checkoutRepo.findByRequestId(requestId);
        String checkoutName = checkout.getName();
        String checkoutEmail = checkout.getEmail();
        String checkoutPhone = checkout.getPhone();
        String resultId = checkout.getResultId();

        System.out.println(resultId);
        if(resultId == null){
            allCustomerDetails.put("Error : ", "ResultId is Null");
        }
//        Quotation quotation = quatationRepo.findByResultId(resultId);
        String insurerName = quotation.getInsurerName();
        String insurerPremium = quotation.getInsurerPremium();
//
        allCustomerDetails.put("vertical", vertical);
        allCustomerDetails.put("make", make);
        allCustomerDetails.put("model", model);
        allCustomerDetails.put("insurerName", insurerName);
        allCustomerDetails.put("insurerPremium", insurerPremium);
        allCustomerDetails.put("resultId", resultId);
        allCustomerDetails.put("checkoutName", checkoutName);
        allCustomerDetails.put("checkoutEmail", checkoutEmail);
        allCustomerDetails.put("checkoutPhone", checkoutPhone);
        return allCustomerDetails;
    }
}
