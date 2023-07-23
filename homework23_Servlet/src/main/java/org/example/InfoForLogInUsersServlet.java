package org.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InfoForLogInUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Object log = session.getAttribute("log");
        ServletContext servletContext = getServletContext();
        if (log == null) {
            System.out.println("ONLY for registered users!");
    servletContext.getRequestDispatcher("/index.html").forward(req,resp);
        } else {

            resp.getWriter().println("You can get secret information");

        }

    }
}
