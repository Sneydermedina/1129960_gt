/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Horadisponibilidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface HoradisponibilidadFacadeLocal {

    void create(Horadisponibilidad horadisponibilidad);

    void edit(Horadisponibilidad horadisponibilidad);

    void remove(Horadisponibilidad horadisponibilidad);

    Horadisponibilidad find(Object id);

    List<Horadisponibilidad> findAll();

    List<Horadisponibilidad> findRange(int[] range);

    int count();
    
}
