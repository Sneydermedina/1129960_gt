/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Contactos;
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
public class ContactosFacade extends AbstractFacade<Contactos> implements ContactosFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactosFacade() {
        super(Contactos.class);
    }

    @Override
    public List<Contactos> listarContactosUsuario(Integer idUsuario) {
        TypedQuery<Contactos> q = getEntityManager().createNamedQuery("Contactos.listaContactos", Contactos.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }  

    @Override
    public List<Contactos> listarContactosPerfil(Integer idUsuario) {
        TypedQuery<Contactos> q = getEntityManager().createNamedQuery("Contactos.listaContactosP", Contactos.class);
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }

    @Override
    public Integer validarContacto(Integer idUsuario, Integer idContacto) {
        TypedQuery<Contactos> q = getEntityManager().createNamedQuery("Contactos.validaContacto", Contactos.class);
        q.setParameter("idUsuario", idUsuario);
        q.setParameter("idContacto", idUsuario);
        return q.getResultList().size();
    }

    @Override
    public void eliminarContacto(Integer idUsuario, Integer idContacto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
