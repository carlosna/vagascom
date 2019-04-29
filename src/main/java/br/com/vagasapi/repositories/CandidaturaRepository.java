package br.com.vagasapi.repositories;

import br.com.vagasapi.domain.Candidatura;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends PagingAndSortingRepository<Candidatura, String> {

    @Query(value = "{ 'vaga.$id': ?0 }")
    List<Candidatura> findByVagaId(Integer vagaid, Sort sort);
}
