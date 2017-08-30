/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Adjunto;
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
public class AdjuntoFacade extends AbstractFacade<Adjunto> implements AdjuntoFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdjuntoFacade() {
        super(Adjunto.class);
    }

    @Override
    public List<Adjunto> listarPorSolicitud(Integer idSolicitud) {
        TypedQuery<Adjunto> q = getEntityManager().createNamedQuery("Adjunto.listarPorSolicitud", Adjunto.class);
        q.setParameter("idSolicitud", idSolicitud);
        return q.getResultList();
    }
    
}
