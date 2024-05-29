package com.easy.easytable.handler;

import com.easy.easytable.dto.AvisDto;
import com.easy.easytable.dto.MenuDto;
import com.easy.easytable.dto.RestaurantDto;
import com.easy.easytable.dto.TablerestaurantDto;
import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.MenuEntity;
import com.easy.easytable.entity.RestaurantEntity;
import com.easy.easytable.entity.TablerestaurantEntity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantHandler {
    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurantEntity.getId());
        dto.setCodePostal(restaurantEntity.getCodePostal());
        dto.setNom(restaurantEntity.getNom());
        dto.setEmail(restaurantEntity.getEmail());
        dto.setRue(restaurantEntity.getRue());
        dto.setTelephone(restaurantEntity.getTelephone());
        dto.setVille(restaurantEntity.getVille());
        dto.setUrl(restaurantEntity.getUrl());
        dto.setPresentation(restaurantEntity.getPresentation());
        dto.setRestaurantType(restaurantEntity.getRestaurantType());

        List<AvisDto> avisDtos = new ArrayList<>();
        List<AvisEntity> avisEntities = restaurantEntity.getAvis();
        avisEntities.forEach(avis -> avisDtos.add(AvisHandler.fromEntity(avis)));
        dto.setAvis(avisDtos);

        List<MenuDto> menuDtos = new ArrayList<>();
        List<MenuEntity> menuEntities = restaurantEntity.getMenus();
        menuEntities.forEach(menu -> menuDtos.add(MenuHandler.fromEntity(menu)));
        dto.setMenus(menuDtos);

        List<TablerestaurantDto> tablerestaurantDtos = new ArrayList<>();
        List<TablerestaurantEntity> tablerestaurantEntities = restaurantEntity.getTablerestaurants();
        tablerestaurantEntities.forEach(tablerestaurant -> tablerestaurantDtos.add(TablerestaurantHandler.fromEntity(tablerestaurant)));
        dto.setTableRestaurants(tablerestaurantDtos);

        return dto;
    }
}
