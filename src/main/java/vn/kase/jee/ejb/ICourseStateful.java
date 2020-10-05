package vn.kase.jee.ejb;

import javax.ejb.Remote;

import vn.kase.jee.ejb.exception.AuthenticationException;

@Remote
public interface ICourseStateful {
    void authen(String email, String password) throws AuthenticationException;

    void join(Integer linkId);
}
