package com.example.assignment.services;

import com.example.assignment.model.Input;
import com.example.assignment.model.Profile;
import com.example.assignment.repos.InputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InputService {
    @Autowired
    private InputRepo inputRepo;

    public InputService(InputRepo inputRepo) {
        this.inputRepo = inputRepo;
    }

    public String add(Input input) {
        inputRepo.save(input);
        return "added";
    }

}
