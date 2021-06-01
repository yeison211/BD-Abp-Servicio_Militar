/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.SegundaBrigada;
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
public class SegundaBrigadaJpaController implements Serializable {

    public SegundaBrigadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SegundaBrigada segundaBrigada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(segundaBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SegundaBrigada segundaBrigada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            segundaBrigada = em.merge(segundaBrigada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = segundaBrigada.getIdSegundaBrigada();
                if (findSegundaBrigada(id) == null) {
                    throw new NonexistentEntityException("The segundaBrigada with id " + id + " no longer exists.");
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
            SegundaBrigada segundaBrigada;
            try {
                segundaBrigada = em.getReference(SegundaBrigada.class, id);
                segundaBrigada.getIdSegundaBrigada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The segundaBrigada with id " + id + " no longer exists.", enfe);
            }
            em.remove(segundaBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SegundaBrigada> findSegundaBrigadaEntities() {
        return findSegundaBrigadaEntities(true, -1, -1);
    }

    public List<SegundaBrigada> findSegundaBrigadaEntities(int maxResults, int firstResult) {
        return findSegundaBrigadaEntities(false, maxResults, firstResult);
    }

    private List<SegundaBrigada> findSegundaBrigadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SegundaBrigada.class));
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

    public SegundaBrigada findSegundaBrigada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SegundaBrigada.class, id);
        } finally {
            em.close();
        }
    }

    public int getSegundaBrigadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SegundaBrigada> rt = cq.from(SegundaBrigada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
