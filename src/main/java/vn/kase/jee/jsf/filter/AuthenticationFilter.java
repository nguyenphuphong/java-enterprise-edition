package vn.kase.jee.jsf.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kase.jee.jsf.pojo.Session;

@WebFilter(urlPatterns = "/teacher/*")
public class AuthenticationFilter extends HttpFilter {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        Session session = (Session) req.getSession().getAttribute("SESSION");
        if (session == null) {
            req.setAttribute("LOGIN_MESSAGE", "You need to login to access that page");
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
            dispatcher.forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}
