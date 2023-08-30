package org.example.servlets;

import org.example.info.Activities;
import org.example.info.User;
import org.example.service.ServiceOfTasks;
import org.example.service.ServiceOfUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tasks")
public class ServletOfTask extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String)req.getSession().getAttribute("login");
        String task = req.getParameter("task");


        ServiceOfTasks serviceOfTasks = new ServiceOfTasks();
        ServiceOfUsers serviceOfUsers = new ServiceOfUsers();
        User user = serviceOfUsers.getUser(login);

        req.getSession().setAttribute("Activity", serviceOfTasks.saveTask(user,task));

        req.getRequestDispatcher("tasks.jsp").forward(req, resp);



    }


}

