package com.example.demo.clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client test1 = new Client("example", "example.mail@gmail.com");
            Client test2 = new Client("example2", "example2.mail@gmail.com");

            repository.saveAll(
                    List.of(test1, test2)
            );
        };
    }
}
