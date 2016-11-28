package beerzeit.beans;

import beerzeit.utils.AvatarStorage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileNotFoundException;

/**
 * Created by pedro on 28/11/16.
 */
@ManagedBean(name="imagerender")
@ApplicationScoped
public class ImageRenderBean {
    public StreamedContent getImage() throws FileNotFoundException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }

        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
        return AvatarStorage.showFile(filename);
    }
}
