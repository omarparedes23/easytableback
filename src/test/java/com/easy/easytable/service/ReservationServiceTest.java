package com.easy.easytable.service;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.ReservationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
@Transactional
@Rollback
class ReservationServiceTest {
    @Autowired
    IReservationService reservationService;
    @Test
        // Reservation tout va bien tout va bien
    void reservation01() throws Exception {
        var reservation=new ReservationEntity();
        reservation.setNombrePersonnes(4);
        reservation.setHeureReservation(Time.valueOf("10:00:00"));
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        reservation.setDateReservation(df.parse("30-12-2023"));
        var reservationRetournee=reservationService.reserver(reservation,1,1);
        Assertions.assertNotNull(reservationRetournee,"L'entité reservation retourner ne doit pas etre null");
        Assertions.assertTrue(reservationRetournee.getId()>0,"La reservation retournee doit avoir un Id");
    }

    @Test
        // Reservation informations manquantes
    void reservation02() throws ParseException {
        var reservation=new ReservationEntity();
        reservation.setNombrePersonnes(4);
        reservation.setHeureReservation(Time.valueOf("10:00:00"));
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        reservation.setDateReservation(df.parse("30-12-2023"));
        Assertions.assertThrows(Exception.class, ()->reservationService.reserver(reservation,80,1),"Echec de reservation");
    }
}
