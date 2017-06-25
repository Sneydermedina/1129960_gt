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
import javax.persistence.Lob;
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
@Table(name = "certificadotrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificadotrabajo.findAll", query = "SELECT c FROM Certificadotrabajo c"),
    @NamedQuery(name = "Certificadotrabajo.findByIdCertificadoTrabajo", query = "SELECT c FROM Certificadotrabajo c WHERE c.idCertificadoTrabajo = :idCertificadoTrabajo"),
    @NamedQuery(name = "Certificadotrabajo.findByEmpresa", query = "SELECT c FROM Certificadotrabajo c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Certificadotrabajo.findByFechaCertificado", query = "SELECT c FROM Certificadotrabajo c WHERE c.fechaCertificado = :fechaCertificado")})
public class Certificadotrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCertificadoTrabajo")
    private Integer idCertificadoTrabajo;
    @Lob
    @Column(name = "certificado")
    private Byte[] certificado;
    @Size(max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Lob
    @Size(max = 65535)
    @Column(name = "serviciosPrestados")
    private String serviciosPrestados;
    @Size(max = 45)
    @Column(name = "fechaCertificado")
    private String fechaCertificado;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;

    public Certificadotrabajo() {
    }

    public Certificadotrabajo(Integer idCertificadoTrabajo) {
        this.idCertificadoTrabajo = idCertificadoTrabajo;
    }

    public Integer getIdCertificadoTrabajo() {
        return idCertificadoTrabajo;
    }

    public void setIdCertificadoTrabajo(Integer idCertificadoTrabajo) {
        this.idCertificadoTrabajo = idCertificadoTrabajo;
    }

    public Byte[] getCertificado() {
        return certificado;
    }

    public void setCertificado(Byte[] certificado) {
        this.certificado = certificado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getServiciosPrestados() {
        return serviciosPrestados;
    }

    public void setServiciosPrestados(String serviciosPrestados) {
        this.serviciosPrestados = serviciosPrestados;
    }

    public String getFechaCertificado() {
        return fechaCertificado;
    }

    public void setFechaCertificado(String fechaCertificado) {
        this.fechaCertificado = fechaCertificado;
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
        hash += (idCertificadoTrabajo != null ? idCertificadoTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificadotrabajo)) {
            return false;
        }
        Certificadotrabajo other = (Certificadotrabajo) object;
        if ((this.idCertificadoTrabajo == null && other.idCertificadoTrabajo != null) || (this.idCertificadoTrabajo != null && !this.idCertificadoTrabajo.equals(other.idCertificadoTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Certificadotrabajo[ idCertificadoTrabajo=" + idCertificadoTrabajo + " ]";
    }
    
}
