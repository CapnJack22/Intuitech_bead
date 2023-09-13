package com.example.demo.Model;

import com.example.demo.positions.Position;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionDTO {
    private Position position;
    private String URL;

    public PositionDTO(){

    }
}
