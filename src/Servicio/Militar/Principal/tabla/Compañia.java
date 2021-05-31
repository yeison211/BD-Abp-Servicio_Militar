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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(catalog = "bd_abp_desarrollo_de_software", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compa\u00f1ia.findAll", query = "SELECT c FROM Compa\u00f1ia c")
    , @NamedQuery(name = "Compa\u00f1ia.findByIdCompa\u00f1ia", query = "SELECT c FROM Compa\u00f1ia c WHERE c.idCompa\u00f1ia = :idCompa\u00f1ia")
    , @NamedQuery(name = "Compa\u00f1ia.findByActividadPrincipal", query = "SELECT c FROM Compa\u00f1ia c WHERE c.actividadPrincipal = :actividadPrincipal")})
public class Compañia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCompañia;
    private String actividadPrincipal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compa\u00f1iaidCompa\u00f1ia")
    private List<Cuarteles> cuartelesList;
    @JoinColumn(name = "Soldados_idSoldados", referencedColumnName = "idSoldados")
    @ManyToOne(optional = false)
    private Soldados soldadosidSoldados;

    public Compañia() {
    }

    public Compañia(Integer idCompañia) {
        this.idCompañia = idCompañia;
    }

    public Integer getIdCompañia() {
        return idCompañia;
    }

    public void setIdCompañia(Integer idCompañia) {
        this.idCompañia = idCompañia;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public List<Cuarteles> getCuartelesList() {
        return cuartelesList;
    }

    public void setCuartelesList(List<Cuarteles> cuartelesList) {
        this.cuartelesList = cuartelesList;
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
        hash += (idCompañia != null ? idCompañia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compañia)) {
            return false;
        }
        Compañia other = (Compañia) object;
        if ((this.idCompañia == null && other.idCompañia != null) || (this.idCompañia != null && !this.idCompañia.equals(other.idCompañia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Compa\u00f1ia[ idCompa\u00f1ia=" + idCompañia + " ]";
    }
    
}
