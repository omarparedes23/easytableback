package com.easy.easytable.dto;

import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.ReservationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Setter
@Getter
@NoArgsConstructor
public class ClientDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String codePostal;
	private String email;
	// Le mot de passe NE DOIT PAS ETRE dans le dto
	// private String motDePasse;
	private String nom;
	private String prenom;
	private String rue;
	private String telephone;
	private String ville;

	private List<AvisDto> avis;
	private List<ReservationDto> reservations;


}