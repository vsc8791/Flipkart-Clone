package com.vsc.darkhorse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAutoConfiguration
@CrossOrigin("*")
public class FlipkartProductApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartProductApIsApplication.class, args);
	}

}
