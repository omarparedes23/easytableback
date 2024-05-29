package com.easy.easytable.service;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.exception.EasyTableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class ClientServiceTest {
    @Autowired
    IClientService clientService;

    @Test
        // Authentification tout va bien
    void authentifier01() throws Exception {
        var client = clientService.authentifier("pape@mbaye.com", "123456");
        Assertions.assertNotNull(client, "L'entite retournée doit exister");
        Assertions.assertTrue(client.getId() > 0, "l'id doit exister");
        Assertions.assertEquals(client.getEmail(), "pape@mbaye.com", "Le client retourné n'est pas le bon");
    }

    @Test
        // Authentification mot de passe ko
    void authentifier02() throws Exception {
        Assertions.assertThrows(EasyTableException.class, () -> clientService.authentifier("papem@mbaye.com", "124354"));
    }

    @Test
        // Authentification email inexistant
    void authentifier03() throws Exception {
        Assertions.assertThrows(Exception.class, () -> clientService.authentifier("papem@15", "124354"));
    }

    @Test
        //Tout va bien
    void getClientById01() throws EasyTableException {
        var client = clientService.getClientById(1);
        Assertions.assertNotNull(client, "L'entite retournée doit exister");
        Assertions.assertTrue(client.getId() > 0, "l'id doit exister");
        Assertions.assertEquals(client.getEmail(), "pape@mbaye.com", "Le client retourné n'est pas le bon");
    }

    @Test
        //Client introuvable
    void getClientById02() throws EasyTableException {
        Assertions.assertThrows(EasyTableException.class, () -> clientService.getClientById(53));
    }

    @Test
        // Tout va bien
    void creerCompte01() throws EasyTableException {
        var client = new ClientEntity();
        client.setNom("Prince");
        client.setPrenom("Remy");
        client.setEmail("remy@prince.com");
        client.setMotDePasse("remy");
        client.setVille("Metz");
        client.setRue("6 rue du la peine");
        client.setTelephone("021345678");
        client.setCodePostal("57200");

        var clientRetourne = clientService.creerCompte(client);
        Assertions.assertNotNull(clientRetourne, "L'entite retournée doit exister");
        Assertions.assertEquals(clientRetourne.getEmail(), client.getEmail(), "Le client retourné n'est pas le bon");

    }

    @Test
        // Avec un compte déja existant
    void creerCompte02() {
        var client = new ClientEntity();
        client.setNom("Prince");
        client.setPrenom("Remy");
        client.setEmail("pape@mbaye.com");
        client.setMotDePasse("remy");
        client.setVille("Metz");
        client.setRue("6 rue du la peine");
        client.setTelephone("021345678");
        client.setCodePostal("57200");

        Assertions.assertThrows(EasyTableException.class, () -> clientService.creerCompte(client));
    }

    @Test
        // Sans mot de pass
    void creerCompte03() {
        var client = new ClientEntity();
        client.setNom("Prince");
        client.setPrenom("Remy");
        client.setEmail("pape@mbaye.com");
       // client.setMotDePasse("remy");
        client.setVille("Metz");
        client.setRue("6 rue du la peine");
        client.setTelephone("021345678");
        client.setCodePostal("57200");

        Assertions.assertThrows(EasyTableException.class, () -> clientService.creerCompte(client));
    }


    @Test
    void testGetClientById() {
    }

    @Test
    void testCreerCompte() {
    }
}
