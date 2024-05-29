package com.easy.easytable.controller;

import com.easy.easytable.dto.ClientCreationCompteDto;
import com.easy.easytable.dto.ClientDto;
import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.exception.EasyTableException;
import com.easy.easytable.handler.ClientHandler;
import com.easy.easytable.service.IClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Log4j2
@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    // http://localhost:9000/client/55
    @GetMapping("/{idClient}")
    public ResponseEntity<ClientDto> getClient(@PathVariable("idClient") int idClient) throws Exception {
        log.info("dans getClient avec {}", idClient);
        ClientEntity client = clientService.getClientById(idClient);
        ClientDto dto = ClientHandler.fromEntity(client);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<ClientDto> authentifier(@PathVariable("email") String email, @PathVariable("password") String password) throws Exception {
        log.info("dans authentifier  avec emai : {} et password :{}", email, password);
        ClientEntity client = clientService.authentifier(email, password);
        ClientDto dto = ClientHandler.fromEntity(client);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/creerCompte")
    public ResponseEntity<ClientDto> creerCompte(@RequestBody ClientCreationCompteDto clientDto) throws ParseException, EasyTableException {
        log.info("dans creer compte avec {}", clientDto);
        ClientEntity clientEntityFromDto = ClientHandler.fromDto(clientDto);
        ClientEntity clientEntity = clientService.creerCompte(clientEntityFromDto);
        clientDto.setId(clientEntity.getId());
        return ResponseEntity.ok(clientDto);
    }
}
