package com.easy.easytable.service;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.exception.EasyTableException;
import com.easy.easytable.repository.IClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ClientEntity authentifier(String email, String password) throws Exception {
        Optional<ClientEntity> client;
        try {
            client = repository.findOneByEmail(email);
        } catch (Exception e) {
            log.error("L'authentification a échoué", e);
            throw e;
        }
        if (client.isEmpty()) {
            throw new EasyTableException("Erreur d'authentification");
        } else {
           // String pwc = passwordEncoder.encode(password);
            String pwc=password.trim();
           // if (!passwordEncoder.matches(client.get().getMotDePasse().trim(), pwc)) {
                if (!passwordEncoder.matches( pwc,client.get().getMotDePasse().trim())) {
                throw new EasyTableException("Erreur d'authentification");
            }
        }
        return client.get();
    }

    @Override
    public ClientEntity getClientById(int id) throws EasyTableException {
        Optional<ClientEntity> client;
        try {
            client = repository.findById(id);
        } catch (Exception e) {
            log.error("Client inconnu", e);
            throw e;
        }

        if (client.isEmpty()) {
            throw new EasyTableException("Client inconnu");
        }
        return client.get();
    }

    @Override
    public ClientEntity creerCompte(ClientEntity client) throws EasyTableException {
        boolean isPresent;
        ClientEntity clientEntity;
        try {
            isPresent = repository.findOneByEmail(client.getEmail()).isPresent();
        } catch (Exception e) {
            log.error("Erreur identification client");
            throw e;
        }
        if (isPresent) {
            throw new EasyTableException("Ce  compte existe déjà");
        } else {
            try {
                client.setMotDePasse(passwordEncoder.encode(client.getMotDePasse()));
                clientEntity = repository.save(client);
            } catch (Exception e) {
                log.error("Client inconnu", e);
                throw e;
            }
        }
        return clientEntity;
    }
}
