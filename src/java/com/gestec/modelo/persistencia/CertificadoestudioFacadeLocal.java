/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Certificadoestudio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author michael
 */
@Local
public interface CertificadoestudioFacadeLocal {

    void create(Certificadoestudio certificadoestudio);

    void edit(Certificadoestudio certificadoestudio);

    void remove(Certificadoestudio certificadoestudio);

    Certificadoestudio find(Object id);

    List<Certificadoestudio> findAll();

    List<Certificadoestudio> findRange(int[] range);

    int count();
    
    public List<Certificadoestudio> listarPorUser(int id);
}
