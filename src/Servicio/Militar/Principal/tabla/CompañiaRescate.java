/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.tabla;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "compa\u00f1ia_rescate", catalog = "bd_abp_final", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compa\u00f1iaRescate.findAll", query = "SELECT c FROM Compa\u00f1iaRescate c")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByIdCompa\u00f1iaRescate", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.idCompa\u00f1iaRescate = :idCompa\u00f1iaRescate")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByIdSoldado", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.idSoldado = :idSoldado")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByNombre", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByApellido", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByCedula", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Compa\u00f1iaRescate.findByRango", query = "SELECT c FROM Compa\u00f1iaRescate c WHERE c.rango = :rango")})
public class CompañiaRescate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompa\u00f1ia_Rescate")
    private Integer idCompañiaRescate;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public CompañiaRescate() {
    }

    public CompañiaRescate(Integer idCompañiaRescate) {
        this.idCompañiaRescate = idCompañiaRescate;
    }

    public Integer getIdCompañiaRescate() {
        return idCompañiaRescate;
    }

    public void setIdCompañiaRescate(Integer idCompañiaRescate) {
        this.idCompañiaRescate = idCompañiaRescate;
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
        hash += (idCompañiaRescate != null ? idCompañiaRescate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompañiaRescate)) {
            return false;
        }
        CompañiaRescate other = (CompañiaRescate) object;
        if ((this.idCompañiaRescate == null && other.idCompañiaRescate != null) || (this.idCompañiaRescate != null && !this.idCompañiaRescate.equals(other.idCompañiaRescate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Compa\u00f1iaRescate[ idCompa\u00f1iaRescate=" + idCompañiaRescate + " ]";
    }
    
}
