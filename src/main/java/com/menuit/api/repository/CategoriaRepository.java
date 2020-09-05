package com.menuit.api.repository;

import com.menuit.api.model.Categoria;
import com.menuit.api.model.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
    public Optional<Categoria> findById(Long id);

}
