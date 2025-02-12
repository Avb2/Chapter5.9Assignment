package com.example.restaurantrater.models;

public class RatingModel {
    private String type;
    private String name;
    private double rating;

    public RatingModel(String type, String name, double rating) {
        this.type = type;
        this.name = name;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}
