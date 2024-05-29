package com.easy.easytable.service;

import com.easy.easytable.exception.EasyTableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class RestaurantServiceTest {
    @Autowired
    IRestaurantService restaurantService;

    @Test
        //  tout va bien
    void getRestaurants() {
        var restaurants = restaurantService.getRestaurants();
        assertFalse(restaurants.isEmpty(), "Au moins un restaurant doit etre retourné");

    }

    @Test
        // tout va bien
    void getRestaurantById01() throws EasyTableException {
        var restaurant = restaurantService.getRestaurantById(1);
        assertEquals(restaurant.getId(), 1, "Les id ne correspondent pas");
        assertEquals(restaurant.getNom(), "Waly Fay", " les noms ne correspondent pas");

    }

    @Test
        // restaurant introuvable
    void getRestaurantById02() {
        assertThrows(EasyTableException.class, () -> restaurantService.getRestaurantById(10), "Restaurant introuvable");
    }

}
