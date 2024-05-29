package com.easy.easytable.repository;

import com.easy.easytable.entity.TablerestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITableRestaurantRepository extends JpaRepository<TablerestaurantEntity, Integer> {
}
