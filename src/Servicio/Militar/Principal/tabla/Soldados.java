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
    @NamedQuery(name = "Soldados.findAll", query = "SELECT s FROM Soldados s")
    , @NamedQuery(name = "Soldados.findByIdSoldados", query = "SELECT s FROM Soldados s WHERE s.idSoldados = :idSoldados")
    , @NamedQuery(name = "Soldados.findByNombre", query = "SELECT s FROM Soldados s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Soldados.findByApellido", query = "SELECT s FROM Soldados s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "Soldados.findByCedula", query = "SELECT s FROM Soldados s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "Soldados.findByRango", query = "SELECT s FROM Soldados s WHERE s.rango = :rango")})
public class Soldados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idSoldados;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public Soldados() {
    }

    public Soldados(String idSoldados) {
        this.idSoldados = idSoldados;
    }

    public String getIdSoldados() {
        return idSoldados;
    }

    public void setIdSoldados(String idSoldados) {
        this.idSoldados = idSoldados;
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
        hash += (idSoldados != null ? idSoldados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soldados)) {
            return false;
        }
        Soldados other = (Soldados) object;
        if ((this.idSoldados == null && other.idSoldados != null) || (this.idSoldados != null && !this.idSoldados.equals(other.idSoldados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Soldados[ idSoldados=" + idSoldados + " ]";
    }
    
}
