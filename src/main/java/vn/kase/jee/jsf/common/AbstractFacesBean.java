package vn.kase.jee.jsf.common;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import vn.kase.jee.jsf.pojo.Session;

public abstract class AbstractFacesBean {
    protected Session getSession() {
        FacesContext context = FacesContext.getCurrentInstance();

        return (Session) context.getExternalContext().getSessionMap().get("SESSION");
    }

    protected void setSession(Session session) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("SESSION", session);
    }

    protected String getParameter(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getRequestParameterMap().get(name);
    }

    protected void invalidateSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
    }

    protected void setRequestAttribute(String name, Object value) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.setAttribute(name, value);
    }
}
