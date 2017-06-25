package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Equipo;
import com.gestec.modelo.persistencia.EquipoFacadeLocal;
import com.gestec.modelo.persistencia.EquipoFacade;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@Named(value = "equipoController")
@SessionScoped
public class equipoController implements Serializable{

    @EJB
    EquipoFacadeLocal efl;
    Equipo e;
    EquipoFacade ef;
    List<Equipo> equipos;

    @PostConstruct
    public void equipoController() {
        this.e = new Equipo();
        this.equipos = this.efl.findAll();
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

    public String insertarEquipo() {
        this.efl.create(this.e);
        this.e = new Equipo();
        this.equipos = this.efl.findAll();
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
        
    }

    @Override
    public String toString() {
        return "equipoController{" + "efl=" + efl + ", equipos=" + equipos + ", e=" + e + '}';
    }

}
