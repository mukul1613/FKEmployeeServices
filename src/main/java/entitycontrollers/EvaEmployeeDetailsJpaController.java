/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EvaEmployeeDetails;
import entitycontrollers.exceptions.NonexistentEntityException;
import entitycontrollers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mukul.kumar
 */
public class EvaEmployeeDetailsJpaController implements Serializable {

    public EvaEmployeeDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaEmployeeDetails evaEmployeeDetails) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(evaEmployeeDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
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

    public void edit(EvaEmployeeDetails evaEmployeeDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            evaEmployeeDetails = em.merge(evaEmployeeDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
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

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EvaEmployeeDetails evaEmployeeDetails;
            try {
                evaEmployeeDetails = em.getReference(EvaEmployeeDetails.class, id);
                evaEmployeeDetails.getEmail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaEmployeeDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(evaEmployeeDetails);
            em.getTransaction().commit();
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
