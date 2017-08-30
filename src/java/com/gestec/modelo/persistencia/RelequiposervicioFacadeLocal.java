/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relequiposervicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface RelequiposervicioFacadeLocal {

    void create(Relequiposervicio relequiposervicio);

    void edit(Relequiposervicio relequiposervicio);

    void remove(Relequiposervicio relequiposervicio);

    Relequiposervicio find(Object id);

    List<Relequiposervicio> findAll();

    List<Relequiposervicio> findRange(int[] range);
    
    List<Relequiposervicio> listarComentarios(Integer idServicio);
    
    List<Relequiposervicio> buscarComPorTiquet(Integer noTiquet);

    int count();
    
}
