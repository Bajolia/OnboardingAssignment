package com.example.assignment.controllers;

import com.example.assignment.model.Checkout;
import com.example.assignment.model.CheckoutResponce;
import com.example.assignment.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CheckoutResponce getAllDetails(@PathVariable String requestId){
        return checkoutService.getAllDetails(requestId);
    }
}
