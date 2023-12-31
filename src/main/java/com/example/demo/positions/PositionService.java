package com.example.demo.positions;

import com.example.demo.Model.PositionDTO;
import com.example.demo.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<PositionDTO> getComplexPositions(Position position) {
        List<Position> positionsFromDb = positionRepository.findPositionsBy(position.getName(), position.getLocation());
        List<PositionDTO> result = new ArrayList<>();
        for (Position p : positionsFromDb
             ) {
            result.add(new PositionDTO(p, URL.concat(String.valueOf(p.getId()))));
        }
        return result;
    }
}
