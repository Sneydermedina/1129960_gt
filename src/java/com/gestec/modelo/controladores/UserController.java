/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.model.Email;
import com.gestec.modelo.entidades.Usuarios;
import com.gestec.modelo.entidades.Direccion;
import com.gestec.modelo.entidades.Contactos;
import com.gestec.modelo.entidades.Barrio;
import com.gestec.modelo.entidades.Localidad;
import com.gestec.modelo.entidades.Especialidad;
import com.gestec.modelo.entidades.Telefono;
import com.gestec.modelo.entidades.Relcalificacionusuarios;
import com.gestec.modelo.entidades.Calificacion;
import com.gestec.modelo.persistencia.BarrioFacadeLocal;
import com.gestec.modelo.persistencia.CalificacionFacadeLocal;
import com.gestec.modelo.persistencia.ContactosFacadeLocal;
import com.gestec.modelo.persistencia.DireccionFacadeLocal;
import com.gestec.modelo.persistencia.EspecialidadFacadeLocal;
import com.gestec.modelo.persistencia.LocalidadFacadeLocal;
import com.gestec.modelo.persistencia.RelcalificacionusuariosFacadeLocal;
import com.gestec.modelo.persistencia.TelefonoFacadeLocal;
import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.primefaces.event.FileUploadEvent;


/**
 *
 * @author leider
 */
@Named(value = "userController")
@ManagedBean (name = "userControllerr")
@SessionScoped
public class UserController implements Serializable{

    @EJB
    private UsuariosFacadeLocal ufl;
    @EJB
    private ContactosFacadeLocal cfl;
    @EJB
    private DireccionFacadeLocal dfl;
    @EJB
    private BarrioFacadeLocal bfl;
    @EJB
    private LocalidadFacadeLocal lfl;
    @EJB
    private TelefonoFacadeLocal tfl;
    @EJB
    private RelcalificacionusuariosFacadeLocal relcu;
    @EJB
    private CalificacionFacadeLocal calfl;
    @EJB
    private EspecialidadFacadeLocal efl;
    private List<Usuarios> listarUsuarios;
    private Usuarios usuarios;
    private Contactos contactos;
    private Direccion direccion;
    private Calificacion calificacion;
    private Telefono telefono;
    private Especialidad especialidad;
    private Barrio barrio;
    private Localidad localidad;
    private Relcalificacionusuarios rel;
    private String confirmarContra;
    private List<String> barrioss;
    private List<Barrio> barrios;
    private List<Localidad> localidades;
    private Integer numeroLocalidad;
    private List<String> especialidades;
    private Date date2;
    private Integer calif;
    private Integer barrioId;
    private String con;
    private String con2;
    private Boolean nuevoUsuario;
    private Boolean tipoUser;
    private Boolean editar;
    private Boolean ver;
    private double cali;
    private List<Relcalificacionusuarios> listarGeneral;
    private byte[] foto;
    private Boolean foto2;
    private Boolean contraA;

