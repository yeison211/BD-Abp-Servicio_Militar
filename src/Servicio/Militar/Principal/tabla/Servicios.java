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
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findByIdServicios", query = "SELECT s FROM Servicios s WHERE s.idServicios = :idServicios")
    , @NamedQuery(name = "Servicios.findByNombre", query = "SELECT s FROM Servicios s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Servicios.findByApellido", query = "SELECT s FROM Servicios s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "Servicios.findByCedula", query = "SELECT s FROM Servicios s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "Servicios.findByOpcionservicio", query = "SELECT s FROM Servicios s WHERE s.opcionservicio = :opcionservicio")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idServicios;
    private String nombre;
    private String apellido;
    private String cedula;
    @Column(name = "Opcion_servicio")
    private String opcionservicio;

    public Servicios() {
    }

    public Servicios(String idServicios) {
        this.idServicios = idServicios;
    }

    public String getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(String idServicios) {
        this.idServicios = idServicios;
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

    public String getOpcionservicio() {
        return opcionservicio;
    }

    public void setOpcionservicio(String opcionservicio) {
        this.opcionservicio = opcionservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicios != null ? idServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicios == null && other.idServicios != null) || (this.idServicios != null && !this.idServicios.equals(other.idServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Servicios[ idServicios=" + idServicios + " ]";
    }
    
}
