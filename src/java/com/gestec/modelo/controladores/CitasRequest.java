package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Adjunto;
import com.gestec.modelo.entidades.Barrio;
import com.gestec.modelo.entidades.Citas;
import com.gestec.modelo.entidades.Direccion;
import com.gestec.modelo.entidades.Equipo;
import com.gestec.modelo.entidades.Equipomodificacion;
import com.gestec.modelo.entidades.Eventoagenda;
import com.gestec.modelo.entidades.Horadisponibilidad;
import com.gestec.modelo.entidades.Localidad;
import com.gestec.modelo.entidades.Mensaje;
import com.gestec.modelo.entidades.Notificacion;
import com.gestec.modelo.entidades.NotificacionCita;
import com.gestec.modelo.entidades.NotificacionUsuario;
import com.gestec.modelo.entidades.Relcalificacionusuarios;
import com.gestec.modelo.entidades.Relequiposervicio;
import com.gestec.modelo.entidades.Relsolicitudtipo;
import com.gestec.modelo.entidades.Servicio;
import com.gestec.modelo.entidades.Solicitud;
import com.gestec.modelo.entidades.Tiposervicio;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.persistencia.AdjuntoFacadeLocal;
import com.gestec.modelo.persistencia.CitasFacadeLocal;
import com.gestec.modelo.persistencia.DireccionFacadeLocal;
import com.gestec.modelo.persistencia.EquipoFacadeLocal;
import com.gestec.modelo.persistencia.EquipomodificacionFacadeLocal;
import com.gestec.modelo.persistencia.EventoagendaFacadeLocal;
import com.gestec.modelo.persistencia.HoradisponibilidadFacadeLocal;
import com.gestec.modelo.persistencia.LocalidadFacadeLocal;
import com.gestec.modelo.persistencia.MensajeFacadeLocal;
import com.gestec.modelo.persistencia.NotificacionCitaFacadeLocal;
import com.gestec.modelo.persistencia.NotificacionFacadeLocal;
import com.gestec.modelo.persistencia.NotificacionUsuarioFacadeLocal;
import com.gestec.modelo.persistencia.RelequiposervicioFacadeLocal;
import com.gestec.modelo.persistencia.RelsolicitudtipoFacadeLocal;
import com.gestec.modelo.persistencia.ServicioFacadeLocal;
import com.gestec.modelo.persistencia.SolicitudFacadeLocal;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author michael
 */
@Named(value = "citasRequest")
@ManagedBean(name = "citasRequestt")
@SessionScoped
public class CitasRequest implements Serializable {

    @Inject
    private SesionController sesion;

    @EJB
    private UsuariosFacadeLocal ufl;
    @EJB
    private MensajeFacadeLocal mfl;
    @EJB
    private CitasFacadeLocal cfl;
    @EJB
    private SolicitudFacadeLocal sfl;
    @EJB
    private HoradisponibilidadFacadeLocal hdfl;
    @EJB
    private DireccionFacadeLocal dfl;
    @EJB
    private EventoagendaFacadeLocal efl;
    @EJB
    private ServicioFacadeLocal sefl;
    @EJB
    private RelsolicitudtipoFacadeLocal tsfl;
    @EJB
    private NotificacionCitaFacadeLocal ncfl;
    @EJB
    private NotificacionUsuarioFacadeLocal nufl;
    @EJB
    private NotificacionFacadeLocal nfl;
    @EJB
    private LocalidadFacadeLocal lfl;
    @EJB
    private EquipoFacadeLocal eqfl;
    @EJB
    private EquipomodificacionFacadeLocal emfl;
    @EJB
    private RelequiposervicioFacadeLocal esfl;
    @EJB
    private AdjuntoFacadeLocal adfl;

