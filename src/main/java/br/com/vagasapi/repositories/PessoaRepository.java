package br.com.vagasapi.repositories;

import br.com.vagasapi.domain.Pessoa;
import br.com.vagasapi.domain.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Integer> {

    Page<Vaga> findByNome(String nome, Pageable pageable);

    @Query(value = "{ '_id' : ?0 }")
    Optional<Pessoa> findById(int id);

    Pessoa save(Pessoa entity);

}
