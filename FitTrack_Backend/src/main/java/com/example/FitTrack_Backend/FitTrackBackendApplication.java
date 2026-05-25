package com.example.FitTrack_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FitTrackBackendApplication {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

	public static void main(String[] args) {
		SpringApplication.run(FitTrackBackendApplication.class, args);
	}

}
