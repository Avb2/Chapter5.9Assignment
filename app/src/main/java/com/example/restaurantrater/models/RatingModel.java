package com.example.restaurantrater.models;

public class RatingModel {
    private String type;
    private String name;
    private int rating;

    public RatingModel(String type, String name, int rating) {
        this.type = type;
        this.name = name;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}
