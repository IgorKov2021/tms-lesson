package org.example;

import javax.servlet.*;

import java.io.IOException;


public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserProcessor userProcessor = new UserProcessor();

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (userProcessor.checkEnter(login, pass) ) {
            //request.getRequestDispatcher("/successlogin").forward(request,response);
            chain.doFilter(request,response);

        } else {
            response.getWriter().println("check the entered data!!!");

            //request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
