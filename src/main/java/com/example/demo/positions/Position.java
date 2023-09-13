package com.example.demo.positions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String location;

    public Position(String name, String location){
        this.name=name;
        this.location=location;
    }

    public Position() {

    }
}
