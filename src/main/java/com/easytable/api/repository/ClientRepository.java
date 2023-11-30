package com.easytable.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.easytable.api.model.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

}
