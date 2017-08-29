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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "relequiposervicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relequiposervicio.findAll", query = "SELECT r FROM Relequiposervicio r"),
    @NamedQuery(name = "Relequiposervicio.comentarios", query = "SELECT r FROM Relequiposervicio r WHERE r.servicionoTiquet.noTiquet = :noTiquet"),
    @NamedQuery(name = "Relequiposervicio.findByIdrelEquipoServicio", query = "SELECT r FROM Relequiposervicio r WHERE r.idrelEquipoServicio = :idrelEquipoServicio")})
public class Relequiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelEquipoServicio")
    private Integer idrelEquipoServicio;
    @JoinColumn(name = "equipo_idEquipo", referencedColumnName = "idEquipo")
    @ManyToOne(optional = false)
    private Equipo equipoidEquipo;
    @JoinColumn(name = "servicio_noTiquet", referencedColumnName = "noTiquet")
    @ManyToOne(optional = false)
    private Servicio servicionoTiquet;
    @Size(max = 200)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuario;

    public Relequiposervicio() {
    }

    public Relequiposervicio(Integer idrelEquipoServicio) {
        this.idrelEquipoServicio = idrelEquipoServicio;
    }

    public Integer getIdrelEquipoServicio() {
        return idrelEquipoServicio;
    }

    public void setIdrelEquipoServicio(Integer idrelEquipoServicio) {
        this.idrelEquipoServicio = idrelEquipoServicio;
    }

    public Equipo getEquipoidEquipo() {
        return equipoidEquipo;
    }

    public void setEquipoidEquipo(Equipo equipoidEquipo) {
        this.equipoidEquipo = equipoidEquipo;
    }

    public Servicio getServicionoTiquet() {
        return servicionoTiquet;
    }

    public void setServicionoTiquet(Servicio servicionoTiquet) {
        this.servicionoTiquet = servicionoTiquet;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelEquipoServicio != null ? idrelEquipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relequiposervicio)) {
            return false;
        }
        Relequiposervicio other = (Relequiposervicio) object;
        if ((this.idrelEquipoServicio == null && other.idrelEquipoServicio != null) || (this.idrelEquipoServicio != null && !this.idrelEquipoServicio.equals(other.idrelEquipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Relequiposervicio[ idrelEquipoServicio=" + idrelEquipoServicio + " ]";
    }
    
}
