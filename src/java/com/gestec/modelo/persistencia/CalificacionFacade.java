/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Calificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.gestec.modelo.entidades.Usuarios;

/**
 *
 * @author michael
 */
@Stateless
public class CalificacionFacade extends AbstractFacade<Calificacion> implements CalificacionFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionFacade() {
        super(Calificacion.class);
    }
    
    @Override
    public Object findByUser(int idUser){
        Query q;
        q = em.createNativeQuery("SELECT c.calificacion FROM calificacion c JOIN relcalificacionusuarios rel ON c.idCalificacion=rel.calificacion_idcalificacion \n" +
"JOIN usuarios u ON rel.usuarios_idusuario = u.idUsuario WHERE u.idusuario=?1",Calificacion.class);
        
        q.setParameter("1", idUser);
        Object id = q.getFirstResult();
        return id;
    }
}
