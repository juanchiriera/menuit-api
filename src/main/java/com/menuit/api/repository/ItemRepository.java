package com.menuit.api.repository;

import com.menuit.api.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findById(Long parseLong);
}
