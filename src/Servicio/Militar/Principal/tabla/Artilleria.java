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
    @NamedQuery(name = "Artilleria.findAll", query = "SELECT a FROM Artilleria a")
    , @NamedQuery(name = "Artilleria.findByIdArtilleria", query = "SELECT a FROM Artilleria a WHERE a.idArtilleria = :idArtilleria")
    , @NamedQuery(name = "Artilleria.findByIdSoldado", query = "SELECT a FROM Artilleria a WHERE a.idSoldado = :idSoldado")
    , @NamedQuery(name = "Artilleria.findByNombre", query = "SELECT a FROM Artilleria a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Artilleria.findByApellido", query = "SELECT a FROM Artilleria a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Artilleria.findByCedula", query = "SELECT a FROM Artilleria a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Artilleria.findByRango", query = "SELECT a FROM Artilleria a WHERE a.rango = :rango")})
public class Artilleria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idArtilleria;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public Artilleria() {
    }

    public Artilleria(Integer idArtilleria) {
        this.idArtilleria = idArtilleria;
    }

    public Integer getIdArtilleria() {
        return idArtilleria;
    }

    public void setIdArtilleria(Integer idArtilleria) {
        this.idArtilleria = idArtilleria;
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
        hash += (idArtilleria != null ? idArtilleria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artilleria)) {
            return false;
        }
        Artilleria other = (Artilleria) object;
        if ((this.idArtilleria == null && other.idArtilleria != null) || (this.idArtilleria != null && !this.idArtilleria.equals(other.idArtilleria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Artilleria[ idArtilleria=" + idArtilleria + " ]";
    }
    
}
