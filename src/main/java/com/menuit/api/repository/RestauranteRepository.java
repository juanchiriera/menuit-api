package com.menuit.api.repository;

import com.menuit.api.model.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends MongoRepository<Restaurante, String> {
    public Restaurante findByNombre(String nombre);
    public Optional<Restaurante> findById(long id);
}
