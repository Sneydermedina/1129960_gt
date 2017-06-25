/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByContrasenaUsuario", query = "SELECT u FROM Usuarios u WHERE u.contrasenaUsuario = :contrasenaUsuario"),
    @NamedQuery(name = "Usuarios.findByDocumento", query = "SELECT u FROM Usuarios u WHERE u.documento = :documento"),
    @NamedQuery(name = "Usuarios.findByTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuarios.findByTipoDocumento", query = "SELECT u FROM Usuarios u WHERE u.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuarios.findByEstadoUsuario", query = "SELECT u FROM Usuarios u WHERE u.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Usuarios.findByWeb", query = "SELECT u FROM Usuarios u WHERE u.web = :web"),
    @NamedQuery(name = "Usuarios.findByApellido", query = "SELECT u FROM Usuarios u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByDiscapacidad", query = "SELECT u FROM Usuarios u WHERE u.discapacidad = :discapacidad"),
    @NamedQuery(name = "Usuarios.login", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :usuario AND u.contrasenaUsuario = :clave")})
public class Usuarios implements Serializable {

    @Lob
    @Column(name = "fotoPerfil")
    private byte[] fotoPerfil;
    @Lob
    @Column(name = "documentoEscaneado")
    private byte[] documentoEscaneado;
    @Column(name = "cantidadNotificaciones")
    private Integer cantidadNotificaciones;
    @Column(name = "cantidadMensajes")
    private Integer cantidadMensajes;
    @OneToMany(mappedBy = "idUsuario")
    private List<NotificacionUsuario> notificacionUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContacto")
    private List<Contactos> contactosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Contactos> contactosList1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "contrasenaUsuario")
    private String contrasenaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoUsuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "estadoUsuario")
    private String estadoUsuario;
    @Size(max = 45)
    @Column(name = "web")
    private String web;
    @Lob
    @Size(max = 65535)
    @Column(name = "perfil")
    private String perfil;
    @Size(max = 60)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 45)
    @Column(name = "discapacidad")
    private String discapacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Certificadotrabajo> certificadotrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Certificadoestudio> certificadoestudioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Relcalificacionusuarios> relcalificacionusuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<EmpresaUsuarios> empresaUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Direccion> direccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Especialidad> especialidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Mensaje> mensajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario")
    private List<Eventoagenda> eventoagendaList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String contrasenaUsuario, String documento, String tipoUsuario, String nombreUsuario, String tipoDocumento, String correo, String estadoUsuario) {
        this.idUsuario = idUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.tipoDocumento = tipoDocumento;
        this.correo = correo;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    @XmlTransient
    public List<Certificadotrabajo> getCertificadotrabajoList() {
        return certificadotrabajoList;
    }

    public void setCertificadotrabajoList(List<Certificadotrabajo> certificadotrabajoList) {
        this.certificadotrabajoList = certificadotrabajoList;
    }

    @XmlTransient
    public List<Certificadoestudio> getCertificadoestudioList() {
        return certificadoestudioList;
    }

    public void setCertificadoestudioList(List<Certificadoestudio> certificadoestudioList) {
        this.certificadoestudioList = certificadoestudioList;
    }

    @XmlTransient
    public List<Relcalificacionusuarios> getRelcalificacionusuariosList() {
        return relcalificacionusuariosList;
    }

    public void setRelcalificacionusuariosList(List<Relcalificacionusuarios> relcalificacionusuariosList) {
        this.relcalificacionusuariosList = relcalificacionusuariosList;
    }

    @XmlTransient
    public List<EmpresaUsuarios> getEmpresaUsuariosList() {
        return empresaUsuariosList;
    }

    public void setEmpresaUsuariosList(List<EmpresaUsuarios> empresaUsuariosList) {
        this.empresaUsuariosList = empresaUsuariosList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @XmlTransient
    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @XmlTransient
    public List<Eventoagenda> getEventoagendaList() {
        return eventoagendaList;
    }

    public void setEventoagendaList(List<Eventoagenda> eventoagendaList) {
        this.eventoagendaList = eventoagendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestec.modelo.entidades.Usuarios[ idUsuario=" + idUsuario + " ]";
    }


    @XmlTransient
    public List<Contactos> getContactosList() {
        return contactosList;
    }

    public void setContactosList(List<Contactos> contactosList) {
        this.contactosList = contactosList;
    }

    @XmlTransient
    public List<Contactos> getContactosList1() {
        return contactosList1;
    }

    public void setContactosList1(List<Contactos> contactosList1) {
        this.contactosList1 = contactosList1;
    }


    public Integer getCantidadNotificaciones() {
        return cantidadNotificaciones;
    }

    public void setCantidadNotificaciones(Integer cantidadNotificaciones) {
        this.cantidadNotificaciones = cantidadNotificaciones;
    }

    public Integer getCantidadMensajes() {
        return cantidadMensajes;
    }

    public void setCantidadMensajes(Integer cantidadMensajes) {
        this.cantidadMensajes = cantidadMensajes;
    }

    @XmlTransient
    public List<NotificacionUsuario> getNotificacionUsuarioList() {
        return notificacionUsuarioList;
    }

    public void setNotificacionUsuarioList(List<NotificacionUsuario> notificacionUsuarioList) {
        this.notificacionUsuarioList = notificacionUsuarioList;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public byte[] getDocumentoEscaneado() {
        return documentoEscaneado;
    }

    public void setDocumentoEscaneado(byte[] documentoEscaneado) {
        this.documentoEscaneado = documentoEscaneado;
    }
    
}
