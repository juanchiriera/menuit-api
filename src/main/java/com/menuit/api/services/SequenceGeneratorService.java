package com.menuit.api.services;
import com.menuit.api.model.DatabaseSequence;
import com.menuit.api.repository.SequenceGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class SequenceGeneratorService {

    @Autowired
    private SequenceGeneratorRepository sequenceGeneratorRepository;

    @Autowired
    public SequenceGeneratorService(SequenceGeneratorRepository sequenceGeneratorRepository) {
        this.sequenceGeneratorRepository = sequenceGeneratorRepository;
    }

    public long generateSequence(String seqName) {
        Optional<DatabaseSequence> counter = sequenceGeneratorRepository.findById(seqName);
        long newId = 0;
        if(counter.isPresent()) {
            newId = counter.get().getSeq()+1;
            DatabaseSequence newSeq = counter.get();
            newSeq.setSeq(newId);
            sequenceGeneratorRepository.save(newSeq);
            return newId;
        }else{
            DatabaseSequence newSeq = new DatabaseSequence();
            newSeq.setSeq(0);
            newSeq.setId(seqName);
            sequenceGeneratorRepository.insert(newSeq);
            return 0;
        }
    }
}