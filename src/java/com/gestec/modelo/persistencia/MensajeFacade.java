 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Mensaje;
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
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

    @Override
    public List<Mensaje> listarMensajesUsuario(Integer idUsuario) {
        TypedQuery<Mensaje> q = getEntityManager().createNamedQuery("Mensaje.findByIdUsuario", Mensaje.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }

    @Override
    public List<Mensaje> listarMensajesCita(Integer idSolicitud) {
        TypedQuery<Mensaje> q = getEntityManager().createNamedQuery("Mensaje.findByCita", Mensaje.class);
        q.setParameter("idSolicitud", idSolicitud);
        return q.getResultList();
    }

}
