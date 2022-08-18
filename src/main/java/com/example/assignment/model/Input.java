package com.example.assignment.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "mycollection")
public class Input {
    private String id;
    private String vertical;
    private String make;
    private String model;
    private ArrayList<Insurer> supportedInsurer;

    public Input(String id, String vertical, String make, String model, ArrayList<Insurer> supportedInsurer) {
        this.id = id;
        this.vertical = vertical;
        this.make = make;
        this.model = model;
        this.supportedInsurer = supportedInsurer;
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

    public ArrayList<Insurer> getSupportedInsurer() {
        return supportedInsurer;
    }

    public void setSupportedInsurer(ArrayList<Insurer> supportedInsurer) {
        this.supportedInsurer = supportedInsurer;
    }


}
