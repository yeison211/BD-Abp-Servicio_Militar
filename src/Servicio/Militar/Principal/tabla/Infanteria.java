/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.tabla;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(catalog = "bd_abp_final", schema = "")
@NamedQueries({
    @NamedQuery(name = "Infanteria.findAll", query = "SELECT i FROM Infanteria i")
    , @NamedQuery(name = "Infanteria.findByIdInfanteria", query = "SELECT i FROM Infanteria i WHERE i.idInfanteria = :idInfanteria")
    , @NamedQuery(name = "Infanteria.findByIdSoldado", query = "SELECT i FROM Infanteria i WHERE i.idSoldado = :idSoldado")
    , @NamedQuery(name = "Infanteria.findByNombre", query = "SELECT i FROM Infanteria i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Infanteria.findByApellido", query = "SELECT i FROM Infanteria i WHERE i.apellido = :apellido")
    , @NamedQuery(name = "Infanteria.findByCedula", query = "SELECT i FROM Infanteria i WHERE i.cedula = :cedula")
    , @NamedQuery(name = "Infanteria.findByRango", query = "SELECT i FROM Infanteria i WHERE i.rango = :rango")})
public class Infanteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idInfanteria;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public Infanteria() {
    }

    public Infanteria(Integer idInfanteria) {
        this.idInfanteria = idInfanteria;
    }

    public Integer getIdInfanteria() {
        return idInfanteria;
    }

    public void setIdInfanteria(Integer idInfanteria) {
        this.idInfanteria = idInfanteria;
    }

    public String getIdSoldado() {
        return idSoldado;
    }

    public void setIdSoldado(String idSoldado) {
        this.idSoldado = idSoldado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfanteria != null ? idInfanteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infanteria)) {
            return false;
        }
        Infanteria other = (Infanteria) object;
        if ((this.idInfanteria == null && other.idInfanteria != null) || (this.idInfanteria != null && !this.idInfanteria.equals(other.idInfanteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Infanteria[ idInfanteria=" + idInfanteria + " ]";
    }
    
}
