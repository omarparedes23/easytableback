package com.easy.easytable.dto;

import com.easy.easytable.entity.RestaurantEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class MenuDto {
    private int id;
    private String contenu;
    private String menuType;
    private String nom;
    private BigDecimal prix;
    private String url;
    //private RestaurantDto restaurant;
}
