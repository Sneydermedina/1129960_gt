/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Reljornadausuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface ReljornadausuariosFacadeLocal {

    void create(Reljornadausuarios reljornadausuarios);

    void edit(Reljornadausuarios reljornadausuarios);

    void remove(Reljornadausuarios reljornadausuarios);

    Reljornadausuarios find(Object id);

    List<Reljornadausuarios> findAll();

    List<Reljornadausuarios> findRange(int[] range);

    int count();
    
}
