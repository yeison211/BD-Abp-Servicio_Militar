/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import Servicio.Militar.Principal.tabla.Soldados;
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
public class SoldadosJpaController implements Serializable {

    public SoldadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Soldados soldados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(soldados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSoldados(soldados.getIdSoldados()) != null) {
                throw new PreexistingEntityException("Soldados " + soldados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Soldados soldados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            soldados = em.merge(soldados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = soldados.getIdSoldados();
                if (findSoldados(id) == null) {
                    throw new NonexistentEntityException("The soldados with id " + id + " no longer exists.");
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
            Soldados soldados;
            try {
                soldados = em.getReference(Soldados.class, id);
                soldados.getIdSoldados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The soldados with id " + id + " no longer exists.", enfe);
            }
            em.remove(soldados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Soldados> findSoldadosEntities() {
        return findSoldadosEntities(true, -1, -1);
    }

    public List<Soldados> findSoldadosEntities(int maxResults, int firstResult) {
        return findSoldadosEntities(false, maxResults, firstResult);
    }

    private List<Soldados> findSoldadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Soldados.class));
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

    public Soldados findSoldados(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Soldados.class, id);
        } finally {
            em.close();
        }
    }

    public int getSoldadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Soldados> rt = cq.from(Soldados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
