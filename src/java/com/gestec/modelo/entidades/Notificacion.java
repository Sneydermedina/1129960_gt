/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n"),
    @NamedQuery(name = "Notificacion.findByIdNotificacion", query = "SELECT n FROM Notificacion n WHERE n.idNotificacion = :idNotificacion"),
    @NamedQuery(name = "Notificacion.findByNotificacion", query = "SELECT n FROM Notificacion n WHERE n.notificacion = :notificacion")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_notificacion")
    private Integer idNotificacion;
    @Size(max = 200)
    @Column(name = "notificacion")
    private String notificacion;
    @OneToMany(mappedBy = "idNotificacion")
    private List<NotificacionUsuario> notificacionUsuarioList;
    @OneToMany(mappedBy = "idNotificacion")
    private List<NotificacionCita> notificacionCitaList;

    public Notificacion() {
    }

    public Notificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    @XmlTransient
    public List<NotificacionUsuario> getNotificacionUsuarioList() {
        return notificacionUsuarioList;
    }

    public void setNotificacionUsuarioList(List<NotificacionUsuario> notificacionUsuarioList) {
        this.notificacionUsuarioList = notificacionUsuarioList;
    }

    @XmlTransient
    public List<NotificacionCita> getNotificacionCitaList() {
        return notificacionCitaList;
    }

    public void setNotificacionCitaList(List<NotificacionCita> notificacionCitaList) {
        this.notificacionCitaList = notificacionCitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacion != null ? idNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.idNotificacion == null && other.idNotificacion != null) || (this.idNotificacion != null && !this.idNotificacion.equals(other.idNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Notificacion[ idNotificacion=" + idNotificacion + " ]";
    }
    
}
