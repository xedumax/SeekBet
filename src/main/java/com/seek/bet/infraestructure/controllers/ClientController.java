package com.seek.bet.infraestructure.controllers;

import com.seek.bet.application.services.ClientService;
import com.seek.bet.domain.model.Client;
import com.seek.bet.domain.model.ClientMetrics;
import com.seek.bet.domain.model.ClientWithEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping("/metrics")
    public ResponseEntity<ClientMetrics> getMetrics() {
        ClientMetrics metrics = clientService.getMetrics();
        return ResponseEntity.ok(metrics);
    }

    @GetMapping("/listClientWithEvent")
    public ResponseEntity<List<ClientWithEvent>> listClientsWithEvent() {
        List<ClientWithEvent> clients = clientService.listAllWithEvent();
        return ResponseEntity.ok(clients);
    }

}
