package br.edu.utfpr.model.ejb;

import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 25/02/13
 *         Time: 18:41
 */
public interface DisciplinaBean {

    public void save(Disciplina disciplina,Long prof_id);

    public List<Professor> getProfessores();
}
