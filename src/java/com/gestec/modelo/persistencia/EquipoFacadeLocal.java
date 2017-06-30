/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Equipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface EquipoFacadeLocal {

    void create(Equipo equipo);

    void edit(Equipo equipo);

    void remove(Equipo equipo);

    Equipo find(Object id);

    List<Equipo> findAll();

    List<Equipo> findRange(int[] range);

    int count();
    
    List<Equipo> findByIdUsuario(Integer idCliente);
    
    int ingresarEquipoExcel(String[] equipo);
}
