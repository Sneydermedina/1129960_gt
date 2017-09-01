/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.model.Email;
import com.gestec.modelo.entidades.Barrio;
import com.gestec.modelo.entidades.Certificadoestudio;
import com.gestec.modelo.entidades.Calificacion;
import com.gestec.modelo.entidades.Certificadotrabajo;
import com.gestec.modelo.entidades.Citas;
import com.gestec.modelo.entidades.Contactos;
import com.gestec.modelo.entidades.Direccion;
import com.gestec.modelo.entidades.Especialidad;
import com.gestec.modelo.entidades.Localidad;
import com.gestec.modelo.entidades.Mensaje;
import com.gestec.modelo.entidades.Telefono;
import com.gestec.modelo.entidades.NotificacionCita;
import com.gestec.modelo.entidades.NotificacionUsuario;
import com.gestec.modelo.entidades.Relcalificacionusuarios;
import com.gestec.modelo.entidades.Solicitud;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.persistencia.BarrioFacadeLocal;
import com.gestec.modelo.persistencia.CalificacionFacadeLocal;
import com.gestec.modelo.persistencia.CertificadoestudioFacadeLocal;
import com.gestec.modelo.persistencia.CertificadotrabajoFacadeLocal;
import com.gestec.modelo.persistencia.CitasFacadeLocal;
import com.gestec.modelo.persistencia.ContactosFacadeLocal;
import com.gestec.modelo.persistencia.DireccionFacadeLocal;
import com.gestec.modelo.persistencia.EspecialidadFacadeLocal;
import com.gestec.modelo.persistencia.LocalidadFacadeLocal;
import com.gestec.modelo.persistencia.MensajeFacadeLocal;
import com.gestec.modelo.persistencia.NotificacionCitaFacadeLocal;
import com.gestec.modelo.persistencia.NotificacionUsuarioFacadeLocal;
import com.gestec.modelo.persistencia.RelcalificacionusuariosFacadeLocal;
import com.gestec.modelo.persistencia.SolicitudFacadeLocal;
import com.gestec.modelo.persistencia.TelefonoFacadeLocal;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named(value = "sesionGestec")
@ManagedBean(name = "sesion")
@SessionScoped
public class SesionController implements Serializable {

    @EJB
    private UsuariosFacadeLocal ufl;
    @EJB
    private CitasFacadeLocal ctfl;
    @EJB
    private MensajeFacadeLocal mfl;
    @EJB
    private SolicitudFacadeLocal sfl;
    @EJB
    private LocalidadFacadeLocal lfl;
    @EJB
    private BarrioFacadeLocal bfl;
    @EJB
    private ContactosFacadeLocal cfl;
    @EJB
    private NotificacionUsuarioFacadeLocal nfl;
    @EJB
    private NotificacionCitaFacadeLocal ncfl;
    @EJB
    private DireccionFacadeLocal dfl;
    @EJB
    private CalificacionFacadeLocal calfl;
    @EJB
    private EspecialidadFacadeLocal efl;
    @EJB
    private RelcalificacionusuariosFacadeLocal relcu;
    @EJB
    private TelefonoFacadeLocal telfl;
    @EJB
    private CertificadoestudioFacadeLocal cerefl;
    @EJB
    private CertificadotrabajoFacadeLocal certfl;
    
    private String nombreUsuario;
    private String contrasena;
    private List<Localidad> localidades;
    private List<String> barriosLocalidades;
    List<NotificacionUsuario> notificaciones;
    private Integer numeroLocalidad;
    private List<Barrio> barrios;
    private List<String> nombreBarrios;
    private Usuarios perfil;
    private Usuarios usuario;
    private Contactos contacto;
    private String mensaje;
    private List<NotificacionCita> notCitas;
    private String estados;
    private String correo;
    private List<Usuarios> listarUsuarios;
    private List<Solicitud> solicitudesUsuario;
    private Mensaje ultimoMensaje;
    private Integer pagina;
    private String estado;
    private String con;
    private String con2;
    private String confirmarContra;
    private Direccion dire;
    private Locale idiomaSeleccionado;
    private List<Locale> idiomasSoportados;
    private Boolean ac;
    private Boolean db;
    private Localidad localidad;
    private Barrio barrio;
    private Integer barrioId;
    private Boolean infor;
    private Boolean certificado1;
    private Boolean certificado2;
    private List<Direccion> listarDireccion;
    private List<Telefono> listarTelefono;
    private List<Calificacion> listarCalificacion;
    private List<Localidad> listarLocalidad;
    private byte[] foto;
    private Especialidad esp;
    private Integer num; 
    private Certificadoestudio cEstudio;
    private Certificadotrabajo cTrabajo;
    private Boolean cEstudio1;
    private Boolean cTrabajo1;

