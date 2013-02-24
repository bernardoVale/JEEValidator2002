package example;

import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;
import br.edu.utfpr.servico.ProfessorServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 21:53
 */
public class TesteWS {
    public static void main(String[] args) {
        try{
            URL url =  new URL("http://localhost:8080/jeeAtividade/ps?wsdl");
            QName qame = new QName("http://servico.utfpr.edu.br/", "ProfessorServerImplService");
            Service service = Service.create(url, qame);
            ProfessorServer prof = service.getPort(ProfessorServer.class);
            Professor[] profs = prof.returnProfessores();
            for(int i=0;i<profs.length;i++){
                System.out.printf(profs[i].toString());
            }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        try{
            URL url =  new URL("http://localhost:8080/jeeAtividade/ps?wsdl");
            QName qame = new QName("http://servico.utfpr.edu.br/", "ProfessorServerImplService");
            Service service = Service.create(url,qame);
            ProfessorServer prof = service.getPort(ProfessorServer.class);
            Disciplina[] disciplinas = prof.returnDisciplinaByProfessor(new Professor(2L));
            for(int i=0;i<disciplinas.length;i++){
                System.out.printf(disciplinas[i].toString());
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
