package br.com.vagasapi.services;

import br.com.vagasapi.domain.Candidatura;
import br.com.vagasapi.domain.Graph;
import br.com.vagasapi.domain.Node;
import br.com.vagasapi.helpers.Dijkstra;
import br.com.vagasapi.repositories.CandidaturaRepository;
import br.com.vagasapi.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    Dijkstra algoritmo;

    @Autowired
    CandidaturaRepository candidaturaRepository;

    @Autowired
    VagaRepository vagaRepository;

    private Integer calcularPontuacaoDistancia(String candidato, String vaga){
        //Integer shortestPath = algoritmo.getDistance(candidato, vaga);
        Graph graph = new Graph();
        Node source = new Node(candidato);
        graph.addNode(source);

        Node dest = new Node(vaga);

        graph = Dijkstra.calculateShortestPathFromSource(graph, dest);
        Integer shortestPath = graph.getNodes().
                stream().
                mapToInt(n -> n.getDistance()).
                findFirst().
                getAsInt();

        if(shortestPath > 20) return 0;
        if(shortestPath > 15) return 25;
        if(shortestPath > 10) return 50;
        if(shortestPath > 5) return 75;

        return 100;
    }

    public Integer calcularScore(Candidatura candidatura){
        Integer distance = calcularPontuacaoDistancia(candidatura.getPessoa().getLocalizacao(),
                                                      candidatura.getVaga().getLocalizacao());

        Integer N = ( 100 - 25 * (Math.abs(candidatura.getVaga().getNivel() - // NV
                                            candidatura.getPessoa().getNivel())) ); // NC

        Integer score = (N + distance) / 2;
        return score;

    }

    public List<Candidatura> findCandidaturas(Integer vagaid) {

        return candidaturaRepository.findByVagaId(vagaid, sortByScoreDesc());
    }

    private Sort sortByScoreDesc() {
        return new Sort(Sort.Direction.DESC, "score");
    }
}
