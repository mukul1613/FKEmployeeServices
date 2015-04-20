/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import dbentity.EmployeeDetails;
import entitycontrollers.exceptions.NonexistentEntityException;
import entitycontrollers.exceptions.PreexistingEntityException;
import entitycontrollers.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsJpaController implements Serializable {

    public EmployeeDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EmployeeDetailsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmployeeDetails employeeDetails) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(employeeDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEmployeeDetails(employeeDetails.getId()) != null) {
                throw new PreexistingEntityException("EmployeeDetails " + employeeDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmployeeDetails employeeDetails) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            employeeDetails = em.merge(employeeDetails);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = employeeDetails.getId();
                if (findEmployeeDetails(id) == null) {
                    throw new NonexistentEntityException("The employeeDetails with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            EmployeeDetails employeeDetails;
            try {
                employeeDetails = em.getReference(EmployeeDetails.class, id);
                employeeDetails.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employeeDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(employeeDetails);
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

    public List<EmployeeDetails> findEmployeeDetailsEntities() {
        return findEmployeeDetailsEntities(true, -1, -1);
    }

    public List<EmployeeDetails> findEmployeeDetailsEntities(int maxResults, int firstResult) {
        return findEmployeeDetailsEntities(false, maxResults, firstResult);
    }

    private List<EmployeeDetails> findEmployeeDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmployeeDetails.class));
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

    public EmployeeDetails findEmployeeDetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmployeeDetails.class, id);
        } finally {
            em.close();
        }
    }
    
    //named query for email - employee detail mapping
    public EmployeeDetails findEmployeeDetails(String email) {
        EntityManager em = getEntityManager();
        TypedQuery<EmployeeDetails> query;
        try {
           query  = em.createNamedQuery("EmployeeDetails.findByEmpEmailid", EmployeeDetails.class);
           query.setParameter("empEmailid", email);
           List<EmployeeDetails> list = query.getResultList();
           return list.size()>0?list.get(0):null;
        } finally {
            em.close();
        }
    }
    

    public int getEmployeeDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmployeeDetails> rt = cq.from(EmployeeDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
