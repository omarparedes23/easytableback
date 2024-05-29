package com.easy.easytable.dto;

import com.easy.easytable.entity.ReservationEntity;
import com.easy.easytable.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class TablerestaurantDto {

    private int id;
    private List<ReservationDto> reservations;
    ///private RestaurantDto restaurant;
}
