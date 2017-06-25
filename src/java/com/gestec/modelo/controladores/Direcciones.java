/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.modelo.entidades.Direccion;
import com.gestec.modelo.persistencia.DireccionFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "direccionController")
@RequestScoped
public class Direcciones {
    
    @EJB
    DireccionFacadeLocal dfl;
    
    List<Direccion> direcciones;
    
    public void init(){
        this.direcciones = dfl.findAll();
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
    
    
    
}
