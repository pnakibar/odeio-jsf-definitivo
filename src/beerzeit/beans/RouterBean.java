package beerzeit.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by pedro on 28/11/16.
 */
@ManagedBean(name = "routerbean")
@SessionScoped
public class RouterBean  {
    public String getViewId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String viewId = facesContext.getViewRoot().getViewId();
        return viewId;
    }
    public String getNavClass(String current) {
        String r = getViewId().contentEquals(current) ?
                        "active" :
                        "";
        return r;
    }
}
