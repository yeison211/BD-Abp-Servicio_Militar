/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.IllegalOrphanException;
import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import Servicio.Militar.Principal.tabla.Compañia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Soldados;
import Servicio.Militar.Principal.tabla.Cuarteles;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class CompañiaJpaController implements Serializable {

    public CompañiaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compañia compañia) throws PreexistingEntityException, Exception {
        if (compañia.getCuartelesList() == null) {
            compañia.setCuartelesList(new ArrayList<Cuarteles>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soldados soldadosid = compañia.getSoldadosid();
            if (soldadosid != null) {
                soldadosid = em.getReference(soldadosid.getClass(), soldadosid.getId());
                compañia.setSoldadosid(soldadosid);
            }
            List<Cuarteles> attachedCuartelesList = new ArrayList<Cuarteles>();
            for (Cuarteles cuartelesListCuartelesToAttach : compañia.getCuartelesList()) {
                cuartelesListCuartelesToAttach = em.getReference(cuartelesListCuartelesToAttach.getClass(), cuartelesListCuartelesToAttach.getIdCuarteles());
                attachedCuartelesList.add(cuartelesListCuartelesToAttach);
            }
            compañia.setCuartelesList(attachedCuartelesList);
            em.persist(compañia);
            if (soldadosid != null) {
                soldadosid.getCompañiaList().add(compañia);
                soldadosid = em.merge(soldadosid);
            }
            for (Cuarteles cuartelesListCuarteles : compañia.getCuartelesList()) {
                Compañia oldCompañiaidCompañiaOfCuartelesListCuarteles = cuartelesListCuarteles.getCompañiaidCompañia();
                cuartelesListCuarteles.setCompañiaidCompañia(compañia);
                cuartelesListCuarteles = em.merge(cuartelesListCuarteles);
                if (oldCompañiaidCompañiaOfCuartelesListCuarteles != null) {
                    oldCompañiaidCompañiaOfCuartelesListCuarteles.getCuartelesList().remove(cuartelesListCuarteles);
                    oldCompañiaidCompañiaOfCuartelesListCuarteles = em.merge(oldCompañiaidCompañiaOfCuartelesListCuarteles);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCompañia(compañia.getIdCompañia()) != null) {
                throw new PreexistingEntityException("Compa\u00f1ia " + compañia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compañia compañia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compañia persistentCompañia = em.find(Compañia.class, compañia.getIdCompañia());
            Soldados soldadosidOld = persistentCompañia.getSoldadosid();
            Soldados soldadosidNew = compañia.getSoldadosid();
            List<Cuarteles> cuartelesListOld = persistentCompañia.getCuartelesList();
            List<Cuarteles> cuartelesListNew = compañia.getCuartelesList();
            List<String> illegalOrphanMessages = null;
            for (Cuarteles cuartelesListOldCuarteles : cuartelesListOld) {
                if (!cuartelesListNew.contains(cuartelesListOldCuarteles)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cuarteles " + cuartelesListOldCuarteles + " since its compa\u00f1iaidCompa\u00f1ia field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (soldadosidNew != null) {
                soldadosidNew = em.getReference(soldadosidNew.getClass(), soldadosidNew.getId());
                compañia.setSoldadosid(soldadosidNew);
            }
            List<Cuarteles> attachedCuartelesListNew = new ArrayList<Cuarteles>();
            for (Cuarteles cuartelesListNewCuartelesToAttach : cuartelesListNew) {
                cuartelesListNewCuartelesToAttach = em.getReference(cuartelesListNewCuartelesToAttach.getClass(), cuartelesListNewCuartelesToAttach.getIdCuarteles());
                attachedCuartelesListNew.add(cuartelesListNewCuartelesToAttach);
            }
            cuartelesListNew = attachedCuartelesListNew;
            compañia.setCuartelesList(cuartelesListNew);
            compañia = em.merge(compañia);
            if (soldadosidOld != null && !soldadosidOld.equals(soldadosidNew)) {
                soldadosidOld.getCompañiaList().remove(compañia);
                soldadosidOld = em.merge(soldadosidOld);
            }
            if (soldadosidNew != null && !soldadosidNew.equals(soldadosidOld)) {
                soldadosidNew.getCompañiaList().add(compañia);
                soldadosidNew = em.merge(soldadosidNew);
            }
            for (Cuarteles cuartelesListNewCuarteles : cuartelesListNew) {
                if (!cuartelesListOld.contains(cuartelesListNewCuarteles)) {
                    Compañia oldCompañiaidCompañiaOfCuartelesListNewCuarteles = cuartelesListNewCuarteles.getCompañiaidCompañia();
                    cuartelesListNewCuarteles.setCompañiaidCompañia(compañia);
                    cuartelesListNewCuarteles = em.merge(cuartelesListNewCuarteles);
                    if (oldCompañiaidCompañiaOfCuartelesListNewCuarteles != null && !oldCompañiaidCompañiaOfCuartelesListNewCuarteles.equals(compañia)) {
                        oldCompañiaidCompañiaOfCuartelesListNewCuarteles.getCuartelesList().remove(cuartelesListNewCuarteles);
                        oldCompañiaidCompañiaOfCuartelesListNewCuarteles = em.merge(oldCompañiaidCompañiaOfCuartelesListNewCuarteles);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compañia.getIdCompañia();
                if (findCompañia(id) == null) {
                    throw new NonexistentEntityException("The compa\u00f1ia with id " + id + " no longer exists.");
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
            Compañia compañia;
            try {
                compañia = em.getReference(Compañia.class, id);
                compañia.getIdCompañia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compa\u00f1ia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cuarteles> cuartelesListOrphanCheck = compañia.getCuartelesList();
            for (Cuarteles cuartelesListOrphanCheckCuarteles : cuartelesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compa\u00f1ia (" + compañia + ") cannot be destroyed since the Cuarteles " + cuartelesListOrphanCheckCuarteles + " in its cuartelesList field has a non-nullable compa\u00f1iaidCompa\u00f1ia field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Soldados soldadosid = compañia.getSoldadosid();
            if (soldadosid != null) {
                soldadosid.getCompañiaList().remove(compañia);
                soldadosid = em.merge(soldadosid);
            }
            em.remove(compañia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compañia> findCompañiaEntities() {
        return findCompañiaEntities(true, -1, -1);
    }

    public List<Compañia> findCompañiaEntities(int maxResults, int firstResult) {
        return findCompañiaEntities(false, maxResults, firstResult);
    }

    private List<Compañia> findCompañiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compañia.class));
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

    public Compañia findCompañia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compañia.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompañiaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compañia> rt = cq.from(Compañia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
