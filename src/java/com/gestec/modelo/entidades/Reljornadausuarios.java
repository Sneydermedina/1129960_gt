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
@Table(name = "reljornadausuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reljornadausuarios.findAll", query = "SELECT r FROM Reljornadausuarios r"),
    @NamedQuery(name = "Reljornadausuarios.findByIdrelJornadaUsuarios", query = "SELECT r FROM Reljornadausuarios r WHERE r.idrelJornadaUsuarios = :idrelJornadaUsuarios"),
    @NamedQuery(name = "Reljornadausuarios.findByJornadaAtencionidjornadaAtencion", query = "SELECT r FROM Reljornadausuarios r WHERE r.jornadaAtencionidjornadaAtencion = :jornadaAtencionidjornadaAtencion"),
    @NamedQuery(name = "Reljornadausuarios.findByUsuariosidUsuario", query = "SELECT r FROM Reljornadausuarios r WHERE r.usuariosidUsuario = :usuariosidUsuario")})
public class Reljornadausuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelJornadaUsuarios")
    private Integer idrelJornadaUsuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jornadaAtencion_idjornadaAtencion")
    private Integer jornadaAtencionidjornadaAtencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarios_idUsuario")
    private Integer usuariosidUsuario;

    public Reljornadausuarios() {
    }

    public Reljornadausuarios(Integer idrelJornadaUsuarios) {
        this.idrelJornadaUsuarios = idrelJornadaUsuarios;
    }

    public Reljornadausuarios(Integer idrelJornadaUsuarios, Integer jornadaAtencionidjornadaAtencion, Integer usuariosidUsuario) {
        this.idrelJornadaUsuarios = idrelJornadaUsuarios;
        this.jornadaAtencionidjornadaAtencion = jornadaAtencionidjornadaAtencion;
        this.usuariosidUsuario = usuariosidUsuario;
    }

    public Integer getIdrelJornadaUsuarios() {
        return idrelJornadaUsuarios;
    }

    public void setIdrelJornadaUsuarios(Integer idrelJornadaUsuarios) {
        this.idrelJornadaUsuarios = idrelJornadaUsuarios;
    }

    public int getJornadaAtencionidjornadaAtencion() {
        return jornadaAtencionidjornadaAtencion;
    }

    public void setJornadaAtencionidjornadaAtencion(Integer jornadaAtencionidjornadaAtencion) {
        this.jornadaAtencionidjornadaAtencion = jornadaAtencionidjornadaAtencion;
    }

    public int getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Integer usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelJornadaUsuarios != null ? idrelJornadaUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reljornadausuarios)) {
            return false;
        }
        Reljornadausuarios other = (Reljornadausuarios) object;
        if ((this.idrelJornadaUsuarios == null && other.idrelJornadaUsuarios != null) || (this.idrelJornadaUsuarios != null && !this.idrelJornadaUsuarios.equals(other.idrelJornadaUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Reljornadausuarios[ idrelJornadaUsuarios=" + idrelJornadaUsuarios + " ]";
    }
    
}
