/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.tabla.Servicios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Soldados;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class ServiciosJpaController implements Serializable {

    public ServiciosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicios servicios) {
        if (servicios.getSoldadosList() == null) {
            servicios.setSoldadosList(new ArrayList<Soldados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Soldados> attachedSoldadosList = new ArrayList<Soldados>();
            for (Soldados soldadosListSoldadosToAttach : servicios.getSoldadosList()) {
                soldadosListSoldadosToAttach = em.getReference(soldadosListSoldadosToAttach.getClass(), soldadosListSoldadosToAttach.getIdSoldados());
                attachedSoldadosList.add(soldadosListSoldadosToAttach);
            }
            servicios.setSoldadosList(attachedSoldadosList);
            em.persist(servicios);
            for (Soldados soldadosListSoldados : servicios.getSoldadosList()) {
                soldadosListSoldados.getServiciosList().add(servicios);
                soldadosListSoldados = em.merge(soldadosListSoldados);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicios servicios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicios persistentServicios = em.find(Servicios.class, servicios.getIdServicios());
            List<Soldados> soldadosListOld = persistentServicios.getSoldadosList();
            List<Soldados> soldadosListNew = servicios.getSoldadosList();
            List<Soldados> attachedSoldadosListNew = new ArrayList<Soldados>();
            for (Soldados soldadosListNewSoldadosToAttach : soldadosListNew) {
                soldadosListNewSoldadosToAttach = em.getReference(soldadosListNewSoldadosToAttach.getClass(), soldadosListNewSoldadosToAttach.getIdSoldados());
                attachedSoldadosListNew.add(soldadosListNewSoldadosToAttach);
            }
            soldadosListNew = attachedSoldadosListNew;
            servicios.setSoldadosList(soldadosListNew);
            servicios = em.merge(servicios);
            for (Soldados soldadosListOldSoldados : soldadosListOld) {
                if (!soldadosListNew.contains(soldadosListOldSoldados)) {
                    soldadosListOldSoldados.getServiciosList().remove(servicios);
                    soldadosListOldSoldados = em.merge(soldadosListOldSoldados);
                }
            }
            for (Soldados soldadosListNewSoldados : soldadosListNew) {
                if (!soldadosListOld.contains(soldadosListNewSoldados)) {
                    soldadosListNewSoldados.getServiciosList().add(servicios);
                    soldadosListNewSoldados = em.merge(soldadosListNewSoldados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = servicios.getIdServicios();
                if (findServicios(id) == null) {
                    throw new NonexistentEntityException("The servicios with id " + id + " no longer exists.");
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
            Servicios servicios;
            try {
                servicios = em.getReference(Servicios.class, id);
                servicios.getIdServicios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicios with id " + id + " no longer exists.", enfe);
            }
            List<Soldados> soldadosList = servicios.getSoldadosList();
            for (Soldados soldadosListSoldados : soldadosList) {
                soldadosListSoldados.getServiciosList().remove(servicios);
                soldadosListSoldados = em.merge(soldadosListSoldados);
            }
            em.remove(servicios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicios> findServiciosEntities() {
        return findServiciosEntities(true, -1, -1);
    }

    public List<Servicios> findServiciosEntities(int maxResults, int firstResult) {
        return findServiciosEntities(false, maxResults, firstResult);
    }

    private List<Servicios> findServiciosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicios.class));
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

    public Servicios findServicios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicios.class, id);
        } finally {
            em.close();
        }
    }

    public int getServiciosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicios> rt = cq.from(Servicios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
