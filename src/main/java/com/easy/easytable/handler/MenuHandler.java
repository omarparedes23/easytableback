package com.easy.easytable.handler;

import com.easy.easytable.dto.MenuDto;
import com.easy.easytable.entity.MenuEntity;

public class MenuHandler {
    public  static MenuDto fromEntity(MenuEntity menuEntity){
        MenuDto dto=new MenuDto();
        dto.setNom(menuEntity.getNom());
        dto.setId(menuEntity.getId());
        dto.setPrix(menuEntity.getPrix());
        dto.setContenu(menuEntity.getContenu());
        dto.setMenuType(menuEntity.getMenuType());
        dto.setUrl(menuEntity.getUrl());
       // dto.setRestaurant(RestaurantHandler.fromEntity(menuEntity.getRestaurant()));

        return dto;

    }
}
