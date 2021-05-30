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
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "solicitar_servicio")
@NamedQueries({
    @NamedQuery(name = "SolicitarServicio.findAll", query = "SELECT s FROM SolicitarServicio s")
    , @NamedQuery(name = "SolicitarServicio.findById", query = "SELECT s FROM SolicitarServicio s WHERE s.id = :id")})
public class SolicitarServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "Servicios_idServicios", referencedColumnName = "idServicios")
    @ManyToOne(optional = false)
    private Servicios serviciosidServicios;
    @JoinColumn(name = "Soldados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soldados soldadosid;

    public SolicitarServicio() {
    }

    public SolicitarServicio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servicios getServiciosidServicios() {
        return serviciosidServicios;
    }

    public void setServiciosidServicios(Servicios serviciosidServicios) {
        this.serviciosidServicios = serviciosidServicios;
    }

    public Soldados getSoldadosid() {
        return soldadosid;
    }

    public void setSoldadosid(Soldados soldadosid) {
        this.soldadosid = soldadosid;
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
        if (!(object instanceof SolicitarServicio)) {
            return false;
        }
        SolicitarServicio other = (SolicitarServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.SolicitarServicio[ id=" + id + " ]";
    }
    
}
