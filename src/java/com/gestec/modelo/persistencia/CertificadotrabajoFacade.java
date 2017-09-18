/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Certificadotrabajo;
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
public class CertificadotrabajoFacade extends AbstractFacade<Certificadotrabajo> implements CertificadotrabajoFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CertificadotrabajoFacade() {
        super(Certificadotrabajo.class);
    }
    
    @Override
    public List<Certificadotrabajo> listarPorUser(int id){
        Query q;
        q = em.createNativeQuery("select c.* from certificadotrabajo c join usuarios u on c.usuarios_idusuario=idusuario where c.usuarios_idusuario=?",Certificadotrabajo.class);
        q.setParameter(1, id);
        List<Certificadotrabajo> listar = q.getResultList();
        return listar;
    }
}
