package br.com.vagasapi.controllers.br.com.vagasapi.controllers.impl;

import br.com.vagasapi.controllers.CandidaturaController;
import br.com.vagasapi.domain.Pessoa;
import br.com.vagasapi.domain.Vaga;
import br.com.vagasapi.services.CandidaturaService;
import br.com.vagasapi.services.PessoaService;
import br.com.vagasapi.services.RankingService;
import br.com.vagasapi.services.VagaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Optional;

@CandidaturaController
public class CandidaturaControllerImpl {

        @Autowired
        RankingService rankingService;

        @Autowired
        PessoaService pessoaService;

        @Autowired
        VagaService vagaService;

        @Autowired
        CandidaturaService candidaturaService;

        @ApiOperation(value = "Cadastrar pessoa na vaga")
        @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE } )
        public ResponseEntity<Void> cadastrar(@RequestBody Map<String, Integer> json){

            Optional<Pessoa> pessoa1 = pessoaService.findById(json.get("pessoa"));
            Optional<Vaga> vaga1 = vagaService.findById(json.get("vaga"));

            candidaturaService.register(pessoa1.get(), vaga1.get());

            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
}
