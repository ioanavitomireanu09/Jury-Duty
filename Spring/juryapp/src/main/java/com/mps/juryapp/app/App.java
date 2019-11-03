package com.mps.juryapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mps.juryapp.app.App;

@SpringBootApplication
@ComponentScan("com.mps")
@EnableAutoConfiguration
@EntityScan("com.mps.*")
@EnableJpaRepositories("com.mps.*")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
