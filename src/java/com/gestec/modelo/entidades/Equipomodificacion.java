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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "equipomodificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipomodificacion.findAll", query = "SELECT e FROM Equipomodificacion e"),
    @NamedQuery(name = "Equipomodificacion.findByIdequipoActas", query = "SELECT e FROM Equipomodificacion e WHERE e.idequipoActas = :idequipoActas"),
    @NamedQuery(name = "Equipomodificacion.findByModificacion", query = "SELECT e FROM Equipomodificacion e WHERE e.modificacion = :modificacion"),
    @NamedQuery(name = "Equipomodificacion.findByFechaModifiacacion", query = "SELECT e FROM Equipomodificacion e WHERE e.fechaModifiacacion = :fechaModifiacacion")})
public class Equipomodificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipoActas")
    private Integer idequipoActas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modificacion")
    private String modificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaModifiacacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModifiacacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoModificacionidequipoActas")
    private List<Adjunto> adjuntoList;
    @JoinColumn(name = "equipo_idEquipo", referencedColumnName = "idEquipo")
    @ManyToOne(optional = false)
    private Equipo equipoidEquipo;

    public Equipomodificacion() {
    }

    public Equipomodificacion(Integer idequipoActas) {
        this.idequipoActas = idequipoActas;
    }

    public Equipomodificacion(Integer idequipoActas, String modificacion, Date fechaModifiacacion) {
        this.idequipoActas = idequipoActas;
        this.modificacion = modificacion;
        this.fechaModifiacacion = fechaModifiacacion;
    }

    public Integer getIdequipoActas() {
        return idequipoActas;
    }

    public void setIdequipoActas(Integer idequipoActas) {
        this.idequipoActas = idequipoActas;
    }

    public String getModificacion() {
        return modificacion;
    }

    public void setModificacion(String modificacion) {
        this.modificacion = modificacion;
    }

    public Date getFechaModifiacacion() {
        return fechaModifiacacion;
    }

    public void setFechaModifiacacion(Date fechaModifiacacion) {
        this.fechaModifiacacion = fechaModifiacacion;
    }

    @XmlTransient
    public List<Adjunto> getAdjuntoList() {
        return adjuntoList;
    }

    public void setAdjuntoList(List<Adjunto> adjuntoList) {
        this.adjuntoList = adjuntoList;
    }

    public Equipo getEquipoidEquipo() {
        return equipoidEquipo;
    }

    public void setEquipoidEquipo(Equipo equipoidEquipo) {
        this.equipoidEquipo = equipoidEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipoActas != null ? idequipoActas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipomodificacion)) {
            return false;
        }
        Equipomodificacion other = (Equipomodificacion) object;
        if ((this.idequipoActas == null && other.idequipoActas != null) || (this.idequipoActas != null && !this.idequipoActas.equals(other.idequipoActas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Equipomodificacion[ idequipoActas=" + idequipoActas + " ]";
    }
    
}
