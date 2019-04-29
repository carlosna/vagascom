package br.com.vagasapi.dto;

import br.com.vagasapi.domain.Pessoa;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class PessoaDTOToPessoaConverter implements Converter<PessoaDTO, Pessoa> {

    @Override
    public Pessoa convert(PessoaDTO source) {
        return new Pessoa(source.getNome(), source.getProfissao(), source.getLocalizacao(), source.getNivel());
    }
}
