/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Citas;
import com.gestec.modelo.entidades.Eventoagenda;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.persistencia.EventoagendaFacadeLocal;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
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
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author michael
 */
@ManagedBean
@ViewScoped
public class HorarioView {
    @Inject
    private SesionController sesion;
    private ScheduleModel eventModel;
    private Date fechaInicial;
    private String vista;
    @EJB
    private EventoagendaFacadeLocal eafl;
    @EJB
    private UsuariosFacadeLocal ufl;

    private List<Eventoagenda> eventos;
     
    private ScheduleModel lazyEventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        
        
        this.eventos = eafl.listarMisEventos(ufl.find(9).getIdUsuario());
        eventModel = new DefaultScheduleModel();
        eventModel = new DefaultScheduleModel();
        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
        eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
        eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
        eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));

        for (Eventoagenda evento : eventos) {
            if (evento.getUsuariosidUsuario().getIdUsuario().equals(ufl.find(9).getIdUsuario())) {

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
         
        lazyEventModel = new LazyScheduleModel() {
             
            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
                 
                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
            }   
        };
        this.fechaInicial = new Date();
        this.vista = "agendaWeek";
        this.event = new DefaultScheduleEvent();
    }
     
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
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
    
     
    public ScheduleModel getEventModel() {
        

        return eventModel;
    }
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
         
        return t.getTime();
    }
     
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
         
        return t.getTime();
    }
     
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
 
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
         
        return t.getTime();
    }
     
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
         
        return t.getTime();
    }
     
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
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
