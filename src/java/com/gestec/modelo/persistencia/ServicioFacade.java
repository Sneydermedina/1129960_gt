/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author michael
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    @Override
    public List<Servicio> listarServicioporTecnico(Integer idTecnico) {
        List<Servicio>Servicios = new ArrayList();
        try {
        Query q;    
        //q= em.createNativeQuery("SELECT s.noTiquet, s.descripcionServicio,s.fechaServicio,s.garantia,s.costoServicio,u.nombreUsuario as tecnico from servicio s join citas on s.noTiquet=citas.servicio_noTiquet join eventoagenda on citas.idCita=eventoagenda.idEvento join usuarios as u on eventoagenda.usuarios_idUsuario=u.idUsuario where u.tipoUsuario='Tecnico'");
        q= em.createQuery("SELECT s FROM Servicio s WHERE s.tecnico.idTecnico = :idTec");
        q.setParameter("idTec", idTecnico);
        Servicios=(List<Servicio>)q.getResultList();
        } catch (Exception e) {
        e.printStackTrace();
        e.getMessage();
         }
        return Servicios;
        
    }
    
}
