package com.example.assignment.repos;

import com.example.assignment.model.Input;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface InputRepo extends MongoRepository<Input,String> {
    ArrayList<Input> findAllByMakeAndModel(String make, String model);
}
