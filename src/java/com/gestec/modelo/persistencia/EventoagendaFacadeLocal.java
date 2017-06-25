/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Eventoagenda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface EventoagendaFacadeLocal {

    void create(Eventoagenda eventoagenda);

    void edit(Eventoagenda eventoagenda);

    void remove(Eventoagenda eventoagenda);

    Eventoagenda find(Object id);

    List<Eventoagenda> findAll();

    List<Eventoagenda> findRange(int[] range);

    int count();
    
    List<Eventoagenda> listarMisEventos(Integer idUsuario);
    
    Object contarTipoEvento(String tipoE);
    
}
