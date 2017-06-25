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
@Table(name = "relcaracteristicatipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relcaracteristicatipo.findAll", query = "SELECT r FROM Relcaracteristicatipo r"),
    @NamedQuery(name = "Relcaracteristicatipo.findByIdrelCaracteristicaTipo", query = "SELECT r FROM Relcaracteristicatipo r WHERE r.idrelCaracteristicaTipo = :idrelCaracteristicaTipo")})
public class Relcaracteristicatipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelCaracteristicaTipo")
    private Integer idrelCaracteristicaTipo;
    @JoinColumn(name = "Caracteristica_idCaracteristica", referencedColumnName = "idCaracteristica")
    @ManyToOne(optional = false)
    private Caracteristica caracteristicaidCaracteristica;
    @JoinColumn(name = "tipoServicio_idtipoServicio", referencedColumnName = "idtipoServicio")
    @ManyToOne(optional = false)
    private Tiposervicio tipoServicioidtipoServicio;

    public Relcaracteristicatipo() {
    }

    public Relcaracteristicatipo(Integer idrelCaracteristicaTipo) {
        this.idrelCaracteristicaTipo = idrelCaracteristicaTipo;
    }

    public Integer getIdrelCaracteristicaTipo() {
        return idrelCaracteristicaTipo;
    }

    public void setIdrelCaracteristicaTipo(Integer idrelCaracteristicaTipo) {
        this.idrelCaracteristicaTipo = idrelCaracteristicaTipo;
    }

    public Caracteristica getCaracteristicaidCaracteristica() {
        return caracteristicaidCaracteristica;
    }

    public void setCaracteristicaidCaracteristica(Caracteristica caracteristicaidCaracteristica) {
        this.caracteristicaidCaracteristica = caracteristicaidCaracteristica;
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
        hash += (idrelCaracteristicaTipo != null ? idrelCaracteristicaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relcaracteristicatipo)) {
            return false;
        }
        Relcaracteristicatipo other = (Relcaracteristicatipo) object;
        if ((this.idrelCaracteristicaTipo == null && other.idrelCaracteristicaTipo != null) || (this.idrelCaracteristicaTipo != null && !this.idrelCaracteristicaTipo.equals(other.idrelCaracteristicaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Relcaracteristicatipo[ idrelCaracteristicaTipo=" + idrelCaracteristicaTipo + " ]";
    }
    
}
