package com.menuit.api;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration{
    @Value("${spring.data.mongodb.database}")
    private String DB_NAME;
    @Value("${spring.data.mongodb.host}")
    private String DB_HOST;
    @Value("${spring.data.mongodb.port}")
    private int DB_PORT;
    

    public @Bean MongoClient mongoClient() {
        return new MongoClient(System.getenv("DB_HOST"));
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), System.getenv("DB_NAME"));
    }
}
