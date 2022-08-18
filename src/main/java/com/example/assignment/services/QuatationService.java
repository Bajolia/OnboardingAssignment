package com.example.assignment.services;

import com.example.assignment.model.Input;
import com.example.assignment.model.Insurer;
import com.example.assignment.model.Profile;
import com.example.assignment.model.Quotation;
import com.example.assignment.repos.InputRepo;
import com.example.assignment.repos.ProfileRepo;
import com.example.assignment.repos.QuatationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuatationService {

    @Autowired
    private QuatationRepo quatationRepo;
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private InputRepo inputRepo;

    @Autowired
    private ProfileService profileService;


//    public QuatationService(QuatationRepo quatationRepo, ProfileRepo profileRepo, InputRepo inputRepo) {
//        this.quatationRepo = quatationRepo;
//        this.profileRepo = profileRepo;
//        this.inputRepo = inputRepo;
//    }

    public List<Input> getAllPremiums(String requestId) {
        Profile profile = profileRepo.findByRequestId(requestId);
        String vertical = profile.getVertical();
        String make = profile.getMake();
        String model = profile.getModel();
        ArrayList<Input> allInputByMakeModel =  inputRepo.findAllByMakeAndModel(make,model);
        ArrayList<Insurer> allInsurers = new ArrayList<>();
        return allInputByMakeModel;
    }

    public List<Quotation> getPremiums(Profile profile ){
        List<Quotation> allPremiums = new ArrayList<>();
//        Profile profile = profileRepo.findByRequestId(requestId);
        String vertical = profile.getVertical();
        String make = profile.getMake();
        String model = profile.getModel();
        String requestId = profile.getRequestId();
        if(requestId == null){
            System.out.println("requestId is null");
            return allPremiums;
        }
        List<Input> allInputByMakeModel =  inputRepo.findAllByMakeAndModel(make,model);
        for(Input input : allInputByMakeModel){
            List<Insurer> insurers = input.getSupportedInsurer();
            for(Insurer insurer : insurers){
                Random temp1 = new Random();
                String resultId1= String.valueOf(Math.abs(temp1.nextLong()));
                System.out.println(resultId1);
                insurer.setId(resultId1);
                String insurerName = insurer.getName();
                String insurerPremuum = insurer.getValue();
                Quotation quotation1 = new Quotation(requestId, resultId1, insurerName, insurerPremuum);
                allPremiums.add(quotation1);
                quatationRepo.save(quotation1);
            }
        }
        return allPremiums;
    }
}
