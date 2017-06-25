/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Localidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author michael
 */
@Stateless
public class LocalidadFacade extends AbstractFacade<Localidad> implements LocalidadFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }
    
    @Override
    public Localidad llenarBarriosLocalidad(Integer idLocalidad) {
        TypedQuery<Localidad> q = getEntityManager().createNamedQuery("Localidad.findByIdLocalidad", Localidad.class);
        q.setParameter("idLocalidad", idLocalidad);
        Localidad barriosLocalidad = q.getSingleResult();
        return barriosLocalidad;
    }
    
}
