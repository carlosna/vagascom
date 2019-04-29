package br.com.vagasapi.dto;

import br.com.vagasapi.domain.Vaga;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class VagaDTOToVagaConverter implements Converter<VagaDTO, Vaga> {

    @Override
    public Vaga convert(VagaDTO source) {
        return new Vaga(source.getEmpresa(), source.getTitulo(), source.getDescricao(), source.getLocalizacao(), source.getNivel());
    }
}
