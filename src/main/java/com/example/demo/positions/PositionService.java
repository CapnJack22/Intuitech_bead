package com.example.demo.positions;

import com.example.demo.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    private static final String URL = "localhost:8080/positions/";

    @Autowired
    public PositionService(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }

    public String addNewPosition(Position position) {
        if (50 < position.getName().length())
            throw new IllegalArgumentException("position name too long");
        if (50 < position.getLocation().length())
            throw new IllegalArgumentException("position location too long");

        return URL.concat(String.valueOf(positionRepository.save(position).getId()));
    }

    public List<Position> getPositions() {
        return positionRepository.findAll();
    }
}
