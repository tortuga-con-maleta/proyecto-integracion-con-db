/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baliza;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo de la Sotta
 */
@Entity
@Table(name = "baliza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baliza.findAll", query = "SELECT b FROM Baliza b"),
    @NamedQuery(name = "Baliza.findByIdBaliza", query = "SELECT b FROM Baliza b WHERE b.idBaliza = :idBaliza"),
    @NamedQuery(name = "Baliza.findByCodBaliza", query = "SELECT b FROM Baliza b WHERE b.codBaliza = :codBaliza"),
    @NamedQuery(name = "Baliza.findByFkZona", query = "SELECT b FROM Baliza b WHERE b.fkZona = :fkZona")})
public class Baliza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_baliza")
    private Integer idBaliza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cod_baliza")
    private String codBaliza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_zona")
    private int fkZona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "baliza")
    private Zona zona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkBaliza")
    private Collection<Visita> visitaCollection;

    public Baliza() {
    }

    public Baliza(Integer idBaliza) {
        this.idBaliza = idBaliza;
    }

    public Baliza(Integer idBaliza, String codBaliza, int fkZona) {
        this.idBaliza = idBaliza;
        this.codBaliza = codBaliza;
        this.fkZona = fkZona;
    }

    public Integer getIdBaliza() {
        return idBaliza;
    }

    public void setIdBaliza(Integer idBaliza) {
        this.idBaliza = idBaliza;
    }

    public String getCodBaliza() {
        return codBaliza;
    }

    public void setCodBaliza(String codBaliza) {
        this.codBaliza = codBaliza;
    }

    public int getFkZona() {
        return fkZona;
    }

    public void setFkZona(int fkZona) {
        this.fkZona = fkZona;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBaliza != null ? idBaliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baliza)) {
            return false;
        }
        Baliza other = (Baliza) object;
        if ((this.idBaliza == null && other.idBaliza != null) || (this.idBaliza != null && !this.idBaliza.equals(other.idBaliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baliza.Baliza[ idBaliza=" + idBaliza + " ]";
    }
    
}
