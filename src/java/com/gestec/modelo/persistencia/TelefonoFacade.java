/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Telefono;
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
public class TelefonoFacade extends AbstractFacade<Telefono> implements TelefonoFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonoFacade() {
        super(Telefono.class);
    }
    
    @Override
    public List<Telefono> listarPorUser(int id){
        Query q;
        q = em.createNativeQuery("SELECT telefono.* FROM telefono JOIN usuarios ON telefono.idTelefono=usuarios.idusuario WHERE telefono.idusuario=?1",Telefono.class);
        q.setParameter("1", id);
        List<Telefono> list = q.getResultList();
        return list;
    }
}
