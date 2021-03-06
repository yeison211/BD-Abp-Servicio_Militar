/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.Infanteria;
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
public class InfanteriaJpaController implements Serializable {

    public InfanteriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Infanteria infanteria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(infanteria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Infanteria infanteria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infanteria = em.merge(infanteria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infanteria.getIdInfanteria();
                if (findInfanteria(id) == null) {
                    throw new NonexistentEntityException("The infanteria with id " + id + " no longer exists.");
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
            Infanteria infanteria;
            try {
                infanteria = em.getReference(Infanteria.class, id);
                infanteria.getIdInfanteria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infanteria with id " + id + " no longer exists.", enfe);
            }
            em.remove(infanteria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Infanteria> findInfanteriaEntities() {
        return findInfanteriaEntities(true, -1, -1);
    }

    public List<Infanteria> findInfanteriaEntities(int maxResults, int firstResult) {
        return findInfanteriaEntities(false, maxResults, firstResult);
    }

    private List<Infanteria> findInfanteriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Infanteria.class));
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

    public Infanteria findInfanteria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Infanteria.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfanteriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Infanteria> rt = cq.from(Infanteria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
