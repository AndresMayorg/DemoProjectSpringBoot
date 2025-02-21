package com.project.demo.project.web.controller;

import com.project.demo.project.persistence.entity.ClientEntity;
import com.project.demo.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        return ResponseEntity.ok(this.clientService.getAllClients());
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable int idClient) {
        return ResponseEntity.ok(this.clientService.getClientById(idClient));
    }

    @PostMapping
    public ResponseEntity<ClientEntity> saveClient(@RequestBody ClientEntity client) {
        if (client.getIdClient() == null || !this.clientService.existsClient(client.getIdClient())) {
            return ResponseEntity.ok(this.clientService.saveClient(client));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ClientEntity> updateClient(@RequestBody ClientEntity client) {
        if (client.getIdClient() != null && this.clientService.existsClient(client.getIdClient())) {
            return ResponseEntity.ok(this.clientService.saveClient(client));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable int idClient) {
        if (this.clientService.existsClient(idClient)) {
            this.clientService.deleteClient(idClient);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
