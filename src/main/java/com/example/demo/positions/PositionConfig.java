package com.example.demo.positions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PositionConfig {

    @Bean
    CommandLineRunner commandLineRunner2(PositionRepository repository){
        return args -> {
            Position test1 = new Position("Nagyonjomelo", "Budapest");
            Position test2 = new Position("MegjobbMelo", "EzIsBudapest");

            repository.saveAll(
                    List.of(test1, test2)
            );
        };
    }
}