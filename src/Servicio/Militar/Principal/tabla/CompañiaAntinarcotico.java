
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
@Table(name = "compa\u00f1ia_antinarcotico", catalog = "bd_abp_final", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findAll", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByIdCompa\u00f1oaAntinarcotico", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.idCompa\u00f1oaAntinarcotico = :idCompa\u00f1oaAntinarcotico")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByIdSoldado", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.idSoldado = :idSoldado")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByNombre", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByApellido", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByCedula", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Compa\u00f1iaAntinarcotico.findByRango", query = "SELECT c FROM Compa\u00f1iaAntinarcotico c WHERE c.rango = :rango")})
public class CompaĆ±iaAntinarcotico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompa\u00f1oa_Antinarcotico")
    private Integer idCompaĆ±oaAntinarcotico;
    private String idSoldado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String rango;

    public CompaĆ±iaAntinarcotico() {
    }

    public CompaĆ±iaAntinarcotico(Integer idCompaĆ±oaAntinarcotico) {
        this.idCompaĆ±oaAntinarcotico = idCompaĆ±oaAntinarcotico;
    }

    public Integer getIdCompaĆ±oaAntinarcotico() {
        return idCompaĆ±oaAntinarcotico;
    }

    public void setIdCompaĆ±oaAntinarcotico(Integer idCompaĆ±oaAntinarcotico) {
        this.idCompaĆ±oaAntinarcotico = idCompaĆ±oaAntinarcotico;
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
        hash += (idCompaĆ±oaAntinarcotico != null ? idCompaĆ±oaAntinarcotico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompaĆ±iaAntinarcotico)) {
            return false;
        }
        CompaĆ±iaAntinarcotico other = (CompaĆ±iaAntinarcotico) object;
        if ((this.idCompaĆ±oaAntinarcotico == null && other.idCompaĆ±oaAntinarcotico != null) || (this.idCompaĆ±oaAntinarcotico != null && !this.idCompaĆ±oaAntinarcotico.equals(other.idCompaĆ±oaAntinarcotico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio.Militar.Principal.tabla.Compa\u00f1iaAntinarcotico[ idCompa\u00f1oaAntinarcotico=" + idCompaĆ±oaAntinarcotico + " ]";
    }
    
}
