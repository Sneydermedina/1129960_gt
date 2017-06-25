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
@Table(name = "empresa_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaUsuarios.findAll", query = "SELECT e FROM EmpresaUsuarios e"),
    @NamedQuery(name = "EmpresaUsuarios.findByIdEmpresaUsuario", query = "SELECT e FROM EmpresaUsuarios e WHERE e.idEmpresaUsuario = :idEmpresaUsuario")})
public class EmpresaUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa_usuario")
    private Integer idEmpresaUsuario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public EmpresaUsuarios() {
    }

    public EmpresaUsuarios(Integer idEmpresaUsuario) {
        this.idEmpresaUsuario = idEmpresaUsuario;
    }

    public Integer getIdEmpresaUsuario() {
        return idEmpresaUsuario;
    }

    public void setIdEmpresaUsuario(Integer idEmpresaUsuario) {
        this.idEmpresaUsuario = idEmpresaUsuario;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaUsuario != null ? idEmpresaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaUsuarios)) {
            return false;
        }
        EmpresaUsuarios other = (EmpresaUsuarios) object;
        if ((this.idEmpresaUsuario == null && other.idEmpresaUsuario != null) || (this.idEmpresaUsuario != null && !this.idEmpresaUsuario.equals(other.idEmpresaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.EmpresaUsuarios[ idEmpresaUsuario=" + idEmpresaUsuario + " ]";
    }
    
}
