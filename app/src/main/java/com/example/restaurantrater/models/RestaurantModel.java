package com.example.restaurantrater.models;

public class RestaurantModel {
    private String name;
    private String address;
    private String city;
    private String state;
    private int zipcode;


    public RestaurantModel(String name, String address, String city, String state, int zipcode){
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
