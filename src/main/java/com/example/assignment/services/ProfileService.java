package com.example.assignment.services;

import com.example.assignment.model.Profile;
import com.example.assignment.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private QuatationService quatationService;
    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public String add(Profile profile) {
        Random temp = new Random();
        String requestId = String.valueOf(Math.abs(temp.nextLong()));
        System.out.println(requestId);
        profile.setRequestId(requestId);
        profileRepo.save(profile);
//        quatationService.getPremiums(requestId);
        quatationService.getPremiums(profile);
        return requestId;
    }

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }


    public Profile getProfile(String requestId) {
        return profileRepo.findById(requestId).get();
    }

    public String updateProfile(Profile profile, String requestId) {
        Profile profile1 = profileRepo.findByRequestId(requestId);
        profile1.setMake(profile.getMake());
        profile1.setModel(profile.getModel());
        profile1.setVertical(profile.getVertical());
        profileRepo.save(profile1);
        return "Profile Updated Successfully";
    }

    public String deleteProfile(String requestId) {
        profileRepo.deleteByRequestId(requestId);
        return "Profile Deleted!";
    }
}
