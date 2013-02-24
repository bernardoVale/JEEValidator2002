package br.edu.utfpr.model.dao;

import br.edu.utfpr.model.pojo.Professor;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 20:54
 */
public class ProfessorDao extends AbstractDao<Professor>{

    public ProfessorDao() {
        super(Professor.class);
    }
}
