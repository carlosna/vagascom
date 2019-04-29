package br.com.vagasapi.services;

import br.com.vagasapi.domain.Vaga;
import br.com.vagasapi.dto.VagaDTO;
import br.com.vagasapi.dto.VagaDTOToVagaConverter;
import br.com.vagasapi.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    public static final String collection = "vagas";

    @Autowired
    VagaRepository repo;

    @Autowired
    VagaDTOToVagaConverter converter;

    @Autowired
    CounterService counterService;

    public Vaga fromDTO(VagaDTO vagaDTO) {
        return Vaga.builder().empresa(vagaDTO.getEmpresa()).descricao(vagaDTO.getDescricao()).
                titulo(vagaDTO.getTitulo()).
                localizacao(vagaDTO.getLocalizacao()).
                nivel(vagaDTO.getNivel()).
                build();
    }

    public Integer insert(VagaDTO vagaDTO) {
        Vaga vaga = converter.convert(vagaDTO);
        vaga.setId(counterService.getNextSequence(collection));

        repo.save(vaga);

        return vaga.getId();
    }

    public Page<Vaga> findPage(Integer page, Integer linesPerPage, String orderBy) {
        // Iterable<Vaga> all = repo.findAll(Sort.by(orderBy));
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.by(orderBy).descending());
        return repo.findAll(pageable);

    }

    public Optional<Vaga> findById(int id) {
        return repo.findById(id);
    }
}
