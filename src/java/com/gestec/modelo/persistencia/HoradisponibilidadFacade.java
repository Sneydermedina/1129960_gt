/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Horadisponibilidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateless
public class HoradisponibilidadFacade extends AbstractFacade<Horadisponibilidad> implements HoradisponibilidadFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoradisponibilidadFacade() {
        super(Horadisponibilidad.class);
    }
    
}
