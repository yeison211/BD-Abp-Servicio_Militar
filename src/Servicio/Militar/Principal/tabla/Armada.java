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
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author PC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Armada.findAll", query = "SELECT a FROM Armada a")
    , @NamedQuery(name = "Armada.findByIdArmada", query = "SELECT a FROM Armada a WHERE a.idArmada = :idArmada")})
public class Armada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idArmada;
    @JoinColumn(name = "Soldados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soldados soldadosid;

    public Armada() {
    }

    public Armada(Integer idArmada) {
        this.idArmada = idArmada;
    }

    public Integer getIdArmada() {
        return idArmada;
    }

    public void setIdArmada(Integer idArmada) {
        this.idArmada = idArmada;
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
        hash += (idArmada != null ? idArmada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armada)) {
            return false;
        }
        Armada other = (Armada) object;
        if ((this.idArmada == null && other.idArmada != null) || (this.idArmada != null && !this.idArmada.equals(other.idArmada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Armada[ idArmada=" + idArmada + " ]";
    }

  

   
    
}
