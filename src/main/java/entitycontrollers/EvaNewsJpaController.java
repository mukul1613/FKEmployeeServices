/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EvaNews;
import entitycontrollers.exceptions.NonexistentEntityException;
import entitycontrollers.exceptions.PreexistingEntityException;
import entitycontrollers.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author mukul.kumar
 */
public class EvaNewsJpaController implements Serializable {

     public EvaNewsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
     }
     
    public EvaNewsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaNews evaNews) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(evaNews);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEvaNews(evaNews.getEmailId()) != null) {
                throw new PreexistingEntityException("EvaNews " + evaNews + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EvaNews evaNews) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            evaNews = em.merge(evaNews);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = evaNews.getEmailId();
                if (findEvaNews(id) == null) {
                    throw new NonexistentEntityException("The evaNews with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            EvaNews evaNews;
            try {
                evaNews = em.getReference(EvaNews.class, id);
                evaNews.getEmailId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaNews with id " + id + " no longer exists.", enfe);
            }
            em.remove(evaNews);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EvaNews> findEvaNewsEntities() {
        return findEvaNewsEntities(true, -1, -1);
    }

    public List<EvaNews> findEvaNewsEntities(int maxResults, int firstResult) {
        return findEvaNewsEntities(false, maxResults, firstResult);
    }

    private List<EvaNews> findEvaNewsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EvaNews.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EvaNews findEvaNews(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EvaNews.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvaNewsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EvaNews> rt = cq.from(EvaNews.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
