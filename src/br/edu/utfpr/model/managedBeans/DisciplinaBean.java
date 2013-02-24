package br.edu.utfpr.model.managedBeans;

import br.edu.utfpr.model.dao.DisciplinaDao;
import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 24/12/12
 *         Time: 15:13
 */
public class DisciplinaBean {

    private Disciplina disciplina = new Disciplina();
    private Long currentProfessor = 0L;
    private DisciplinaDao dao = new DisciplinaDao();
    private ProfessorDao daoP = new ProfessorDao();
    private List<SelectItem> professorList = getProfessores();

    public void save(){
        Professor p = daoP.findByID(getCurrentProfessor());
        disciplina.setProfessor(p);
        dao.save(disciplina);
        disciplina = new Disciplina();
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        for(Professor p : daoP.findAll()){
            professores.add(new SelectItem(p.getId(),p.getNome()));
        }
        return professores;
    }
}

