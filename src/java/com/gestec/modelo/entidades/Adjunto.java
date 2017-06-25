/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "adjunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adjunto.findAll", query = "SELECT a FROM Adjunto a"),
    @NamedQuery(name = "Adjunto.findByIdadjunto", query = "SELECT a FROM Adjunto a WHERE a.idadjunto = :idadjunto")})
public class Adjunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadjunto")
    private Integer idadjunto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "adjunto")
    private byte[] adjunto;
    @JoinColumn(name = "equipoModificacion_idequipoActas", referencedColumnName = "idequipoActas")
    @ManyToOne(optional = false)
    private Equipomodificacion equipoModificacionidequipoActas;
    @JoinColumn(name = "servicio_noTiquet", referencedColumnName = "noTiquet")
    @ManyToOne(optional = false)
    private Servicio servicionoTiquet;
    @JoinColumn(name = "solicitud_idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdsolicitud;

    public Adjunto() {
    }

    public Adjunto(Integer idadjunto) {
        this.idadjunto = idadjunto;
    }

    public Adjunto(Integer idadjunto, byte[] adjunto) {
        this.idadjunto = idadjunto;
        this.adjunto = adjunto;
    }

    public Integer getIdadjunto() {
        return idadjunto;
    }

    public void setIdadjunto(Integer idadjunto) {
        this.idadjunto = idadjunto;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public Equipomodificacion getEquipoModificacionidequipoActas() {
        return equipoModificacionidequipoActas;
    }

    public void setEquipoModificacionidequipoActas(Equipomodificacion equipoModificacionidequipoActas) {
        this.equipoModificacionidequipoActas = equipoModificacionidequipoActas;
    }

    public Servicio getServicionoTiquet() {
        return servicionoTiquet;
    }

    public void setServicionoTiquet(Servicio servicionoTiquet) {
        this.servicionoTiquet = servicionoTiquet;
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
        hash += (idadjunto != null ? idadjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adjunto)) {
            return false;
        }
        Adjunto other = (Adjunto) object;
        if ((this.idadjunto == null && other.idadjunto != null) || (this.idadjunto != null && !this.idadjunto.equals(other.idadjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Adjunto[ idadjunto=" + idadjunto + " ]";
    }
    
}
