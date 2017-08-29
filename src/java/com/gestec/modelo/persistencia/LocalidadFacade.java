/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Localidad;
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
public class LocalidadFacade extends AbstractFacade<Localidad> implements LocalidadFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }
    
    @Override
    public Localidad llenarBarriosLocalidad(Integer idLocalidad) {
        TypedQuery<Localidad> q = getEntityManager().createNamedQuery("Localidad.findByIdLocalidad", Localidad.class);
        q.setParameter("idLocalidad", idLocalidad);
        Localidad barriosLocalidad = q.getSingleResult();
        return barriosLocalidad;
    }
    
    @Override
    public List<Localidad> listarLocalidad(int id){
        Query q;
        q = em.createNativeQuery("select l.* from localidad l join barrio b on l.idLocalidad=b.idLocalidad join direccion d on b.idbarrio=d.idbarrio\n" +
"join usuarios u on d.usuarios_idusuario=u.idusuario where u.idusuario = ?1",Localidad.class);
        q.setParameter("1", id);
        List<Localidad> local = q.getResultList();
        return local;
    }
}
