/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByReferencia", query = "SELECT e FROM Equipo e WHERE e.referencia = :referencia"),
    @NamedQuery(name = "Equipo.findByDescripcionEquipo", query = "SELECT e FROM Equipo e WHERE e.descripcionEquipo = :descripcionEquipo"),
    @NamedQuery(name = "Equipo.findByFechaUltimaRevision", query = "SELECT e FROM Equipo e WHERE e.fechaUltimaRevision = :fechaUltimaRevision"),
    @NamedQuery(name = "Equipo.findByMarcaEquipo", query = "SELECT e FROM Equipo e WHERE e.marcaEquipo = :marcaEquipo"),
    @NamedQuery(name = "Equipo.findBySerialEquipo", query = "SELECT e FROM Equipo e WHERE e.serialEquipo = :serialEquipo"),
    @NamedQuery(name = "Equipo.findByTipoEquipo", query = "SELECT e FROM Equipo e WHERE e.tipoEquipo = :tipoEquipo")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 255)
    @Column(name = "descripcionEquipo")
    private String descripcionEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaUltimaRevision")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaRevision;
    @Size(max = 40)
    @Column(name = "marcaEquipo")
    private String marcaEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "serialEquipo")
    private String serialEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoEquipo")
    private String tipoEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoidEquipo")
    private List<Relequiposervicio> relequiposervicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoidEquipo")
    private List<Equipomodificacion> equipomodificacionList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String referencia, Date fechaUltimaRevision, String serialEquipo, String tipoEquipo) {
        this.idEquipo = idEquipo;
        this.referencia = referencia;
        this.fechaUltimaRevision = fechaUltimaRevision;
        this.serialEquipo = serialEquipo;
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    public Date getFechaUltimaRevision() {
        return fechaUltimaRevision;
    }

    public void setFechaUltimaRevision(Date fechaUltimaRevision) {
        this.fechaUltimaRevision = fechaUltimaRevision;
    }

    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    @XmlTransient
    public List<Relequiposervicio> getRelequiposervicioList() {
        return relequiposervicioList;
    }

    public void setRelequiposervicioList(List<Relequiposervicio> relequiposervicioList) {
        this.relequiposervicioList = relequiposervicioList;
    }

    @XmlTransient
    public List<Equipomodificacion> getEquipomodificacionList() {
        return equipomodificacionList;
    }

    public void setEquipomodificacionList(List<Equipomodificacion> equipomodificacionList) {
        this.equipomodificacionList = equipomodificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
