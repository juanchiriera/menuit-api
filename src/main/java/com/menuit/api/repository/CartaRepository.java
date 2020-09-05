package com.menuit.api.repository;

import com.menuit.api.model.Carta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartaRepository extends MongoRepository<Carta, String> {
}
