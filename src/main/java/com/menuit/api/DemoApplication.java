package com.menuit.api;

import com.mongodb.client.MongoClients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(final String[] args) {
		//MongoOperations mongoOps = new MongoTemplate(MongoConfiguration.create(), "database");
		SpringApplication.run(DemoApplication.class, args);
	}

}
