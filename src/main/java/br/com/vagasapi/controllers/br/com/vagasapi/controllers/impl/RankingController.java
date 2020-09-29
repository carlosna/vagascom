package br.com.vagasapi.controllers.br.com.vagasapi.controllers.impl;


import br.com.vagasapi.domain.Candidatura;
import br.com.vagasapi.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1")
@RestController
public class RankingController {

    @Autowired
    RankingService rankingService;

    @RequestMapping(value = "/vagas/{vagaid}/candidaturas/ranking", method = RequestMethod.GET)
    public ResponseEntity<List<Candidatura>> ranking(@PathVariable Integer vagaid){

        List<Candidatura> candidaturaList = rankingService.findCandidaturas(vagaid);

        return ResponseEntity.ok().body(candidaturaList);
    }
}
