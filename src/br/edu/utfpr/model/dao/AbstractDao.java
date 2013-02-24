package br.edu.utfpr.model.dao;

import br.edu.utfpr.controller.PersistenceGetter;
import br.edu.utfpr.model.pojo.IPojo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Dao abstrato.
 *
 * @author Bernardo Vale
 */
public abstract class AbstractDao<T extends IPojo> {

  private EntityManager em = PersistenceGetter.getManager();
  private final Class<T> clazz;

  public AbstractDao(Class<T> clazz) {
    this.clazz = clazz;
  }

  /**
   * Pega a instancia do entity manager.
   *
   * @return instance de EM.
   */
  protected final EntityManager em() {
    return em;
  }

  private void end(T t){
      end();
      em.refresh(t);
  }
    private void end(){
        em.getTransaction().commit();
    }
  private void start(){
      if(em.getTransaction().
      isActive()){end();}
      em.getTransaction().begin();
  }
  /**
   * Salva o objeto no banco.
   * Trata internamente o Persist/Update.
   *
   * @param t objeto a ser salvo.
   * @return objeto atualizado.
   */
  public T save(T t) {
    start();
    if (t != null && t.getId() != null) {
      t = em().merge(t);
      em().flush();
      return t;
    }
    em().persist(t);
    end(t);
    return t;
  }
    public T findByKeyAtribute(String key,String keyValue){
      return (T) em().createQuery("Select t from " +
              "" + clazz.getSimpleName() + " t where t."+key+"='"+keyValue+"'",clazz)
        .getSingleResult();
    }

    /**
     * Metodo so para atualizaçao. Foi necessario utiliza-lo fora do save para que
     * as classes que sao tabelas associativas pudessem atiliza-los sem que precisassem
     * ter uma id unica.
     * @param t objeto
     * @return objeto atualizado
     */
  public T update(T t) {
      t = em().merge(t);
      em().flush();
      return t;
  }


  /**
   * Carrega um objeto do banco a partir de seu ID.
   *
   * @param id id do objeto
   * @return objeto carregado.
   */
  public T findByID(Long id) {
    start();
    return em().find(clazz, id);
  }

  /**
   * Apaga um registro do banco.
   *
   * @param t Objeto a ser excluido.
   */
  public void remove(T t) {
    em().remove(t.getId() != null ? em().merge(t) : t);
  }

  /**
   * Retorna uma lista com todos os objetos do tipo T do banco.
   *
   * @return
   */
  public List<T> findAll() {
    TypedQuery<T> query = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
    return query.getResultList();
  }
}
