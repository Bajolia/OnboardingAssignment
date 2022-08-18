package com.example.assignment.controllers;

import com.example.assignment.model.Input;
import com.example.assignment.model.Profile;
import com.example.assignment.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {

    @Autowired
    private InputService inputService;

    @RequestMapping(method = RequestMethod.POST, value = "api/input")
    public String addProfile(@RequestBody Input input){
        return inputService.add(input);
    }
}
