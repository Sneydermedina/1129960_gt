package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Equipo;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.persistencia.EquipoFacadeLocal;
import com.gestec.modelo.persistencia.EquipoFacade;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

@Named(value = "equipoController")
@SessionScoped
public class equipoController implements Serializable{

    @EJB
    EquipoFacadeLocal efl;
    Equipo e;
    EquipoFacade ef;
    List<Equipo> equipos;
    private Part archivoPublicacion;
    private String contenido;
    
    private Usuarios u;
    
    @Inject
    private SesionController sesion;
    
    
    private UsuariosFacadeLocal ufl;
    
    @PostConstruct
    public void equipoController() {
        this.e = new Equipo();
        this.equipos = this.efl.findByIdUsuario(sesion.getUsuario().getIdUsuario());
        System.out.println("ID: "+efl.findByIdUsuario(sesion.getUsuario().getIdUsuario()));
        
    }

    public SesionController getSesion() {
        return sesion;
    }
    

    public EquipoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EquipoFacadeLocal efl) {
        this.efl = efl;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Equipo getE() {
        return e;
    }

    public void setE(Equipo e) {
        this.e = e;
    }

    public EquipoFacade getEf() {
        return ef;
    }

    public void setEf(EquipoFacade ef) {
        this.ef = ef;
    }

    public Usuarios getU() {
        return u;
    }

    public void setU(Usuarios u) {
        this.u = u;
    }

    public UsuariosFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuariosFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public String getNombreArchivo() {
        if (archivoPublicacion != null) {
            return archivoPublicacion.getSubmittedFileName();
            
        }
        return "Adjuntar imagen";
    }
    
    

    public String insertarEquipo() {
        this.efl.create(this.e);
        this.e = new Equipo();
        this.equipos = this.efl.findByIdUsuario(sesion.getUsuario().getIdUsuario());
        return "/faces/gestec/equipo/listaEquipos";
    }

    
    public String edit(Equipo e) {
        this.e = e;
        return "formActualizar";
    }

    public String edit() {
        this.efl.edit(this.e);
        this.e = new Equipo();
        return "";
    }
    public String vista(Equipo e){
        this.e=e;
        return "datosEquipo";
    }

    public void eliminar(){
        efl.remove(e);
        this.equipos = efl.findByIdUsuario(sesion.getUsuario().getIdUsuario());
        
    }

    @Override
    public String toString() {
        return "equipoController{" + "efl=" + efl + ", equipos=" + equipos + ", e=" + e + '}';
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public void validar(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;
        this.archivoPublicacion = file;
    }
    
    public void subir() {
        try {
            contenido = archivoPublicacion.getContentType();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    public Part getArchivoPublicacion() {
        return archivoPublicacion;
    }

    public void setArchivoPublicacion(Part archivoPublicacion) {
        this.archivoPublicacion = archivoPublicacion;
    }

}
