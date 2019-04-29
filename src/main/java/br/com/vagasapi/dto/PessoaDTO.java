package br.com.vagasapi.dto;

import br.com.vagasapi.domain.Pessoa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PessoaDTO implements Serializable {

    @NotBlank
    private String nome;
    @NotBlank
    private String profissao;
    @NotBlank
    private String localizacao;
    @NotNull
    private Integer nivel;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa obj){
        nome = obj.getNome();
        profissao = obj.getProfissao();
        localizacao = obj.getLocalizacao();
        nivel = obj.getNivel();
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Integer getNivel() {
        return nivel;
    }


}
