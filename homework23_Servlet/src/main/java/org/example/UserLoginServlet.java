package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object login1 = session.getAttribute("log");
        resp.getWriter().println("<html> " +
                "<body> " +
                "<h3>You are successfully logged in!</h3> </body></html>");

        if (login1 == null) {
        session.setAttribute("log","userLogged");
        }


    }
}
