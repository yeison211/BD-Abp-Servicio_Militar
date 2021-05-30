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
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findByIdServicios", query = "SELECT s FROM Servicios s WHERE s.idServicios = :idServicios")
    , @NamedQuery(name = "Servicios.findByGuardia", query = "SELECT s FROM Servicios s WHERE s.guardia = :guardia")
    , @NamedQuery(name = "Servicios.findByImaginaria", query = "SELECT s FROM Servicios s WHERE s.imaginaria = :imaginaria")
    , @NamedQuery(name = "Servicios.findByCuarteleros", query = "SELECT s FROM Servicios s WHERE s.cuarteleros = :cuarteleros")
    , @NamedQuery(name = "Servicios.findByFechaDeRealizacion", query = "SELECT s FROM Servicios s WHERE s.fechaDeRealizacion = :fechaDeRealizacion")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idServicios;
    private String guardia;
    private String imaginaria;
    private String cuarteleros;
    private String fechaDeRealizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciosidServicios")
    private List<SolicitarServicio> solicitarServicioList;

    public Servicios() {
    }

    public Servicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public Integer getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public String getGuardia() {
        return guardia;
    }

    public void setGuardia(String guardia) {
        this.guardia = guardia;
    }

    public String getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(String imaginaria) {
        this.imaginaria = imaginaria;
    }

    public String getCuarteleros() {
        return cuarteleros;
    }

    public void setCuarteleros(String cuarteleros) {
        this.cuarteleros = cuarteleros;
    }

    public String getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    public void setFechaDeRealizacion(String fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public List<SolicitarServicio> getSolicitarServicioList() {
        return solicitarServicioList;
    }

    public void setSolicitarServicioList(List<SolicitarServicio> solicitarServicioList) {
        this.solicitarServicioList = solicitarServicioList;
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
