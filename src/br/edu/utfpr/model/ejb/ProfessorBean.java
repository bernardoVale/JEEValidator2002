package br.edu.utfpr.model.ejb;

import br.edu.utfpr.model.pojo.Professor;

/**
 * @author Bernardo Vale
 *         Date: 25/02/13
 *         Time: 19:15
 */
public interface ProfessorBean {

    public void salvar(Professor p);
    public Professor getProfessor(Long id);
}
