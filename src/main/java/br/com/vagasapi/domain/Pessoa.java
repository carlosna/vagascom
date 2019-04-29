package br.com.vagasapi.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document(collection = "pessoas")
public class Pessoa implements Serializable {

    @NotNull
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String profissao;
    @NotBlank
    private String localizacao;
    @NotNull
    private Integer nivel;

    public Pessoa(@NotBlank String nome, @NotBlank String profissao, @NotBlank String localizacao, @NotBlank Integer nivel) {
        this.nome = nome;
        this.profissao = profissao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
