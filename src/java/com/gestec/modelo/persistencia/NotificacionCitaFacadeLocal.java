/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.NotificacionCita;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface NotificacionCitaFacadeLocal {

    void create(NotificacionCita notificacionCita);

    void edit(NotificacionCita notificacionCita);

    void remove(NotificacionCita notificacionCita);

    NotificacionCita find(Object id);

    List<NotificacionCita> findAll();

    List<NotificacionCita> findRange(int[] range);

    int count();
    
}
