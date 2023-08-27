package org.example.servlets;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.User;
import org.example.service.ServiceOfNewUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/newUser")
public class ServletNewUser extends HttpServlet {
    DatabaseOfUsers database = new DatabaseOfUsers();
    ServiceOfNewUser serviceOfNewUser = new ServiceOfNewUser();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = DatabaseOfUsers.getUserList();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/newUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String surname = req.getParameter("surname");


        User user1 = serviceOfNewUser.saveUser(new User(name,surname,password,email,login));
        if (user1 != null) {
            req.getSession().setAttribute("login", user1.getLogin());
            req.getSession().setAttribute("name", user1.getName());

            req.getRequestDispatcher("/tasks.jsp").forward(req,resp);

        } else {
            req.setAttribute("repeat",true);
            req.getRequestDispatcher("/newUser.jsp").forward(req, resp);
        }

    }
}
