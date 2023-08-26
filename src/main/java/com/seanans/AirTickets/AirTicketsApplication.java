package com.seanans.AirTickets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AirTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirTicketsApplication.class, args);
	}

}
