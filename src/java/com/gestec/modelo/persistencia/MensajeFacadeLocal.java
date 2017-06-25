/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Mensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface MensajeFacadeLocal {

    void create(Mensaje mensaje);

    void edit(Mensaje mensaje);

    void remove(Mensaje mensaje);

    Mensaje find(Object id);

    List<Mensaje> findAll();

    List<Mensaje> findRange(int[] range);

    int count();
    
    List<Mensaje> listarMensajesUsuario(Integer idUsuario);
    
}
