package com.easy.easytable.handler;

import com.easy.easytable.dto.AvisDto;
import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.ClientEntity;

public class AvisHandler {

    public static AvisDto fromEntity(AvisEntity e) {
        AvisDto aDto = new AvisDto();
        aDto.setRestaurantId(e.getRestaurant().getId());
        aDto.setClientId(e.getClient().getId());
        aDto.setId(e.getId());
        aDto.setNote(e.getNote());
        aDto.setCommentaire(e.getCommentaire());
        aDto.setDateAvis(e.getDateAvis());
        return aDto;
    }
}
