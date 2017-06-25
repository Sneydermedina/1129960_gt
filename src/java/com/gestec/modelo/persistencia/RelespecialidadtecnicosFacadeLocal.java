/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relespecialidadtecnicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface RelespecialidadtecnicosFacadeLocal {

    void create(Relespecialidadtecnicos relespecialidadtecnicos);

    void edit(Relespecialidadtecnicos relespecialidadtecnicos);

    void remove(Relespecialidadtecnicos relespecialidadtecnicos);

    Relespecialidadtecnicos find(Object id);

    List<Relespecialidadtecnicos> findAll();

    List<Relespecialidadtecnicos> findRange(int[] range);

    int count();
    
}
