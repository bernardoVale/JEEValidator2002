package br.edu.utfpr.model.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 19:28
 */
@Entity
@SequenceGenerator(allocationSize = 1, name = "professorGenerator", sequenceName = "professor_s")
public class Professor implements IPojo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorGenerator")
    private Long id;
    private String nome;
    private String cpf;
    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinasMinistrantes = new ArrayList<Disciplina>();


    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public List<Disciplina> getDisciplinasMinistrantes() {
        return disciplinasMinistrantes;
    }

    public Professor(Long id) {
        this.id = id;
    }

    public Professor() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", disciplinasMinistrantes=" + disciplinasMinistrantes +
                '}';
    }
}
