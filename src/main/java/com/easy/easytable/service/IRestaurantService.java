package com.easy.easytable.service;

import com.easy.easytable.entity.RestaurantEntity;
import com.easy.easytable.exception.EasyTableException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRestaurantService {
    @Transactional(rollbackFor = Exception.class, timeout = 50)
    public abstract List<RestaurantEntity> getRestaurants();
    @Transactional(rollbackFor = Exception.class, timeout = 50)
    public abstract RestaurantEntity getRestaurantById(int id) throws EasyTableException;

}