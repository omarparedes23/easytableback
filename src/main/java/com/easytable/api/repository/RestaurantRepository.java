package com.easytable.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.easytable.api.model.Restaurant;

public interface RestaurantRepository  extends CrudRepository<Restaurant, Long> {

}
