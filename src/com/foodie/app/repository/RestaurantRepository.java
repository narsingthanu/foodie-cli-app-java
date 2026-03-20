package com.foodie.app.repository;

import java.util.List;
import java.util.Optional;

import com.foodie.app.model.Restaurant;
import com.foodie.app.util.Factory;

public class RestaurantRepository {
    List<Restaurant> restaurantList;

    public RestaurantRepository() {
        this.restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getRestaurantList() {
        return this.restaurantList;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurantById(String id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }
}
