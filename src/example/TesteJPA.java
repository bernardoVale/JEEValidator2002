package example;


import br.edu.utfpr.model.dao.DisciplinaDao;
import br.edu.utfpr.model.dao.ProfessorDao;
import br.edu.utfpr.model.pojo.Disciplina;
import br.edu.utfpr.model.pojo.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 20:01
 */
public class TesteJPA {

    public static void main(String[] args) {
        ProfessorDao d = new ProfessorDao();
        DisciplinaDao dd = new DisciplinaDao();
        String PERSISTENCE_UNIT_NAME = "jee1912";
        EntityManagerFactory factory;
        EntityManager em;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();

        Professor p = em.find(Professor.class,9L);
        Disciplina disciplina = new Disciplina("largfudencio",p);
        em.persist(disciplina);
        em.getTransaction().commit();
        em.refresh(p);
        p = em.find(Professor.class,9L);
        em.close();
                                      /*
        List<Disciplina> dis = p.getDisciplinasMinistrantes();
        p = d.findByID(p.getId());
        List<Disciplina> disciplinas = p.getDisciplinasMinistrantes();
        System.out.printf(disciplinas.toString());      */

    }
}
