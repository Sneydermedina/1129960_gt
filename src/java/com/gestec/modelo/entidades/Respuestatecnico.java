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
@Table(name = "respuestatecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestatecnico.findAll", query = "SELECT r FROM Respuestatecnico r"),
    @NamedQuery(name = "Respuestatecnico.findByIdRespuesta", query = "SELECT r FROM Respuestatecnico r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuestatecnico.findByTiempoCita", query = "SELECT r FROM Respuestatecnico r WHERE r.tiempoCita = :tiempoCita"),
    @NamedQuery(name = "Respuestatecnico.findByPosibleCosto", query = "SELECT r FROM Respuestatecnico r WHERE r.posibleCosto = :posibleCosto"),
    @NamedQuery(name = "Respuestatecnico.findByTecnicosidTecnico", query = "SELECT r FROM Respuestatecnico r WHERE r.tecnicosidTecnico = :tecnicosidTecnico")})
public class Respuestatecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempoCita")
    private Integer tiempoCita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posibleCosto")
    private Integer posibleCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tecnicos_idTecnico")
    private Integer tecnicosidTecnico;
    @JoinColumn(name = "solicitud_idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdsolicitud;

    public Respuestatecnico() {
    }

    public Respuestatecnico(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuestatecnico(Integer idRespuesta, Integer tiempoCita, Integer posibleCosto, Integer tecnicosidTecnico) {
        this.idRespuesta = idRespuesta;
        this.tiempoCita = tiempoCita;
        this.posibleCosto = posibleCosto;
        this.tecnicosidTecnico = tecnicosidTecnico;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getTiempoCita() {
        return tiempoCita;
    }

    public void setTiempoCita(Integer tiempoCita) {
        this.tiempoCita = tiempoCita;
    }

    public int getPosibleCosto() {
        return posibleCosto;
    }

    public void setPosibleCosto(Integer posibleCosto) {
        this.posibleCosto = posibleCosto;
    }

    public Integer getTecnicosidTecnico() {
        return tecnicosidTecnico;
    }

    public void setTecnicosidTecnico(Integer tecnicosidTecnico) {
        this.tecnicosidTecnico = tecnicosidTecnico;
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
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestatecnico)) {
            return false;
        }
        Respuestatecnico other = (Respuestatecnico) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Respuestatecnico[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
