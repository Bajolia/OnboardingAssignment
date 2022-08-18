package com.example.assignment.model;

import com.example.assignment.repos.ProfileRepo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWRequest")
public class Profile {
    private String id;
    private String vertical;
    private String make;
    private String model;
    private String requestId;

    public Profile(){

    }

    public Profile(String id, String vertical, String make, String model, String requestId) {
        this.id = id;
        this.vertical = vertical;
        this.make = make;
        this.model = model;
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
