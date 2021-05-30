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

/**
 *
 * @author PC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Artilleria.findAll", query = "SELECT a FROM Artilleria a")
    , @NamedQuery(name = "Artilleria.findByIdArtilleria", query = "SELECT a FROM Artilleria a WHERE a.idArtilleria = :idArtilleria")})
public class Artilleria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idArtilleria;
    @JoinColumn(name = "Soldados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soldados soldadosid;

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

    public Soldados getSoldadosid() {
        return soldadosid;
    }

    public void setSoldadosid(Soldados soldadosid) {
        this.soldadosid = soldadosid;
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
