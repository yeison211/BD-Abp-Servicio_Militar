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
@Table(catalog = "bd_abp_desarrollo_de_software", schema = "")
@NamedQueries({
    @NamedQuery(name = "Infanteria.findAll", query = "SELECT i FROM Infanteria i")
    , @NamedQuery(name = "Infanteria.findByIdInfanteria", query = "SELECT i FROM Infanteria i WHERE i.idInfanteria = :idInfanteria")})
public class Infanteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idInfanteria;
    @JoinColumn(name = "Soldados_idSoldados", referencedColumnName = "idSoldados")
    @ManyToOne(optional = false)
    private Soldados soldadosidSoldados;

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

    public Soldados getSoldadosidSoldados() {
        return soldadosidSoldados;
    }

    public void setSoldadosidSoldados(Soldados soldadosidSoldados) {
        this.soldadosidSoldados = soldadosidSoldados;
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