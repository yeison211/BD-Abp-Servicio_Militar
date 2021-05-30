/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.IllegalOrphanException;
import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import Servicio.Militar.Principal.tabla.Servicios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.SolicitarServicio;
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

    public void create(Servicios servicios) throws PreexistingEntityException, Exception {
        if (servicios.getSolicitarServicioList() == null) {
            servicios.setSolicitarServicioList(new ArrayList<SolicitarServicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SolicitarServicio> attachedSolicitarServicioList = new ArrayList<SolicitarServicio>();
            for (SolicitarServicio solicitarServicioListSolicitarServicioToAttach : servicios.getSolicitarServicioList()) {
                solicitarServicioListSolicitarServicioToAttach = em.getReference(solicitarServicioListSolicitarServicioToAttach.getClass(), solicitarServicioListSolicitarServicioToAttach.getId());
                attachedSolicitarServicioList.add(solicitarServicioListSolicitarServicioToAttach);
            }
            servicios.setSolicitarServicioList(attachedSolicitarServicioList);
            em.persist(servicios);
            for (SolicitarServicio solicitarServicioListSolicitarServicio : servicios.getSolicitarServicioList()) {
                Servicios oldServiciosidServiciosOfSolicitarServicioListSolicitarServicio = solicitarServicioListSolicitarServicio.getServiciosidServicios();
                solicitarServicioListSolicitarServicio.setServiciosidServicios(servicios);
                solicitarServicioListSolicitarServicio = em.merge(solicitarServicioListSolicitarServicio);
                if (oldServiciosidServiciosOfSolicitarServicioListSolicitarServicio != null) {
                    oldServiciosidServiciosOfSolicitarServicioListSolicitarServicio.getSolicitarServicioList().remove(solicitarServicioListSolicitarServicio);
                    oldServiciosidServiciosOfSolicitarServicioListSolicitarServicio = em.merge(oldServiciosidServiciosOfSolicitarServicioListSolicitarServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findServicios(servicios.getIdServicios()) != null) {
                throw new PreexistingEntityException("Servicios " + servicios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicios servicios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicios persistentServicios = em.find(Servicios.class, servicios.getIdServicios());
            List<SolicitarServicio> solicitarServicioListOld = persistentServicios.getSolicitarServicioList();
            List<SolicitarServicio> solicitarServicioListNew = servicios.getSolicitarServicioList();
            List<String> illegalOrphanMessages = null;
            for (SolicitarServicio solicitarServicioListOldSolicitarServicio : solicitarServicioListOld) {
                if (!solicitarServicioListNew.contains(solicitarServicioListOldSolicitarServicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SolicitarServicio " + solicitarServicioListOldSolicitarServicio + " since its serviciosidServicios field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<SolicitarServicio> attachedSolicitarServicioListNew = new ArrayList<SolicitarServicio>();
            for (SolicitarServicio solicitarServicioListNewSolicitarServicioToAttach : solicitarServicioListNew) {
                solicitarServicioListNewSolicitarServicioToAttach = em.getReference(solicitarServicioListNewSolicitarServicioToAttach.getClass(), solicitarServicioListNewSolicitarServicioToAttach.getId());
                attachedSolicitarServicioListNew.add(solicitarServicioListNewSolicitarServicioToAttach);
            }
            solicitarServicioListNew = attachedSolicitarServicioListNew;
            servicios.setSolicitarServicioList(solicitarServicioListNew);
            servicios = em.merge(servicios);
            for (SolicitarServicio solicitarServicioListNewSolicitarServicio : solicitarServicioListNew) {
                if (!solicitarServicioListOld.contains(solicitarServicioListNewSolicitarServicio)) {
                    Servicios oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio = solicitarServicioListNewSolicitarServicio.getServiciosidServicios();
                    solicitarServicioListNewSolicitarServicio.setServiciosidServicios(servicios);
                    solicitarServicioListNewSolicitarServicio = em.merge(solicitarServicioListNewSolicitarServicio);
                    if (oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio != null && !oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio.equals(servicios)) {
                        oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio.getSolicitarServicioList().remove(solicitarServicioListNewSolicitarServicio);
                        oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio = em.merge(oldServiciosidServiciosOfSolicitarServicioListNewSolicitarServicio);
                    }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<SolicitarServicio> solicitarServicioListOrphanCheck = servicios.getSolicitarServicioList();
            for (SolicitarServicio solicitarServicioListOrphanCheckSolicitarServicio : solicitarServicioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicios (" + servicios + ") cannot be destroyed since the SolicitarServicio " + solicitarServicioListOrphanCheckSolicitarServicio + " in its solicitarServicioList field has a non-nullable serviciosidServicios field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
