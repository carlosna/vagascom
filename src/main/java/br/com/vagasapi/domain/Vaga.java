package br.com.vagasapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document(collection = "vagas")
public class Vaga implements Serializable {

    @Id @NotNull
    private Integer id;
    @NotNull
    private String empresa;
    @NotNull
    private String titulo;
    @NotNull
    private String descricao;
    @NotNull
    private String localizacao;
    @NotNull
    private Integer nivel;

    public Vaga(@NotNull String empresa, @NotNull String titulo, @NotNull String descricao, @NotNull String localizacao, @NotNull Integer nivel) {
        this.empresa = empresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public static VagaBuilder builder() {
        return new VagaBuilder();
    }

    public static class VagaBuilder {

        private String empresa;
        private String titulo;
        private String descricao;
        private String localizacao;
        private Integer nivel;

        VagaBuilder() {
        }

        public VagaBuilder empresa(String empresa) {
            this.empresa = empresa;
            return this;
        }

        public VagaBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public VagaBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public VagaBuilder localizacao(String localizacao) {
            this.localizacao = localizacao;
            return this;
        }

        public VagaBuilder nivel(Integer nivel) {
            this.nivel = nivel;
            return this;
        }

        public Vaga build() {

            return new Vaga(empresa, titulo, descricao, localizacao, nivel);
        }

        @java.lang.Override
        public String toString() {
            return "VagaBuilder(empresa = " + this.empresa + ", " +
                    "           titulo = " + this.titulo + ", " +
                    "           descricao = " + this.descricao + ", " +
                    "           localizacao = " + this.localizacao + ", " +
                    "           nivel = " + this.nivel + ")";
        }
    }
}