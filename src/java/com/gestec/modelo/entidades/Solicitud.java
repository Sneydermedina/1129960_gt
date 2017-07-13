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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdsolicitud", query = "SELECT s FROM Solicitud s WHERE s.idsolicitud = :idsolicitud"),
    @NamedQuery(name = "Solicitud.findBySolicitudFecha", query = "SELECT s FROM Solicitud s WHERE s.solicitudFecha = :solicitudFecha"),
    @NamedQuery(name = "Solicitud.findByUsuario", query = "SELECT s FROM Solicitud s WHERE s.direccionidDireccion.idDireccion = :idDireccion")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsolicitud")
    private Integer idsolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitudFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitudFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Relsolicitudtipo> relsolicitudtipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Adjunto> adjuntoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Citas> citasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Respuestatecnico> respuestatecnicoList;
    @JoinColumn(name = "direccion_idDireccion", referencedColumnName = "idDireccion")
    @ManyToOne(optional = false)
    private Direccion direccionidDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Mensaje> mensajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdsolicitud")
    private List<Horadisponibilidad> horadisponibilidadList;

    public Solicitud() {
    }

    public Solicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Solicitud(Integer idsolicitud, Date solicitudFecha) {
        this.idsolicitud = idsolicitud;
        this.solicitudFecha = solicitudFecha;
    }

    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Date getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Date solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    @XmlTransient
    public List<Relsolicitudtipo> getRelsolicitudtipoList() {
        return relsolicitudtipoList;
    }

    public void setRelsolicitudtipoList(List<Relsolicitudtipo> relsolicitudtipoList) {
        this.relsolicitudtipoList = relsolicitudtipoList;
    }

    @XmlTransient
    public List<Adjunto> getAdjuntoList() {
        return adjuntoList;
    }

    public void setAdjuntoList(List<Adjunto> adjuntoList) {
        this.adjuntoList = adjuntoList;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @XmlTransient
    public List<Respuestatecnico> getRespuestatecnicoList() {
        return respuestatecnicoList;
    }

    public void setRespuestatecnicoList(List<Respuestatecnico> respuestatecnicoList) {
        this.respuestatecnicoList = respuestatecnicoList;
    }

    public Direccion getDireccionidDireccion() {
        return direccionidDireccion;
    }

    public void setDireccionidDireccion(Direccion direccionidDireccion) {
        this.direccionidDireccion = direccionidDireccion;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @XmlTransient
    public List<Horadisponibilidad> getHoradisponibilidadList() {
        return horadisponibilidadList;
    }

    public void setHoradisponibilidadList(List<Horadisponibilidad> horadisponibilidadList) {
        this.horadisponibilidadList = horadisponibilidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idsolicitud=" + idsolicitud + ", solicitudFecha=" + solicitudFecha + ", relsolicitudtipoList=" + relsolicitudtipoList + ", adjuntoList=" + adjuntoList + ", citasList=" + citasList + ", respuestatecnicoList=" + respuestatecnicoList + ", direccionidDireccion=" + direccionidDireccion + ", mensajeList=" + mensajeList + ", horadisponibilidadList=" + horadisponibilidadList + '}';
    }

    
    
}
