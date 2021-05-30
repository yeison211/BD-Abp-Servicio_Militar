/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Servicios;
import Servicio.Militar.Principal.tabla.Soldados;
import Servicio.Militar.Principal.tabla.SolicitarServicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class SolicitarServicioJpaController implements Serializable {

    public SolicitarServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitarServicio solicitarServicio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicios serviciosidServicios = solicitarServicio.getServiciosidServicios();
            if (serviciosidServicios != null) {
                serviciosidServicios = em.getReference(serviciosidServicios.getClass(), serviciosidServicios.getIdServicios());
                solicitarServicio.setServiciosidServicios(serviciosidServicios);
            }
            Soldados soldadosid = solicitarServicio.getSoldadosid();
            if (soldadosid != null) {
                soldadosid = em.getReference(soldadosid.getClass(), soldadosid.getId());
                solicitarServicio.setSoldadosid(soldadosid);
            }
            em.persist(solicitarServicio);
            if (serviciosidServicios != null) {
                serviciosidServicios.getSolicitarServicioList().add(solicitarServicio);
                serviciosidServicios = em.merge(serviciosidServicios);
            }
            if (soldadosid != null) {
                soldadosid.getSolicitarServicioList().add(solicitarServicio);
                soldadosid = em.merge(soldadosid);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSolicitarServicio(solicitarServicio.getId()) != null) {
                throw new PreexistingEntityException("SolicitarServicio " + solicitarServicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitarServicio solicitarServicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitarServicio persistentSolicitarServicio = em.find(SolicitarServicio.class, solicitarServicio.getId());
            Servicios serviciosidServiciosOld = persistentSolicitarServicio.getServiciosidServicios();
            Servicios serviciosidServiciosNew = solicitarServicio.getServiciosidServicios();
            Soldados soldadosidOld = persistentSolicitarServicio.getSoldadosid();
            Soldados soldadosidNew = solicitarServicio.getSoldadosid();
            if (serviciosidServiciosNew != null) {
                serviciosidServiciosNew = em.getReference(serviciosidServiciosNew.getClass(), serviciosidServiciosNew.getIdServicios());
                solicitarServicio.setServiciosidServicios(serviciosidServiciosNew);
            }
            if (soldadosidNew != null) {
                soldadosidNew = em.getReference(soldadosidNew.getClass(), soldadosidNew.getId());
                solicitarServicio.setSoldadosid(soldadosidNew);
            }
            solicitarServicio = em.merge(solicitarServicio);
            if (serviciosidServiciosOld != null && !serviciosidServiciosOld.equals(serviciosidServiciosNew)) {
                serviciosidServiciosOld.getSolicitarServicioList().remove(solicitarServicio);
                serviciosidServiciosOld = em.merge(serviciosidServiciosOld);
            }
            if (serviciosidServiciosNew != null && !serviciosidServiciosNew.equals(serviciosidServiciosOld)) {
                serviciosidServiciosNew.getSolicitarServicioList().add(solicitarServicio);
                serviciosidServiciosNew = em.merge(serviciosidServiciosNew);
            }
            if (soldadosidOld != null && !soldadosidOld.equals(soldadosidNew)) {
                soldadosidOld.getSolicitarServicioList().remove(solicitarServicio);
                soldadosidOld = em.merge(soldadosidOld);
            }
            if (soldadosidNew != null && !soldadosidNew.equals(soldadosidOld)) {
                soldadosidNew.getSolicitarServicioList().add(solicitarServicio);
                soldadosidNew = em.merge(soldadosidNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = solicitarServicio.getId();
                if (findSolicitarServicio(id) == null) {
                    throw new NonexistentEntityException("The solicitarServicio with id " + id + " no longer exists.");
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
            SolicitarServicio solicitarServicio;
            try {
                solicitarServicio = em.getReference(SolicitarServicio.class, id);
                solicitarServicio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitarServicio with id " + id + " no longer exists.", enfe);
            }
            Servicios serviciosidServicios = solicitarServicio.getServiciosidServicios();
            if (serviciosidServicios != null) {
                serviciosidServicios.getSolicitarServicioList().remove(solicitarServicio);
                serviciosidServicios = em.merge(serviciosidServicios);
            }
            Soldados soldadosid = solicitarServicio.getSoldadosid();
            if (soldadosid != null) {
                soldadosid.getSolicitarServicioList().remove(solicitarServicio);
                soldadosid = em.merge(soldadosid);
            }
            em.remove(solicitarServicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitarServicio> findSolicitarServicioEntities() {
        return findSolicitarServicioEntities(true, -1, -1);
    }

    public List<SolicitarServicio> findSolicitarServicioEntities(int maxResults, int firstResult) {
        return findSolicitarServicioEntities(false, maxResults, firstResult);
    }

    private List<SolicitarServicio> findSolicitarServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitarServicio.class));
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

    public SolicitarServicio findSolicitarServicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitarServicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitarServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitarServicio> rt = cq.from(SolicitarServicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
