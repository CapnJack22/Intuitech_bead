package com.example.demo.clients;

import com.example.demo.clients.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/client")
public class ClientController {
    private final ClientService ClientService;

    public ClientController(ClientService clientService) {
        ClientService = clientService;
    }


    @GetMapping
    public List<Client> getClients() {
        return ClientService.getClients();
    }
}
