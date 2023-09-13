package com.example.demo.positions;

import com.example.demo.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
