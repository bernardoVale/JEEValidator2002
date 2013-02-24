package br.edu.utfpr.servico;

import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Bernardo Vale
 *         Date: 22/12/12
 *         Time: 10:34
 */
@WebService(endpointInterface = "br.edu.utfpr.servico.ProfessorServer")
public class ProfessorServerImpl implements ProfessorServer {


    @WebMethod
    public Disciplina[] returnDisciplinaByProfessor(Professor p) {
        ProfessorDao dao = new ProfessorDao();
        List<Disciplina> disciplinas = dao.findByID(p.getId()).getDisciplinasMinistrantes();
        Disciplina[] disciplinasArray = new Disciplina[disciplinas.size()];
        int i = 0;
        for(Disciplina d : disciplinas){
            disciplinasArray[i] = d;
            i++;
        }
        return disciplinasArray;
    }

    @WebMethod
    public Professor[] returnProfessores() {
        ProfessorDao dao = new ProfessorDao();
        List<Professor> p = dao.findAll();
        Professor[] professores = new Professor[p.size()];
        int i=0;
        for(Professor prof : p){
            professores[i] = prof;
            i++;
        }
        return professores;
    }
}
