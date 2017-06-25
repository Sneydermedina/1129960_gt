/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Equipomodificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface EquipomodificacionFacadeLocal {

    void create(Equipomodificacion equipomodificacion);

    void edit(Equipomodificacion equipomodificacion);

    void remove(Equipomodificacion equipomodificacion);

    Equipomodificacion find(Object id);

    List<Equipomodificacion> findAll();

    List<Equipomodificacion> findRange(int[] range);

    int count();
    
}
