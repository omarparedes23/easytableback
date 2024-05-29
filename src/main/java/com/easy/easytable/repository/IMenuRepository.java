package com.easy.easytable.repository;

import com.easy.easytable.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRepository extends JpaRepository<MenuEntity, Integer> {
}
