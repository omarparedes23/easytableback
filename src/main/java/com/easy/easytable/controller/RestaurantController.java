package com.easy.easytable.controller;

import com.easy.easytable.dto.RestaurantDto;
import com.easy.easytable.entity.RestaurantEntity;
import com.easy.easytable.exception.EasyTableException;
import com.easy.easytable.handler.RestaurantHandler;
import com.easy.easytable.service.RestaurantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants() {
        log.info("dans getrestaurants");
        var restaurantEntities = restaurantService.getRestaurants();
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        restaurantEntities.forEach(restaurantEntity -> restaurantDtos.add(RestaurantHandler.fromEntity(restaurantEntity)));
        log.info("Nombre de restaurants dto: {}", restaurantDtos.size());
        return ResponseEntity.ok(restaurantDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable("id") int id) throws EasyTableException {
        log.info("dans getRestaurant avec {}", id);
        RestaurantEntity restaurant = restaurantService.getRestaurantById(id);
        RestaurantDto dto = RestaurantHandler.fromEntity(restaurant);
        return ResponseEntity.ok(dto);
    }
}
