package com.easy.easytable.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the restaurant database table.
 * 
 */
@Entity
@Table(name="restaurant")
@Setter
@Getter
@NoArgsConstructor
public class RestaurantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="code_postal", length=5)
	private String codePostal;

	@Column(length=40)
	private String email;

	@Column(length=50)
	private String nom;

	@Column(length=200)
	private String presentation;

	@Column(name="restaurant_type")
	private String restaurantType;

	@Column(length=200)
	private String rue;

	@Column(length=20)
	private String telephone;

	@Column(length=200)
	private String url;

	@Column(length=100)
	private String ville;

	//bi-directional many-to-one association to AvisEntity
	@OneToMany(mappedBy="restaurant",fetch = FetchType.EAGER)
	private List<AvisEntity> avis;

	//bi-directional many-to-one association to MenuEntity
	@OneToMany(mappedBy="restaurant",fetch = FetchType.EAGER)
	private List<MenuEntity> menus;

	//bi-directional many-to-one association to TablerestaurantEntity
	@OneToMany(mappedBy="restaurant", fetch = FetchType.EAGER)
	private List<TablerestaurantEntity> tablerestaurants;

	public AvisEntity addAvis(AvisEntity avis) {
		getAvis().add(avis);
		avis.setRestaurant(this);

		return avis;
	}

	public AvisEntity removeAvis(AvisEntity avis) {
		getAvis().remove(avis);
		avis.setRestaurant(null);

		return avis;
	}
	public MenuEntity addMenus(MenuEntity menus) {
		getMenus().add(menus);
		menus.setRestaurant(this);

		return menus;
	}

	public MenuEntity removeMenus(MenuEntity menus) {
		getMenus().remove(menus);
		menus.setRestaurant(null);

		return menus;
	}


	public TablerestaurantEntity addTablerestaurant(TablerestaurantEntity tablerestaurant) {
		getTablerestaurants().add(tablerestaurant);
		tablerestaurant.setRestaurant(this);

		return tablerestaurant;
	}

	public TablerestaurantEntity removeTablerestaurant(TablerestaurantEntity tablerestaurant) {
		getTablerestaurants().remove(tablerestaurant);
		tablerestaurant.setRestaurant(null);

		return tablerestaurant;
	}

}