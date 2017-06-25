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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "tiposervicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposervicio.findAll", query = "SELECT t FROM Tiposervicio t"),
    @NamedQuery(name = "Tiposervicio.findByIdtipoServicio", query = "SELECT t FROM Tiposervicio t WHERE t.idtipoServicio = :idtipoServicio"),
    @NamedQuery(name = "Tiposervicio.findByTipoServicio", query = "SELECT t FROM Tiposervicio t WHERE t.tipoServicio = :tipoServicio")})
public class Tiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoServicio")
    private Integer idtipoServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoServicio")
    private String tipoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposervicioidtipoServicio")
    private List<Caracteristica> caracteristicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicioidtipoServicio")
    private List<Relsolicitudtipo> relsolicitudtipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicioidtipoServicio")
    private List<Relcaracteristicatipo> relcaracteristicatipoList;

    public Tiposervicio() {
    }

    public Tiposervicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public Tiposervicio(Integer idtipoServicio, String tipoServicio) {
        this.idtipoServicio = idtipoServicio;
        this.tipoServicio = tipoServicio;
    }

    public Integer getIdtipoServicio() {
        return idtipoServicio;
    }

    public void setIdtipoServicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @XmlTransient
    public List<Caracteristica> getCaracteristicaList() {
        return caracteristicaList;
    }

    public void setCaracteristicaList(List<Caracteristica> caracteristicaList) {
        this.caracteristicaList = caracteristicaList;
    }

    @XmlTransient
    public List<Relsolicitudtipo> getRelsolicitudtipoList() {
        return relsolicitudtipoList;
    }

    public void setRelsolicitudtipoList(List<Relsolicitudtipo> relsolicitudtipoList) {
        this.relsolicitudtipoList = relsolicitudtipoList;
    }

    @XmlTransient
    public List<Relcaracteristicatipo> getRelcaracteristicatipoList() {
        return relcaracteristicatipoList;
    }

    public void setRelcaracteristicatipoList(List<Relcaracteristicatipo> relcaracteristicatipoList) {
        this.relcaracteristicatipoList = relcaracteristicatipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoServicio != null ? idtipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposervicio)) {
            return false;
        }
        Tiposervicio other = (Tiposervicio) object;
        if ((this.idtipoServicio == null && other.idtipoServicio != null) || (this.idtipoServicio != null && !this.idtipoServicio.equals(other.idtipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Tiposervicio[ idtipoServicio=" + idtipoServicio + " ]";
    }
    
}
