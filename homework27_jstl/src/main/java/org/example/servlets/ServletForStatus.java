package org.example.servlets;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/change")
public class ServletForStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actName = req.getParameter("actName");
        Object activity = getServletContext().getAttribute("ActivityDone");
        // getServletContext().removeAttribute("Activity");
        List<Activities> list = (List<Activities>) activity;
        List<Activities> newList = new ArrayList<>(list);
        for (Activities act : newList) {
            if (act.getName().equals(actName) && act.getStatus().equals(Status.NOT_DONE)) {
                act.setStatus(Status.IN_PROGRESS);
            } else if (act.getName().equals(actName)) {
                act.setStatus(Status.DONE);
                newList.remove(act);
                break;

            }


        }
        if (newList.size() != 0) {
            getServletContext().setAttribute("taskEmpty", "done");
            getServletContext().setAttribute("ActivityDone", newList);
            req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
        } else {
            getServletContext().setAttribute("ActivityDone", newList);
            getServletContext().setAttribute("taskEmpty", "empty");
            req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
        }
    }
}