    private Citas cita;
    private Citas nuevaCita;
    private Integer tipoServicio;
    private Integer tipoEquipo;
    private Integer cantidadEquipos;
    private Integer numeroLocalidad;
    private Integer numeroBarrio;
    private Integer tecnicos;
    private Servicio servicio;
    private Direccion direccion;
    private Citas citaModificada;
    private String contacto;
    private Usuarios perfil;
    private List<Citas> citas;
    private Date fechaSolicitud;
    private Solicitud nuevaSolicitud;
    private Solicitud solicitud;
    private Horadisponibilidad horaDisponibilidad;
    private Eventoagenda evento;
    private Relsolicitudtipo tipoSolicitud;
    private NotificacionCita notificacionCita;
    private Notificacion notificacion;
    private List<Barrio> barrios;
    private String orden;
    private String orientacion;
    private List<Usuarios> tecnicosCita;
    private String nombreTecnico;
    private Usuarios tecnicoCita;
    private Citas citaEvento;
    private Eventoagenda eventoCita;
    private Date horaInicio;
    private Date horaFin;
    private Date fechaCita;
    private String descripcionEvento;
    private NotificacionUsuario notificacionUsuario;
    private Mensaje mensaje;
    private String operadorBarrio;
    private String operadorLocalidad;
    private UploadedFile imagenSolicitud;
    private Equipo nuevoEquipo;
    private Relequiposervicio eqServicio;
    private Equipomodificacion eqModificacion;
    private Adjunto adjunto;
    private byte[] archivoSolicitud;
    private String cos;
    private String descrip;
    private String nuevoMensaje;
    private Boolean citaEnviada;
    private String comentario;
    private Citas citaM;
    private int coincidencias;
    private List<Mensaje> mensajes;

    public CitasRequest() {
        this.coincidencias = 0;
        this.numeroBarrio = 0;
        this.numeroLocalidad = 0;
        this.tecnicos = 1;
        this.nombreTecnico = "";
        this.orden = "usuarios.nombreUsuario";
        this.orientacion = "ASC";
        this.fechaSolicitud = new Date();
        this.operadorBarrio = "<>";
        this.operadorLocalidad = "<>";
        this.nuevoMensaje = "";
        this.citaEnviada = false;
    }

    @PostConstruct
    public void init() {
        this.mensaje = new Mensaje();
        this.citaM = new Citas();
        this.tecnicosCita = ufl.listarTecnicosFiltro(numeroBarrio, numeroLocalidad,
                nombreTecnico, orientacion, orden, operadorBarrio, operadorLocalidad);
        this.citas = cfl.listarCitas("Agendada");
        this.servicio = new Servicio();
        this.nuevaSolicitud = new Solicitud();
        this.horaDisponibilidad = new Horadisponibilidad();
        this.horaDisponibilidad.setSolicitudIdsolicitud(new Solicitud());
        this.direccion = new Direccion();
        this.direccion.setIdBarrio(new Barrio());
        this.direccion.setUsuariosidUsuario(new Usuarios());
        this.evento = new Eventoagenda();
        this.evento.setUsuariosidUsuario(new Usuarios());
        this.nuevaCita = new Citas();
        this.nuevaCita.setSolicitudIdsolicitud(new Solicitud());
        this.nuevaCita.setServicionoTiquet(new Servicio());
        this.tipoSolicitud = new Relsolicitudtipo();
        this.tipoSolicitud.setSolicitudIdsolicitud(new Solicitud());
        this.tipoSolicitud.setTipoServicioidtipoServicio(new Tiposervicio());
        this.notificacionCita = new NotificacionCita();
        this.notificacionCita.setIdCita(new Citas());
        this.notificacionCita.setIdNotificacion(new Notificacion());
        this.notificacion = nfl.find(5);
        this.barrios = new ArrayList<>();
        this.notificacionUsuario = new NotificacionUsuario();
        this.notificacionUsuario.setIdNotificacion(new Notificacion());
        this.notificacionUsuario.setIdUsuario(new Usuarios());
        this.eqModificacion = new Equipomodificacion();
        this.eqModificacion.setEquipoidEquipo(new Equipo());
        this.eqServicio = new Relequiposervicio();
        this.eqServicio.setServicionoTiquet(new Servicio());
        this.eqServicio.setEquipoidEquipo(new Equipo());
        this.nuevoEquipo = new Equipo();
        this.adjunto = new Adjunto();
        this.adjunto.setEquipoModificacionidequipoActas(new Equipomodificacion());
        this.adjunto.setServicionoTiquet(new Servicio());
        this.adjunto.setSolicitudIdsolicitud(new Solicitud());
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }

