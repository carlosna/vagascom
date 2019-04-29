package br.com.vagasapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document(collection = "candidaturas")
@CompoundIndexes({
        @CompoundIndex(name = "vaga_pessoa_idx", def = "{'vaga.id' : 1, 'pessoa.id': 1}")
})
public class Candidatura implements Serializable {

    @Id
    private String id;
    @NotNull
    @DBRef
    private Vaga vaga;
    @NotNull
    @DBRef
    private Pessoa pessoa;

    private Integer score;

    public Candidatura(Pessoa pessoa, Vaga vaga) {
        this.vaga = vaga;
        this.pessoa = pessoa;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
