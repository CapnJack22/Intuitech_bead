package com.example.demo.positions;

import com.example.demo.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/positions")
public class PositionController {
    private final ClientService ClientService;
    private final PositionService PositionService;


    @Autowired
    public PositionController(ClientService clientService, PositionService positionService) {
        ClientService = clientService;
        PositionService = positionService;
    }

    @PostMapping
    public ResponseEntity<String> registerNewPosition(@RequestBody Position position){

        String s=String.join("");

        return ResponseEntity.ok(s);
    }
}
