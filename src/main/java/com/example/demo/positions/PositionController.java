package com.example.demo.positions;

import com.example.demo.Model.PositionDTO;
import com.example.demo.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.util.List;

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

    @GetMapping
    public List<Position> getPositions(){
        return PositionService.getPositions();
    }

    @GetMapping("/")
    public List<PositionDTO> getComplexPositions(@RequestHeader(HttpHeaders.AUTHORIZATION) String apiKey, @RequestBody Position position){
        if(!ClientService.CheckKey((apiKey))){
            throw new IllegalArgumentException("api key not found");
        }

        return PositionService.getComplexPositions(position);
    }

    @PostMapping
    public ResponseEntity<String> registerNewPosition( @RequestHeader(HttpHeaders.AUTHORIZATION) String apiKey, @RequestBody Position position){

        if(!ClientService.CheckKey(apiKey)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("api key not found");
        }

        String response = PositionService.addNewPosition(position);

        return ResponseEntity.ok(response);
    }
}
