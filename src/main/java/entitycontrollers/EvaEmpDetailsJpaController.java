/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EvaEmpDetails;
import ApplicationSpecificClasses.exceptions.NonexistentEntityException;
import ApplicationSpecificClasses.exceptions.PreexistingEntityException;
import ApplicationSpecificClasses.exceptions.RollbackFailureException;
//import dbentity.EvaEmpDetails;
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
public class EvaEmpDetailsJpaController implements Serializable {

    public EvaEmpDetailsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EvaEmpDetailsJpaController(EntityManagerFactory createEntityManagerFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaEmpDetails evaEmpDetails) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(evaEmpDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEvaEmpDetails(evaEmpDetails.getId()) != null) {
                throw new PreexistingEntityException("EvaEmpDetails " + evaEmpDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EvaEmpDetails evaEmpDetails) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            evaEmpDetails = em.merge(evaEmpDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = evaEmpDetails.getId();
                if (findEvaEmpDetails(id) == null) {
                    throw new NonexistentEntityException("The evaEmpDetails with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            EvaEmpDetails evaEmpDetails;
            try {
                evaEmpDetails = em.getReference(EvaEmpDetails.class, id);
                evaEmpDetails.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaEmpDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(evaEmpDetails);
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

    public List<EvaEmpDetails> findEvaEmpDetailsEntities() {
        return findEvaEmpDetailsEntities(true, -1, -1);
    }

    public List<EvaEmpDetails> findEvaEmpDetailsEntities(int maxResults, int firstResult) {
        return findEvaEmpDetailsEntities(false, maxResults, firstResult);
    }

    private List<EvaEmpDetails> findEvaEmpDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EvaEmpDetails.class));
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

    public EvaEmpDetails findEvaEmpDetails(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EvaEmpDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvaEmpDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EvaEmpDetails> rt = cq.from(EvaEmpDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
