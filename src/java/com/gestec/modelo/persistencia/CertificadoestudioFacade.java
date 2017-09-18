/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Certificadoestudio;
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
public class CertificadoestudioFacade extends AbstractFacade<Certificadoestudio> implements CertificadoestudioFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CertificadoestudioFacade() {
        super(Certificadoestudio.class);
    }
    
    @Override
    public List<Certificadoestudio> listarPorUser(int id){
        Query q;
        q = em.createNativeQuery("select c.* from certificadoestudio c join usuarios u on c.usuarios_idusuario=idusuario where c.usuarios_idusuario=?",Certificadoestudio.class);
        q.setParameter(1, id);
        List<Certificadoestudio> listar = q.getResultList();
        return listar;
    }
    
}
