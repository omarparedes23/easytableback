package com.easy.easytable.handler;

import com.easy.easytable.dto.ReservationDto;
import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.ReservationEntity;
import com.easy.easytable.entity.TablerestaurantEntity;
import com.easy.easytable.repository.IClientRepository;
import com.easy.easytable.repository.ITableRestaurantRepository;

import java.sql.Time;

public class ReservationHandler {

    public static ReservationDto fromEntity(ReservationEntity e) {
        ReservationDto aDto = new ReservationDto();
        aDto.setDateReservation(e.getDateReservation());
        aDto.setClientId(e.getClient().getId());
        aDto.setId(e.getId());
        aDto.setHeureReservation(e.getHeureReservation().toLocalTime());
        aDto.setNombrePersonnes(e.getNombrePersonnes());
        aDto.setTablerestaurantId(e.getTablerestaurant().getId());
        return aDto;
    }
    public static ReservationEntity fromDto (ReservationDto dto){
        ReservationEntity reservationEntity=new ReservationEntity();
        reservationEntity.setDateReservation(dto.getDateReservation());
        reservationEntity.setHeureReservation(Time.valueOf(dto.getHeureReservation()));
        reservationEntity.setNombrePersonnes(dto.getNombrePersonnes());
        return reservationEntity;
    }
}
