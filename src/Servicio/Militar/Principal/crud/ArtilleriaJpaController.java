/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
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

    public void create(Artilleria artilleria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soldados soldadosid = artilleria.getSoldadosid();
            if (soldadosid != null) {
                soldadosid = em.getReference(soldadosid.getClass(), soldadosid.getId());
                artilleria.setSoldadosid(soldadosid);
            }
            em.persist(artilleria);
            if (soldadosid != null) {
                soldadosid.getArtilleriaList().add(artilleria);
                soldadosid = em.merge(soldadosid);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArtilleria(artilleria.getIdArtilleria()) != null) {
                throw new PreexistingEntityException("Artilleria " + artilleria + " already exists.", ex);
            }
            throw ex;
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
            Soldados soldadosidOld = persistentArtilleria.getSoldadosid();
            Soldados soldadosidNew = artilleria.getSoldadosid();
            if (soldadosidNew != null) {
                soldadosidNew = em.getReference(soldadosidNew.getClass(), soldadosidNew.getId());
                artilleria.setSoldadosid(soldadosidNew);
            }
            artilleria = em.merge(artilleria);
            if (soldadosidOld != null && !soldadosidOld.equals(soldadosidNew)) {
                soldadosidOld.getArtilleriaList().remove(artilleria);
                soldadosidOld = em.merge(soldadosidOld);
            }
            if (soldadosidNew != null && !soldadosidNew.equals(soldadosidOld)) {
                soldadosidNew.getArtilleriaList().add(artilleria);
                soldadosidNew = em.merge(soldadosidNew);
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
            Soldados soldadosid = artilleria.getSoldadosid();
            if (soldadosid != null) {
                soldadosid.getArtilleriaList().remove(artilleria);
                soldadosid = em.merge(soldadosid);
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
