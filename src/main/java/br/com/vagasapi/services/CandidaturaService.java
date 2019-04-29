package br.com.vagasapi.services;

import br.com.vagasapi.domain.Candidatura;
import br.com.vagasapi.domain.Pessoa;
import br.com.vagasapi.domain.Vaga;
import br.com.vagasapi.repositories.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidaturaService {

    @Autowired
    CandidaturaRepository repository;

    @Autowired
    RankingService rankingService;

    public void register(Pessoa pessoa, Vaga vaga){
        Candidatura candidatura = new Candidatura(pessoa, vaga);

        Integer score = rankingService.calcularScore(candidatura);
        candidatura.setScore(score);

        repository.save(candidatura);
    }
}
