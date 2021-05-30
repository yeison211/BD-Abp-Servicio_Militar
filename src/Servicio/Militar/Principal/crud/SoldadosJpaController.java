/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.crud;

import Servicio.Militar.Principal.crud.exceptions.IllegalOrphanException;
import Servicio.Militar.Principal.crud.exceptions.NonexistentEntityException;
import Servicio.Militar.Principal.crud.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Servicio.Militar.Principal.tabla.SolicitarServicio;
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

    public void create(Soldados soldados) throws PreexistingEntityException, Exception {
        if (soldados.getSolicitarServicioList() == null) {
            soldados.setSolicitarServicioList(new ArrayList<SolicitarServicio>());
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
            List<SolicitarServicio> attachedSolicitarServicioList = new ArrayList<SolicitarServicio>();
            for (SolicitarServicio solicitarServicioListSolicitarServicioToAttach : soldados.getSolicitarServicioList()) {
                solicitarServicioListSolicitarServicioToAttach = em.getReference(solicitarServicioListSolicitarServicioToAttach.getClass(), solicitarServicioListSolicitarServicioToAttach.getId());
                attachedSolicitarServicioList.add(solicitarServicioListSolicitarServicioToAttach);
            }
            soldados.setSolicitarServicioList(attachedSolicitarServicioList);
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
            for (SolicitarServicio solicitarServicioListSolicitarServicio : soldados.getSolicitarServicioList()) {
                Soldados oldSoldadosidOfSolicitarServicioListSolicitarServicio = solicitarServicioListSolicitarServicio.getSoldadosid();
                solicitarServicioListSolicitarServicio.setSoldadosid(soldados);
                solicitarServicioListSolicitarServicio = em.merge(solicitarServicioListSolicitarServicio);
                if (oldSoldadosidOfSolicitarServicioListSolicitarServicio != null) {
                    oldSoldadosidOfSolicitarServicioListSolicitarServicio.getSolicitarServicioList().remove(solicitarServicioListSolicitarServicio);
                    oldSoldadosidOfSolicitarServicioListSolicitarServicio = em.merge(oldSoldadosidOfSolicitarServicioListSolicitarServicio);
                }
            }
            for (Compañia compañiaListCompañia : soldados.getCompañiaList()) {
                Soldados oldSoldadosidOfCompañiaListCompañia = compañiaListCompañia.getSoldadosid();
                compañiaListCompañia.setSoldadosid(soldados);
                compañiaListCompañia = em.merge(compañiaListCompañia);
                if (oldSoldadosidOfCompañiaListCompañia != null) {
                    oldSoldadosidOfCompañiaListCompañia.getCompañiaList().remove(compañiaListCompañia);
                    oldSoldadosidOfCompañiaListCompañia = em.merge(oldSoldadosidOfCompañiaListCompañia);
                }
            }
            for (Infanteria infanteriaListInfanteria : soldados.getInfanteriaList()) {
                Soldados oldSoldadosidOfInfanteriaListInfanteria = infanteriaListInfanteria.getSoldadosid();
                infanteriaListInfanteria.setSoldadosid(soldados);
                infanteriaListInfanteria = em.merge(infanteriaListInfanteria);
                if (oldSoldadosidOfInfanteriaListInfanteria != null) {
                    oldSoldadosidOfInfanteriaListInfanteria.getInfanteriaList().remove(infanteriaListInfanteria);
                    oldSoldadosidOfInfanteriaListInfanteria = em.merge(oldSoldadosidOfInfanteriaListInfanteria);
                }
            }
            for (Artilleria artilleriaListArtilleria : soldados.getArtilleriaList()) {
                Soldados oldSoldadosidOfArtilleriaListArtilleria = artilleriaListArtilleria.getSoldadosid();
                artilleriaListArtilleria.setSoldadosid(soldados);
                artilleriaListArtilleria = em.merge(artilleriaListArtilleria);
                if (oldSoldadosidOfArtilleriaListArtilleria != null) {
                    oldSoldadosidOfArtilleriaListArtilleria.getArtilleriaList().remove(artilleriaListArtilleria);
                    oldSoldadosidOfArtilleriaListArtilleria = em.merge(oldSoldadosidOfArtilleriaListArtilleria);
                }
            }
            for (Armada armadaListArmada : soldados.getArmadaList()) {
                Soldados oldSoldadosidOfArmadaListArmada = armadaListArmada.getSoldadosid();
                armadaListArmada.setSoldadosid(soldados);
                armadaListArmada = em.merge(armadaListArmada);
                if (oldSoldadosidOfArmadaListArmada != null) {
                    oldSoldadosidOfArmadaListArmada.getArmadaList().remove(armadaListArmada);
                    oldSoldadosidOfArmadaListArmada = em.merge(oldSoldadosidOfArmadaListArmada);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSoldados(soldados.getId()) != null) {
                throw new PreexistingEntityException("Soldados " + soldados + " already exists.", ex);
            }
            throw ex;
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
            Soldados persistentSoldados = em.find(Soldados.class, soldados.getId());
            List<SolicitarServicio> solicitarServicioListOld = persistentSoldados.getSolicitarServicioList();
            List<SolicitarServicio> solicitarServicioListNew = soldados.getSolicitarServicioList();
            List<Compañia> compañiaListOld = persistentSoldados.getCompañiaList();
            List<Compañia> compañiaListNew = soldados.getCompañiaList();
            List<Infanteria> infanteriaListOld = persistentSoldados.getInfanteriaList();
            List<Infanteria> infanteriaListNew = soldados.getInfanteriaList();
            List<Artilleria> artilleriaListOld = persistentSoldados.getArtilleriaList();
            List<Artilleria> artilleriaListNew = soldados.getArtilleriaList();
            List<Armada> armadaListOld = persistentSoldados.getArmadaList();
            List<Armada> armadaListNew = soldados.getArmadaList();
            List<String> illegalOrphanMessages = null;
            for (SolicitarServicio solicitarServicioListOldSolicitarServicio : solicitarServicioListOld) {
                if (!solicitarServicioListNew.contains(solicitarServicioListOldSolicitarServicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SolicitarServicio " + solicitarServicioListOldSolicitarServicio + " since its soldadosid field is not nullable.");
                }
            }
            for (Compañia compañiaListOldCompañia : compañiaListOld) {
                if (!compañiaListNew.contains(compañiaListOldCompañia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compa\u00f1ia " + compañiaListOldCompañia + " since its soldadosid field is not nullable.");
                }
            }
            for (Infanteria infanteriaListOldInfanteria : infanteriaListOld) {
                if (!infanteriaListNew.contains(infanteriaListOldInfanteria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Infanteria " + infanteriaListOldInfanteria + " since its soldadosid field is not nullable.");
                }
            }
            for (Artilleria artilleriaListOldArtilleria : artilleriaListOld) {
                if (!artilleriaListNew.contains(artilleriaListOldArtilleria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Artilleria " + artilleriaListOldArtilleria + " since its soldadosid field is not nullable.");
                }
            }
            for (Armada armadaListOldArmada : armadaListOld) {
                if (!armadaListNew.contains(armadaListOldArmada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Armada " + armadaListOldArmada + " since its soldadosid field is not nullable.");
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
            soldados.setSolicitarServicioList(solicitarServicioListNew);
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
            for (SolicitarServicio solicitarServicioListNewSolicitarServicio : solicitarServicioListNew) {
                if (!solicitarServicioListOld.contains(solicitarServicioListNewSolicitarServicio)) {
                    Soldados oldSoldadosidOfSolicitarServicioListNewSolicitarServicio = solicitarServicioListNewSolicitarServicio.getSoldadosid();
                    solicitarServicioListNewSolicitarServicio.setSoldadosid(soldados);
                    solicitarServicioListNewSolicitarServicio = em.merge(solicitarServicioListNewSolicitarServicio);
                    if (oldSoldadosidOfSolicitarServicioListNewSolicitarServicio != null && !oldSoldadosidOfSolicitarServicioListNewSolicitarServicio.equals(soldados)) {
                        oldSoldadosidOfSolicitarServicioListNewSolicitarServicio.getSolicitarServicioList().remove(solicitarServicioListNewSolicitarServicio);
                        oldSoldadosidOfSolicitarServicioListNewSolicitarServicio = em.merge(oldSoldadosidOfSolicitarServicioListNewSolicitarServicio);
                    }
                }
            }
            for (Compañia compañiaListNewCompañia : compañiaListNew) {
                if (!compañiaListOld.contains(compañiaListNewCompañia)) {
                    Soldados oldSoldadosidOfCompañiaListNewCompañia = compañiaListNewCompañia.getSoldadosid();
                    compañiaListNewCompañia.setSoldadosid(soldados);
                    compañiaListNewCompañia = em.merge(compañiaListNewCompañia);
                    if (oldSoldadosidOfCompañiaListNewCompañia != null && !oldSoldadosidOfCompañiaListNewCompañia.equals(soldados)) {
                        oldSoldadosidOfCompañiaListNewCompañia.getCompañiaList().remove(compañiaListNewCompañia);
                        oldSoldadosidOfCompañiaListNewCompañia = em.merge(oldSoldadosidOfCompañiaListNewCompañia);
                    }
                }
            }
            for (Infanteria infanteriaListNewInfanteria : infanteriaListNew) {
                if (!infanteriaListOld.contains(infanteriaListNewInfanteria)) {
                    Soldados oldSoldadosidOfInfanteriaListNewInfanteria = infanteriaListNewInfanteria.getSoldadosid();
                    infanteriaListNewInfanteria.setSoldadosid(soldados);
                    infanteriaListNewInfanteria = em.merge(infanteriaListNewInfanteria);
                    if (oldSoldadosidOfInfanteriaListNewInfanteria != null && !oldSoldadosidOfInfanteriaListNewInfanteria.equals(soldados)) {
                        oldSoldadosidOfInfanteriaListNewInfanteria.getInfanteriaList().remove(infanteriaListNewInfanteria);
                        oldSoldadosidOfInfanteriaListNewInfanteria = em.merge(oldSoldadosidOfInfanteriaListNewInfanteria);
                    }
                }
            }
            for (Artilleria artilleriaListNewArtilleria : artilleriaListNew) {
                if (!artilleriaListOld.contains(artilleriaListNewArtilleria)) {
                    Soldados oldSoldadosidOfArtilleriaListNewArtilleria = artilleriaListNewArtilleria.getSoldadosid();
                    artilleriaListNewArtilleria.setSoldadosid(soldados);
                    artilleriaListNewArtilleria = em.merge(artilleriaListNewArtilleria);
                    if (oldSoldadosidOfArtilleriaListNewArtilleria != null && !oldSoldadosidOfArtilleriaListNewArtilleria.equals(soldados)) {
                        oldSoldadosidOfArtilleriaListNewArtilleria.getArtilleriaList().remove(artilleriaListNewArtilleria);
                        oldSoldadosidOfArtilleriaListNewArtilleria = em.merge(oldSoldadosidOfArtilleriaListNewArtilleria);
                    }
                }
            }
            for (Armada armadaListNewArmada : armadaListNew) {
                if (!armadaListOld.contains(armadaListNewArmada)) {
                    Soldados oldSoldadosidOfArmadaListNewArmada = armadaListNewArmada.getSoldadosid();
                    armadaListNewArmada.setSoldadosid(soldados);
                    armadaListNewArmada = em.merge(armadaListNewArmada);
                    if (oldSoldadosidOfArmadaListNewArmada != null && !oldSoldadosidOfArmadaListNewArmada.equals(soldados)) {
                        oldSoldadosidOfArmadaListNewArmada.getArmadaList().remove(armadaListNewArmada);
                        oldSoldadosidOfArmadaListNewArmada = em.merge(oldSoldadosidOfArmadaListNewArmada);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = soldados.getId();
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
                soldados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The soldados with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SolicitarServicio> solicitarServicioListOrphanCheck = soldados.getSolicitarServicioList();
            for (SolicitarServicio solicitarServicioListOrphanCheckSolicitarServicio : solicitarServicioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the SolicitarServicio " + solicitarServicioListOrphanCheckSolicitarServicio + " in its solicitarServicioList field has a non-nullable soldadosid field.");
            }
            List<Compañia> compañiaListOrphanCheck = soldados.getCompañiaList();
            for (Compañia compañiaListOrphanCheckCompañia : compañiaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Compa\u00f1ia " + compañiaListOrphanCheckCompañia + " in its compa\u00f1iaList field has a non-nullable soldadosid field.");
            }
            List<Infanteria> infanteriaListOrphanCheck = soldados.getInfanteriaList();
            for (Infanteria infanteriaListOrphanCheckInfanteria : infanteriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Infanteria " + infanteriaListOrphanCheckInfanteria + " in its infanteriaList field has a non-nullable soldadosid field.");
            }
            List<Artilleria> artilleriaListOrphanCheck = soldados.getArtilleriaList();
            for (Artilleria artilleriaListOrphanCheckArtilleria : artilleriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Artilleria " + artilleriaListOrphanCheckArtilleria + " in its artilleriaList field has a non-nullable soldadosid field.");
            }
            List<Armada> armadaListOrphanCheck = soldados.getArmadaList();
            for (Armada armadaListOrphanCheckArmada : armadaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Soldados (" + soldados + ") cannot be destroyed since the Armada " + armadaListOrphanCheckArmada + " in its armadaList field has a non-nullable soldadosid field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
