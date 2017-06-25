/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Direccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author michael
 */
@Stateless
public class DireccionFacade extends AbstractFacade<Direccion> implements DireccionFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

    @Override
    public List<Direccion> buscarPorBarrio(Integer idBarrio) {
        TypedQuery<Direccion> q = getEntityManager().createNamedQuery("Direccion.findByBarrio", Direccion.class);
        q.setParameter("idBarrio", idBarrio);
        List<Direccion> direcciones = q.getResultList();
        return direcciones;
    }
    
}
