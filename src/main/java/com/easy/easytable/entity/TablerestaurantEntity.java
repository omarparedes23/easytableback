package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the tablerestaurant database table.
 * 
 */
@Entity
@Table(name="tablerestaurant")
@Setter
@Getter
@NoArgsConstructor
public class TablerestaurantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to ReservationEntity
	@OneToMany(mappedBy="tablerestaurant")
	private List<ReservationEntity> reservations;

	//bi-directional many-to-one association to RestaurantEntity
	@ManyToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private RestaurantEntity restaurant;

	public ReservationEntity addReservation(ReservationEntity reservation) {
		getReservations().add(reservation);
		reservation.setTablerestaurant(this);

		return reservation;
	}
	public ReservationEntity removeReservation(ReservationEntity reservation) {
		getReservations().remove(reservation);
		reservation.setTablerestaurant(null);

		return reservation;
	}
}