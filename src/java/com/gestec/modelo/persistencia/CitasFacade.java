/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Citas;
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
public class CitasFacade extends AbstractFacade<Citas> implements CitasFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }

    @Override
    public List<Citas> listarCitas(String estado) {
        TypedQuery<Citas> q = getEntityManager().createNamedQuery("Citas.findByEstadoCita", Citas.class);
        q.setParameter("estadoCita", estado);
        return q.getResultList();
    }

    @Override
    public List<Citas> listarCitasSolicitud(Integer idSolicitud) {
        TypedQuery<Citas> q = getEntityManager().createNamedQuery("Citas.citasSolicitud", Citas.class);
        q.setParameter("idSolicitud", idSolicitud);
        return q.getResultList();
    }
}
