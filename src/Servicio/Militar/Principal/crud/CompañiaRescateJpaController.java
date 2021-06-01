/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.CompañiaRescate;
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
 * @author PC
 */
public class CompañiaRescateJpaController implements Serializable {

    public CompañiaRescateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompañiaRescate compañiaRescate) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(compañiaRescate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompañiaRescate compañiaRescate) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            compañiaRescate = em.merge(compañiaRescate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compañiaRescate.getIdCompañiaRescate();
                if (findCompañiaRescate(id) == null) {
                    throw new NonexistentEntityException("The compa\u00f1iaRescate with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CompañiaRescate compañiaRescate;
            try {
                compañiaRescate = em.getReference(CompañiaRescate.class, id);
                compañiaRescate.getIdCompañiaRescate();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compa\u00f1iaRescate with id " + id + " no longer exists.", enfe);
            }
            em.remove(compañiaRescate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompañiaRescate> findCompañiaRescateEntities() {
        return findCompañiaRescateEntities(true, -1, -1);
    }

    public List<CompañiaRescate> findCompañiaRescateEntities(int maxResults, int firstResult) {
        return findCompañiaRescateEntities(false, maxResults, firstResult);
    }

    private List<CompañiaRescate> findCompañiaRescateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompañiaRescate.class));
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

    public CompañiaRescate findCompañiaRescate(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompañiaRescate.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompañiaRescateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompañiaRescate> rt = cq.from(CompañiaRescate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
