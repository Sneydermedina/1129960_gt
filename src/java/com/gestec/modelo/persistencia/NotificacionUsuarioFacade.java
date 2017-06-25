/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.NotificacionUsuario;
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
public class NotificacionUsuarioFacade extends AbstractFacade<NotificacionUsuario> implements NotificacionUsuarioFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionUsuarioFacade() {
        super(NotificacionUsuario.class);
    }

    @Override
    public List<NotificacionUsuario> listarMisNotificaciones(Integer idUsuario) {
        TypedQuery<NotificacionUsuario> q = getEntityManager().createNamedQuery("NotificacionUsuario.findByIdUsuario", NotificacionUsuario.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }
    
}
