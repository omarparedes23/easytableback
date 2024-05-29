package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
@Setter@Getter@NoArgsConstructor
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=300)
	private String contenu;

	@Column(name="menu_type")
	private String menuType;

	@Column(length=30)
	private String nom;

	@Column(precision=5, scale = 2)
	private BigDecimal prix;

	@Column(length=200)
	private String url;

	//bi-directional many-to-one association to RestaurantEntity
	@ManyToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private RestaurantEntity restaurant;
}