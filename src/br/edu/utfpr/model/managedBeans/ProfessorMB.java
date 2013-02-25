package br.edu.utfpr.model.managedBeans;

import br.edu.utfpr.model.ejb.ProfessorBean;
import br.edu.utfpr.model.pojo.Professor;

import javax.ejb.EJB;

/**
 * @author Bernardo Vale
 *         Date: 16/12/12
 *         Time: 12:23
 */
public class ProfessorMB {

    private Professor professor = new Professor();
    @EJB
    private ProfessorBean bean;

    public void salvar(){
        bean.salvar(professor);
        professor = new Professor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
