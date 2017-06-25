/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c"),
    @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion"),
    @NamedQuery(name = "Calificacion.findByIdcalificacion", query = "SELECT c FROM Calificacion c WHERE c.idcalificacion = :idcalificacion")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private double calificacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcalificacion")
    private Integer idcalificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calificacionIdcalificacion")
    private List<Relcalificacionusuarios> relcalificacionusuariosList;

    public Calificacion() {
    }

    public Calificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Calificacion(Integer idcalificacion, double calificacion) {
        this.idcalificacion = idcalificacion;
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    @XmlTransient
    public List<Relcalificacionusuarios> getRelcalificacionusuariosList() {
        return relcalificacionusuariosList;
    }

    public void setRelcalificacionusuariosList(List<Relcalificacionusuarios> relcalificacionusuariosList) {
        this.relcalificacionusuariosList = relcalificacionusuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalificacion != null ? idcalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idcalificacion == null && other.idcalificacion != null) || (this.idcalificacion != null && !this.idcalificacion.equals(other.idcalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Calificacion[ idcalificacion=" + idcalificacion + " ]";
    }
    
}
