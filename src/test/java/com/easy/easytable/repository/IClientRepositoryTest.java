package com.easy.easytable.repository;

import com.easy.easytable.entity.AvisEntity;
import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.entity.ReservationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
@Rollback(true)
class IClientRepositoryTest {
    @Autowired
    private IClientRepository repository;

    @Test
    void testInsert() {
        List<AvisEntity> avis = new ArrayList<>();
        List<ReservationEntity> reservations = new ArrayList<>();
        ClientEntity entity = new ClientEntity();
        entity.setNom("MBAYEf");
        entity.setAvis(avis);
        entity.setReservations(reservations);
        entity.setEmail("papemm@mmbaye.lol");
        entity.setPrenom("Pape");
        entity.setMotDePasse("12354");
        entity.setTelephone("0123456789");
        entity.setRue("16 rue de la Montagne");
        entity.setVille("Herblay");
        entity.setCodePostal("01234");
        ClientEntity clientInsere = repository.save(entity);
        Assertions.assertNotNull(clientInsere, "L'entite retournée doit exister");
        Assertions.assertTrue(clientInsere.getId()>0, "l'id doit exister");
        Assertions.assertEquals(clientInsere.getNom(), entity.getNom(),"Le nom doit etre Pape");
    }
}
