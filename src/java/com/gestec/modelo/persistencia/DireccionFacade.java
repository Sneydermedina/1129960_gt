/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Direccion;
import com.gestec.modelo.entidades.Telefono;
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
public class DireccionFacade extends AbstractFacade<Direccion> implements DireccionFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

    @Override
    public List<Direccion> buscarPorBarrio(Integer idBarrio) {
        TypedQuery<Direccion> q = getEntityManager().createNamedQuery("Direccion.findByBarrio", Direccion.class);
        q.setParameter("idBarrio", idBarrio);
        List<Direccion> direcciones = q.getResultList();
        return direcciones;
    }
    @Override
    public List<Direccion> listarPorUser(int id){
        Query q;
        q = em.createNativeQuery("SELECT direccion.* FROM direccion JOIN usuarios ON direccion.usuarios_idusuario=usuarios.idusuario WHERE direccion.usuarios_idusuario=?1",Direccion.class);
        q.setParameter("1", id);
        List<Direccion> list = q.getResultList();
        return list;
    }

    @Override
    public List<Direccion> listarDireccionUsuario(Integer idUsuario) {
        TypedQuery<Direccion> q = getEntityManager().createNamedQuery("Direccion.findByUsuario", Direccion.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }
    
}
