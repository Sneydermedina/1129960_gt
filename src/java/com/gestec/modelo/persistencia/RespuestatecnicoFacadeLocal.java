/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Respuestatecnico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface RespuestatecnicoFacadeLocal {

    void create(Respuestatecnico respuestatecnico);

    void edit(Respuestatecnico respuestatecnico);

    void remove(Respuestatecnico respuestatecnico);

    Respuestatecnico find(Object id);

    List<Respuestatecnico> findAll();

    List<Respuestatecnico> findRange(int[] range);

    int count();
    
}
