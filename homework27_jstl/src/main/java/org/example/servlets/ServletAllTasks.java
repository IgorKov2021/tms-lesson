package org.example.servlets;

import org.example.info.Activities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAll")

public class ServletAllTasks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userAllAct = getServletContext().getAttribute("Activity");
        List<Activities> listAllAct= (List<Activities>)userAllAct;
        getServletContext().setAttribute("AllAct", listAllAct);
        System.out.println(listAllAct);
        getServletContext().setAttribute("taskEmpty", "all");
        req.getRequestDispatcher("tasks.jsp").forward(req, resp);

    }
}
