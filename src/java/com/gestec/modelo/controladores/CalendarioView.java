package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Citas;
import com.gestec.modelo.entidades.Eventoagenda;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.persistencia.EventoagendaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@Named(value = "calendarView")
@ViewScoped
public class CalendarioView implements Serializable {

    @Inject
    private SesionController sesion;
    @EJB
    private EventoagendaFacadeLocal eafl;

    private List<Eventoagenda> eventos;
    private Eventoagenda nuevoEvento;
    private Date fechaInicial;
    private String vista;
    private String accion;
    private Citas eventoSeleccionado;
    private ScheduleModel eventModel;

    private ScheduleEvent event;

    @PostConstruct
    public void init() {
        
        this.eventos = eafl.listarMisEventos(sesion.getUsuario().getIdUsuario());
        eventModel = new DefaultScheduleModel();

        for (Eventoagenda evento : eventos) {
            if (evento.getUsuariosidUsuario().getIdUsuario().equals(sesion.getUsuario().getIdUsuario())) {

            }
            ScheduleEvent even = new DefaultScheduleEvent();
            if (evento.getCitasList().isEmpty()) {

                even = new DefaultScheduleEvent(evento.getNombreEvento(),
                        evento.getFechaInicio(),
                        evento.getFechaFin());
            }
            if (!evento.getCitasList().isEmpty()) {
                even = new DefaultScheduleEvent(evento.getNombreEvento(),
                        evento.getFechaInicio(),
                        evento.getFechaFin(),
                        evento.getCitasList().get(0));
            }
            DefaultScheduleEvent ev = (DefaultScheduleEvent) even;
            ev.setDescription(evento.getDescripcionEvento());

            if (evento.getTipoEvento().equals("Servicio")) {
                ev.setStyleClass("eventoAgenda");
                ev.setEditable(false);
            }
            if (evento.getTipoEvento().equals("Solicitud")) {
                ev.setStyleClass("eventoSolicitud");
                ev.setEditable(false);
            }
            if (evento.getTipoEvento().equals("Personal")) {
                ev.setStyleClass("eventoPersonal");
            }
            eventModel.addEvent(ev);

        }
        
        this.eventoSeleccionado = new Citas();
        this.nuevoEvento = new Eventoagenda();
        this.nuevoEvento.setUsuariosidUsuario(new Usuarios());
        this.fechaInicial = new Date();
        this.vista = "agendaWeek";
        this.event = new DefaultScheduleEvent();
    }
    
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public Citas getEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(Citas eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public List<Eventoagenda> getEventosProximos() {
        this.eventos = eafl.listarMisEventos(sesion.getUsuario().getIdUsuario());
        List<Eventoagenda> eventosProximos = new ArrayList<>();
        if (eventos.size() == 1) {
            eventosProximos.add(eventos.get(0));
        }
        if (eventos.size() == 2) {
            eventosProximos.add(eventos.get(0));
            eventosProximos.add(eventos.get(1));
        }
        if (eventos.size() == 3) {
            eventosProximos.add(eventos.get(0));
            eventosProximos.add(eventos.get(1));
            eventosProximos.add(eventos.get(2));
        }
        if (eventos.size() == 4) {
            eventosProximos.add(eventos.get(0));
            eventosProximos.add(eventos.get(1));
            eventosProximos.add(eventos.get(2));
            eventosProximos.add(eventos.get(3));
        }
        if (eventos.size() >= 5) {
            eventosProximos.add(eventos.get(0));
            eventosProximos.add(eventos.get(1));
            eventosProximos.add(eventos.get(2));
            eventosProximos.add(eventos.get(3));
            eventosProximos.add(eventos.get(4));
        }
        return eventosProximos;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public Eventoagenda getNuevoEvento() {
        return nuevoEvento;
    }

    public void setNuevoEvento(Eventoagenda nuevoEvento) {
        this.nuevoEvento = nuevoEvento;
    }

    public void irAEvento(Date fecha) {
        setFechaInicial(fecha);
        setVista("agendaDay");
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            DefaultScheduleEvent ev = (DefaultScheduleEvent) event;
            ev.setStyleClass("eventoPersonal");
            nuevoEvento.setDescripcionEvento(ev.getDescription());
            nuevoEvento.setFechaInicio(ev.getStartDate());
            nuevoEvento.setFechaFin(ev.getEndDate());
            nuevoEvento.setTipoEvento("Personal");
            nuevoEvento.setNombreEvento(ev.getTitle());
            nuevoEvento.setUsuariosidUsuario(sesion.getUsuario());
            eafl.create(nuevoEvento);
            eventModel.addEvent(event);
            
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (DefaultScheduleEvent) selectEvent.getObject();

        if (!event.getStyleClass().equals("eventoPersonal")) {
            this.eventoSeleccionado = (Citas) event.getData();
        }

    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