    @PostConstruct
    public void init(){
        this.tipoUser=false;
        this.telefono=new Telefono();
        this.usuarios=new Usuarios();
        this.telefono.setIdUsuario(new Usuarios());
        this.direccion=new Direccion();
        this.barrio=new Barrio();
        this.calificacion=new Calificacion();
        this.contactos=new Contactos();
        this.localidad=new Localidad();
        this.especialidad=new Especialidad();
        this.rel = new Relcalificacionusuarios();
        this.rel.setCalificacionIdcalificacion(new Calificacion());
        this.rel.setUsuariosidUsuario(new Usuarios());
        this.telefono.setIdUsuario(new Usuarios());
        this.especialidad.setUsuariosidUsuario(new Usuarios());
        this.direccion.setIdBarrio(new Barrio());
        this.direccion.setUsuariosidUsuario(new Usuarios());
        this.contactos.setIdUsuario(new Usuarios());
        this.contactos.setIdContacto(new Usuarios());
        this.nuevoUsuario=false;
        
        this.listarGeneral = relcu.findAll();
        this.listarUsuarios = ufl.findAll();
        this.localidades=lfl.findAll();
        this.barrios=bfl.findAll();
        this.cali = 1;
        this.editar=false;
        this.ver = false;
        this.foto2 = false;
        this.contraA=false;
    }
    public UsuariosFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuariosFacadeLocal ufl) {
        this.ufl = ufl;
    }

    public ContactosFacadeLocal getCfl() {
        return cfl;
    }

    public void setCfl(ContactosFacadeLocal cfl) {
        this.cfl = cfl;
    }

    public DireccionFacadeLocal getDfl() {
        return dfl;
    }

    public void setDfl(DireccionFacadeLocal dfl) {
        this.dfl = dfl;
    }

    public BarrioFacadeLocal getBfl() {
        return bfl;
    }

    public void setBfl(BarrioFacadeLocal bfl) {
        this.bfl = bfl;
    }

    public LocalidadFacadeLocal getLfl() {
        return lfl;
    }

    public void setLfl(LocalidadFacadeLocal lfl) {
        this.lfl = lfl;
    }

    public TelefonoFacadeLocal getTfl() {
        return tfl;
    }

    public void setTfl(TelefonoFacadeLocal tfl) {
        this.tfl = tfl;
    }

    public RelcalificacionusuariosFacadeLocal getRelcu() {
        return relcu;
    }

    public void setRelcu(RelcalificacionusuariosFacadeLocal relcu) {
        this.relcu = relcu;
    }

    public List<Usuarios> getListarUsuarios() {
        return listarUsuarios;
    }

    public void setListarUsuarios(List<Usuarios> listarUsuarios) {
        this.listarUsuarios = listarUsuarios;
    }
    
    public CalificacionFacadeLocal getCalfl() {
        return calfl;
    }

    public void setCalfl(CalificacionFacadeLocal calfl) {
        this.calfl = calfl;
    }

    public EspecialidadFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EspecialidadFacadeLocal efl) {
        this.efl = efl;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Contactos getContactos() {
        return contactos;
    }

    public void setContactos(Contactos contactos) {
        this.contactos = contactos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getConfirmarContra() {
        return confirmarContra;
    }

    public void setConfirmarContra(String confirmarContra) {
        this.confirmarContra = confirmarContra;
    }

    public List<String> getBarrioss() {
        return barrioss;
    }

    public void setBarrioss(List<String> barrioss) {
        this.barrioss = barrioss;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }

    public Integer getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Integer numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Relcalificacionusuarios getRel() {
        return rel;
    }

    public void setRel(Relcalificacionusuarios rel) {
        this.rel = rel;
    }

    public Integer getCalif() {
        return calif;
    }

    public void setCalif(Integer calif) {
        this.calif = calif;
    }

    public Integer getBarrioId() {
        return barrioId;
    }

    public void setBarrioId(Integer barrioId) {
        this.barrioId = barrioId;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public Boolean getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Boolean nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

   

    public double getCali() {
        return cali;
    }

    public void setCali(double cali) {
        this.cali = cali;
    }

    public List<Relcalificacionusuarios> getListarGeneral() {
        return listarGeneral;
    }

    public void setListarGeneral(List<Relcalificacionusuarios> listarGeneral) {
        this.listarGeneral = listarGeneral;
    }

    public Boolean getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(Boolean tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getFoto2() {
        return foto2;
    }

    public void setFoto2(Boolean foto2) {
        this.foto2 = foto2;
    }

    public Boolean getContraA() {
        return contraA;
    }

    public void setContraA(Boolean contraA) {
        this.contraA = contraA;
    }
    
  
    
    


    public void llenarBarrios(AjaxBehaviorEvent event){
   
        
        if (getNumeroLocalidad()<21 && getNumeroLocalidad()>0) {
            Localidad localidadBarrios = lfl.llenarBarriosLocalidad(getNumeroLocalidad());
            List<Barrio> barrios = localidadBarrios.getBarrioList();
            this.barrioss = new ArrayList<>();
            
            for (Barrio barrio1 : barrios) {
               barrioss.add(barrio1.getNombreBarrio());
               barrioId = barrio1.getIdBarrio();
            }
            
        }else{
            barrioss = new ArrayList<>();
            barrioss.add("Buena");
        }
        
    }

    
    public void especialidades(){
        
        ArrayList<Especialidad> especialidad = new ArrayList<Especialidad>();
        Especialidad esp = new Especialidad();
        esp.setIdespecialidad(1);
        esp.setEspecialidad("Mantenimiento");
        Especialidad esp2 = new Especialidad();
        esp2.setIdespecialidad(2);
        esp2.setEspecialidad("Instalacion");
        Especialidad esp3 = new Especialidad();
        esp3.setIdespecialidad(3);
        esp3.setEspecialidad("Diagnostico");
        especialidad.add(esp);
        especialidad.add(esp2);
        especialidad.add(esp3);
        
      
        
    }
    public ArrayList<SelectItem> genero(){
        ArrayList lista = new ArrayList();
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msjGestec");
        String msjGestec = null;
        msjGestec = bundle.getString("indiqueGenero");
        lista.add(new SelectItem(null,msjGestec));
        lista.add(new SelectItem("Masculino",bundle.getString("masculino")));
        lista.add(new SelectItem("Femenino", bundle.getString("femenino")));

        lista.add(new SelectItem("Otro",bundle.getString("otro")));
        
        return lista;
    }
    public ArrayList<SelectItem> especialidad(){
        ArrayList lista = new ArrayList();
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msjGestec");
        String msjGestec = null;
        msjGestec = bundle.getString("seleccioneEspecialidad");
        lista.add(new SelectItem(null,msjGestec));
        lista.add(new SelectItem("Diagnostico",bundle.getString("diagnostico")));
        lista.add(new SelectItem("Instalacion",bundle.getString("instalacion")));
        lista.add(new SelectItem("Mantenimiento",bundle.getString("mantenimiento")));
        lista.add(new SelectItem("Ninguna",bundle.getString("ninguna")));
        
        return lista;
    }
    public void valContra(AjaxBehaviorEvent event){
        this.con2=con;
    }
  
    public void validarCorreo(FacesContext context,UIComponent toValidate,Object value){
        context = FacesContext.getCurrentInstance();
        String texto=(String) value;
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msjGestec");
        FacesMessage msjGestec=null;
        
        if (texto.isEmpty()) {
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle4"));
            context.addMessage(toValidate.getClientId(context),msjGestec);
        }
        
        for (Usuarios correos : ufl.findAll()) {
            correos.getCorreo();
            msjGestec = new FacesMessage(bundle.getString("bundle3"));
            if (texto.equals(correos.getCorreo())) {
                ((UIInput)toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context),msjGestec);
            }
        }
    }
    public void validarNombre(FacesContext context,UIComponent toValidate,Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msjGestec");
        
        FacesMessage msjGestec=null;
    
        
        if (texto.isEmpty()) {
            ((UIInput)toValidate).setValid(false);
            msjGestec=new FacesMessage(bundle.getString("bundle2"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
        for (Usuarios users : ufl.findAll()) {
            users.getNombreUsuario();
            
            if (texto.equals(users.getNombreUsuario())) {
                ((UIInput)toValidate).setValid(false);
                //msj = new FacesMessage(bundle.getLocale().getLanguage().concat());
                msjGestec = new FacesMessage(bundle.getString("bundle1"));
                context.addMessage(toValidate.getClientId(context), msjGestec);
                texto="";
               // msjGestec = new FacesMessage(FacesMessage.SEVERITY_INFO,bundle.getString("registrar"),texto); 
                
            }
        }
    }
    
    public void validarContrasena(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msjGestec");
        FacesMessage msjGestec=null;
        
        if (texto.isEmpty()) {
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle5"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
        
        else if (!texto.equals(con2)) {
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle6"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
        
        
    }
    public void validarDocumento(FacesContext context,UIComponent toValidate,Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msjGestec");
        
        FacesMessage msjGestec=null;
        if (texto.isEmpty()) {
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle5"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
        for (Usuarios doc : ufl.findAll()) {
            doc.getDocumento();
            if (texto.equals(doc.getDocumento())) {
                msjGestec = new FacesMessage(bundle.getString("bundle7"));
                ((UIInput)toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), msjGestec);
            }
        }
    }
    public void validarFecha(FacesContext context,UIComponent toValidate, Object value) throws ParseException{
        context = FacesContext.getCurrentInstance();
        Date texto = (Date) value;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2000-01-01");
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msjGestec");
        
        FacesMessage msjGestec = null;
        if (texto == null){
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle8"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
        else if (texto.after(fecha)) {
            ((UIInput)toValidate).setValid(false);
            msjGestec = new FacesMessage(bundle.getString("bundle9"));
            context.addMessage(toValidate.getClientId(context), msjGestec);
        }
    }
    /*    public void validarCorreo(FacesContext context, UIComponent toValidate, Object value){
    context = FacesContext.getCurrentInstance();
    String texto = (String) value;
    
    Pattern patern = Pattern.compile("\\v+@\\v+\\.\\v+");
    Matcher matcher = patern.matcher((CharSequence) value);
    
    if (!matcher.matches()) {
    context.addMessage(toValidate.getClientId(context), new FacesMessage("Escriba una direccion de correo valida"));
    }
    }*/
    public String enviarCorreo(){
        Usuarios usuarioLog1 = ufl.validarUsuariosCorreo(usuarios.getCorreo());
        if (!usuarioLog1.getNombreUsuario().equals("No Existe")) {
            String estados="2";
            
            try {
                Email micorreo = new Email();
                Email.sendModificacion(usuarioLog1.getCorreo(), usuarioLog1.getNombreUsuario(), usuarioLog1.getNombreUsuario(), usuarioLog1.getContrasenaUsuario());
            } catch (Exception e) {
                estados="4";
            }
        }else{
            String estados ="3";
        }
        return "";
    }
    public void redireccionar(String url){
        
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath() + url);
        } catch (IOException e) {
            Logger.getLogger(UserController.class.getName()).log(Priority.ERROR, e, e);
        }
        
    }
    public void salir(){
        this.nuevoUsuario=false;
        this.usuarios.setNombreUsuario("");
        this.usuarios.setApellido("");
        this.usuarios.setTipoDocumento("Seleccione un tipo de documento");
        this.usuarios.setDocumento("");
        this.usuarios.setCorreo("");
        this.usuarios.setFechaNacimiento(null);
        this.date2=null;
        this.usuarios.setSexo("Seleccione su genero");
        this.usuarios.setDiscapacidad("");
        this.usuarios.setTipoUsuario("Seleccione un tipo de usuario");
        this.telefono.setTipoTelefono("");
        this.telefono.setNumeroTelefono("");
        this.especialidad.setEspecialidad("");
        this.direccion.setComplemento("");
        this.direccion.setComplementoVia("");
        this.direccion.setComplementoVia2("");
        this.direccion.setNumeroCasa(null);
        this.direccion.setNumeroVia(null);
        this.direccion.setNumeroVia2(null);
        this.direccion.setTipoVia("");
        
        redireccionar("/faces/index.xhtml?faces-redirect=true");
    }
    
    public void registrarUsuario(){
        System.out.println("Entro");
        //Date date3 = (Date)date;
        this.usuarios.setFechaNacimiento(date2);
        this.usuarios.setPerfil("Perfil "+usuarios.getNombreUsuario());
        this.usuarios.setWeb("Ninguna");
        this.usuarios.setEstadoUsuario("1");
        this.usuarios.setContrasenaUsuario(con);
        
        ufl.create(usuarios);
        
        this.rel.setCalificacionIdcalificacion(calfl.find(7));
        
        Integer cantidad=ufl.findAll().size()-1;
        Usuarios usu = ufl.findAll().get(cantidad);
        this.rel.setUsuariosidUsuario(usu);
        
        relcu.create(rel);
        this.telefono.setIdUsuario(usu);
        tfl.create(telefono);
        System.out.println("Todo bien");
        /*Integer especi = (Integer) efl.sumarId();
        Especialidad esp = efl.findAll().get(especi);*/
        long num = (long) efl.sumarId();
        int num2 = (int) num;
        this.especialidad.setIdespecialidad(num2);
        this.especialidad.setUsuariosidUsuario(usu);
        this.especialidad.setEspecialidad("N/A");
        efl.create(especialidad);
        System.out.println("Vamos!");
       
        this.direccion.setIdBarrio(bfl.find(barrioId));
        System.out.println("funciona 1");
        this.direccion.setUsuariosidUsuario(usu);
        System.out.println("funciona 2");
        dfl.create(direccion);
        System.out.println("funciona 3");
        this.contactos.setIdContacto(ufl.find(6));
        this.contactos.setIdUsuario(usu);
        cfl.create(contactos);
        //this.telefono=new Telefono();
        //this.telefono.setIdUsuario(new Usuarios());
        //tfl.create(telefono);
        this.ufl.findAll();
        this.dfl.findAll();
        this.calfl.findAll();
        this.efl.findAll();
        this.relcu.findAll();
        this.tfl.findAll();
        this.bfl.findAll();
        this.lfl.findAll();
        this.cfl.findAll();
        this.relcu.findAll();
        this.listarGeneral = relcu.findAll();
        enviarCorreo();
        System.out.println("Correo");
        this.nuevoUsuario=true;
        System.out.println("Registro exitoso!");
        
    }
    
    public void mensaje(){
        System.out.println("Buena");
    }
    
    public double cal(int usuario){
        this.cali=(Integer)calfl.findByUser(usuario);
        System.out.println(calfl.findByUser(usuario));
        return cali;
    }
    
    /*public List<Double> getCalificaciones() {
        
        List<Double> puntos = new ArrayList<>();
        List<Relcalificacionusuarios> calificaciones = getUsuarios().getRelcalificacionusuariosList();
        for (Relcalificacionusuarios calificacion : calificaciones) {
            puntos.add(calificacion.getCalificacionIdcalificacion().getCalificacion());
        }
        return puntos;
    }*/
    
    public void activar(Usuarios u){
        
        //this.rel.getUsuariosidUsuario().setEstadoUsuario("1");
        this.usuarios = u;
        
        
        this.usuarios.setEstadoUsuario("1");
        //Object s = (Object)u;
        //int d = (int)s;
        //this.listarGeneral.get(u).getUsuariosidUsuario().setEstadoUsuario("1");
        System.out.println(usuarios.getIdUsuario()+" "+usuarios.getEstadoUsuario());
        System.out.println(this.usuarios);
        System.out.println(rel.getUsuariosidUsuario().getIdUsuario());
        this.ufl.edit(this.usuarios);
        //this.relcu.edit(rel);
        System.out.println(usuarios.getEstadoUsuario());
        redireccionar("/faces/gestec/usuario/admin_users.xhtml?faces-redirect=true");
    }
    public void desactivar(Usuarios u){
        this.usuarios = u;
        FacesMessage msj = new FacesMessage();
        if (!usuarios.getTipoUsuario().equals("Administrador")){
            this.usuarios.setEstadoUsuario("0");
            this.ufl.edit(usuarios);
            redireccionar("/faces/gestec/usuario/admin_users.xhtml?faces-redirect=true"); 
        }else{
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO,"No puede bloquear administradores","Prohibido");
        }
        
    }
    
    public void editarUser(Relcalificacionusuarios u){
        this.rel =  u;
        this.editar = true;
        this.ver = false;
        redireccionar("/faces/gestec/usuario/editar_users.xhtml?faces-redirect=true");
    }
    public void actualizarFoto(FileUploadEvent e) throws IOException{
        this.foto = IOUtils.toByteArray(e.getFile().getInputstream());
        this.foto2=true;
    }
    public void editarUser1(){
        if (foto2==true) {
            this.rel.getUsuariosidUsuario().setFotoPerfil(foto);
        }
        System.out.println(foto2);
        relcu.edit(rel);
        this.ufl.edit(rel.getUsuariosidUsuario());
        this.foto2=false;
        redireccionar("/faces/gestec/usuario/editar_users.xhtml?faces-redirect=true");
    }
    public void editarUser2(){
        this.rel.getUsuariosidUsuario().setContrasenaUsuario(con2);
        this.ufl.edit(rel.getUsuariosidUsuario());
        this.contraA=true;
    }
    
    public void retornarListado(){
        this.editar = false;
        this.foto2 = false;
        this.ver = false;
        this.contraA = false;
        redireccionar("/faces/gestec/usuario/admin_users.xhtml?faces-redirect=true");
    }
    
   
    public int calcularEdad(){
        return 1;
    }
  
    
}
