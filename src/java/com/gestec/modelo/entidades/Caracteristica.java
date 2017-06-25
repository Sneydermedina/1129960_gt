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
@Table(name = "caracteristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c"),
    @NamedQuery(name = "Caracteristica.findByIdCaracteristica", query = "SELECT c FROM Caracteristica c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "Caracteristica.findByCaracteristica", query = "SELECT c FROM Caracteristica c WHERE c.caracteristica = :caracteristica")})
public class Caracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCaracteristica")
    private Integer idCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Caracteristica")
    private String caracteristica;
    @JoinColumn(name = "tiposervicio_idtipoServicio", referencedColumnName = "idtipoServicio")
    @ManyToOne(optional = false)
    private Tiposervicio tiposervicioidtipoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaidCaracteristica")
    private List<Relcaracteristicatipo> relcaracteristicatipoList;

    public Caracteristica() {
    }

    public Caracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public Caracteristica(Integer idCaracteristica, String caracteristica) {
        this.idCaracteristica = idCaracteristica;
        this.caracteristica = caracteristica;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Tiposervicio getTiposervicioidtipoServicio() {
        return tiposervicioidtipoServicio;
    }

    public void setTiposervicioidtipoServicio(Tiposervicio tiposervicioidtipoServicio) {
        this.tiposervicioidtipoServicio = tiposervicioidtipoServicio;
    }

    @XmlTransient
    public List<Relcaracteristicatipo> getRelcaracteristicatipoList() {
        return relcaracteristicatipoList;
    }

    public void setRelcaracteristicatipoList(List<Relcaracteristicatipo> relcaracteristicatipoList) {
        this.relcaracteristicatipoList = relcaracteristicatipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristica)) {
            return false;
        }
        Caracteristica other = (Caracteristica) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Caracteristica[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
