/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relespecialidadtecnicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michael
 */
@Stateless
public class RelespecialidadtecnicosFacade extends AbstractFacade<Relespecialidadtecnicos> implements RelespecialidadtecnicosFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelespecialidadtecnicosFacade() {
        super(Relespecialidadtecnicos.class);
    }
    
}
