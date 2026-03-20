package com.foodie.app.service;

import java.util.List;

import com.foodie.app.exceptions.RestaurantNotFoundException;
import com.foodie.app.model.Restaurant;

public interface RestaurantService {
    public List<Restaurant> getRestaurantList();
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;
}
