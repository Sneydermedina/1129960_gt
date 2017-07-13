/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Solicitud;
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
public class SolicitudFacade extends AbstractFacade<Solicitud> implements SolicitudFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudFacade() {
        super(Solicitud.class);
    }
    
    @Override
    public Object contarTipoSolicitud(String tipo){
        Query q=getEntityManager().createNativeQuery("SELECT COUNT(idSolicitud) FROM solicitud s JOIN "
                + "relsolicitudtipo rel on s.idsolicitud=rel.solicitud_idsolicitud\n" 
                + "JOIN tiposervicio tp ON rel.tiposervicio_idtiposervicio=tp.idtiposervicio "
                + "WHERE tiposervicio=?;");
        q.setParameter(1, tipo);
        Object tipos = q.getSingleResult();
        return tipos;
    }

    @Override
    public List<Solicitud> listarSolicitudesCliente(Integer idDireccion) {
        TypedQuery<Solicitud> q = getEntityManager().createNamedQuery("Solicitud.findByUsuario", Solicitud.class);
        q.setParameter("idDireccion", idDireccion);
        return q.getResultList();
    }
    
    @Override
    public List<Solicitud> listarSolicitudesTecnico(Integer idSolicitud) {
        TypedQuery<Solicitud> q = getEntityManager().createNamedQuery("Solicitud.findByIdsolicitud", Solicitud.class);
        q.setParameter("idSolicitud", idSolicitud);
        return q.getResultList();
    }
    
    
    
}
