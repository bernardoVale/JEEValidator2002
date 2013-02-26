package br.edu.utfpr.model.ejb;

import br.edu.utfpr.model.dao.DisciplinaDao;
import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 25/02/13
 *         Time: 18:47
 */
@Stateless
@Local(DisciplinaBean.class)
public class DisciplinaBeanImpl implements DisciplinaBean{

    private DisciplinaDao dao = new DisciplinaDao();
    private ProfessorDao daoP = new ProfessorDao();

    @Override
    public void save(Disciplina disciplina,Long prof_id) {
        Professor p = daoP.findByID(prof_id);
        disciplina.setProfessor(p);
        dao.save(disciplina);

    }

    @Override
    public List<Professor> getProfessores() {
        return daoP.findAll();
    }
}
