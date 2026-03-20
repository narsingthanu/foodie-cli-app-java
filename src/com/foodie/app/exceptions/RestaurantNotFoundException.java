package com.foodie.app.exceptions;

public class RestaurantNotFoundException extends Exception {

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
