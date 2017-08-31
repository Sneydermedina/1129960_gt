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
@Table(name = "contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c"),
    @NamedQuery(name = "Contactos.listaContactos", query = "SELECT c FROM Contactos c WHERE c.idUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Contactos.listaContactosP", query = "SELECT c FROM Contactos c WHERE c.idContacto.idUsuario = :idUsuario"),
    @NamedQuery(name = "Contactos.validaContacto", query = "SELECT c FROM Contactos c WHERE c.idContacto.idUsuario = :idContacto AND c.idUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Contactos.findByIdC", query = "SELECT c FROM Contactos c WHERE c.idC = :idC")})
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_c")
    private Integer idC;
    @JoinColumn(name = "id_contacto", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idContacto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Contactos() {
    }

    public Contactos(Integer idC) {
        this.idC = idC;
    }
    
    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Usuarios getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Usuarios idContacto) {
        this.idContacto = idContacto;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Contactos[ idC=" + idC + " ]";
    }
    
}
