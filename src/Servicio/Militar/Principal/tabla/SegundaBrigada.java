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
@Table(name = "segunda_brigada", catalog = "bd_abp_final", schema = "")
@NamedQueries({
    @NamedQuery(name = "SegundaBrigada.findAll", query = "SELECT s FROM SegundaBrigada s")
    , @NamedQuery(name = "SegundaBrigada.findByIdSegundaBrigada", query = "SELECT s FROM SegundaBrigada s WHERE s.idSegundaBrigada = :idSegundaBrigada")
    , @NamedQuery(name = "SegundaBrigada.findByIdSoldado", query = "SELECT s FROM SegundaBrigada s WHERE s.idSoldado = :idSoldado")
    , @NamedQuery(name = "SegundaBrigada.findByNombre", query = "SELECT s FROM SegundaBrigada s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegundaBrigada.findByApellido", query = "SELECT s FROM SegundaBrigada s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "SegundaBrigada.findByCedula", query = "SELECT s FROM SegundaBrigada s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "SegundaBrigada.findByRango", query = "SELECT s FROM SegundaBrigada s WHERE s.rango = :rango")})
public class SegundaBrigada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSegunda_Brigada")
    private Integer idSegundaBrigada;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public SegundaBrigada() {
    }

    public SegundaBrigada(Integer idSegundaBrigada) {
        this.idSegundaBrigada = idSegundaBrigada;
    }

    public Integer getIdSegundaBrigada() {
        return idSegundaBrigada;
    }

    public void setIdSegundaBrigada(Integer idSegundaBrigada) {
        this.idSegundaBrigada = idSegundaBrigada;
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
        hash += (idSegundaBrigada != null ? idSegundaBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegundaBrigada)) {
            return false;
        }
        SegundaBrigada other = (SegundaBrigada) object;
        if ((this.idSegundaBrigada == null && other.idSegundaBrigada != null) || (this.idSegundaBrigada != null && !this.idSegundaBrigada.equals(other.idSegundaBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.SegundaBrigada[ idSegundaBrigada=" + idSegundaBrigada + " ]";
    }
    
}
