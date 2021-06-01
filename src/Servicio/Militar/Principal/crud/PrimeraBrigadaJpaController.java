/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.PrimeraBrigada;
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
public class PrimeraBrigadaJpaController implements Serializable {

    public PrimeraBrigadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PrimeraBrigada primeraBrigada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(primeraBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PrimeraBrigada primeraBrigada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            primeraBrigada = em.merge(primeraBrigada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = primeraBrigada.getIdPrimeraBrigada();
                if (findPrimeraBrigada(id) == null) {
                    throw new NonexistentEntityException("The primeraBrigada with id " + id + " no longer exists.");
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
            PrimeraBrigada primeraBrigada;
            try {
                primeraBrigada = em.getReference(PrimeraBrigada.class, id);
                primeraBrigada.getIdPrimeraBrigada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The primeraBrigada with id " + id + " no longer exists.", enfe);
            }
            em.remove(primeraBrigada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PrimeraBrigada> findPrimeraBrigadaEntities() {
        return findPrimeraBrigadaEntities(true, -1, -1);
    }

    public List<PrimeraBrigada> findPrimeraBrigadaEntities(int maxResults, int firstResult) {
        return findPrimeraBrigadaEntities(false, maxResults, firstResult);
    }

    private List<PrimeraBrigada> findPrimeraBrigadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PrimeraBrigada.class));
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

    public PrimeraBrigada findPrimeraBrigada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PrimeraBrigada.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrimeraBrigadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PrimeraBrigada> rt = cq.from(PrimeraBrigada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
