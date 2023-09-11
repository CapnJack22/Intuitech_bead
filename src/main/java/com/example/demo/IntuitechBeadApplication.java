package com.example.demo;

import com.example.demo.clients.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class IntuitechBeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntuitechBeadApplication.class, args);
	}

	@GetMapping
	public List<Client> hello() {
		return List.of(
				new Client(1L,"example", "example.mail@gmail.com")
		);
	}
}
