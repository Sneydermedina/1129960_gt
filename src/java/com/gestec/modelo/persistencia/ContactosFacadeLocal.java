/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Contactos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface ContactosFacadeLocal {

    void create(Contactos contactos);

    void edit(Contactos contactos);

    void remove(Contactos contactos);

    Contactos find(Object id);

    List<Contactos> findAll();

    List<Contactos> findRange(int[] range);

    int count();
    
}
