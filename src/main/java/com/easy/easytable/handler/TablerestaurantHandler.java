package com.easy.easytable.handler;

import com.easy.easytable.dto.ReservationDto;
import com.easy.easytable.dto.TablerestaurantDto;
import com.easy.easytable.entity.ReservationEntity;
import com.easy.easytable.entity.TablerestaurantEntity;

import java.util.ArrayList;
import java.util.List;

public class TablerestaurantHandler {
    public static TablerestaurantDto fromEntity(TablerestaurantEntity tablerestaurantEntity) {
        var tablerestaurantDto = new TablerestaurantDto();
        tablerestaurantDto.setId(tablerestaurantEntity.getId());
        //tablerestaurantDto.setRestaurant(RestaurantHandler.fromEntity(tablerestaurantEntity.getRestaurant()));
        List<ReservationDto> reservationDtos = new ArrayList<>();
        List<ReservationEntity> reservationEntities = tablerestaurantEntity.getReservations();
        reservationEntities.forEach(reservation -> reservationDtos.add(ReservationHandler.fromEntity(reservation)));
        tablerestaurantDto.setReservations(reservationDtos);
        return tablerestaurantDto;
    }
}
