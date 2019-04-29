package br.com.vagasapi.services;

import br.com.vagasapi.domain.Pessoa;
import br.com.vagasapi.domain.Vaga;
import br.com.vagasapi.dto.PessoaDTO;
import br.com.vagasapi.dto.PessoaDTOToPessoaConverter;
import br.com.vagasapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    public final static String collection = "pessoas";

    @Autowired
    PessoaRepository repo;

    @Autowired
    PessoaDTOToPessoaConverter converter;

    @Autowired
    CounterService counterService;

    public Integer insert(PessoaDTO pessoaDTO){
        Pessoa pessoa = converter.convert(pessoaDTO);
        pessoa.setId(counterService.getNextSequence(collection));

        repo.save(pessoa);

        return pessoa.getId();
    }

    public Optional<Pessoa> findById(int id) {
        return repo.findById(id);
    }

}
