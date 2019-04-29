package br.com.vagasapi.dto;

import br.com.vagasapi.domain.Vaga;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class VagaDTO implements Serializable {

    @NotBlank
    private String empresa;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String localizacao;
    @NotNull
    private Integer nivel;

    public VagaDTO(){ }

    public VagaDTO(Vaga obj){
        empresa = obj.getEmpresa();
        titulo = obj.getTitulo();
        descricao = obj.getDescricao();
        localizacao = obj.getLocalizacao();
        nivel = obj.getNivel();
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Integer getNivel() {
        return nivel;
    }


}
