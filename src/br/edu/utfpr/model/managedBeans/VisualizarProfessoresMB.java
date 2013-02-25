package br.edu.utfpr.model.managedBeans;

import br.edu.utfpr.model.dao.DisciplinaDao;
import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.ejb.ProfessorBean;
import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 24/12/12
 *         Time: 16:12
 */
public class VisualizarProfessoresMB {

    private DisciplinaDao disciplinaDao = new DisciplinaDao();
    private ProfessorDao professorDao = new ProfessorDao();
    private Long currentProfessor = 0L;
    private List<SelectItem> professorList = getProfessores();
    private List<Disciplina> disciplinasList = new ArrayList<Disciplina>();
    @EJB
    private ProfessorBean bean;

    public List<Disciplina> getDisciplinasList() {
        return disciplinasList;
    }

    public void buscar(){
        disciplinasList = bean.getProfessor(currentProfessor).getDisciplinasMinistrantes();
    }
    public Long getCurrentProfessor() {
        return currentProfessor;
    }

    public void setCurrentProfessor(Long currentProfessor) {
        this.currentProfessor = currentProfessor;
    }

    public List<SelectItem> getProfessorList() {
        return professorList;
    }

    public List<SelectItem> getProfessores() {
        List<SelectItem> professores = new ArrayList<SelectItem>();
        List<Professor> profs = professorDao.findAll();
        for(Professor p : profs){
            professores.add(new SelectItem(p.getId(),p.getNome()));
        }
        return professores;
    }
}
