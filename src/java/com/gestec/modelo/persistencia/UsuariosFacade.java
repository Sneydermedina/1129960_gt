/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Usuarios;
import java.util.ArrayList;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios iniciarSesion(String nombreUsuario, String clave) {
        try {
            TypedQuery<Usuarios> q = getEntityManager().createNamedQuery("Usuarios.login", Usuarios.class);
            q.setParameter("usuario", nombreUsuario);
            q.setParameter("clave", clave);
            Usuarios usuarioLogin = q.getSingleResult();
            return usuarioLogin;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuarios> listarTecnicos() {
        List<Usuarios> tecnicos;
        TypedQuery<Usuarios> q = getEntityManager().createNamedQuery("Usuarios.findByTipoUsuario", Usuarios.class);
        q.setParameter("tipoUsuario", "Tecnico");
        tecnicos = q.getResultList();
        return tecnicos;
    }

    @Override
    public List<Usuarios> listarTecnicosFiltro(Integer noBarrio, Integer noLocalidad, String nombre,
            String orientacion, String ordenamiento, String operadorB, String operadorL) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM usuarios JOIN direccion\n"
                + "ON usuarios.idUsuario=direccion.usuarios_idUsuario\n"
                + "JOIN barrio \n"
                + "ON barrio.idBarrio=direccion.idBarrio \n"
                + "JOIN localidad\n"
                + "ON localidad.idLocalidad=barrio.idLocalidad\n"
                + "JOIN relcalificacionusuarios \n"
                + "ON relcalificacionusuarios.usuarios_idUsuario=usuarios.idUsuario \n"
                + "WHERE usuarios.nombreUsuario like ? \n"
                + "and barrio.idBarrio " + operadorB + " ? and localidad.idLocalidad " + operadorL + " ?\n"
                + "and usuarios.tipoUsuario = 'Tecnico'"
                + "order by " + ordenamiento + " " + orientacion + ";", Usuarios.class);
        q.setParameter(1, nombre + "%");
        q.setParameter(2, noBarrio);
        q.setParameter(3, noLocalidad);
        q.setParameter(4, ordenamiento);
        q.setParameter(5, orientacion);
        List<Usuarios> tecnicosFiltro = q.getResultList();
        return tecnicosFiltro;
    }
    
    @Override
    public Object listarTecnico(){
        Query q=getEntityManager().createNativeQuery("SELECT COUNT(idUsuario) FROM usuarios WHERE tipoUsuario='Tecnico'");    
        Object tecnico=q.getSingleResult();
        return tecnico;
    }
    @Override
    public Object listarCliente(){
        Query q=getEntityManager().createNativeQuery("SELECT COUNT(idUsuario) FROM usuarios WHERE tipoUsuario='Cliente'");    
        Object tecnico=q.getSingleResult();
        return tecnico;
    }
    @Override
    public Object listarAdmin(){
        Query q=getEntityManager().createNativeQuery("SELECT COUNT(idUsuario) FROM usuarios WHERE tipoUsuario='Administrador'");    
        Object tecnico=q.getSingleResult();
        return tecnico;
    }

}
