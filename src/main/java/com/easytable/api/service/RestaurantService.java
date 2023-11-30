package com.easytable.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytable.api.model.Restaurant;
import com.easytable.api.repository.RestaurantRepository;

public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Optional<Restaurant> getRestaurant(final Long id) {
		return restaurantRepository.findById(id);
	}
	
	public Iterable<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}
	
	public void deleteRestaurant(final Long id) {
		restaurantRepository.deleteById(id);
	}
	
	public Restaurant saveEmployee(Restaurant restaurant) {
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);
		return savedRestaurant;
	}	
}
