package com.easy.easytable.handler;

import com.easy.easytable.dto.AvisDto;
import com.easy.easytable.dto.ClientCreationCompteDto;
import com.easy.easytable.dto.ClientDto;
import com.easy.easytable.dto.ReservationDto;
import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.ReservationEntity;

import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    public static ClientDto fromEntity(ClientEntity client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        dto.setPrenom(client.getPrenom());
        dto.setRue(client.getRue());
        dto.setVille(client.getVille());
        dto.setTelephone(client.getTelephone());
        dto.setCodePostal(client.getCodePostal());

        List<AvisDto> avisDtos = new ArrayList<>();
        List<AvisEntity> avisEntities = client.getAvis();
        avisEntities.forEach(e -> avisDtos.add(AvisHandler.fromEntity(e)));
        dto.setAvis(avisDtos);

        List<ReservationDto> reservationDtos = new ArrayList<>();
        List<ReservationEntity> reservationEntities = client.getReservations();
        reservationEntities.forEach(e -> reservationDtos.add(ReservationHandler.fromEntity(e)));
        dto.setReservations(reservationDtos);

        return dto;
    }

    public  static ClientEntity fromDto(ClientCreationCompteDto clientDto){
        ClientEntity clientEntity=new ClientEntity();
        clientEntity.setRue(clientDto.getRue());
        clientEntity.setMotDePasse(clientDto.getMotDePasse());
        clientEntity.setTelephone(clientDto.getTelephone());
        clientEntity.setVille(clientDto.getVille());
        clientEntity.setPrenom(clientDto.getPrenom());
        clientEntity.setEmail(clientDto.getEmail());
        clientEntity.setNom(clientDto.getNom());
        clientEntity.setCodePostal(clientDto.getCodePostal());

        return clientEntity;
    }
}
