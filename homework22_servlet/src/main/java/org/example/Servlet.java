package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("DO GET");
        PrintWriter writer = resp.getWriter();
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        Locale locale = resp.getLocale();
        int status = resp.getStatus();
        writer.println("<html>" +
                "<head> Servlet is started </head>" +
                "<body> " +
                "<h1> Current date and time: " + date  + "</h1> " +
                "<h2>Current locale: " + locale + "</h2>" +
                "<h3>Current status: " + status + "</h3>" +
                "</body>"+
                "</html>");



    }


}
