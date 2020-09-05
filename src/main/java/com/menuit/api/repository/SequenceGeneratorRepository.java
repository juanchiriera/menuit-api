package com.menuit.api.repository;

import com.menuit.api.model.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SequenceGeneratorRepository extends MongoRepository<DatabaseSequence, String> {
}
