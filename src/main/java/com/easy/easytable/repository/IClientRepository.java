package com.easy.easytable.repository;

import com.easy.easytable.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity,Integer> {
public Optional<ClientEntity> findOneByEmail(String email);

}
