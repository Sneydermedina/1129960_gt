/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "certificadoestudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificadoestudio.findAll", query = "SELECT c FROM Certificadoestudio c"),
    @NamedQuery(name = "Certificadoestudio.findByIdCertificadoEstudio", query = "SELECT c FROM Certificadoestudio c WHERE c.idCertificadoEstudio = :idCertificadoEstudio"),
    @NamedQuery(name = "Certificadoestudio.findByCentroEducativo", query = "SELECT c FROM Certificadoestudio c WHERE c.centroEducativo = :centroEducativo"),
    @NamedQuery(name = "Certificadoestudio.findByNivelEstudios", query = "SELECT c FROM Certificadoestudio c WHERE c.nivelEstudios = :nivelEstudios"),
    @NamedQuery(name = "Certificadoestudio.findByTitulo", query = "SELECT c FROM Certificadoestudio c WHERE c.titulo = :titulo"),
    @NamedQuery(name = "Certificadoestudio.findByFechaCertificado", query = "SELECT c FROM Certificadoestudio c WHERE c.fechaCertificado = :fechaCertificado")})
public class Certificadoestudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCertificadoEstudio")
    private Integer idCertificadoEstudio;
    @Lob
    @Column(name = "certificado")
    private Byte[] certificado;
    @Size(max = 45)
    @Column(name = "centroEducativo")
    private String centroEducativo;
    @Size(max = 45)
    @Column(name = "nivelEstudios")
    private String nivelEstudios;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fechaCertificado")
    @Temporal(TemporalType.DATE)
    private Date fechaCertificado;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;

    public Certificadoestudio() {
    }

    public Certificadoestudio(Integer idCertificadoEstudio) {
        this.idCertificadoEstudio = idCertificadoEstudio;
    }

    public Integer getIdCertificadoEstudio() {
        return idCertificadoEstudio;
    }

    public void setIdCertificadoEstudio(Integer idCertificadoEstudio) {
        this.idCertificadoEstudio = idCertificadoEstudio;
    }

    public Byte[] getCertificado() {
        return certificado;
    }

    public void setCertificado(Byte[] certificado) {
        this.certificado = certificado;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCertificado() {
        return fechaCertificado;
    }

    public void setFechaCertificado(Date fechaCertificado) {
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
        hash += (idCertificadoEstudio != null ? idCertificadoEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificadoestudio)) {
            return false;
        }
        Certificadoestudio other = (Certificadoestudio) object;
        if ((this.idCertificadoEstudio == null && other.idCertificadoEstudio != null) || (this.idCertificadoEstudio != null && !this.idCertificadoEstudio.equals(other.idCertificadoEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Certificadoestudio[ idCertificadoEstudio=" + idCertificadoEstudio + " ]";
    }
    
}
