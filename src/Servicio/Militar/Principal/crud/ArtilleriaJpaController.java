/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.Artilleria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Soldados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class ArtilleriaJpaController implements Serializable {

    public ArtilleriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Artilleria artilleria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soldados soldadosidSoldados = artilleria.getSoldadosidSoldados();
            if (soldadosidSoldados != null) {
                soldadosidSoldados = em.getReference(soldadosidSoldados.getClass(), soldadosidSoldados.getIdSoldados());
                artilleria.setSoldadosidSoldados(soldadosidSoldados);
            }
            em.persist(artilleria);
            if (soldadosidSoldados != null) {
                soldadosidSoldados.getArtilleriaList().add(artilleria);
                soldadosidSoldados = em.merge(soldadosidSoldados);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Artilleria artilleria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Artilleria persistentArtilleria = em.find(Artilleria.class, artilleria.getIdArtilleria());
            Soldados soldadosidSoldadosOld = persistentArtilleria.getSoldadosidSoldados();
            Soldados soldadosidSoldadosNew = artilleria.getSoldadosidSoldados();
            if (soldadosidSoldadosNew != null) {
                soldadosidSoldadosNew = em.getReference(soldadosidSoldadosNew.getClass(), soldadosidSoldadosNew.getIdSoldados());
                artilleria.setSoldadosidSoldados(soldadosidSoldadosNew);
            }
            artilleria = em.merge(artilleria);
            if (soldadosidSoldadosOld != null && !soldadosidSoldadosOld.equals(soldadosidSoldadosNew)) {
                soldadosidSoldadosOld.getArtilleriaList().remove(artilleria);
                soldadosidSoldadosOld = em.merge(soldadosidSoldadosOld);
            }
            if (soldadosidSoldadosNew != null && !soldadosidSoldadosNew.equals(soldadosidSoldadosOld)) {
                soldadosidSoldadosNew.getArtilleriaList().add(artilleria);
                soldadosidSoldadosNew = em.merge(soldadosidSoldadosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = artilleria.getIdArtilleria();
                if (findArtilleria(id) == null) {
                    throw new NonexistentEntityException("The artilleria with id " + id + " no longer exists.");
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
            Artilleria artilleria;
            try {
                artilleria = em.getReference(Artilleria.class, id);
                artilleria.getIdArtilleria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artilleria with id " + id + " no longer exists.", enfe);
            }
            Soldados soldadosidSoldados = artilleria.getSoldadosidSoldados();
            if (soldadosidSoldados != null) {
                soldadosidSoldados.getArtilleriaList().remove(artilleria);
                soldadosidSoldados = em.merge(soldadosidSoldados);
            }
            em.remove(artilleria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artilleria> findArtilleriaEntities() {
        return findArtilleriaEntities(true, -1, -1);
    }

    public List<Artilleria> findArtilleriaEntities(int maxResults, int firstResult) {
        return findArtilleriaEntities(false, maxResults, firstResult);
    }

    private List<Artilleria> findArtilleriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artilleria.class));
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

    public Artilleria findArtilleria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Artilleria.class, id);
        } finally {
            em.close();
        }
    }

    public int getArtilleriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Artilleria> rt = cq.from(Artilleria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
