package com.example.demo.positions;

import com.example.demo.clients.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;

    public PositionService(ClientRepository clientRepository, PositionRepository positionRepository){
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }
}
