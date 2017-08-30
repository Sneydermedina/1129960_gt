/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relequiposervicio;
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
public class RelequiposervicioFacade extends AbstractFacade<Relequiposervicio> implements RelequiposervicioFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelequiposervicioFacade() {
        super(Relequiposervicio.class);
    }
    
    @Override
    public List<Relequiposervicio> listarComentarios(Integer idServicio){
        TypedQuery<Relequiposervicio> q = getEntityManager().createNamedQuery("Relequiposervicio.comentarios", Relequiposervicio.class);
        q.setParameter("noTiquet", idServicio);
        return q.getResultList();
    }

    @Override
    public List<Relequiposervicio> buscarComPorTiquet(Integer noTiquet) {
        TypedQuery<Relequiposervicio> q = getEntityManager().createNamedQuery("Relequiposervicio.listarComentariosPorTiquet", Relequiposervicio.class);
        q.setParameter("noTiquet", noTiquet);
        return q.getResultList();
    }
    
}
