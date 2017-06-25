/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "horadisponibilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horadisponibilidad.findAll", query = "SELECT h FROM Horadisponibilidad h"),
    @NamedQuery(name = "Horadisponibilidad.findByIdHoraDisponibilidad", query = "SELECT h FROM Horadisponibilidad h WHERE h.idHoraDisponibilidad = :idHoraDisponibilidad"),
    @NamedQuery(name = "Horadisponibilidad.findByHoraInicio", query = "SELECT h FROM Horadisponibilidad h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Horadisponibilidad.findByHoraFin", query = "SELECT h FROM Horadisponibilidad h WHERE h.horaFin = :horaFin")})
public class Horadisponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHoraDisponibilidad")
    private Integer idHoraDisponibilidad;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @JoinColumn(name = "solicitud_idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdsolicitud;

    public Horadisponibilidad() {
    }

    public Horadisponibilidad(Integer idHoraDisponibilidad) {
        this.idHoraDisponibilidad = idHoraDisponibilidad;
    }

    public Integer getIdHoraDisponibilidad() {
        return idHoraDisponibilidad;
    }

    public void setIdHoraDisponibilidad(Integer idHoraDisponibilidad) {
        this.idHoraDisponibilidad = idHoraDisponibilidad;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Solicitud getSolicitudIdsolicitud() {
        return solicitudIdsolicitud;
    }

    public void setSolicitudIdsolicitud(Solicitud solicitudIdsolicitud) {
        this.solicitudIdsolicitud = solicitudIdsolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoraDisponibilidad != null ? idHoraDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horadisponibilidad)) {
            return false;
        }
        Horadisponibilidad other = (Horadisponibilidad) object;
        if ((this.idHoraDisponibilidad == null && other.idHoraDisponibilidad != null) || (this.idHoraDisponibilidad != null && !this.idHoraDisponibilidad.equals(other.idHoraDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Horadisponibilidad[ idHoraDisponibilidad=" + idHoraDisponibilidad + " ]";
    }
    
}
