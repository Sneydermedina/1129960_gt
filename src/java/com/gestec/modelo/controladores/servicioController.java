/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Servicio;
import com.gestec.modelo.persistencia.AdjuntoFacadeLocal;
import com.gestec.modelo.persistencia.CitasFacadeLocal;
import com.gestec.modelo.persistencia.DireccionFacadeLocal;
import com.gestec.modelo.persistencia.ServicioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author soluciones
 */
@Named(value = "servicioControl")
@SessionScoped
public class servicioController implements Serializable {

    @EJB
    private DireccionFacadeLocal dlf;

    @EJB
    private ServicioFacadeLocal slf;
    
    @EJB
    private CitasFacadeLocal clf;
    
    @EJB
    private AdjuntoFacadeLocal adlf;
    
    private  List<Servicio> ListaServicios;
    private Servicio servicio;
    private Servicio servicioModificado;
    

   @PostConstruct
   public void init(){
   
   ListaServicios=slf.findAll();   
   
   }

    public List<Servicio> getListaServicios() {
        return ListaServicios;
    }

    public void setListaServicios(List<Servicio> ListaServicios) {
        this.ListaServicios = ListaServicios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String eliminarServicio(){
         slf.remove(this.servicio);
         return "";
    }
    
    public String actualizarServicio(){
    slf.edit(this.servicio);
    return "serviciosTecnico";
   
    }
    public String editarServicio(Servicio servicio){
     this.servicio=servicio;
     return "datosServicio.xhtml?faces-redirect=true";
  
    }

    public Servicio getServicioModificado() {
        return servicioModificado;
    }

    public void setServicioModificado(Servicio servicioModificado) {
        this.servicioModificado = servicioModificado;
    }
}
