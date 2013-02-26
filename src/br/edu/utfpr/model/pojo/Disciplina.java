package br.edu.utfpr.model.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 19:30
 */
@Entity
@SequenceGenerator(allocationSize = 1, name = "disciplina_s", sequenceName = "disciplina_s")
public class Disciplina implements IPojo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_s")
    private Long id;

    @NotNull(message = "Não pode ser nulo")
    @Size(min = 4, max=30, message = "{sizeName}")
    private String nome;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Professor professor;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina() {
    }

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
