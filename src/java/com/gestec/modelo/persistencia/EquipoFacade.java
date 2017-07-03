/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.persistencia;

import com.gestec.modelo.entidades.Equipo;
import com.gestec.modelo.entidades.Usuarios;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class EquipoFacade extends AbstractFacade<Equipo> implements EquipoFacadeLocal {

    @PersistenceContext(unitName = "gestecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoFacade() {
        super(Equipo.class);
    }
    
    @Override
    public List<Equipo> findByIdUsuario(Integer idCliente){
        
        /*Query q = getEntityManager().createNativeQuery("select e.* from equipo e join relequiposervicio rel on e.idEquipo=rel.equipo_idequipo join usuarios u on\n" +
"        u.idUsuario=rel.id_usuario where idUsuario=10");
        
        List<Equipo> list = q.getResultList();
        return list;**/
        
        List<Equipo>Equipos = new ArrayList<>();
        try {
        Query q;    
        q= em.createNativeQuery("SELECT e.* FROM Equipo e JOIN Relequiposervicio r ON e.idEquipo=r.equipo_idequipo WHERE r.id_usuario = ?1",Equipo.class);
        
        q.setParameter("1", idCliente);
        Equipos=(List<Equipo>)q.getResultList();
        } catch (Exception e) {
        e.printStackTrace();
        e.getMessage();
         }
            return Equipos;
        
    }
    
    @Override
    public int ingresarEquipoExcel(String[] equipo){
        int salida=0;
        try {
            Query q;
            q = em.createNativeQuery("INSERT INTO equipo (idEquipo,referencia,descripcionEquipo,fechaUltimaRevision,marcaEquipo,serialEquipo,tipoEquipo) VALUES (null,?,?,?,?,?,?)");
            q.setParameter(1, equipo[0]);
            q.setParameter(2, equipo[1]);
            q.setParameter(3, equipo[2]);
            q.setParameter(4, equipo[3]);
            q.setParameter(5, equipo[4]);
            q.setParameter(6, equipo[5]);
            
            salida = q.executeUpdate();
        } catch (Exception e) {
        }
        return salida;
        
    }
    

    
}
