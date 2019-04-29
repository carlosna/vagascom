package br.com.vagasapi.repositories;

import br.com.vagasapi.domain.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CounterRepository extends MongoRepository<Counter, String> {

    @Query(value = "{ '_id' : ?0 }")
    Optional<Counter> findById(String id);

}
