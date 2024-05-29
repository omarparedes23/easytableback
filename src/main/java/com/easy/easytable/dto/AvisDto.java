package com.easy.easytable.dto;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.RestaurantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;


/**
 * The persistent class for the avis database table.
 * 
 */
@Setter
@Getter
@NoArgsConstructor
public class AvisDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String commentaire;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private Date dateAvis;
	private int note;
	private int clientId;
	private int restaurantId;

}