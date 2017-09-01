/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relcalificacionusuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface RelcalificacionusuariosFacadeLocal {

    void create(Relcalificacionusuarios relcalificacionusuarios);

    void edit(Relcalificacionusuarios relcalificacionusuarios);

    void remove(Relcalificacionusuarios relcalificacionusuarios);

    Relcalificacionusuarios find(Object id);

    List<Relcalificacionusuarios> findAll();

    List<Relcalificacionusuarios> findRange(int[] range);

    int count();
    
    List<Relcalificacionusuarios> listarCalsUsuario(Integer idUsuario);
    
}
