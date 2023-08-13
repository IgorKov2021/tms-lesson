package org.example.servlets;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.User;

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

        List<User> userList = DatabaseOfUsers.getUserList();
        List<String> collect = userList.stream()
                .map(user -> user.getLogin())
                .collect(Collectors.toList());
        if (login == null || login.isBlank() || password == null || password.isBlank()
        || collect.contains(login)) {
            System.out.println("GJDNJH!!!!!");
            req.setAttribute("repeat",true);
            req.getRequestDispatcher("/newUser.jsp").forward(req, resp);
        } else {
            User user = new User(name, surname, password, email, login);
            userList.add(user);
            req.getSession().setAttribute("name", user.getName());
            req.setAttribute("login", user.getLogin());
            getServletContext().setAttribute("user", user);
            req.getRequestDispatcher("/tasks.jsp").forward(req,resp);
            System.out.println(userList);
        }

    }
}
