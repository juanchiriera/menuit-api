package com.menuit.api.repository;

import com.menuit.api.model.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RestauranteRepository extends MongoRepository<Restaurante, String> {
}