    public Usuarios getPerfil() {
        return perfil;
    }

    public void setPerfil(Usuarios perfil) {
        this.perfil = perfil;
    }

    public Citas getCitaModificada() {
        return citaModificada;
    }

    public void setCitaModificada(Citas citaModificada) {
        this.citaModificada = citaModificada;
    }

    public Citas getNuevaCita() {
        return nuevaCita;
    }

    public void setNuevaCita(Citas nuevaCita) {
        this.nuevaCita = nuevaCita;
    }

    public Integer getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Integer tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Integer getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(Integer tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(Integer cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Integer tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Integer getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Integer noLocalidad) {
        this.numeroLocalidad = noLocalidad;
    }

    public Integer getNumeroBarrio() {
        return numeroBarrio;
    }

    public void setNumeroBarrio(Integer numeroBarrio) {
        this.numeroBarrio = numeroBarrio;
    }

    public List<Localidad> getLocalidades() {
        return sesion.getLocalidades();
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Solicitud getNuevaSolicitud() {
        return nuevaSolicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.nuevaSolicitud = solicitud;
    }

    public Horadisponibilidad getHoraDisponibilidad() {
        return horaDisponibilidad;
    }

    public void setHoraDisponibilidad(Horadisponibilidad horaDisponibilidad) {
        this.horaDisponibilidad = horaDisponibilidad;
    }

    public Eventoagenda getEvento() {
        return evento;
    }

    public void setEvento(Eventoagenda evento) {
        this.evento = evento;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public List<Usuarios> getTecnicosCita() {
        return tecnicosCita;
    }

    public void setTecnicosCita(List<Usuarios> tecnicosCita) {
        this.tecnicosCita = tecnicosCita;
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public void setTecnicoCita(Usuarios tecnicoCita) {
        this.coincidencias = 0;
        this.tecnicoCita = tecnicoCita;
        List<Eventoagenda> ea = tecnicoCita.getEventoagendaList();
        for (Eventoagenda evTecnico : ea) {
            for (Citas c : evTecnico.getCitasList()) {
                for (Horadisponibilidad hd : c.getSolicitudIdsolicitud().getHoradisponibilidadList()) {
                    if (hd.getHoraInicio().compareTo(this.horaInicio) <= 0
                            && hd.getHoraFin().compareTo(this.horaFin) >= 0) {
                        this.coincidencias++;
                    }
                }
            }
        }
    }

    public String formatearFechaHora(Integer opcion, Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMM", new Locale("es", "CO"));
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", new Locale("es", "CO"));
        if (opcion.equals(1)) {
            return formatoFecha.format(fecha);
        }
        return formatoHora.format(fecha);
    }

    public Usuarios getTecnicoCita() {
        return tecnicoCita;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNuevoMensaje() {
        return nuevoMensaje;
    }

    public void setNuevoMensaje(String nuevoMensaje) {
        this.nuevoMensaje = nuevoMensaje;
    }

    public String getNTecnico() {
        if (this.tecnicoCita == null) {
            return "";
        }
        return this.tecnicoCita.getNombreUsuario() + " " + this.tecnicoCita.getApellido();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Citas getCitaM() {
        return citaM;
    }

    public void setCitaM(Citas mCita) {
        this.citaM = mCita;
    }

    public int getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(int coincidencias) {
        this.coincidencias = coincidencias;
    }

    public List<Double> getCalificaciones(Usuarios tecnico) {
        List<Double> ptos = new ArrayList<>();
        List<Relcalificacionusuarios> calif = tecnico.getRelcalificacionusuariosList();
        for (Relcalificacionusuarios calificacion : calif) {
            ptos.add(calificacion.getCalificacionIdcalificacion().getCalificacion());
        }
        return ptos;
    }

    public List<Direccion> getDireccion(Usuarios tecnico) {
        return tecnico.getDireccionList();
    }

    public StreamedContent getImagenTecnico() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgTecnico");
            byte[] imagen = ufl.find(Integer.valueOf(parametro)).getFotoPerfil();
            if (imagen == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public StreamedContent getImagenClientePublicacion() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgCP");
            byte[] imagen = ufl.find(Integer.valueOf(parametro)).getFotoPerfil();
            if (imagen == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public UploadedFile getImagenSolicitud() {
        return imagenSolicitud;
    }

    public void setImagenSolicitud(UploadedFile imagenSolicitud) {
        this.imagenSolicitud = imagenSolicitud;
    }

    public Boolean getCitaEnviada() {
        return citaEnviada;
    }

    public void setCitaEnviada(Boolean citaEnviada) {
        this.citaEnviada = citaEnviada;
    }

    public List<Citas> getPublicaciones() {
        return cfl.findAll();
    }

    public StreamedContent getImagenPublicacion() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgPublicacion");
            byte[] imagen = sfl.find(Integer.valueOf(parametro)).getAdjuntoList().get(0).getAdjunto();
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public StreamedContent getFotoComentario() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgComentario");
            byte[] imagen = ufl.find(Integer.valueOf(parametro)).getFotoPerfil();
            if (imagen == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public StreamedContent getFotoComentarioM() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgComentarioM");
            byte[] imagen = ufl.find(Integer.valueOf(parametro)).getFotoPerfil();
            if (imagen == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public StreamedContent getImagenRespuesta() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String parametro = context.getExternalContext().getRequestParameterMap().get("imgRespuesta");
            byte[] imagen = cfl.find(Integer.valueOf(parametro)).getServicionoTiquet().getAdjuntoList().get(0).getAdjunto();
            if (imagen == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen));
        }
    }

    public List<Relequiposervicio> getComentarios(Citas cita) {
        List<Relequiposervicio> comentarios = esfl.listarComentarios(cita.getServicionoTiquet().getNoTiquet());
        return comentarios;
    }

    public Integer validarFiltro() {
        if (this.tecnicos == 1) {
            return 1;
        }
        if (this.tecnicos == 2) {
            return 2;
        }
        if (this.tecnicos == 3) {
            return 3;
        }
        return null;
    }

    public void registrarCita() {
        this.nuevaSolicitud.setDireccionidDireccion(sesion.getUsuario().getDireccionList().get(0));
        this.nuevaSolicitud.setSolicitudFecha(fechaSolicitud);
        sfl.create(nuevaSolicitud);
        List<Solicitud> s = sfl.findAll();
        int t = s.size() - 1;
        this.solicitud = s.get(t);
        this.horaDisponibilidad.setSolicitudIdsolicitud(solicitud);
        this.horaDisponibilidad.setHoraInicio(horaInicio);
        this.horaDisponibilidad.setHoraFin(horaFin);
        hdfl.create(horaDisponibilidad);
        this.servicio.setDescripcionServicio("Descripcion");
        this.servicio.setCostoServicio("Costo");
        this.servicio.setGarantia(new Date());
        this.servicio.setFechaServicio(new Date());
        this.servicio.setEstadoServicio("Solicitado");
        sefl.create(servicio);
        List<Servicio> se = sefl.findAll();
        int ta = se.size() - 1;
        this.servicio = se.get(ta);
        this.nuevaCita.setDuracionCita("Duracion");
        this.nuevaCita.setEstadoCita("Solicitado");
        this.nuevaCita.setFechaCita(fechaCita);
        this.nuevaCita.setFiltro(validarFiltro());
        this.nuevaCita.setSolicitudIdsolicitud(solicitud);
        this.nuevaCita.setServicionoTiquet(servicio);
        this.evento.setFechaFin(this.horaDisponibilidad.getHoraFin());
        this.evento.setFechaInicio(this.horaDisponibilidad.getHoraInicio());
        this.evento.setDescripcionEvento(descripcionEvento);
        this.evento.setNombreEvento("Servicio " + sesion.getUsuario().getNombreUsuario());
        this.evento.setTipoEvento("Servicio");
        this.evento.setUsuariosidUsuario(sesion.getUsuario());
        efl.create(evento);
        List<Eventoagenda> ea = efl.findAll();
        int tama = ea.size() - 1;
        this.eventoCita = ea.get(tama);
        this.nuevaCita.setEventoAgenda(eventoCita);
        cfl.create(nuevaCita);
        this.tipoSolicitud.getTipoServicioidtipoServicio().setIdtipoServicio(this.tipoServicio);
        this.tipoSolicitud.setSolicitudIdsolicitud(this.solicitud);
        tsfl.create(tipoSolicitud);
        List<Citas> c = cfl.findAll();
        int tam = c.size() - 1;
        this.citaEvento = c.get(tam);
        this.nuevoEquipo.setDescripcionEquipo("Descripcion");
        this.nuevoEquipo.setFechaUltimaRevision(new Date());
        this.nuevoEquipo.setMarcaEquipo("Marca");
        this.nuevoEquipo.setReferencia("Referencia");
        this.nuevoEquipo.setSerialEquipo("Serial");
        this.nuevoEquipo.setTipoEquipo("Tipo");
        nuevoEquipo = eqfl.findAll().get(eqfl.findAll().size() - 1);
        this.eqModificacion.setEquipoidEquipo(nuevoEquipo);
        this.eqModificacion.setFechaModifiacacion(new Date());
        this.eqModificacion.setModificacion("Modificación");
        emfl.create(eqModificacion);
        this.eqServicio.setEquipoidEquipo(nuevoEquipo);
        this.eqServicio.setServicionoTiquet(servicio);
        this.eqServicio.setComentario("Comentario");
        this.eqServicio.setUsuario(sesion.getUsuario());
        esfl.create(eqServicio);
        this.adjunto.setAdjunto(archivoSolicitud);
        Equipomodificacion eqm = emfl.findAll().get(emfl.findAll().size() - 1);
        this.adjunto.setEquipoModificacionidequipoActas(eqm);
        this.adjunto.setServicionoTiquet(servicio);
        this.adjunto.setSolicitudIdsolicitud(nuevaSolicitud);
        adfl.create(adjunto);
    }

    public void ingresarSolicitud() {

        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage msj = new FacesMessage();

        if (this.horaInicio.compareTo(this.horaFin) > 0) {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "La fecha inicial no puede ser mayor a la fecha final", "");
        } else if (validarFiltro() == 2) {
            redireccionar("/faces/gestec/cita/busqueda_tecnico.xhtml?faces-redirect=true");
        } else {
            try {
                registrarCita();
                this.citaEnviada = true;
            } catch (Exception e) {
                msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al registrar la cita", "");
            }
        }
        fc.addMessage(null, msj);

    }

    public void agendarCita() {

        registrarCita();
        this.notificacionCita.setIdCita(citaEvento);
        this.notificacionCita.setIdNotificacion(this.notificacion);
        this.notificacionCita.setEstadoNotificacion("Enviado");
        this.notificacionCita.setFechaNotificacion(new Date());
        ncfl.create(notificacionCita);
        this.mensaje.setEstadoMensaje("Enviado");
        this.mensaje.setFechaMensaje(new Date());
        this.mensaje.setMensaje(descripcionEvento);
        this.mensaje.setSolicitudIdsolicitud(this.solicitud);
        this.mensaje.setUsuariosidUsuario(tecnicoCita);
        mfl.create(mensaje);
        this.evento.setUsuariosidUsuario(tecnicoCita);
        this.evento.setTipoEvento("Solicitud");
        efl.edit(evento);
        this.citaEnviada = true;

    }

    public void setServicioTecnico(Servicio servicio, Usuarios tecnico, Citas cita) {
        setTecnicoCita(tecnico);
        setServicio(servicio);
        this.citaEvento = cita;
        setDescripcionEvento(cita.getEventoAgenda().getDescripcionEvento());
        this.solicitud = cita.getSolicitudIdsolicitud();
    }

    public void agendarCitaPublicacion() {
        this.notificacionCita.setIdCita(citaEvento);
        this.notificacionCita.setIdNotificacion(this.notificacion);
        this.notificacionCita.setEstadoNotificacion("Enviado");
        this.notificacionCita.setFechaNotificacion(new Date());
        ncfl.create(notificacionCita);
        this.mensaje.setEstadoMensaje("Enviado");
        this.mensaje.setFechaMensaje(new Date());
        this.mensaje.setMensaje(descripcionEvento);
        this.mensaje.setSolicitudIdsolicitud(this.solicitud);
        this.mensaje.setUsuariosidUsuario(tecnicoCita);
        Eventoagenda event = this.citaEvento.getEventoAgenda();
        event.setUsuariosidUsuario(tecnicoCita);
        mfl.create(mensaje);
        efl.edit(event);
        ocultarPublicacion(servicio);
        this.citaEnviada = true;
    }

    public String formatearFechaCita(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd", new Locale("es", "CO"));
        String fechaF = formato.format(fecha);
        if (fechaF.equals("")) {
            return "Sin fecha";
        } else {
            return fechaF;
        }
    }

    public List<Mensaje> mensajes(Integer idSolicitud) {
        mensajes = mfl.listarMensajesCita(idSolicitud);
        mensajes.remove(0);
        return mensajes;
    }

    public String getPrimerMensaje(Integer idSolicitud) {
        List<Mensaje> msjs = mfl.listarMensajesCita(idSolicitud);
        return msjs.get(0).getMensaje();
    }

    public Integer getCantidadMensajes(Integer idSolicitud) {
        List<Mensaje> msjs = mfl.listarMensajesCita(idSolicitud);
        return msjs.size();
    }

    public String ultimoMensaje(Citas cita) {
        int tamañoLista = cita.getSolicitudIdsolicitud().getMensajeList().size() - 1;
        return cita.getSolicitudIdsolicitud().getMensajeList().get(tamañoLista).getMensaje();
    }

    public String verDetalle(Citas cita) {
        setCita(cita);
        return "detalle_cita.xhtml?faces-redirect=true";
    }

    public void verDetalleNotificacion(Citas cita, NotificacionCita not) {
        setCita(cita);
        not.setEstadoNotificacion("Visto");
        ncfl.edit(not);
        redireccionar("/faces/gestec/cita/detalle_cita.xhtml?faces-redirect=true");
    }
    
    public void verDetalleMensaje(Solicitud solicitud) {
        setCita(solicitud.getCitasList().get(0));
        List<Mensaje> msjs = mfl.listarMensajesCita(solicitud.getIdsolicitud());
        int t = msjs.size() - 1;
        Mensaje m = msjs.get(t);
        if (!m.getUsuariosidUsuario().getIdUsuario().equals(sesion.getUsuario().getIdUsuario())) {      
            m.setEstadoMensaje("Visto");
        }
        mfl.edit(m);
        redireccionar("/faces/gestec/cita/detalle_cita.xhtml?faces-redirect=true");
    }

    public String contacto() {
        this.contacto = cita.getSolicitudIdsolicitud().getDireccionidDireccion().getUsuariosidUsuario().getNombreUsuario()
                + " " + cita.getSolicitudIdsolicitud().getDireccionidDireccion().getUsuariosidUsuario().getApellido();
        return contacto;
    }

    public Usuarios obtenerContacto() {
        return cita.getSolicitudIdsolicitud().getDireccionidDireccion().getUsuariosidUsuario();
    }

    public void cancelarCita() {
        citaModificada.setEstadoCita("Cancelada");
        cfl.edit(citaModificada);
//        this.notificacionUsuario.getIdNotificacion().setIdNotificacion(6);
//        Usuarios usuario = new Usuarios();
//        if (sesion.getUsuario().getTipoUsuario().equals("Tecnico")) {
//            usuario = citaModificada.getSolicitudIdsolicitud().getDireccionidDireccion().getUsuariosidUsuario();
//        } else if (sesion.getUsuario().getTipoUsuario().equals("Cliente")) {
//            usuario = citaModificada.getSolicitudIdsolicitud().getMensajeList().get(0).getUsuariosidUsuario();
//        }
//        this.notificacionUsuario.setIdUsuario(usuario);
//        this.notificacionUsuario.setEstadoNotificacion("Enviado");
//        this.notificacionUsuario.setFechaNotificacion(new Date());
//        nufl.create(notificacionUsuario);
//        this.citas = cfl.listarCitas("Agendada");
    }

    public String editar(Citas cita) {
        setCitaM(cita);
        return "formulario_citas.xhtml?faces-redirect=true";
    }

    public String actualizarCita() {
        setCitaModificada(cita);
        citaModificada.setEstadoCita("Agendada");
        citaModificada.getServicionoTiquet().setDescripcionServicio(descrip);
        citaModificada.getServicionoTiquet().setCostoServicio(cos);
        citaModificada.getEventoAgenda().setTipoEvento("Servicio");
        citaModificada.getEventoAgenda().setUsuariosidUsuario(sesion.getUsuario());
        cfl.edit(citaModificada);
        efl.edit(citaModificada.getEventoAgenda());
        sefl.edit(citaModificada.getServicionoTiquet());
        this.notificacionCita.setIdCita(citaModificada);
        this.notificacionCita.setIdNotificacion(nfl.find(7));
        this.notificacionCita.setEstadoNotificacion("Enviado");
        this.notificacionCita.setFechaNotificacion(new Date());
        ncfl.create(notificacionCita);
        return "";
    }

    public void actualizarDatosCita() {
        FacesMessage msj;
        try {
            this.cfl.edit(citaM);
            Servicio serv = citaM.getServicionoTiquet();
            Eventoagenda even = citaM.getEventoAgenda();
            this.sefl.edit(serv);
            this.efl.edit(even);
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos actualizados correctamente", "");
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la actualizacion de los datos", "");
        }
        FacesContext.getCurrentInstance().addMessage(null, msj);
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

    public void validarCita() {
        if (getCitas() == null) {
            redireccionar("/faces/gestec/error/error404.xhtml");
        }
    }

    public String crearCita() {
        this.cfl.create(getNuevaCita());
        return "";
    }

    public void llenarBarrios(AjaxBehaviorEvent event) {
        if (getNumeroLocalidad() < 21 && getNumeroLocalidad() > 0) {
            Localidad barriosLocalidad = lfl.llenarBarriosLocalidad(getNumeroLocalidad());
            this.barrios = barriosLocalidad.getBarrioList();

        } else {
            this.barrios = new ArrayList<>();
        }
        filtrarTecnicos();
    }

    public void filtrarTecnicos() {
        if (getNumeroLocalidad() == 0) {
            this.operadorLocalidad = "<>";
        }
        if (getNumeroLocalidad() != 0) {
            this.operadorLocalidad = "=";
        }
        if (getNumeroBarrio() == 0) {
            this.operadorBarrio = "<>";
        }
        if (getNumeroBarrio() != 0) {
            this.operadorBarrio = "=";
        }
        this.tecnicosCita = ufl.listarTecnicosFiltro(numeroBarrio, numeroLocalidad,
                nombreTecnico, orientacion, orden, operadorBarrio, operadorLocalidad);

    }

    public void subir(FileUploadEvent event) throws IOException {
        this.archivoSolicitud = IOUtils.toByteArray(event.getFile().getInputstream());
        FacesMessage message = new FacesMessage("El archivo", event.getFile().getFileName() + " fué subido correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void marcarPublicacion(Servicio servicio) {
        servicio.setEstadoServicio("Marcado");
        sefl.edit(servicio);
    }

    public void desmarcarPublicacion(Servicio servicio) {
        servicio.setEstadoServicio("Desmarcado");
        sefl.edit(servicio);
    }

    public void ocultarPublicacion(Servicio servicio) {
        servicio.setEstadoServicio("Oculta");
        sefl.edit(servicio);
    }

    public void enviarMensaje() {
        this.mensaje.setEstadoMensaje("Enviado");
        this.mensaje.setFechaMensaje(new Date());
        this.mensaje.setMensaje(getNuevoMensaje());
        this.mensaje.setSolicitudIdsolicitud(this.cita.getSolicitudIdsolicitud());
        this.mensaje.setUsuariosidUsuario(sesion.getUsuario());
        this.nuevoMensaje = "";
        mfl.create(mensaje);
    }

    public void añadirComentario(Citas cita) {
        Relequiposervicio es = new Relequiposervicio();
        es.setComentario(comentario);
        es.setEquipoidEquipo(cita.getServicionoTiquet().getRelequiposervicioList().get(0).getEquipoidEquipo());
        es.setServicionoTiquet(cita.getServicionoTiquet());
        es.setUsuario(sesion.getUsuario());
        esfl.create(es);
    }

    public void eliminarConversacion() {
        this.mensajes.stream().forEach((mnsj) -> {
            mfl.remove(mnsj);
        });
    }

}
