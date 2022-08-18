package com.example.assignment.repos;

import com.example.assignment.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuatationRepo extends MongoRepository<Quotation,String> {
    Quotation findByRequestId(String requestId);

    Quotation findByResultId(String resultId);
}
