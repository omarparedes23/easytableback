package com.easy.easytable.repository;

import com.easy.easytable.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
