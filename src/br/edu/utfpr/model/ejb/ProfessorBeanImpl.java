package br.edu.utfpr.model.ejb;

import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Professor;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * @author Bernardo Vale
 *         Date: 25/02/13
 *         Time: 19:19
 */
@Stateless
@Local(ProfessorBean.class)
public class ProfessorBeanImpl implements ProfessorBean{

    private ProfessorDao dao = new ProfessorDao();

    @Override
    public void salvar(Professor p){
        dao.save(p);
    }

    @Override
    public Professor getProfessor(Long id) {
        return dao.findByID(id);
    }
}
