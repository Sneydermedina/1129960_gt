/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Tiposervicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface TiposervicioFacadeLocal {

    void create(Tiposervicio tiposervicio);

    void edit(Tiposervicio tiposervicio);

    void remove(Tiposervicio tiposervicio);

    Tiposervicio find(Object id);

    List<Tiposervicio> findAll();

    List<Tiposervicio> findRange(int[] range);

    int count();
    
}
