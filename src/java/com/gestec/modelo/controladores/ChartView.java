/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

 
import com.gestec.modelo.persistencia.EventoagendaFacadeLocal;
import com.gestec.modelo.persistencia.SolicitudFacadeLocal;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private BarChartModel barModel;
    private BarChartModel animatedModel2;
 
    @EJB
    private UsuariosFacadeLocal ufl;
    
    @EJB
    private SolicitudFacadeLocal sfl;
    
    @EJB
    private EventoagendaFacadeLocal evfl;
 
    @PostConstruct
    public void init() {
        createPieModels();
        //createBarModels();
        createAnimatedModels();
    }
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
    public BarChartModel getBarModel() {
        return barModel;
    }
    public UsuariosFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuariosFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public EventoagendaFacadeLocal getEvfl() {
        return evfl;
    }

    public void setEvfl(EventoagendaFacadeLocal evfl) {
        this.evfl = evfl;
    }
    
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public SolicitudFacadeLocal getSfl() {
        return sfl;
    }

    public void setSfl(SolicitudFacadeLocal sfl) {
        this.sfl = sfl;
    }

  
    
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
    private void createAnimatedModels() {

        animatedModel2 = initBarModel1();
        animatedModel2.setTitle("Conteo de los tipos de servicio");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(25 );
    }
    
    private BarChartModel initBarModel1() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries mant = new ChartSeries();
        mant.setLabel("Mantenimiento");
        mant.set("#", (long)listarTipoSolicitud("Mantenimiento"));

 
        ChartSeries ins = new ChartSeries();
        ins.setLabel("Instalacion");
        ins.set("", (long)listarTipoSolicitud("Instalacion"));
        
        ChartSeries diag = new ChartSeries();
        diag.setLabel("Diagnostico");
        diag.set("", (long)listarTipoSolicitud("Diagnostico"));
        
        model.addSeries(mant);
        model.addSeries(ins);
        model.addSeries(diag);
         
        return model;
    }
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries tecnico = new ChartSeries();
        tecnico.setLabel("Tecnicos");
        tecnico.set("#", (long)listarTecnico());
      
 
        ChartSeries cliente = new ChartSeries();
        cliente.setLabel("Clientes");
        cliente.set("", (long)listarCliente());
        
        
        ChartSeries admin = new ChartSeries();
        admin.setLabel("Administradores");
        admin.set("", (long)listarAdmin());
      
 
        model.addSeries(tecnico);
        model.addSeries(cliente);
        model.addSeries(admin);
         
        return model;
    }
    /* Bar Model
    private void createBarModels() {
        createBarModel();
        
    }*/
    
    /*Bar Model
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Conteo de los tipos de usuarios");
        barModel.setLegendPosition("ne");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(25 );
    }
 */
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Personal", (long)contarTipoEvento("Personal"));
        pieModel1.set("Servicio", (long)contarTipoEvento("Servicio"));
        pieModel1.set("Solicitud", (long)contarTipoEvento("Solicitud"));
  
         
        pieModel1.setTitle("Tipos de eventos");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Tecnicos", (long)listarTecnico());
        pieModel2.set("Clientes", (long)listarCliente());
        pieModel2.set("Administradores", (long)listarAdmin());
        
         
        pieModel2.setTitle("Tipos de usuarios");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
    
    public Object listarTecnico(){
        Object tec=ufl.listarTecnico();
        return tec;        
    }
    public Object listarCliente(){
        Object cl=ufl.listarCliente();
        return cl;        
    }
    public Object listarAdmin(){
        Object ad=ufl.listarAdmin();
        return ad;        
    }
    public Object listarTipoSolicitud(String tipo){
        Object tiposer = sfl.contarTipoSolicitud(tipo);
        return tiposer;
    }
    public Object contarTipoEvento(String tipoE){
        Object event= evfl.contarTipoEvento(tipoE);
        return event;
    }
  
}