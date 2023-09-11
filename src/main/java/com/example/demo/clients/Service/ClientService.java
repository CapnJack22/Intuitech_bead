package com.example.demo.clients.Service;

import com.example.demo.clients.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    public List<Client> getClients() {
        return List.of(
                new Client("example", "example.mail@gmail.com")
        );
    }
}
