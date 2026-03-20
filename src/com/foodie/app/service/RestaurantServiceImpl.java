package com.foodie.app.service;

import java.util.List;
import java.util.Optional;

import com.foodie.app.exceptions.RestaurantNotFoundException;
import com.foodie.app.model.Restaurant;
import com.foodie.app.repository.RestaurantRepository;

public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        super();
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if (!restaurantById.isPresent()) {
            throw new RestaurantNotFoundException("Restaurant not found with id: " + id);
        }
        return restaurantById.get();
    }
}
