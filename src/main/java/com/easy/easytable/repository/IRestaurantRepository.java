package com.easy.easytable.repository;

import com.easy.easytable.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
}
