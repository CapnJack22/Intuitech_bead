package com.example.demo.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/clients")
public class ClientController {
    private final ClientService ClientService;

    @Autowired
    public ClientController(ClientService clientService) {
        ClientService = clientService;
    }


    @GetMapping
    public List<Client> getClients() {
        return ClientService.getClients();
    }

    @PostMapping
    public ResponseEntity<String> registerNewClient(@RequestBody Client client) {

        String api = ClientService.addNewClient(client);

        return ResponseEntity.ok(api);
    }
}
