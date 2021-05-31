/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Compañia;
import Servicio.Militar.Principal.tabla.Cuarteles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class CuartelesJpaController implements Serializable {

    public CuartelesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cuarteles cuarteles) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compañia compañiaidCompañia = cuarteles.getCompañiaidCompañia();
            if (compañiaidCompañia != null) {
                compañiaidCompañia = em.getReference(compañiaidCompañia.getClass(), compañiaidCompañia.getIdCompañia());
                cuarteles.setCompañiaidCompañia(compañiaidCompañia);
            }
            em.persist(cuarteles);
            if (compañiaidCompañia != null) {
                compañiaidCompañia.getCuartelesList().add(cuarteles);
                compañiaidCompañia = em.merge(compañiaidCompañia);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cuarteles cuarteles) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuarteles persistentCuarteles = em.find(Cuarteles.class, cuarteles.getIdCuarteles());
            Compañia compañiaidCompañiaOld = persistentCuarteles.getCompañiaidCompañia();
            Compañia compañiaidCompañiaNew = cuarteles.getCompañiaidCompañia();
            if (compañiaidCompañiaNew != null) {
                compañiaidCompañiaNew = em.getReference(compañiaidCompañiaNew.getClass(), compañiaidCompañiaNew.getIdCompañia());
                cuarteles.setCompañiaidCompañia(compañiaidCompañiaNew);
            }
            cuarteles = em.merge(cuarteles);
            if (compañiaidCompañiaOld != null && !compañiaidCompañiaOld.equals(compañiaidCompañiaNew)) {
                compañiaidCompañiaOld.getCuartelesList().remove(cuarteles);
                compañiaidCompañiaOld = em.merge(compañiaidCompañiaOld);
            }
            if (compañiaidCompañiaNew != null && !compañiaidCompañiaNew.equals(compañiaidCompañiaOld)) {
                compañiaidCompañiaNew.getCuartelesList().add(cuarteles);
                compañiaidCompañiaNew = em.merge(compañiaidCompañiaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cuarteles.getIdCuarteles();
                if (findCuarteles(id) == null) {
                    throw new NonexistentEntityException("The cuarteles with id " + id + " no longer exists.");
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
            Cuarteles cuarteles;
            try {
                cuarteles = em.getReference(Cuarteles.class, id);
                cuarteles.getIdCuarteles();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuarteles with id " + id + " no longer exists.", enfe);
            }
            Compañia compañiaidCompañia = cuarteles.getCompañiaidCompañia();
            if (compañiaidCompañia != null) {
                compañiaidCompañia.getCuartelesList().remove(cuarteles);
                compañiaidCompañia = em.merge(compañiaidCompañia);
            }
            em.remove(cuarteles);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuarteles> findCuartelesEntities() {
        return findCuartelesEntities(true, -1, -1);
    }

    public List<Cuarteles> findCuartelesEntities(int maxResults, int firstResult) {
        return findCuartelesEntities(false, maxResults, firstResult);
    }

    private List<Cuarteles> findCuartelesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuarteles.class));
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

    public Cuarteles findCuarteles(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuarteles.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuartelesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuarteles> rt = cq.from(Cuarteles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
