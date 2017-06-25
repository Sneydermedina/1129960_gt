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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "relsolicitudtipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relsolicitudtipo.findAll", query = "SELECT r FROM Relsolicitudtipo r"),
    @NamedQuery(name = "Relsolicitudtipo.findByIdrelSolicitudTipo", query = "SELECT r FROM Relsolicitudtipo r WHERE r.idrelSolicitudTipo = :idrelSolicitudTipo")})
public class Relsolicitudtipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelSolicitudTipo")
    private Integer idrelSolicitudTipo;
    @JoinColumn(name = "solicitud_idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdsolicitud;
    @JoinColumn(name = "tipoServicio_idtipoServicio", referencedColumnName = "idtipoServicio")
    @ManyToOne(optional = false)
    private Tiposervicio tipoServicioidtipoServicio;

    public Relsolicitudtipo() {
    }

    public Relsolicitudtipo(Integer idrelSolicitudTipo) {
        this.idrelSolicitudTipo = idrelSolicitudTipo;
    }

    public Integer getIdrelSolicitudTipo() {
        return idrelSolicitudTipo;
    }

    public void setIdrelSolicitudTipo(Integer idrelSolicitudTipo) {
        this.idrelSolicitudTipo = idrelSolicitudTipo;
    }

    public Solicitud getSolicitudIdsolicitud() {
        return solicitudIdsolicitud;
    }

    public void setSolicitudIdsolicitud(Solicitud solicitudIdsolicitud) {
        this.solicitudIdsolicitud = solicitudIdsolicitud;
    }

    public Tiposervicio getTipoServicioidtipoServicio() {
        return tipoServicioidtipoServicio;
    }

    public void setTipoServicioidtipoServicio(Tiposervicio tipoServicioidtipoServicio) {
        this.tipoServicioidtipoServicio = tipoServicioidtipoServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelSolicitudTipo != null ? idrelSolicitudTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relsolicitudtipo)) {
            return false;
        }
        Relsolicitudtipo other = (Relsolicitudtipo) object;
        if ((this.idrelSolicitudTipo == null && other.idrelSolicitudTipo != null) || (this.idrelSolicitudTipo != null && !this.idrelSolicitudTipo.equals(other.idrelSolicitudTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Relsolicitudtipo[ idrelSolicitudTipo=" + idrelSolicitudTipo + " ]";
    }
    
}
