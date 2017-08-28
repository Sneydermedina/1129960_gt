package com.gestec.modelo.controladores;

import com.gestec.modelo.persistencia.UsuariosFacadeLocal;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author michael
 */
@Named(value = "fotosController")
@SessionScoped
public class FotosController implements Serializable {

    byte[] f;
    @EJB
    UsuariosFacadeLocal ufl;
    
    public FotosController() {
    }

    public byte[] getF() {
        return f;
    }

    public void setF(byte[] f) {
        this.f = f;
    }
    
    public StreamedContent getFto() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("pif");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }
    
    public StreamedContent getImagenPerfil() throws IOException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap()
                    .get("pid");
            Integer idF = Integer.valueOf(id);
            byte[] image = ufl.find(idF).getFotoPerfil();
            if (image == null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(ufl.find(1).getFotoPerfil()));
            }
            return new DefaultStreamedContent(new ByteArrayInputStream(image));

        }
    }
    
}
