package br.com.vagasapi.controllers.br.com.vagasapi.controllers.impl;

import br.com.vagasapi.controllers.PessoaController;
import br.com.vagasapi.dto.PessoaDTO;
import br.com.vagasapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@PessoaController
public class PessoaControllerImpl {

    @Autowired
    PessoaService service;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody PessoaDTO pessoaDTO){
        Integer id = service.insert(pessoaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }
}
