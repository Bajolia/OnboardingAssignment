package com.example.assignment.repos;

import com.example.assignment.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface ProfileRepo extends MongoRepository<Profile,String> {
    Profile findByRequestId(String requestId);

    void deleteByRequestId(String requestId);
}
