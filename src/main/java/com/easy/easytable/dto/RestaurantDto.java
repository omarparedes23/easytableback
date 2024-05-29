package com.easy.easytable.dto;

import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.MenuEntity;
import com.easy.easytable.entity.TablerestaurantEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class RestaurantDto {
    private int id;
    private String codePostal;
    private String email;
    private String nom;

    private String presentation;
    private String restaurantType;
    private String rue;

    private String telephone;

    private String url;

    private String ville;

    private List<AvisDto> avis;
    private List<MenuDto> menus;
    private List<TablerestaurantDto> tableRestaurants;
}
