/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.EmpresaUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface EmpresaUsuariosFacadeLocal {

    void create(EmpresaUsuarios empresaUsuarios);

    void edit(EmpresaUsuarios empresaUsuarios);

    void remove(EmpresaUsuarios empresaUsuarios);

    EmpresaUsuarios find(Object id);

    List<EmpresaUsuarios> findAll();

    List<EmpresaUsuarios> findRange(int[] range);

    int count();
    
}
