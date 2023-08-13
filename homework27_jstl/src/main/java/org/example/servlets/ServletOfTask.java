package org.example.servlets;

import org.example.info.Activities;
import org.example.info.User;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
       Object user = getServletContext().getAttribute("user");

        User user1 = (User) user;


        if (task != null || !task.isEmpty()) {

            Object activity = getServletContext().getAttribute("Activity");
            getServletContext().removeAttribute("Activity");

            if (activity == null) {
                List<Activities> actNew = new ArrayList<>();
                Activities act = new Activities(task);
                actNew.add(act);

                // getServletContext().setAttribute("Activity", actNew);
                user1.setUserActivities(actNew);

                getServletContext().setAttribute("Activity", user1.getUserActivities());
                getServletContext().setAttribute("ActivityDone", user1.getUserActivities());
                req.getRequestDispatcher("tasks.jsp").forward(req, resp);
            } else {
                List<Activities> activities = (List<Activities>) activity;
                List<Activities> actNew = new ArrayList<>(activities);
                Activities act = new Activities(task);
                actNew.add(act);
                user1.setUserActivities(actNew);

                getServletContext().setAttribute("Activity", user1.getUserActivities());
                getServletContext().setAttribute("ActivityDone", user1.getUserActivities());


                getServletContext().setAttribute("taskEmpty", "notempty");

                //getServletContext().setAttribute("Activity", actNew);

                req.getRequestDispatcher("tasks.jsp").forward(req, resp);
            }
        }

    }


}

