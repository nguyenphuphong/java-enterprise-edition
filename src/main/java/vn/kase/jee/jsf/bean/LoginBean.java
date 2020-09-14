package vn.kase.jee.jsf.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import vn.kase.jee.jsf.common.AbstractFacesBean;
import vn.kase.jee.jsf.pojo.Session;

@Named
@RequestScoped
public class LoginBean extends AbstractFacesBean {
    private String email;
    private String password;
    private Integer roleId;

    public String login() {
        if ("nguyenphuphong@gmail.com".equals(email)) {
            Session session = new Session();
            session.setEmail(email);
            session.setRoleId(roleId);
    
            setSession(session);

            return "pretty:teacher-home";
        }

        setRequestAttribute("LOGIN_MESSAGE", "Your username/password are not matching");

        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
