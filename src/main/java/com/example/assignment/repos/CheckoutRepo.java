package com.example.assignment.repos;

import com.example.assignment.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface CheckoutRepo extends MongoRepository<Checkout,String> {
    Checkout findByRequestId(String requestId);
}
