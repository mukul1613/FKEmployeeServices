/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EvaEmployeeDetails;
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
public class EvaEmployeeDetailsJpaController implements Serializable {

    
    public EvaEmployeeDetailsJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    public EvaEmployeeDetailsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaEmployeeDetails evaEmployeeDetails) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(evaEmployeeDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEvaEmployeeDetails(evaEmployeeDetails.getEmail()) != null) {
                throw new PreexistingEntityException("EvaEmployeeDetails " + evaEmployeeDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EvaEmployeeDetails evaEmployeeDetails) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            evaEmployeeDetails = em.merge(evaEmployeeDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = evaEmployeeDetails.getEmail();
                if (findEvaEmployeeDetails(id) == null) {
                    throw new NonexistentEntityException("The evaEmployeeDetails with id " + id + " no longer exists.");
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
            EvaEmployeeDetails evaEmployeeDetails;
            try {
                evaEmployeeDetails = em.getReference(EvaEmployeeDetails.class, id);
                evaEmployeeDetails.getEmail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaEmployeeDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(evaEmployeeDetails);
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

    public List<EvaEmployeeDetails> findEvaEmployeeDetailsEntities() {
        return findEvaEmployeeDetailsEntities(true, -1, -1);
    }

    public List<EvaEmployeeDetails> findEvaEmployeeDetailsEntities(int maxResults, int firstResult) {
        return findEvaEmployeeDetailsEntities(false, maxResults, firstResult);
    }

    private List<EvaEmployeeDetails> findEvaEmployeeDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EvaEmployeeDetails.class));
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

    public EvaEmployeeDetails findEvaEmployeeDetails(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EvaEmployeeDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvaEmployeeDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EvaEmployeeDetails> rt = cq.from(EvaEmployeeDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
