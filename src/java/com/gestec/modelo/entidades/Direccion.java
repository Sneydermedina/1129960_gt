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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByUsuario", query = "SELECT d FROM Direccion d WHERE d.usuariosidUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByTipoVia", query = "SELECT d FROM Direccion d WHERE d.tipoVia = :tipoVia"),
    @NamedQuery(name = "Direccion.findByNumeroVia", query = "SELECT d FROM Direccion d WHERE d.numeroVia = :numeroVia"),
    @NamedQuery(name = "Direccion.findByComplementoVia", query = "SELECT d FROM Direccion d WHERE d.complementoVia = :complementoVia"),
    @NamedQuery(name = "Direccion.findByNumeroVia2", query = "SELECT d FROM Direccion d WHERE d.numeroVia2 = :numeroVia2"),
    @NamedQuery(name = "Direccion.findByComplementoVia2", query = "SELECT d FROM Direccion d WHERE d.complementoVia2 = :complementoVia2"),
    @NamedQuery(name = "Direccion.findByNumeroCasa", query = "SELECT d FROM Direccion d WHERE d.numeroCasa = :numeroCasa"),
    @NamedQuery(name = "Direccion.findByBarrio", query = "SELECT d FROM Direccion d WHERE d.idBarrio.idBarrio = :idBarrio"),
    @NamedQuery(name = "Direccion.findByComplemento", query = "SELECT d FROM Direccion d WHERE d.complemento = :complemento")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Size(max = 15)
    @Column(name = "tipoVia")
    private String tipoVia;
    @Column(name = "numeroVia")
    private Integer numeroVia;
    @Size(max = 20)
    @Column(name = "complementoVia")
    private String complementoVia;
    @Column(name = "numeroVia2")
    private Integer numeroVia2;
    @Size(max = 20)
    @Column(name = "complementoVia2")
    private String complementoVia2;
    @Column(name = "numeroCasa")
    private Integer numeroCasa;
    @Size(max = 20)
    @Column(name = "complemento")
    private String complemento;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccionidDireccion")
    private List<Solicitud> solicitudList;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public Integer getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(Integer numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getComplementoVia() {
        return complementoVia;
    }

    public void setComplementoVia(String complementoVia) {
        this.complementoVia = complementoVia;
    }

    public Integer getNumeroVia2() {
        return numeroVia2;
    }

    public void setNumeroVia2(Integer numeroVia2) {
        this.numeroVia2 = numeroVia2;
    }

    public String getComplementoVia2() {
        return complementoVia2;
    }

    public void setComplementoVia2(String complementoVia2) {
        this.complementoVia2 = complementoVia2;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Usuarios getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Usuarios usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
