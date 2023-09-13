package com.example.demo.clients;

import com.example.demo.clients.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registerNewClient(@RequestBody Client client) {
        ClientService.addNewClient(client);
    }
}
