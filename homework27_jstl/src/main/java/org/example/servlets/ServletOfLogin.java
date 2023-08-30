package org.example.servlets;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.User;
import org.example.service.ServiceOfUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet("/")
public class ServletOfLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        ServiceOfUsers serviceOfUsers = new ServiceOfUsers();

        String text = serviceOfUsers.getLogin(login, password);

        if (text.equals(login)) {

            req.getSession().setAttribute("Activity", serviceOfUsers.getUser(login).getUserActivities());
            req.getSession().setAttribute("name", serviceOfUsers.getUser(login).getName());
            req.getSession().setAttribute("login", serviceOfUsers.getUser(login).getLogin());
            req.getRequestDispatcher("/tasks.jsp").forward(req, resp);

        } else {

            req.setAttribute("blank", text);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}


