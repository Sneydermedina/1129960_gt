/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.NotificacionUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface NotificacionUsuarioFacadeLocal {

    void create(NotificacionUsuario notificacionUsuario);

    void edit(NotificacionUsuario notificacionUsuario);

    void remove(NotificacionUsuario notificacionUsuario);

    NotificacionUsuario find(Object id);

    List<NotificacionUsuario> findAll();

    List<NotificacionUsuario> findRange(int[] range);

    int count();
    
    List<NotificacionUsuario> listarMisNotificaciones(Integer idUsuario);
    
}