    @PostConstruct
    public void init() {
        this.ac = false;
        this.db = false;
        this.cEstudio1=false;
        this.cTrabajo1=false;
        this.infor = false;
        this.contacto = new Contactos();
        //this.dire = new Direccion();

        this.usuario = new Usuarios();
        this.localidades = lfl.findAll();
        this.barrios = bfl.findAll();
        this.notCitas = ncfl.findAll();
        this.dfl.findAll();
        this.efl.findAll();
        this.relcu.findAll();
        this.calfl.findAll();
        this.cfl.findAll();
        this.telfl.findAll();

        //this.usuario.getDireccionList().set(0, dire);
        //this.dire.setUsuariosidUsuario(new Usuarios());
        //this.listarUsuarios = (List)efl.findAll();
        //this.estadoCertificado1();
        this.solicitudesUsuario = new ArrayList<>();

        FacesContext fc = FacesContext.getCurrentInstance();
        idiomaSeleccionado = new Locale("es");

        idiomasSoportados = new ArrayList<>();
        Iterator<Locale> it = fc.getApplication().getSupportedLocales();
        while (it.hasNext()) {
            idiomasSoportados.add(it.next());
        }

    }

    public List<Direccion> getListarDireccion() {
        return listarDireccion;
    }

    public void setListarDireccion(List<Direccion> listarDireccion) {
        this.listarDireccion = listarDireccion;
    }

    public Locale getIdiomaSeleccionado() {
        return idiomaSeleccionado;
    }

    public void setIdiomaSeleccionado(Locale idiomaSeleccionado) {
        this.idiomaSeleccionado = idiomaSeleccionado;
    }

    public List<Telefono> getListarTelefono() {
        return listarTelefono;
    }

    public Integer getNum() {
        return num;
    }

    public void setListarTelefono(List<Telefono> listarTelefono) {
        this.listarTelefono = listarTelefono;
    }

    public List<Locale> getIdiomasSoportados() {
        return idiomasSoportados;
    }

    public void setIdiomasSoportados(List<Locale> idiomasSoportados) {
        this.idiomasSoportados = idiomasSoportados;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuarios getPerfil() {
        return perfil;
    }

    public void setPerfil(Usuarios perfil) {
        this.perfil = perfil;
    }

    public Contactos getContacto() {
        return contacto;
    }

    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }

    public Integer getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Integer numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public List<String> getBarriosLocalidades() {
        return barriosLocalidades;
    }

    public void setBarriosLocalidades(List<String> barriosLocalidades) {
        this.barriosLocalidades = barriosLocalidades;
    }

    public List<String> getNombreBarrios() {
        return nombreBarrios;
    }

    public void setNombreBarrios(List<String> nombreBarrios) {
        this.nombreBarrios = nombreBarrios;
    }

