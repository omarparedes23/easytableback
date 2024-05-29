package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name="reservation")
@Setter
@Getter
@NoArgsConstructor
public class ReservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_reservation")
	private Date dateReservation;

	@Column(name="heure_reservation")
	private Time heureReservation;

	@Column(name="nombre_personnes")
	private int nombrePersonnes;

	//bi-directional many-to-one association to ClientEntity
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	private ClientEntity client;

	//bi-directional many-to-one association to TablerestaurantEntity
	@ManyToOne
	@JoinColumn(name="table_restaurant_id", nullable=false)
	private TablerestaurantEntity tablerestaurant;

}