package com.Ecommerce.controllers;

import com.Ecommerce.dtos.ClientUpdateDTO;
import com.Ecommerce.models.Client;
import com.Ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getClients();
        if (clients == null || clients.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clients, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Client client = clientService.getClientbyId(id);
        if (client == null){ return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
        return new ResponseEntity<>(client, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = clientService.createClient(client);
        if (newClient == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody ClientUpdateDTO client, @PathVariable Long id){
        Client updatedClient = clientService.updateClient(client,id);
        if (updatedClient == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
