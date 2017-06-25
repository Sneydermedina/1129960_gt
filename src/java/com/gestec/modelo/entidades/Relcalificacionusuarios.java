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
@Table(name = "relcalificacionusuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relcalificacionusuarios.findAll", query = "SELECT r FROM Relcalificacionusuarios r"),
    @NamedQuery(name = "Relcalificacionusuarios.findByIdrelCalificacionUsuarios", query = "SELECT r FROM Relcalificacionusuarios r WHERE r.idrelCalificacionUsuarios = :idrelCalificacionUsuarios")})
public class Relcalificacionusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelCalificacionUsuarios")
    private Integer idrelCalificacionUsuarios;
    @JoinColumn(name = "calificacion_idcalificacion", referencedColumnName = "idcalificacion")
    @ManyToOne(optional = false)
    private Calificacion calificacionIdcalificacion;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;

    public Relcalificacionusuarios() {
    }

    public Relcalificacionusuarios(Integer idrelCalificacionUsuarios) {
        this.idrelCalificacionUsuarios = idrelCalificacionUsuarios;
    }

    public Integer getIdrelCalificacionUsuarios() {
        return idrelCalificacionUsuarios;
    }

    public void setIdrelCalificacionUsuarios(Integer idrelCalificacionUsuarios) {
        this.idrelCalificacionUsuarios = idrelCalificacionUsuarios;
    }

    public Calificacion getCalificacionIdcalificacion() {
        return calificacionIdcalificacion;
    }

    public void setCalificacionIdcalificacion(Calificacion calificacionIdcalificacion) {
        this.calificacionIdcalificacion = calificacionIdcalificacion;
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
        hash += (idrelCalificacionUsuarios != null ? idrelCalificacionUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relcalificacionusuarios)) {
            return false;
        }
        Relcalificacionusuarios other = (Relcalificacionusuarios) object;
        if ((this.idrelCalificacionUsuarios == null && other.idrelCalificacionUsuarios != null) || (this.idrelCalificacionUsuarios != null && !this.idrelCalificacionUsuarios.equals(other.idrelCalificacionUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Relcalificacionusuarios[ idrelCalificacionUsuarios=" + idrelCalificacionUsuarios + " ]";
    }
    
}
