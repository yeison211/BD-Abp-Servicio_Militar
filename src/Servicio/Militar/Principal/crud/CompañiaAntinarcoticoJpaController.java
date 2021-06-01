/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.CompañiaAntinarcotico;
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
public class CompañiaAntinarcoticoJpaController implements Serializable {

    public CompañiaAntinarcoticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompañiaAntinarcotico compañiaAntinarcotico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(compañiaAntinarcotico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompañiaAntinarcotico compañiaAntinarcotico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            compañiaAntinarcotico = em.merge(compañiaAntinarcotico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compañiaAntinarcotico.getIdCompañoaAntinarcotico();
                if (findCompañiaAntinarcotico(id) == null) {
                    throw new NonexistentEntityException("The compa\u00f1iaAntinarcotico with id " + id + " no longer exists.");
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
            CompañiaAntinarcotico compañiaAntinarcotico;
            try {
                compañiaAntinarcotico = em.getReference(CompañiaAntinarcotico.class, id);
                compañiaAntinarcotico.getIdCompañoaAntinarcotico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compa\u00f1iaAntinarcotico with id " + id + " no longer exists.", enfe);
            }
            em.remove(compañiaAntinarcotico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompañiaAntinarcotico> findCompañiaAntinarcoticoEntities() {
        return findCompañiaAntinarcoticoEntities(true, -1, -1);
    }

    public List<CompañiaAntinarcotico> findCompañiaAntinarcoticoEntities(int maxResults, int firstResult) {
        return findCompañiaAntinarcoticoEntities(false, maxResults, firstResult);
    }

    private List<CompañiaAntinarcotico> findCompañiaAntinarcoticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompañiaAntinarcotico.class));
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

    public CompañiaAntinarcotico findCompañiaAntinarcotico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompañiaAntinarcotico.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompañiaAntinarcoticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompañiaAntinarcotico> rt = cq.from(CompañiaAntinarcotico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
