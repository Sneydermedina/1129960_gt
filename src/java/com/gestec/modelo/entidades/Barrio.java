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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b order by b.nombreBarrio"),
    @NamedQuery(name = "Barrio.findByIdBarrio", query = "SELECT b FROM Barrio b WHERE b.idBarrio = :idBarrio"),
    @NamedQuery(name = "Barrio.findByNombreBarrio", query = "SELECT b FROM Barrio b WHERE b.nombreBarrio = :nombreBarrio")})
public class Barrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreBarrio")
    private String nombreBarrio;
    @JoinColumn(name = "idLocalidad", referencedColumnName = "idLocalidad")
    @ManyToOne(optional = false)
    private Localidad idLocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarrio")
    private List<Direccion> direccionList;

    public Barrio() {
    }

    public Barrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Barrio(Integer idBarrio, String nombreBarrio) {
        this.idBarrio = idBarrio;
        this.nombreBarrio = nombreBarrio;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarrio != null ? idBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idBarrio == null && other.idBarrio != null) || (this.idBarrio != null && !this.idBarrio.equals(other.idBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Barrio[ idBarrio=" + idBarrio + " ]";
    }
    
}