    public List<NotificacionUsuario> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<NotificacionUsuario> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getEstados() {
        return estados;
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Usuarios> getListarUsuarios() {
        return listarUsuarios;
    }

    public void setListarUsuarios(List<Usuarios> listarUsuarios) {
        this.listarUsuarios = listarUsuarios;
    }

    public Integer getCantNot() {
        return this.notificaciones.size();
    }

    public Mensaje getUltimoMensaje() {
        return ultimoMensaje;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void estado() {
        this.estado = usuario.getEstadoUsuario();
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public String getConfirmarContra() {
        return confirmarContra;
    }

    public void setConfirmarContra(String confirmarContra) {
        this.confirmarContra = confirmarContra;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }

    public Boolean getDb() {
        return db;
    }

    public void setDb(Boolean db) {
        this.db = db;
    }

    public Direccion getDire() {
        return dire;
    }

    public void setDire(Direccion dire) {
        this.dire = dire;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Integer getBarrioId() {
        return barrioId;
    }

    public void setBarrioId(Integer barrioId) {
        this.barrioId = barrioId;
    }

    public Boolean getInfor() {
        return infor;
    }

    public void setInfor(Boolean infor) {
        this.infor = infor;
    }

    public Boolean getCertificado1() {
        return certificado1;
    }

    public void setCertificado1(Boolean certificado1) {
        this.certificado1 = certificado1;
    }

    public Boolean getCertificado2() {
        return certificado2;
    }

    public void setCertificado2(Boolean certificado2) {
        this.certificado2 = certificado2;
    }

    public List<Localidad> getListarLocalidad() {
        return listarLocalidad;
    }

    public void setListarLocalidad(List<Localidad> listarLocalidad) {
        this.listarLocalidad = listarLocalidad;
    }

    public Especialidad getEsp() {
        return esp;
    }

    public void setEsp(Especialidad esp) {
        this.esp = esp;
    }

    public Certificadoestudio getcEstudio() {
        return cEstudio;
    }

    public void setcEstudio(Certificadoestudio cEstudio) {
        this.cEstudio = cEstudio;
    }

    public Certificadotrabajo getcTrabajo() {
        return cTrabajo;
    }

    public void setcTrabajo(Certificadotrabajo cTrabajo) {
        this.cTrabajo = cTrabajo;
    }

    public Boolean getcEstudio1() {
        return cEstudio1;
    }

    public void setcEstudio1(Boolean cEstudio1) {
        this.cEstudio1 = cEstudio1;
    }

    public Boolean getcTrabajo1() {
        return cTrabajo1;
    }

    public void setcTrabajo1(Boolean cTrabajo1) {
        this.cTrabajo1 = cTrabajo1;
    }
    
    
    public List<NotificacionCita> getNotificacionesCitaUsuario() {
        List<NotificacionCita> nots;
        if (getUsuario().getTipoUsuario().equals("Tecnico")) {
            nots = new ArrayList<>();
            for (NotificacionCita not : this.notCitas) {
                List<Mensaje> msjss = mfl.listarMensajesCita(not.getIdCita().getSolicitudIdsolicitud().getIdsolicitud());
                if (msjss.size() > 0) {
                    List<Mensaje> mensajes = mfl.listarMensajesUsuario(msjss.get(0).getUsuariosidUsuario().getIdUsuario());
                    if (mensajes.get(0).getUsuariosidUsuario().getIdUsuario().equals(getUsuario().getIdUsuario())) {
                        nots.add(not);
                    }
                }
            }
            if (getUsuario().getTipoUsuario().equals("Cliente")) {
                nots = this.notCitas;
            }
            this.notCitas = nots;
        }
        return this.notCitas;
    }

    public Integer getCantidadNotificaciones() {
        Integer cantidad = 0;
        this.notificaciones = nfl.listarMisNotificaciones(getUsuario().getIdUsuario());
        for (NotificacionCita not : getNotificacionesCitaUsuario()) {
            if (not.getEstadoNotificacion().equals("Enviado")) {
                if (getUsuario().getTipoUsuario().equals("Cliente")) {
                    if (not.getIdNotificacion().getIdNotificacion().equals(7) ||
                        not.getIdNotificacion().getIdNotificacion().equals(8)) {  
                        cantidad++;
                    }
                }
                if (getUsuario().getTipoUsuario().equals("Tecnico") && not.getIdNotificacion().getIdNotificacion().equals(5)) {
                    cantidad++;
                }
            }
        }
        for (NotificacionUsuario notUsu : this.notificaciones) {
            if (notUsu.getEstadoNotificacion().equals("Enviado")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Integer getCantidadMensajes() {
        Integer cantidad = null;
        try {
            cantidad = 0;
            if (getUsuario().getTipoUsuario().equals("Cliente")) {
                List<Direccion> dirs = dfl.listarDireccionUsuario(getUsuario().getIdUsuario());
                this.solicitudesUsuario = sfl.listarSolicitudesCliente(dirs.get(0).getIdDireccion());
                for (Solicitud solicitud : this.solicitudesUsuario) {
                    List<Mensaje> mensajes = mfl.listarMensajesCita(solicitud.getIdsolicitud());
                    int tam = mensajes.size() - 1;
                    if (!getUsuario().getIdUsuario().equals(mensajes.get(tam).getUsuariosidUsuario().getIdUsuario())) {
                        List<Citas> ciSol = ctfl.listarCitasSolicitud(mensajes.get(tam).getSolicitudIdsolicitud().getIdsolicitud());
                        if (!mensajes.isEmpty() && mensajes.get(tam).getEstadoMensaje().equals("Enviado") &&
                             ciSol.get(0).getEstadoCita().equals("Agendada")) {
                            cantidad++;
                        }
                    }
                }
            }
            if (getUsuario().getTipoUsuario().equals("Tecnico")) {
                this.solicitudesUsuario.clear();
                List<Mensaje> mensajes = mfl.listarMensajesUsuario(getUsuario().getIdUsuario());
                for (Mensaje mnsj : mensajes) {
                    this.solicitudesUsuario.add(mnsj.getSolicitudIdsolicitud());
                }
                for (Solicitud sol : this.solicitudesUsuario) {
                    List<Mensaje> mensajesT = mfl.listarMensajesCita(sol.getIdsolicitud());
                    int tam = mensajesT.size() - 1;
                    if (!getUsuario().getIdUsuario().equals(mensajesT.get(tam).getUsuariosidUsuario().getIdUsuario())) {
                        if (!mensajesT.isEmpty() && mensajesT.get(tam).getEstadoMensaje().equals("Enviado")) {
                            cantidad++;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return cantidad;
    }

    public List<Solicitud> getMensajes() {
        if (getUsuario().getTipoUsuario().equals("Cliente")) {
            List<Direccion> dirs = dfl.listarDireccionUsuario(getUsuario().getIdUsuario());
            List<Solicitud> solMens = sfl.listarSolicitudesCliente(dirs.get(0).getIdDireccion());
            this.solicitudesUsuario.clear();
            for (Solicitud solic : solMens) {
                List<Citas> citasSolicitud = ctfl.listarCitasSolicitud(solic.getIdsolicitud());
                if (citasSolicitud.get(0).getEstadoCita().equals("Agendada")) {
                    this.solicitudesUsuario.add(solic);
                }
            }
        }
        if (getUsuario().getTipoUsuario().equals("Tecnico")) {
            List<Mensaje> mensajes;
            this.solicitudesUsuario.clear();
            mensajes = mfl.listarMensajesUsuario(getUsuario().getIdUsuario());
            for (Mensaje mnsj : mensajes) {
                List<Citas> citSol = ctfl.listarCitasSolicitud(mnsj.getSolicitudIdsolicitud().getIdsolicitud());
                if (citSol.get(0).getEstadoCita().equals("Agendada")) {   
                    this.solicitudesUsuario.add(mnsj.getSolicitudIdsolicitud());
                }
            }
            
        }
        
        return solicitudesUsuario;
    }

    public void setUltimoMensaje(Solicitud solicitud) {
        List<Mensaje> mnsjs = mfl.listarMensajesCita(solicitud.getIdsolicitud());
        int tam = mnsjs.size() - 1;
        this.ultimoMensaje = mnsjs.get(tam);
    }

    public StreamedContent getImagenPerfil2() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            String id = context.getExternalContext().getRequestParameterMap()
                    .get("pid2");
            Integer idF = Integer.valueOf(id);
            byte[] image = this.usuario.getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }

    public String getEstiloMensaje() {
        if (this.ultimoMensaje.getEstadoMensaje().equals("Visto")) {
            return "notMensajesVistos";
        }
        return "notMensajes";
    }

    public StreamedContent getImagenPerfilExterno() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            String id = context.getExternalContext().getRequestParameterMap()
                    .get("imgPerfil");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }

    public StreamedContent getImagenContacto() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            String id = context.getExternalContext().getRequestParameterMap()
                    .get("imgC");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }

    public List<NotificacionCita> getNotificacionesCitaCliente() {
        return notCitas;
    }

    public StreamedContent getImagenContactoExterno() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {

            String id = context.getExternalContext().getRequestParameterMap()
                    .get("imgCE");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean validarCantNotificaciones() {
        return getNotificacionesCitaUsuario().isEmpty() && getUsuario().getNotificacionUsuarioList().isEmpty();
    }

    public String formatearFechaNotificacion(Date fecha) {
        if (fecha != null) {
            SimpleDateFormat formato = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMM 'de' yyyy 'a las' hh:mm a", new Locale("es", "CO"));
            String fechaF = formato.format(fecha);
            if (fechaF.equals("")) {
                return "Sin fecha";
            } else {
                return fechaF;
            }
        }
        return "";
    }

    public String iniciarSesion() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msjGestec");
        FacesMessage msj = new FacesMessage();
        String url = "";
        String msjGestec = null;

        if (this.nombreUsuario != null && !this.nombreUsuario.equals("")
                && this.contrasena != null && !this.contrasena.equals("")) {
            this.usuario = ufl.iniciarSesion(nombreUsuario, contrasena);
            if (usuario != null) {
                estado();
                if (estado.equals("1")) {

                    ec.getSessionMap().put("user", usuario);
                    switch (usuario.getTipoUsuario()) {
                        case "Administrador":
                            url = "/faces/gestec/usuario/admin.xhtml?faces-redirect=true";
                            break;
                        case "Cliente":
                            url = "/faces/gestec/usuario/cliente.xhtml?faces-redirect=true";
                            break;
                        case "Tecnico":
                            url = "/faces/gestec/usuario/tecnico.xhtml?faces-redirect=true";
                            break;
                        default:
                            break;
                    }
                } else {
                    msj = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("userInactivo"), "Usuario no disponible");
                    usuario.setNombreUsuario("");
                    usuario.setContrasenaUsuario("");
                }
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("datosIncorrectos"), "Confirme que sus datos sean correctos");
            }
        } else {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("camposObligatorios"), "Debe ingresar todos los campos");

        }
        fc.addMessage(null, msj);
        return url;
    }

    public Usuarios getUsuario() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Object u = ec.getSessionMap().get("user");
        if (u instanceof Usuarios) {
            this.usuario = (Usuarios) ec.getSessionMap().get("user");
            return usuario;
        }
        return null;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void verPerfil(Usuarios perfil) {
        setPerfil(perfil);
        redireccionar("/faces/gestec/usuario/perfil_externo.xhtml?faces-redirect=true");
    }

    public String formatearFecha(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "CO"));
        String fechaF = formato.format(fecha);
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public String formatearFechaCumpleaños() {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM", new Locale("es", "CO"));
        String fechaF = formato.format(getUsuario().getFechaNacimiento());
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public String formatearFechaCumpleañosPerfil() {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM", new Locale("es", "CO"));
        String fechaF = formato.format(getPerfil().getFechaNacimiento());
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public String formatearFechaMensaje(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM hh:mm a", new Locale("es", "CO"));
        String fechaF = formato.format(fecha);
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public String formatearFechaNacimiento() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "CO"));
        String fechaF = formato.format(getUsuario().getFechaNacimiento());
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public List<Double> getCalificaciones() {
        validaSesion();
        List<Double> puntos = new ArrayList<>();
        List<Relcalificacionusuarios> calificaciones = getUsuario().getRelcalificacionusuariosList();
        for (Relcalificacionusuarios calificacion : calificaciones) {
            puntos.add(calificacion.getCalificacionIdcalificacion().getCalificacion());
        }
        return puntos;
    }

    public List<Double> getCalificacionesPerfil() {
        validaSesion();
        List<Double> puntos = new ArrayList<>();
        List<Relcalificacionusuarios> calificaciones = getPerfil().getRelcalificacionusuariosList();
        for (Relcalificacionusuarios calificacion : calificaciones) {
            puntos.add(calificacion.getCalificacionIdcalificacion().getCalificacion());
        }
        return puntos;
    }

    public Boolean validarSesion() {
        return getUsuario() != null;
    }

    public void validaSesion() {
        if (getUsuario() == null) {
            redireccionar("/faces/index.xhtml?faces-redirect=true");
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        setUsuario(null);
        this.nombreUsuario = "";
        this.contrasena = "";
        setNombreUsuario(null);
        setContrasena(null);
        redireccionar("/faces/index.xhtml?faces-redirect=true");
    }

    private void redireccionar(String url) {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath() + url);
        } catch (IOException ex) {
            Logger.getLogger(SesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambiarIdioma(Locale nuevoIdioma) {
        this.idiomaSeleccionado = nuevoIdioma;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(this.idiomaSeleccionado);
    }

    public String dibujarMenu() {
        validaSesion();
        String rol = getUsuario().getTipoUsuario();
        switch (rol) {
            case "Administrador":
                return "./../../WEB-INF/template/menu_admin.xhtml";
            case "Tecnico":
                return "./../../WEB-INF/template/menu_tecnico.xhtml";
            case "Cliente":
                return "./../../WEB-INF/template/menu_cliente.xhtml";
            default:
                break;
        }
        return null;
    }

    public void irAlInicio() {
        String rol = getUsuario().getTipoUsuario();
        switch (rol) {
            case "Administrador":
                redireccionar("/faces/gestec/usuario/admin.xhtml?faces-redirect=true");
            case "Tecnico":
                redireccionar("/faces/gestec/usuario/tecnico.xhtml?faces-redirect=true");
            case "Cliente":
                redireccionar("/faces/gestec/usuario/cliente.xhtml?faces-redirect=true");
            default:
                break;
        }
    }

    public void bloquearCliente() {
        String rol = getUsuario().getTipoUsuario();
        if (rol.equals("Cliente")) {
            redireccionar("/faces/gestec/error/error500.xhtml?faces-redirect=true");
        }
    }

    public void bloquearTecnico() {
        String rol = getUsuario().getTipoUsuario();
        if (rol.equals("Tecnico")) {
            redireccionar("/faces/gestec/error/error500.xhtml?faces-redirect=true");
        }
    }

    public void bloquearAdmin() {
        String rol = getUsuario().getTipoUsuario();
        if (rol.equals("Administrador")) {
            redireccionar("/faces/gestec/error/error500.xhtml?faces-redirect=true");
        }
    }

    public String agregarContacto(Usuarios usuario, Usuarios contacto) {
        getContacto().setIdContacto(usuario);
        getContacto().setIdUsuario(contacto);
        cfl.create(this.contacto);
        return "";
    }

    public void editarUsuario() {
        ufl.edit(usuario);
        redireccionar("faces/index.xhtml?faces-redirect=true");
    }

    public void llenarBarrios(AjaxBehaviorEvent event) {
        if (getNumeroLocalidad() < 21 && getNumeroLocalidad() > 0) {
            Localidad barriosLocalidad = lfl.llenarBarriosLocalidad(getNumeroLocalidad());
            List<Barrio> barrios = barriosLocalidad.getBarrioList();
            this.nombreBarrios = new ArrayList<>();

            for (Barrio barrio : barrios) {
                nombreBarrios.add(barrio.getNombreBarrio());
                barrioId = barrio.getIdBarrio();
            }
        } else {
            nombreBarrios = new ArrayList<>();
            nombreBarrios.add("Cualquier barrio");
        }

    }

    public String validarUsuarioCorreo() {

        Usuarios usuarioLog = ufl.validarUsuariosCorreo(correo);
        //this.listarUsuarios = ufl.listarUsuariosCorreo(correo);

        List<Usuarios> listar = new ArrayList();

        listar = ufl.listarUsuariosCorreo(usuarioLog.getCorreo());
        if (!usuarioLog.getNombreUsuario().equals("No existe")) {
            estados = "2";
            try {
                Email miCorreo = new Email();

                Email.send(listar, usuarioLog.getNombreUsuario(), "Envio masivo de correos");
                System.out.println(listar + " " + estados);
                //Email.sendBienvenido(usuarioLog.getCorreo(),usuarioLog.getNombreUsuario(),usuarioLog.getApellido(),usuarioLog.getContrasenaUsuario());
                //Email.sendClaves(usuarioLog.getCorreo(), usuarioLog.getNombreUsuario(), usuarioLog.getNombreUsuario(), usuarioLog.getContrasenaUsuario());
            } catch (Exception e) {
                estados = "4";
            }
        } else {
            estados = "3";
        }

        return "";
    }

    public String validarUsuCorreo() {
        Usuarios usuarioLog1 = ufl.validarUsuariosCorreo(correo);

        if (!usuarioLog1.getNombreUsuario().equals("No existe")) {
            estados = "2";

            try {
                Email miCorreo = new Email();
                Email.sendClaves(usuarioLog1.getCorreo(), usuarioLog1.getNombreUsuario(), usuarioLog1.getNombreUsuario(), usuarioLog1.getContrasenaUsuario());
            } catch (Exception e) {
                estados = "4";

            }
        } else {
            estados = "3";
        }
        return "";
    }

    public void bloquearCuenta() {
        this.usuario.setEstadoUsuario("0");
        this.ufl.edit(usuario);
        redireccionar("/faces/index.xhtml?faces-redirect=true");
    }

    public void validarContraAntigua(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        FacesMessage msj = null;

        if (texto.isEmpty()) {
            ((UIInput) toValidate).setValid(false);
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este campo es obligatorio", "No puede ser null");
            context.addMessage(toValidate.getClientId(context), msj);
        }

        if (!usuario.getContrasenaUsuario().equals(texto)) {
            ((UIInput) toValidate).setValid(false);
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "Error de contraseña");
            context.addMessage(toValidate.getClientId(context), msj);
        }
    }

    public void contraNueva(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        FacesMessage msj = null;

        if (texto.isEmpty()) {
            ((UIInput) toValidate).setValid(false);
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo obligatorio", "Campo obligatorio");
            context.addMessage(toValidate.getClientId(context), msj);
        }
    }

    public void confirmarContras(AjaxBehaviorEvent e) {
        this.con2 = con;
    }

    public void validarContraNueva(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        FacesMessage msj = new FacesMessage();

        if (texto.isEmpty()) {
            ((UIInput) toValidate).setValid(false);
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No puede ser nulo", "No puede ser vacio");
            context.addMessage(toValidate.getClientId(context), msj);
        }
        if (!texto.equals(con2)) {
            ((UIInput) toValidate).setValid(false);
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campos incorrectos", "Las contraseñas no coinciden");
            context.addMessage(toValidate.getClientId(context), msj);
        }
    }

    public StreamedContent getImagenPerfil() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap()
                    .get("pid");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }

    public void actualizarContra() {
        this.ac = true;
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage msj = null;
        this.usuario.setContrasenaUsuario(confirmarContra);
        this.ufl.edit(usuario);
        msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña cambiada exitosamente!", "Contraseña cambiada exitosamente!");
        fc.addMessage(null, msj);

    }

    public void actuzalizarPerfil() {
        this.usuario.setFotoPerfil(this.foto);
        ufl.edit(usuario);
        Integer id = usuario.getIdUsuario();
        this.usuario = null;
        this.usuario = ufl.find(id);
        this.db = true;
    }

    public void volverPerfil() {
        this.db = false;
        this.ac = false;
        this.infor = false;
         this.cEstudio1=false;
        this.cTrabajo1=false;
        redireccionar("/faces/gestec/usuario/perfil.xhtml?faces-redirect=true");
    }

    public void actualizarResidencia() {
        System.out.println("entro");
        this.dire = usuario.getDireccionList().get(0);
        this.localidad = usuario.getDireccionList().get(0).getIdBarrio().getIdLocalidad();
        this.barrio = usuario.getDireccionList().get(0).getIdBarrio();

        //bfl.edit(barrio);
        dire.setIdBarrio(bfl.find(barrioId));
        dfl.edit(dire);
        this.infor = true;
        this.listarLocalidad = lfl.listarLocalidad(usuario.getIdUsuario());
    }

    public void estadoCertificado1() {
        if (usuario.getCertificadoestudioList().isEmpty()) {
            this.certificado1 = false;

        } else {
            this.certificado1 = true;

        }

        if (usuario.getCertificadotrabajoList().isEmpty()) {
            this.certificado2 = false;
        } else {
            this.certificado2 = true;
        }

        redireccionar("/faces/gestec/usuario/editar_perfil.xhtml?faces-redirect=true");
    }

    public void irPerfil() {
        this.listarTelefono = telfl.listarPorUser(usuario.getIdUsuario());
        this.listarDireccion = dfl.listarPorUser(usuario.getIdUsuario());
        this.listarCalificacion = calfl.listarPorUser(usuario.getIdUsuario());
        this.listarLocalidad = lfl.listarLocalidad(usuario.getIdUsuario());

        redireccionar("/faces/gestec/usuario/perfil.xhtml?faces-redirect=true");
    }

    public void cambiarFoto(FileUploadEvent evento) throws IOException {
        this.foto = IOUtils.toByteArray(evento.getFile().getInputstream());
    }

    public void actualizarPerfil1() {
        this.esp = usuario.getEspecialidadList().get(0);
        ufl.edit(usuario);
        efl.edit(esp);
        redireccionar("/faces/gestec/usuario/editar_perfil.xhtml?faces-redirect=true");
    }
    
    public void actualizarCertificado1(){
        this.cEstudio = usuario.getCertificadoestudioList().get(0);
        cerefl.edit(cEstudio);
        this.cEstudio1=true;
        redireccionar("/faces/gestec/usuario/editar_perfil.xhtml?faces-redirect=true");
    }
    public void actualizarCertificado2(){
        this.cTrabajo = usuario.getCertificadotrabajoList().get(0);
        certfl.edit(cTrabajo);
        this.cTrabajo1=true;
        redireccionar("/faces/gestec/usuario/editar_perfil.xhtml?faces-redirect=true");
    }
}
