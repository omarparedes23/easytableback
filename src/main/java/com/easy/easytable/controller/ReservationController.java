package com.easy.easytable.controller;

import com.easy.easytable.dto.ReservationDto;
import com.easy.easytable.handler.ReservationHandler;
import com.easy.easytable.entity.ReservationEntity;
import com.easy.easytable.service.IReservationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Log4j2
@CrossOrigin("*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @PostMapping("/reserver")
    public ResponseEntity<ReservationDto> reserver(@RequestBody ReservationDto reservationDto) throws ParseException {
        log.info("dans reserver avec {}", reservationDto);
        ReservationEntity reservationEntityFromDto = ReservationHandler.fromDto(reservationDto);
        ReservationEntity reservationEntity = reservationService.reserver(reservationEntityFromDto,reservationDto.getClientId(),reservationDto.getTablerestaurantId());
        reservationDto.setId(reservationEntity.getId());
        return ResponseEntity.ok(reservationDto);
    }
}
