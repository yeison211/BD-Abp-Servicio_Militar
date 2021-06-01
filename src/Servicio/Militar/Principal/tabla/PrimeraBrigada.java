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
@Table(name = "primera_brigada", catalog = "bd_abp_final", schema = "")
@NamedQueries({
    @NamedQuery(name = "PrimeraBrigada.findAll", query = "SELECT p FROM PrimeraBrigada p")
    , @NamedQuery(name = "PrimeraBrigada.findByIdPrimeraBrigada", query = "SELECT p FROM PrimeraBrigada p WHERE p.idPrimeraBrigada = :idPrimeraBrigada")
    , @NamedQuery(name = "PrimeraBrigada.findByIdSoldado", query = "SELECT p FROM PrimeraBrigada p WHERE p.idSoldado = :idSoldado")
    , @NamedQuery(name = "PrimeraBrigada.findByNombre", query = "SELECT p FROM PrimeraBrigada p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PrimeraBrigada.findByApellido", query = "SELECT p FROM PrimeraBrigada p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "PrimeraBrigada.findByCedula", query = "SELECT p FROM PrimeraBrigada p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "PrimeraBrigada.findByRango", query = "SELECT p FROM PrimeraBrigada p WHERE p.rango = :rango")})
public class PrimeraBrigada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrimera_Brigada")
    private Integer idPrimeraBrigada;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public PrimeraBrigada() {
    }

    public PrimeraBrigada(Integer idPrimeraBrigada) {
        this.idPrimeraBrigada = idPrimeraBrigada;
    }

    public Integer getIdPrimeraBrigada() {
        return idPrimeraBrigada;
    }

    public void setIdPrimeraBrigada(Integer idPrimeraBrigada) {
        this.idPrimeraBrigada = idPrimeraBrigada;
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
        hash += (idPrimeraBrigada != null ? idPrimeraBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrimeraBrigada)) {
            return false;
        }
        PrimeraBrigada other = (PrimeraBrigada) object;
        if ((this.idPrimeraBrigada == null && other.idPrimeraBrigada != null) || (this.idPrimeraBrigada != null && !this.idPrimeraBrigada.equals(other.idPrimeraBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.PrimeraBrigada[ idPrimeraBrigada=" + idPrimeraBrigada + " ]";
    }
    
}
