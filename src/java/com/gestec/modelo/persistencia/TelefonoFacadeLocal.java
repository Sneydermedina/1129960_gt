/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Telefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface TelefonoFacadeLocal {

    void create(Telefono telefono);

    void edit(Telefono telefono);

    void remove(Telefono telefono);

    Telefono find(Object id);

    List<Telefono> findAll();

    List<Telefono> findRange(int[] range);

    int count();
    
    public List<Telefono> listarPorUser(int id);
}
