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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "eventoagenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventoagenda.findAll", query = "SELECT e FROM Eventoagenda e"),
    @NamedQuery(name = "Eventoagenda.findByIdEvento", query = "SELECT e FROM Eventoagenda e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Eventoagenda.findByNombreEvento", query = "SELECT e FROM Eventoagenda e WHERE e.nombreEvento = :nombreEvento"),
    @NamedQuery(name = "Eventoagenda.findByFechaInicio", query = "SELECT e FROM Eventoagenda e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Eventoagenda.findByFechaFin", query = "SELECT e FROM Eventoagenda e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Eventoagenda.findByUsuario", query = "SELECT e FROM Eventoagenda e WHERE e.usuariosidUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Eventoagenda.findByTipoEvento", query = "SELECT e FROM Eventoagenda e WHERE e.tipoEvento = :tipoEvento")})
public class Eventoagenda implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreEvento")
    private String nombreEvento;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionEvento")
    private String descripcionEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipoEvento")
    private String tipoEvento;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoAgenda")
    private List<Citas> citasList;

    public Eventoagenda() {
    }

    public Eventoagenda(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Eventoagenda(Integer idEvento, String nombreEvento, Date fechaInicio, Date fechaFin, String tipoEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoEvento = tipoEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Usuarios getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Usuarios usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventoagenda)) {
            return false;
        }
        Eventoagenda other = (Eventoagenda) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Eventoagenda[ idEvento=" + idEvento + " ]";
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }
    
}
