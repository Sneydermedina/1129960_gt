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
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByIdCita", query = "SELECT c FROM Citas c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Citas.findByFechaCita", query = "SELECT c FROM Citas c WHERE c.fechaCita = :fechaCita"),
    @NamedQuery(name = "Citas.findByDuracionCita", query = "SELECT c FROM Citas c WHERE c.duracionCita = :duracionCita"),
    @NamedQuery(name = "Citas.findByEstadoCita", query = "SELECT c FROM Citas c WHERE c.estadoCita = :estadoCita")})
public class Citas implements Serializable {

    @OneToMany(mappedBy = "idCita")
    private List<NotificacionCita> notificacionCitaList;

    @Basic(optional = false)
    @NotNull
    @Column(name = "filtro")
    private int filtro;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCita")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "duracionCita")
    private String duracionCita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estadoCita")
    private String estadoCita;
    @JoinColumn(name = "servicio_noTiquet", referencedColumnName = "noTiquet")
    @ManyToOne(optional = false)
    private Servicio servicionoTiquet;
    @JoinColumn(name = "solicitud_idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdsolicitud;
    @JoinColumn(name = "id_evento", referencedColumnName = "idEvento")
    @ManyToOne(optional = false)
    private Eventoagenda eventoAgenda;

    public Citas() {
    }

    public Citas(Integer idCita) {
        this.idCita = idCita;
    }

    public Citas(Integer idCita, Date fechaCita, String duracionCita, String estadoCita) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.duracionCita = duracionCita;
        this.estadoCita = estadoCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDuracionCita() {
        return duracionCita;
    }

    public void setDuracionCita(String duracionCita) {
        this.duracionCita = duracionCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
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
   

    public Eventoagenda getEventoAgenda() {
        return eventoAgenda;
    }

    public void setEventoAgenda(Eventoagenda eventoAgenda) {
        this.eventoAgenda = eventoAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Citas[ idCita=" + idCita + " ]";
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    @XmlTransient
    public List<NotificacionCita> getNotificacionCitaList() {
        return notificacionCitaList;
    }

    public void setNotificacionCitaList(List<NotificacionCita> notificacionCitaList) {
        this.notificacionCitaList = notificacionCitaList;
    }
    
}
