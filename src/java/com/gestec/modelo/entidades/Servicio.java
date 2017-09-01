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
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByNoTiquet", query = "SELECT s FROM Servicio s WHERE s.noTiquet = :noTiquet"),
    @NamedQuery(name = "Servicio.findByDescripcionServicio", query = "SELECT s FROM Servicio s WHERE s.descripcionServicio = :descripcionServicio"),
    @NamedQuery(name = "Servicio.findByEstadoServicio", query = "SELECT s FROM Servicio s WHERE s.estadoServicio = :estadoServicio"),
    @NamedQuery(name = "Servicio.findByCostoServicio", query = "SELECT s FROM Servicio s WHERE s.costoServicio = :costoServicio"),
    @NamedQuery(name = "Servicio.findByFechaServicio", query = "SELECT s FROM Servicio s WHERE s.fechaServicio = :fechaServicio"),
    @NamedQuery(name = "Servicio.findByGarantia", query = "SELECT s FROM Servicio s WHERE s.garantia = :garantia")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "noTiquet")
    private Integer noTiquet;
    @Size(max = 255)
    @Column(name = "descripcionServicio")
    private String descripcionServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoServicio")
    private String estadoServicio;
    @Size(max = 45)
    @Column(name = "costoServicio")
    private String costoServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaServicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "garantia")
    @Temporal(TemporalType.DATE)
    private Date garantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicionoTiquet")
    private List<Adjunto> adjuntoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicionoTiquet")
    private List<Citas> citasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicionoTiquet")
    private List<Relequiposervicio> relequiposervicioList;
    @Column(name = "cal_tecnico")
    private String calificacionTecnico;

    public Servicio() {
    }

    public Servicio(Integer noTiquet) {
        this.noTiquet = noTiquet;
    }

    public Servicio(Integer noTiquet, String estadoServicio, Date fechaServicio, Date garantia) {
        this.noTiquet = noTiquet;
        this.estadoServicio = estadoServicio;
        this.fechaServicio = fechaServicio;
        this.garantia = garantia;
    }

    public Integer getNoTiquet() {
        return noTiquet;
    }

    public void setNoTiquet(Integer noTiquet) {
        this.noTiquet = noTiquet;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public String getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(String costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Date getGarantia() {
        return garantia;
    }

    public void setGarantia(Date garantia) {
        this.garantia = garantia;
    }

    public String getCalificacionTecnico() {
        return calificacionTecnico;
    }

    public void setCalificacionTecnico(String calificacionTecnico) {
        this.calificacionTecnico = calificacionTecnico;
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
    public List<Relequiposervicio> getRelequiposervicioList() {
        return relequiposervicioList;
    }

    public void setRelequiposervicioList(List<Relequiposervicio> relequiposervicioList) {
        this.relequiposervicioList = relequiposervicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noTiquet != null ? noTiquet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.noTiquet == null && other.noTiquet != null) || (this.noTiquet != null && !this.noTiquet.equals(other.noTiquet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Servicio[ noTiquet=" + noTiquet + " ]";
    }
    
}
