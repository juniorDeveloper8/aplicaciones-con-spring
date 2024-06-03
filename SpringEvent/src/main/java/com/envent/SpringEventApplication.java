package com.envent;

import com.envent.Publisher.UserPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserPublisher userPublisher) {
		return  args -> {
		userPublisher.publishUserRegisterEvent("jose","1q2w3e4r", (byte) 24);
		userPublisher.publishUserValidateEvent("daniel", false);
		};
	}
}
