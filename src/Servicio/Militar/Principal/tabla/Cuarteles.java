/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.tabla;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author PC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cuarteles.findAll", query = "SELECT c FROM Cuarteles c")
    , @NamedQuery(name = "Cuarteles.findByIdCuarteles", query = "SELECT c FROM Cuarteles c WHERE c.idCuarteles = :idCuarteles")
    , @NamedQuery(name = "Cuarteles.findByNombre", query = "SELECT c FROM Cuarteles c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cuarteles.findByUbicacion", query = "SELECT c FROM Cuarteles c WHERE c.ubicacion = :ubicacion")
    , @NamedQuery(name = "Cuarteles.findByCuartelescol", query = "SELECT c FROM Cuarteles c WHERE c.cuartelescol = :cuartelescol")})
public class Cuarteles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idCuarteles;
    private String nombre;
    private String ubicacion;
    private String cuartelescol;
    @JoinColumn(name = "Compa\u00f1ia_idCompa\u00f1ia", referencedColumnName = "idCompa\u00f1ia")
    @ManyToOne(optional = false)
    private Compañia compañiaidCompañia;

    public Cuarteles() {
    }

    public Cuarteles(Integer idCuarteles) {
        this.idCuarteles = idCuarteles;
    }

    public Integer getIdCuarteles() {
        return idCuarteles;
    }

    public void setIdCuarteles(Integer idCuarteles) {
        this.idCuarteles = idCuarteles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCuartelescol() {
        return cuartelescol;
    }

    public void setCuartelescol(String cuartelescol) {
        this.cuartelescol = cuartelescol;
    }

    public Compañia getCompañiaidCompañia() {
        return compañiaidCompañia;
    }

    public void setCompañiaidCompañia(Compañia compañiaidCompañia) {
        this.compañiaidCompañia = compañiaidCompañia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuarteles != null ? idCuarteles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuarteles)) {
            return false;
        }
        Cuarteles other = (Cuarteles) object;
        if ((this.idCuarteles == null && other.idCuarteles != null) || (this.idCuarteles != null && !this.idCuarteles.equals(other.idCuarteles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Cuarteles[ idCuarteles=" + idCuarteles + " ]";
    }
    
}
