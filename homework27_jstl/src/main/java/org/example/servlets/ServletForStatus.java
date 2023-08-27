package org.example.servlets;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.Status;
import org.example.service.ServiceOfTasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/change")
public class ServletForStatus extends HttpServlet {
    ServiceOfTasks serviceOfTasks = new ServiceOfTasks();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String actName = req.getParameter("actName"); // Вообще не могу понять почему не могу сделать casting
        // в тип Activity, на JSP странице меняю act.name на act.
        Object activity = req.getSession().getAttribute("Activity");
        List<Activities> activities = (List<Activities>) activity;
        serviceOfTasks.changeStatus(activities,actName);

        req.getSession().setAttribute("Activity",activities);
        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);

    }
}

