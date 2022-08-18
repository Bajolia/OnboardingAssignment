package com.example.assignment.controllers;

import com.example.assignment.model.Checkout;
import com.example.assignment.model.CheckoutResponce;
import com.example.assignment.model.Profile;
import com.example.assignment.repos.CheckoutRepo;
import com.example.assignment.services.CheckoutService;
import com.example.assignment.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @RequestMapping(method = RequestMethod.POST, value = "api/addCustomer")
    public String addCustomer(@RequestBody Checkout checkout){
        return checkoutService.add(checkout);
    }

    @RequestMapping("api/getAllCheckouts")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

    @RequestMapping("api/getCheckout/{requestId}")
    public Checkout getCheckout(@PathVariable String requestId){
        return checkoutService.getCheckout(requestId);
    }

    @RequestMapping("api/getAllDetails/{requestId}")
    public Map<String,String> getAllDetails(@PathVariable String requestId){
        return checkoutService.getAllDetails(requestId);
    }
}
