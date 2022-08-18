package com.example.assignment.controllers;

import com.example.assignment.model.Input;
import com.example.assignment.model.Profile;
import com.example.assignment.model.Quotation;
import com.example.assignment.services.QuatationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class QuatationController {

    @Autowired
    private QuatationService quatationService;

    @RequestMapping("/premiums/{requestId}")
    public List<Input> getAllPremiums(@PathVariable String requestId){
        return quatationService.getAllPremiums(requestId);
    }

//    @RequestMapping("/allPremiums/{requestId}")
//    public List<Quotation> getPremiums(@PathVariable String requestId){
//        return quatationService.getPremiums(requestId);
//    }
    @RequestMapping("/allPremiums/{profile}")
    public List<Quotation> getPremiums(@PathVariable Profile profile){
        return quatationService.getPremiums(profile);
    }
}
