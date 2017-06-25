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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "notificacion_cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionCita.findAll", query = "SELECT n FROM NotificacionCita n"),
    @NamedQuery(name = "NotificacionCita.findByIdNotificacionCita", query = "SELECT n FROM NotificacionCita n WHERE n.idNotificacionCita = :idNotificacionCita"),
    @NamedQuery(name = "NotificacionCita.findByEstadoNotificacion", query = "SELECT n FROM NotificacionCita n WHERE n.estadoNotificacion = :estadoNotificacion"),
    @NamedQuery(name = "NotificacionCita.findByFechaNotificacion", query = "SELECT n FROM NotificacionCita n WHERE n.fechaNotificacion = :fechaNotificacion")})
public class NotificacionCita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion_cita")
    private Integer idNotificacionCita;
    @Size(max = 20)
    @Column(name = "estado_notificacion")
    private String estadoNotificacion;
    @Column(name = "fecha_notificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @JoinColumn(name = "id_notificacion", referencedColumnName = "id_notificacion")
    @ManyToOne
    private Notificacion idNotificacion;
    @JoinColumn(name = "id_cita", referencedColumnName = "idCita")
    @ManyToOne
    private Citas idCita;

    public NotificacionCita() {
    }

    public NotificacionCita(Integer idNotificacionCita) {
        this.idNotificacionCita = idNotificacionCita;
    }

    public Integer getIdNotificacionCita() {
        return idNotificacionCita;
    }

    public void setIdNotificacionCita(Integer idNotificacionCita) {
        this.idNotificacionCita = idNotificacionCita;
    }

    public String getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(String estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Notificacion getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Notificacion idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Citas getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas idCita) {
        this.idCita = idCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacionCita != null ? idNotificacionCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionCita)) {
            return false;
        }
        NotificacionCita other = (NotificacionCita) object;
        if ((this.idNotificacionCita == null && other.idNotificacionCita != null) || (this.idNotificacionCita != null && !this.idNotificacionCita.equals(other.idNotificacionCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.NotificacionCita[ idNotificacionCita=" + idNotificacionCita + " ]";
    }
    
}
