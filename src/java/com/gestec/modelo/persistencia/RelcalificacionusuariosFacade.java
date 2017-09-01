/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Relcalificacionusuarios;
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
public class RelcalificacionusuariosFacade extends AbstractFacade<Relcalificacionusuarios> implements RelcalificacionusuariosFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelcalificacionusuariosFacade() {
        super(Relcalificacionusuarios.class);
    }

    @Override
    public List<Relcalificacionusuarios> listarCalsUsuario(Integer idUsuario) {
        TypedQuery<Relcalificacionusuarios> q = getEntityManager().createNamedQuery
        ("Relcalificacionusuarios.findByUsuario", Relcalificacionusuarios.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }
    
}
