/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;


import com.gestec.modelo.persistencia.EquipoFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Leider
 */
@Named(value = "archivosView")
@ManagedBean(name = "archivos")
@ViewScoped
public class ArchivosView implements Serializable{
    
    /**
     * Creates a new instance of ArchivosView
     */
    
    @EJB
    private EquipoFacadeLocal efl;
    
    private UploadedFile uploadedFile;
    private List<Object[]> datosTabla=new ArrayList();

    public ArchivosView() {
    }

    public List<Object[]> getDatosTabla() {
        return datosTabla;
    }

    public void setDatosTabla(List<Object[]> datosTabla) {
        this.datosTabla = datosTabla;
    }
    
    public void HandleFileUpload(FileUploadEvent event) throws IOException {
        uploadedFile = event.getFile();
        InputStream file=uploadedFile.getInputstream();
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet miHoja = workbook.getSheetAt(0);
        Iterator filas = miHoja.rowIterator();
        this.datosTabla.clear();
        
        while(filas.hasNext()){
            HSSFRow nuevaFila = (HSSFRow) filas.next();
            Iterator celdas = nuevaFila.cellIterator();
            String[] addFila = new String[7];
            int pos=0;
            while(celdas.hasNext()){
                addFila[pos] = celdas.next().toString();
                pos++;
            }
            addFila[6] = ""+efl.ingresarEquipoExcel(addFila);
            this.datosTabla.add(addFila);
        }
        FacesMessage fm = new FacesMessage("Exito",event.getFile().getFileName()+" Fue subido");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
        
    }
    public void redirect(){
        try {
        System.out.println("Vamos bien");
            FacesContext.getCurrentInstance().getExternalContext().redirect("ControlReportes");
        } catch (IOException iOException) {
            
        }
    }
    
}
