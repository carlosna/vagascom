package br.com.vagasapi.repositories;

import br.com.vagasapi.domain.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VagaRepository extends PagingAndSortingRepository<Vaga, Integer> {

    Page<Vaga> findByTitulo(String titulo, Pageable pageable);

    Vaga save (Vaga entity);

    @Query(value = "{ '_id' : ?0 }")
    Optional<Vaga> findById(int id);

}
