/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios iniciarSesion(String nombreUsuario, String clave);
    
    List<Usuarios> listarTecnicos();
    
    List<Usuarios> listarTecnicosFiltro(Integer nombreBarrio, Integer nombreLocalidad, 
            String nombre, String orientacion,String ordenamiento, String operadorB, String operadorL);
    
    Object listarCliente();
    Object listarTecnico();
    Object listarAdmin();
    
    List<Usuarios> listarUsuariosCorreo(String correo);
    
    Usuarios validarUsuariosCorreo(String correo);
    
    
}
