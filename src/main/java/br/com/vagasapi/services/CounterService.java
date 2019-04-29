package br.com.vagasapi.services;

import br.com.vagasapi.domain.Counter;
import br.com.vagasapi.repositories.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CounterService {

    @Autowired
    private MongoOperations mongo;

    @Autowired
    private CounterRepository counterRepository;

    public Integer getNextSequence(String collectionName) {

        mongo.findAndModify(
                query(where("_id").is(collectionName)),
                new Update().inc("seq", 1),
                options().returnNew(true),
                Counter.class);

        Optional<Counter> optionalCounter = counterRepository.findById(collectionName);
        if (optionalCounter.isPresent()){
            return optionalCounter.get().getSeq();
        }
        throw new IllegalStateException("Problema ao localizar a sequence da coleção " + collectionName);
    }
}
