package com.easy.easytable.service;

import com.easy.easytable.entity.ReservationEntity;
import com.easy.easytable.repository.IClientRepository;
import com.easy.easytable.repository.IReservationRepository;
import com.easy.easytable.repository.ITableRestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReservationService implements IReservationService {
    @Autowired
    IReservationRepository reservationRepository;
    @Autowired
    IClientRepository clientRepository;
    @Autowired
    ITableRestaurantRepository tableRestaurantRepository;
    @Override
    public ReservationEntity reserver(ReservationEntity reservation, int clientId, int tableRestaurantId) {
        ReservationEntity reservationEntity;
        try {
            var client= clientRepository.findById(clientId).get();
            var tableRestaurant=tableRestaurantRepository.findById(tableRestaurantId).get();
            reservation.setTablerestaurant(tableRestaurant);
            reservation.setClient(client);
            reservationEntity = reservationRepository.save(reservation);
        } catch (Exception e) {
            log.error("La réservation a échoué", e);
            throw e;
        }
        return reservationEntity;
    }
}