package br.edu.utfpr.servico;

import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author Bernardo Vale
 *         Date: 22/12/12
 *         Time: 10:33
 */
@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT
,use=SOAPBinding.Use.LITERAL,
parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public interface ProfessorServer {

    @WebMethod
    public Disciplina[] returnDisciplinaByProfessor(Professor p);
    @WebMethod
    public Professor[] returnProfessores();
}
