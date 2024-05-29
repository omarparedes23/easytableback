package com.easy.easytable.service;

import com.easy.easytable.entity.RestaurantEntity;
import com.easy.easytable.exception.EasyTableException;
import com.easy.easytable.repository.IRestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class RestaurantService implements IRestaurantService {

    @Autowired
    IRestaurantRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<RestaurantEntity> getRestaurants() {
        return repository.findAll();
    }

    @Override
    public RestaurantEntity getRestaurantById(int id) throws EasyTableException {
        Optional<RestaurantEntity> restaurant;
        try {
            restaurant = repository.findById(id);
        } catch (Exception e) {
            log.error("Restaurant  non trouvé", e);
            throw e;
        }
        if (restaurant.isEmpty()) {
            throw new EasyTableException("Restaurant  non trouvé");
        }
        return restaurant.get();
    }
}