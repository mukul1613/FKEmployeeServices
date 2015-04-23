/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EvaNotifications;
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
public class EvaNotificationsJpaController implements Serializable {

    public EvaNotificationsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EvaNotificationsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EvaNotifications evaNotifications) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(evaNotifications);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEvaNotifications(evaNotifications.getEmail()) != null) {
                throw new PreexistingEntityException("EvaNotifications " + evaNotifications + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EvaNotifications evaNotifications) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            evaNotifications = em.merge(evaNotifications);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = evaNotifications.getEmail();
                if (findEvaNotifications(id) == null) {
                    throw new NonexistentEntityException("The evaNotifications with id " + id + " no longer exists.");
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
            EvaNotifications evaNotifications;
            try {
                evaNotifications = em.getReference(EvaNotifications.class, id);
                evaNotifications.getEmail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evaNotifications with id " + id + " no longer exists.", enfe);
            }
            em.remove(evaNotifications);
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

    public List<EvaNotifications> findEvaNotificationsEntities() {
        return findEvaNotificationsEntities(true, -1, -1);
    }

    public List<EvaNotifications> findEvaNotificationsEntities(int maxResults, int firstResult) {
        return findEvaNotificationsEntities(false, maxResults, firstResult);
    }

    private List<EvaNotifications> findEvaNotificationsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EvaNotifications.class));
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

    public EvaNotifications findEvaNotifications(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EvaNotifications.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvaNotificationsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EvaNotifications> rt = cq.from(EvaNotifications.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
