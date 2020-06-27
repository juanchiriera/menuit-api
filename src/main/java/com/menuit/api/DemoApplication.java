package com.menuit.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");
		SpringApplication.run(DemoApplication.class, args);
	}

}
