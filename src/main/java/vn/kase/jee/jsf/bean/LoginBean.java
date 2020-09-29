package vn.kase.jee.jsf.bean;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import vn.kase.jee.jpa.entity.UserInfo;
import vn.kase.jee.jsf.common.AbstractPersistenceBean;
import vn.kase.jee.jsf.pojo.Session;

@Named
@RequestScoped
public class LoginBean extends AbstractPersistenceBean {
    private String email;
    private String password;
    private Integer roleId;

    public String login() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", email);
        UserInfo userInfo = findOne(UserInfo.class, "SELECT s FROM UserInfo s WHERE s.email = :email", parameters);

        if (userInfo != null && password.equals(userInfo.getUser().getPassword())) {
            if (userInfo.getUser().getRoles().stream().anyMatch(info -> info.getId() == roleId)) {
                Session session = new Session();
                session.setEmail(email);
                session.setRoleId(roleId);

                setSession(session);

                return "pretty:teacher-home";
            }

            setRequestAttribute("LOGIN_MESSAGE", "Your role are not matching");

            return null;
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
