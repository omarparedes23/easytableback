package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the avis database table.
 * 
 */
@Entity
@Table(name="avis")
@Setter
@Getter
@NoArgsConstructor
public class AvisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=200)
	private String commentaire;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_avis")
	private Date dateAvis;

	private int note;

	//bi-directional many-to-one association to ClientEntity
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	private ClientEntity client;

	//bi-directional many-to-one association to RestaurantEntity
	@ManyToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private RestaurantEntity restaurant;

}