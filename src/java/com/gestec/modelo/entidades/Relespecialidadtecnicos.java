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
@Table(name = "relespecialidadtecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relespecialidadtecnicos.findAll", query = "SELECT r FROM Relespecialidadtecnicos r"),
    @NamedQuery(name = "Relespecialidadtecnicos.findByIdrelEspecialidadTecnicos", query = "SELECT r FROM Relespecialidadtecnicos r WHERE r.idrelEspecialidadTecnicos = :idrelEspecialidadTecnicos"),
    @NamedQuery(name = "Relespecialidadtecnicos.findByTecnicosidTecnico", query = "SELECT r FROM Relespecialidadtecnicos r WHERE r.tecnicosidTecnico = :tecnicosidTecnico")})
public class Relespecialidadtecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelEspecialidadTecnicos")
    private Integer idrelEspecialidadTecnicos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tecnicos_idTecnico")
    private int tecnicosidTecnico;
    @JoinColumn(name = "especialidad_idespecialidad", referencedColumnName = "idespecialidad")
    @ManyToOne(optional = false)
    private Especialidad especialidadIdespecialidad;

    public Relespecialidadtecnicos() {
    }

    public Relespecialidadtecnicos(Integer idrelEspecialidadTecnicos) {
        this.idrelEspecialidadTecnicos = idrelEspecialidadTecnicos;
    }

    public Relespecialidadtecnicos(Integer idrelEspecialidadTecnicos, int tecnicosidTecnico) {
        this.idrelEspecialidadTecnicos = idrelEspecialidadTecnicos;
        this.tecnicosidTecnico = tecnicosidTecnico;
    }

    public Integer getIdrelEspecialidadTecnicos() {
        return idrelEspecialidadTecnicos;
    }

    public void setIdrelEspecialidadTecnicos(Integer idrelEspecialidadTecnicos) {
        this.idrelEspecialidadTecnicos = idrelEspecialidadTecnicos;
    }

    public int getTecnicosidTecnico() {
        return tecnicosidTecnico;
    }

    public void setTecnicosidTecnico(int tecnicosidTecnico) {
        this.tecnicosidTecnico = tecnicosidTecnico;
    }

    public Especialidad getEspecialidadIdespecialidad() {
        return especialidadIdespecialidad;
    }

    public void setEspecialidadIdespecialidad(Especialidad especialidadIdespecialidad) {
        this.especialidadIdespecialidad = especialidadIdespecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelEspecialidadTecnicos != null ? idrelEspecialidadTecnicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relespecialidadtecnicos)) {
            return false;
        }
        Relespecialidadtecnicos other = (Relespecialidadtecnicos) object;
        if ((this.idrelEspecialidadTecnicos == null && other.idrelEspecialidadTecnicos != null) || (this.idrelEspecialidadTecnicos != null && !this.idrelEspecialidadTecnicos.equals(other.idrelEspecialidadTecnicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Relespecialidadtecnicos[ idrelEspecialidadTecnicos=" + idrelEspecialidadTecnicos + " ]";
    }
    
}
