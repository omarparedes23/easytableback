package com.easy.easytable.dto;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.TablerestaurantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Setter
@Getter
@NoArgsConstructor
public class ReservationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateReservation;
	@JsonDeserialize(using = LocalTimeDeserializer.class)
	private LocalTime heureReservation;
	private int nombrePersonnes;
	private int clientId;
	private int tablerestaurantId;

}