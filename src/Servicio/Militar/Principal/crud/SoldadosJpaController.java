/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.IllegalOrphanException;
import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.Servicios;
import java.util.ArrayList;
import java.util.List;
import Servicio.Militar.Principal.tabla.Compañia;
import Servicio.Militar.Principal.tabla.Infanteria;
import Servicio.Militar.Principal.tabla.Artilleria;
import Servicio.Militar.Principal.tabla.Armada;
import Servicio.Militar.Principal.tabla.Soldados;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public void create(Soldados soldados) {
        if (soldados.getServiciosList() == null) {
            soldados.setServiciosList(new ArrayList<Servicios>());
        }
        if (soldados.getCompañiaList() == null) {
            soldados.setCompañiaList(new ArrayList<Compañia>());
        }
        if (soldados.getInfanteriaList() == null) {
            soldados.setInfanteriaList(new ArrayList<Infanteria>());
        }
        if (soldados.getArtilleriaList() == null) {
            soldados.setArtilleriaList(new ArrayList<Artilleria>());
        }
        if (soldados.getArmadaList() == null) {
            soldados.setArmadaList(new ArrayList<Armada>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicios> attachedServiciosList = new ArrayList<Servicios>();
            for (Servicios serviciosListServiciosToAttach : soldados.getServiciosList()) {
                serviciosListServiciosToAttach = em.getReference(serviciosListServiciosToAttach.getClass(), serviciosListServiciosToAttach.getIdServicios());
                attachedServiciosList.add(serviciosListServiciosToAttach);
            }
            soldados.setServiciosList(attachedServiciosList);
            List<Compañia> attachedCompañiaList = new ArrayList<Compañia>();
            for (Compañia compañiaListCompañiaToAttach : soldados.getCompañiaList()) {
                compañiaListCompañiaToAttach = em.getReference(compañiaListCompañiaToAttach.getClass(), compañiaListCompañiaToAttach.getIdCompañia());
                attachedCompañiaList.add(compañiaListCompañiaToAttach);
            }
            soldados.setCompañiaList(attachedCompañiaList);
            List<Infanteria> attachedInfanteriaList = new ArrayList<Infanteria>();
            for (Infanteria infanteriaListInfanteriaToAttach : soldados.getInfanteriaList()) {
                infanteriaListInfanteriaToAttach = em.getReference(infanteriaListInfanteriaToAttach.getClass(), infanteriaListInfanteriaToAttach.getIdInfanteria());
                attachedInfanteriaList.add(infanteriaListInfanteriaToAttach);
            }
            soldados.setInfanteriaList(attachedInfanteriaList);
            List<Artilleria> attachedArtilleriaList = new ArrayList<Artilleria>();
            for (Artilleria artilleriaListArtilleriaToAttach : soldados.getArtilleriaList()) {
                artilleriaListArtilleriaToAttach = em.getReference(artilleriaListArtilleriaToAttach.getClass(), artilleriaListArtilleriaToAttach.getIdArtilleria());
                attachedArtilleriaList.add(artilleriaListArtilleriaToAttach);
            }
            soldados.setArtilleriaList(attachedArtilleriaList);
            List<Armada> attachedArmadaList = new ArrayList<Armada>();
            for (Armada armadaListArmadaToAttach : soldados.getArmadaList()) {
                armadaListArmadaToAttach = em.getReference(armadaListArmadaToAttach.getClass(), armadaListArmadaToAttach.getIdArmada());
                attachedArmadaList.add(armadaListArmadaToAttach);
            }
            soldados.setArmadaList(attachedArmadaList);
            em.persist(soldados);
            for (Servicios serviciosListServicios : soldados.getServiciosList()) {
                serviciosListServicios.getSoldadosList().add(soldados);
                serviciosListServicios = em.merge(serviciosListServicios);
            }
            for (Compañia compañiaListCompañia : soldados.getCompañiaList()) {
                Soldados oldSoldadosidSoldadosOfCompañiaListCompañia = compañiaListCompañia.getSoldadosidSoldados();
                compañiaListCompañia.setSoldadosidSoldados(soldados);
                compañiaListCompañia = em.merge(compañiaListCompañia);
                if (oldSoldadosidSoldadosOfCompañiaListCompañia != null) {
                    oldSoldadosidSoldadosOfCompañiaListCompañia.getCompañiaList().remove(compañiaListCompañia);
                    oldSoldadosidSoldadosOfCompañiaListCompañia = em.merge(oldSoldadosidSoldadosOfCompañiaListCompañia);
                }
            }
            for (Infanteria infanteriaListInfanteria : soldados.getInfanteriaList()) {
                Soldados oldSoldadosidSoldadosOfInfanteriaListInfanteria = infanteriaListInfanteria.getSoldadosidSoldados();
                infanteriaListInfanteria.setSoldadosidSoldados(soldados);
                infanteriaListInfanteria = em.merge(infanteriaListInfanteria);
                if (oldSoldadosidSoldadosOfInfanteriaListInfanteria != null) {
                    oldSoldadosidSoldadosOfInfanteriaListInfanteria.getInfanteriaList().remove(infanteriaListInfanteria);
                    oldSoldadosidSoldadosOfInfanteriaListInfanteria = em.merge(oldSoldadosidSoldadosOfInfanteriaListInfanteria);
                }
            }
            for (Artilleria artilleriaListArtilleria : soldados.getArtilleriaList()) {
                Soldados oldSoldadosidSoldadosOfArtilleriaListArtilleria = artilleriaListArtilleria.getSoldadosidSoldados();
                artilleriaListArtilleria.setSoldadosidSoldados(soldados);
                artilleriaListArtilleria = em.merge(artilleriaListArtilleria);
                if (oldSoldadosidSoldadosOfArtilleriaListArtilleria != null) {
                    oldSoldadosidSoldadosOfArtilleriaListArtilleria.getArtilleriaList().remove(artilleriaListArtilleria);
                    oldSoldadosidSoldadosOfArtilleriaListArtilleria = em.merge(oldSoldadosidSoldadosOfArtilleriaListArtilleria);
                }
            }
            for (Armada armadaListArmada : soldados.getArmadaList()) {
                Soldados oldSoldadosidSoldadosOfArmadaListArmada = armadaListArmada.getSoldadosidSoldados();
                armadaListArmada.setSoldadosidSoldados(soldados);
                armadaListArmada = em.merge(armadaListArmada);
                if (oldSoldadosidSoldadosOfArmadaListArmada != null) {
                    oldSoldadosidSoldadosOfArmadaListArmada.getArmadaList().remove(armadaListArmada);
                    oldSoldadosidSoldadosOfArmadaListArmada = em.merge(oldSoldadosidSoldadosOfArmadaListArmada);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Soldados soldados) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Soldados persistentSoldados = em.find(Soldados.class, soldados.getIdSoldados());
            List<Servicios> serviciosListOld = persistentSoldados.getServiciosList();
            List<Servicios> serviciosListNew = soldados.getServiciosList();
            List<Compañia> compañiaListOld = persistentSoldados.getCompañiaList();
            List<Compañia> compañiaListNew = soldados.getCompañiaList();
            List<Infanteria> infanteriaListOld = persistentSoldados.getInfanteriaList();
            List<Infanteria> infanteriaListNew = soldados.getInfanteriaList();
            List<Artilleria> artilleriaListOld = persistentSoldados.getArtilleriaList();
            List<Artilleria> artilleriaListNew = soldados.getArtilleriaList();
            List<Armada> armadaListOld = persistentSoldados.getArmadaList();
            List<Armada> armadaListNew = soldados.getArmadaList();
            List<String> illegalOrphanMessages = null;
            for (Compañia compañiaListOldCompañia : compañiaListOld) {
                if (!compañiaListNew.contains(compañiaListOldCompañia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compa\u00f1ia " + compañiaListOldCompañia + " since its soldadosidSoldados field is not nullable.");
                }
            }
            for (Infanteria infanteriaListOldInfanteria : infanteriaListOld) {
                if (!infanteriaListNew.contains(infanteriaListOldInfanteria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Infanteria " + infanteriaListOldInfanteria + " since its soldadosidSoldados field is not nullable.");
                }
            }
            for (Artilleria artilleriaListOldArtilleria : artilleriaListOld) {
                if (!artilleriaListNew.contains(artilleriaListOldArtilleria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Artilleria " + artilleriaListOldArtilleria + " since its soldadosidSoldados field is not nullable.");
                }
            }
            for (Armada armadaListOldArmada : armadaListOld) {
                if (!armadaListNew.contains(armadaListOldArmada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Armada " + armadaListOldArmada + " since its soldadosidSoldados field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Servicios> attachedServiciosListNew = new ArrayList<Servicios>();
            for (Servicios serviciosListNewServiciosToAttach : serviciosListNew) {
                serviciosListNewServiciosToAttach = em.getReference(serviciosListNewServiciosToAttach.getClass(), serviciosListNewServiciosToAttach.getIdServicios());
                attachedServiciosListNew.add(serviciosListNewServiciosToAttach);
            }
            serviciosListNew = attachedServiciosListNew;
            soldados.setServiciosList(serviciosListNew);
            List<Compañia> attachedCompañiaListNew = new ArrayList<Compañia>();
            for (Compañia compañiaListNewCompañiaToAttach : compañiaListNew) {
                compañiaListNewCompañiaToAttach = em.getReference(compañiaListNewCompañiaToAttach.getClass(), compañiaListNewCompañiaToAttach.getIdCompañia());
                attachedCompañiaListNew.add(compañiaListNewCompañiaToAttach);
            }
            compañiaListNew = attachedCompañiaListNew;
            soldados.setCompañiaList(compañiaListNew);
            List<Infanteria> attachedInfanteriaListNew = new ArrayList<Infanteria>();
            for (Infanteria infanteriaListNewInfanteriaToAttach : infanteriaListNew) {
                infanteriaListNewInfanteriaToAttach = em.getReference(infanteriaListNewInfanteriaToAttach.getClass(), infanteriaListNewInfanteriaToAttach.getIdInfanteria());
                attachedInfanteriaListNew.add(infanteriaListNewInfanteriaToAttach);
            }
            infanteriaListNew = attachedInfanteriaListNew;
            soldados.setInfanteriaList(infanteriaListNew);
            List<Artilleria> attachedArtilleriaListNew = new ArrayList<Artilleria>();
            for (Artilleria artilleriaListNewArtilleriaToAttach : artilleriaListNew) {
                artilleriaListNewArtilleriaToAttach = em.getReference(artilleriaListNewArtilleriaToAttach.getClass(), artilleriaListNewArtilleriaToAttach.getIdArtilleria());
                attachedArtilleriaListNew.add(artilleriaListNewArtilleriaToAttach);
            }
            artilleriaListNew = attachedArtilleriaListNew;
            soldados.setArtilleriaList(artilleriaListNew);
            List<Armada> attachedArmadaListNew = new ArrayList<Armada>();
            for (Armada armadaListNewArmadaToAttach : armadaListNew) {
                armadaListNewArmadaToAttach = em.getReference(armadaListNewArmadaToAttach.getClass(), armadaListNewArmadaToAttach.getIdArmada());
                attachedArmadaListNew.add(armadaListNewArmadaToAttach);
            }
            armadaListNew = attachedArmadaListNew;
            soldados.setArmadaList(armadaListNew);
            soldados = em.merge(soldados);
            for (Servicios serviciosListOldServicios : serviciosListOld) {
                if (!serviciosListNew.contains(serviciosListOldServicios)) {
                    serviciosListOldServicios.getSoldadosList().remove(soldados);
                    serviciosListOldServicios = em.merge(serviciosListOldServicios);
                }
            }
            for (Servicios serviciosListNewServicios : serviciosListNew) {
                if (!serviciosListOld.contains(serviciosListNewServicios)) {
                    serviciosListNewServicios.getSoldadosList().add(soldados);
                    serviciosListNewServicios = em.merge(serviciosListNewServicios);
                }
            }
            for (Compañia compañiaListNewCompañia : compañiaListNew) {
                if (!compañiaListOld.contains(compañiaListNewCompañia)) {
                    Soldados oldSoldadosidSoldadosOfCompañiaListNewCompañia = compañiaListNewCompañia.getSoldadosidSoldados();
                    compañiaListNewCompañia.setSoldadosidSoldados(soldados);
                    compañiaListNewCompañia = em.merge(compañiaListNewCompañia);
                    if (oldSoldadosidSoldadosOfCompañiaListNewCompañia != null && !oldSoldadosidSoldadosOfCompañiaListNewCompañia.equals(soldados)) {
                        oldSoldadosidSoldadosOfCompañiaListNewCompañia.getCompañiaList().remove(compañiaListNewCompañia);
                        oldSoldadosidSoldadosOfCompañiaListNewCompañia = em.merge(oldSoldadosidSoldadosOfCompañiaListNewCompañia);
                    }
                }
            }
            for (Infanteria infanteriaListNewInfanteria : infanteriaListNew) {
                if (!infanteriaListOld.contains(infanteriaListNewInfanteria)) {
                    Soldados oldSoldadosidSoldadosOfInfanteriaListNewInfanteria = infanteriaListNewInfanteria.getSoldadosidSoldados();
                    infanteriaListNewInfanteria.setSoldadosidSoldados(soldados);
                    infanteriaListNewInfanteria = em.merge(infanteriaListNewInfanteria);
                    if (oldSoldadosidSoldadosOfInfanteriaListNewInfanteria != null && !oldSoldadosidSoldadosOfInfanteriaListNewInfanteria.equals(soldados)) {
                        oldSoldadosidSoldadosOfInfanteriaListNewInfanteria.getInfanteriaList().remove(infanteriaListNewInfanteria);
                        oldSoldadosidSoldadosOfInfanteriaListNewInfanteria = em.merge(oldSoldadosidSoldadosOfInfanteriaListNewInfanteria);
                    }
                }
            }
            for (Artilleria artilleriaListNewArtilleria : artilleriaListNew) {
                if (!artilleriaListOld.contains(artilleriaListNewArtilleria)) {
                    Soldados oldSoldadosidSoldadosOfArtilleriaListNewArtilleria = artilleriaListNewArtilleria.getSoldadosidSoldados();
                    artilleriaListNewArtilleria.setSoldadosidSoldados(soldados);
                    artilleriaListNewArtilleria = em.merge(artilleriaListNewArtilleria);
                    if (oldSoldadosidSoldadosOfArtilleriaListNewArtilleria != null && !oldSoldadosidSoldadosOfArtilleriaListNewArtilleria.equals(soldados)) {
                        oldSoldadosidSoldadosOfArtilleriaListNewArtilleria.getArtilleriaList().remove(artilleriaListNewArtilleria);
                        oldSoldadosidSoldadosOfArtilleriaListNewArtilleria = em.merge(oldSoldadosidSoldadosOfArtilleriaListNewArtilleria);
                    }
                }
            }
            for (Armada armadaListNewArmada : armadaListNew) {
                if (!armadaListOld.contains(armadaListNewArmada)) {
                    Soldados oldSoldadosidSoldadosOfArmadaListNewArmada = armadaListNewArmada.getSoldadosidSoldados();
                    armadaListNewArmada.setSoldadosidSoldados(soldados);
                    armadaListNewArmada = em.merge(armadaListNewArmada);
                    if (oldSoldadosidSoldadosOfArmadaListNewArmada != null && !oldSoldadosidSoldadosOfArmadaListNewArmada.equals(soldados)) {
                        oldSoldadosidSoldadosOfArmadaListNewArmada.getArmadaList().remove(armadaListNewArmada);
                        oldSoldadosidSoldadosOfArmadaListNewArmada = em.merge(oldSoldadosidSoldadosOfArmadaListNewArmada);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = soldados.getIdSoldados();
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Compañia> compañiaListOrphanCheck = soldados.getCompañiaList();
            for (Compañia compañiaListOrphanCheckCompañia : compañiaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Compa\u00f1ia " + compañiaListOrphanCheckCompañia + " in its compa\u00f1iaList field has a non-nullable soldadosidSoldados field.");
            }
            List<Infanteria> infanteriaListOrphanCheck = soldados.getInfanteriaList();
            for (Infanteria infanteriaListOrphanCheckInfanteria : infanteriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Infanteria " + infanteriaListOrphanCheckInfanteria + " in its infanteriaList field has a non-nullable soldadosidSoldados field.");
            }
            List<Artilleria> artilleriaListOrphanCheck = soldados.getArtilleriaList();
            for (Artilleria artilleriaListOrphanCheckArtilleria : artilleriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Artilleria " + artilleriaListOrphanCheckArtilleria + " in its artilleriaList field has a non-nullable soldadosidSoldados field.");
            }
            List<Armada> armadaListOrphanCheck = soldados.getArmadaList();
            for (Armada armadaListOrphanCheckArmada : armadaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Armada " + armadaListOrphanCheckArmada + " in its armadaList field has a non-nullable soldadosidSoldados field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Servicios> serviciosList = soldados.getServiciosList();
            for (Servicios serviciosListServicios : serviciosList) {
                serviciosListServicios.getSoldadosList().remove(soldados);
                serviciosListServicios = em.merge(serviciosListServicios);
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

    public Soldados findSoldados(Integer id) {
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
