package com.example.Mas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasApplication.class, args);
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<Start Mas!!!");
	}

}
