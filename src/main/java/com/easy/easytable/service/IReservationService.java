package com.easy.easytable.service;

import com.easy.easytable.entity.ReservationEntity;

public interface IReservationService {
    public abstract  ReservationEntity reserver(ReservationEntity reservation, int clientId, int tableRestaurantId);
}
