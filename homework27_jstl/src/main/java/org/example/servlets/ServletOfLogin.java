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
        List<User> userList = DatabaseOfUsers.getUserList();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            req.setAttribute("blank", "blank");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } else if (checkPassword(userList, login, password)) {
            Optional<User> first = userList.stream()
                    .filter(user -> user.getLogin().equals(login)).findFirst();
            User user1 = first.get();
            req.getSession().setAttribute("name", user1.getName());
            getServletContext().setAttribute("user", user1);
            List<Activities> userActivities = user1.getUserActivities();
            getServletContext().setAttribute("Activity", userActivities);
            req.getRequestDispatcher("/tasks.jsp").forward(req,resp);
        } else {
            req.setAttribute("wrongPassword", "wrong");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


        }

public boolean checkPassword (List<User> userList, String login, String password) {
        return userList.stream()
                . anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
}
}


