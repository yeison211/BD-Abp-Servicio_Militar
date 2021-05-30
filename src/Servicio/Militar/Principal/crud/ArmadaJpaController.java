/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import Servicio.Militar.Principal.tabla.Armada;
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
public class ArmadaJpaController implements Serializable {

    public ArmadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Armada armada) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soldados soldadosid = armada.getSoldadosid();
            if (soldadosid != null) {
                soldadosid = em.getReference(soldadosid.getClass(), soldadosid.getId());
                armada.setSoldadosid(soldadosid);
            }
            em.persist(armada);
            if (soldadosid != null) {
                soldadosid.getArmadaList().add(armada);
                soldadosid = em.merge(soldadosid);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArmada(armada.getIdArmada()) != null) {
                throw new PreexistingEntityException("Armada " + armada + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Armada armada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Armada persistentArmada = em.find(Armada.class, armada.getIdArmada());
            Soldados soldadosidOld = persistentArmada.getSoldadosid();
            Soldados soldadosidNew = armada.getSoldadosid();
            if (soldadosidNew != null) {
                soldadosidNew = em.getReference(soldadosidNew.getClass(), soldadosidNew.getId());
                armada.setSoldadosid(soldadosidNew);
            }
            armada = em.merge(armada);
            if (soldadosidOld != null && !soldadosidOld.equals(soldadosidNew)) {
                soldadosidOld.getArmadaList().remove(armada);
                soldadosidOld = em.merge(soldadosidOld);
            }
            if (soldadosidNew != null && !soldadosidNew.equals(soldadosidOld)) {
                soldadosidNew.getArmadaList().add(armada);
                soldadosidNew = em.merge(soldadosidNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = armada.getIdArmada();
                if (findArmada(id) == null) {
                    throw new NonexistentEntityException("The armada with id " + id + " no longer exists.");
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
            Armada armada;
            try {
                armada = em.getReference(Armada.class, id);
                armada.getIdArmada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The armada with id " + id + " no longer exists.", enfe);
            }
            Soldados soldadosid = armada.getSoldadosid();
            if (soldadosid != null) {
                soldadosid.getArmadaList().remove(armada);
                soldadosid = em.merge(soldadosid);
            }
            em.remove(armada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Armada> findArmadaEntities() {
        return findArmadaEntities(true, -1, -1);
    }

    public List<Armada> findArmadaEntities(int maxResults, int firstResult) {
        return findArmadaEntities(false, maxResults, firstResult);
    }

    private List<Armada> findArmadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Armada.class));
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

    public Armada findArmada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Armada.class, id);
        } finally {
            em.close();
        }
    }

    public int getArmadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Armada> rt = cq.from(Armada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
