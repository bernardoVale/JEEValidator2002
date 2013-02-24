package br.edu.utfpr.model.managedBeans;

import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Professor;

/**
 * @author Bernardo Vale
 *         Date: 16/12/12
 *         Time: 12:23
 */
public class ProfessorBean {

    private Professor professor = new Professor();

    private ProfessorDao dao = new ProfessorDao();

    public void salvar(){
        professor = dao.save(professor);
        professor = new Professor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
