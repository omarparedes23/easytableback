package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@Setter
@Getter
@NoArgsConstructor
public class ClientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="code_postal", length=5)
	private String codePostal;

	@Column(length=50)
	private String email;

	@Column(name="mot_de_passe", length=30)
	private String motDePasse;

	@Column(length=30)
	private String nom;

	@Column(length=30)
	private String prenom;

	@Column(length=200)
	private String rue;

	@Column(length=20)
	private String telephone;

	@Column(length=100)
	private String ville;

	//bi-directional many-to-one association to AvisEntity
	@OneToMany(mappedBy="client")
	private List<AvisEntity> avis;

	//bi-directional many-to-one association to ReservationEntity
	@OneToMany(mappedBy="client")
	private List<ReservationEntity> reservations;



	public ReservationEntity addReservation(ReservationEntity reservation) {
		getReservations().add(reservation);
		reservation.setClient(this);

		return reservation;
	}


	public ReservationEntity removeReservation(ReservationEntity reservation) {
		getReservations().remove(reservation);
		reservation.setClient(null);

		return reservation;
	}

}