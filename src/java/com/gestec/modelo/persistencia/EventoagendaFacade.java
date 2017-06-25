/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Eventoagenda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author michael
 */
@Stateless
public class EventoagendaFacade extends AbstractFacade<Eventoagenda> implements EventoagendaFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoagendaFacade() {
        super(Eventoagenda.class);
    }

    @Override
    public List<Eventoagenda> listarMisEventos(Integer idUsuario) {
        TypedQuery<Eventoagenda> q = getEntityManager().createNamedQuery("Eventoagenda.findByUsuario", Eventoagenda.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }
    
    
@Override
    public Object contarTipoEvento(String tipoE){
        Query q=getEntityManager().createNativeQuery("SELECT COUNT(idEvento) FROM eventoagenda WHERE tipoevento=?");
        q.setParameter(1, tipoE);
        Object event=q.getSingleResult();
        return event;
    }
    
}
