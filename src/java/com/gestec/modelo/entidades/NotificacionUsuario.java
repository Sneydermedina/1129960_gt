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
@Table(name = "notificacion_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionUsuario.findAll", query = "SELECT n FROM NotificacionUsuario n"),
    @NamedQuery(name = "NotificacionUsuario.findByIdNotificacionUsuario", query = "SELECT n FROM NotificacionUsuario n WHERE n.idNotificacionUsuario = :idNotificacionUsuario"),
    @NamedQuery(name = "NotificacionUsuario.findByEstadoNotificacion", query = "SELECT n FROM NotificacionUsuario n WHERE n.estadoNotificacion = :estadoNotificacion"),
    @NamedQuery(name = "NotificacionUsuario.findByIdUsuario", query = "SELECT n FROM NotificacionUsuario n WHERE n.idUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "NotificacionUsuario.findByFechaNotificacion", query = "SELECT n FROM NotificacionUsuario n WHERE n.fechaNotificacion = :fechaNotificacion")})
public class NotificacionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_notificacion_usuario")
    private Integer idNotificacionUsuario;
    @Size(max = 20)
    @Column(name = "estado_notificacion")
    private String estadoNotificacion;
    @Column(name = "fecha_notificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @JoinColumn(name = "id_notificacion", referencedColumnName = "id_notificacion")
    @ManyToOne
    private Notificacion idNotificacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuario;

    public NotificacionUsuario() {
    }

    public NotificacionUsuario(Integer idNotificacionUsuario) {
        this.idNotificacionUsuario = idNotificacionUsuario;
    }

    public Integer getIdNotificacionUsuario() {
        return idNotificacionUsuario;
    }

    public void setIdNotificacionUsuario(Integer idNotificacionUsuario) {
        this.idNotificacionUsuario = idNotificacionUsuario;
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

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacionUsuario != null ? idNotificacionUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionUsuario)) {
            return false;
        }
        NotificacionUsuario other = (NotificacionUsuario) object;
        if ((this.idNotificacionUsuario == null && other.idNotificacionUsuario != null) || (this.idNotificacionUsuario != null && !this.idNotificacionUsuario.equals(other.idNotificacionUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.NotificacionUsuario[ idNotificacionUsuario=" + idNotificacionUsuario + " ]";
    }
    
}
