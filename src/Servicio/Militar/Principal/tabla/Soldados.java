/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.tabla;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Soldados.findAll", query = "SELECT s FROM Soldados s")
    , @NamedQuery(name = "Soldados.findById", query = "SELECT s FROM Soldados s WHERE s.id = :id")
    , @NamedQuery(name = "Soldados.findByNombre", query = "SELECT s FROM Soldados s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Soldados.findByApellido", query = "SELECT s FROM Soldados s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "Soldados.findByCedula", query = "SELECT s FROM Soldados s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "Soldados.findByRango", query = "SELECT s FROM Soldados s WHERE s.rango = :rango")})
public class Soldados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldadosid")
    private List<SolicitarServicio> solicitarServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldadosid")
    private List<Compañia> compañiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldadosid")
    private List<Infanteria> infanteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldadosid")
    private List<Artilleria> artilleriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldadosid")
    private List<Armada> armadaList;

    public Soldados() {
    }

    public Soldados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public List<SolicitarServicio> getSolicitarServicioList() {
        return solicitarServicioList;
    }

    public void setSolicitarServicioList(List<SolicitarServicio> solicitarServicioList) {
        this.solicitarServicioList = solicitarServicioList;
    }

    public List<Compañia> getCompañiaList() {
        return compañiaList;
    }

    public void setCompañiaList(List<Compañia> compañiaList) {
        this.compañiaList = compañiaList;
    }

    public List<Infanteria> getInfanteriaList() {
        return infanteriaList;
    }

    public void setInfanteriaList(List<Infanteria> infanteriaList) {
        this.infanteriaList = infanteriaList;
    }

    public List<Artilleria> getArtilleriaList() {
        return artilleriaList;
    }

    public void setArtilleriaList(List<Artilleria> artilleriaList) {
        this.artilleriaList = artilleriaList;
    }

    public List<Armada> getArmadaList() {
        return armadaList;
    }

    public void setArmadaList(List<Armada> armadaList) {
        this.armadaList = armadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soldados)) {
            return false;
        }
        Soldados other = (Soldados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Soldados[ id=" + id + " ]";
    }
    
}
