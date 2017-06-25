/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByIdespecialidad", query = "SELECT e FROM Especialidad e WHERE e.idespecialidad = :idespecialidad"),
    @NamedQuery(name = "Especialidad.findByEspecialidad", query = "SELECT e FROM Especialidad e WHERE e.especialidad = :especialidad")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idespecialidad")
    private Integer idespecialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "especialidad")
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadIdespecialidad")
    private List<Relespecialidadtecnicos> relespecialidadtecnicosList;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;

    public Especialidad() {
    }

    public Especialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public Especialidad(Integer idespecialidad, String especialidad) {
        this.idespecialidad = idespecialidad;
        this.especialidad = especialidad;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @XmlTransient
    public List<Relespecialidadtecnicos> getRelespecialidadtecnicosList() {
        return relespecialidadtecnicosList;
    }

    public void setRelespecialidadtecnicosList(List<Relespecialidadtecnicos> relespecialidadtecnicosList) {
        this.relespecialidadtecnicosList = relespecialidadtecnicosList;
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
        hash += (idespecialidad != null ? idespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idespecialidad == null && other.idespecialidad != null) || (this.idespecialidad != null && !this.idespecialidad.equals(other.idespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Especialidad[ idespecialidad=" + idespecialidad + " ]";
    }
    
}
