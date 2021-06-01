/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.TerceraBrigada;
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
public class TerceraBrigadaJpaController implements Serializable {

    public TerceraBrigadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TerceraBrigada terceraBrigada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(terceraBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TerceraBrigada terceraBrigada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            terceraBrigada = em.merge(terceraBrigada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = terceraBrigada.getIdPrimeraBrigada();
                if (findTerceraBrigada(id) == null) {
                    throw new NonexistentEntityException("The terceraBrigada with id " + id + " no longer exists.");
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
            TerceraBrigada terceraBrigada;
            try {
                terceraBrigada = em.getReference(TerceraBrigada.class, id);
                terceraBrigada.getIdPrimeraBrigada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The terceraBrigada with id " + id + " no longer exists.", enfe);
            }
            em.remove(terceraBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TerceraBrigada> findTerceraBrigadaEntities() {
        return findTerceraBrigadaEntities(true, -1, -1);
    }

    public List<TerceraBrigada> findTerceraBrigadaEntities(int maxResults, int firstResult) {
        return findTerceraBrigadaEntities(false, maxResults, firstResult);
    }

    private List<TerceraBrigada> findTerceraBrigadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TerceraBrigada.class));
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

    public TerceraBrigada findTerceraBrigada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TerceraBrigada.class, id);
        } finally {
            em.close();
        }
    }

    public int getTerceraBrigadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TerceraBrigada> rt = cq.from(TerceraBrigada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
