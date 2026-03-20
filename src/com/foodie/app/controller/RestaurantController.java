package com.foodie.app.controller;

import java.util.List;

import com.foodie.app.exceptions.RestaurantNotFoundException;
import com.foodie.app.model.Restaurant;
import com.foodie.app.service.RestaurantServiceImpl;

public class RestaurantController {
    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        super();
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantsList() {
        return this.restaurantService.getRestaurantList();
    }

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return this.restaurantService.getRestaurantById(id);
    }
}
