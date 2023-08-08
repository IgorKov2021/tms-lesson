package servlet;

import org.example.Application;
import org.example.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ServletRequest extends HttpServlet {
    private Database database = new Database();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/save-request.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String name = req.getParameter("name");
        String description = req.getParameter("description");
        if (name == null || name.isBlank() || description == null || description.isBlank()) {
            req.setAttribute("name", name);
            req.setAttribute("description", description);
            req.getRequestDispatcher("/save-request.jsp").forward(req,resp);

        } else {
            req.setAttribute("name", name);
            req.setAttribute("description", description);
            Application app = new Application(name, description);
            Database.getApp().add(app);
            List<Application> apps = Database.getApp();
            req.setAttribute("apps", apps);
            req.getRequestDispatcher("/save-request2.jsp").forward(req,resp);
        }
        System.out.println(name);
        System.out.println(description);
       // req.getRequestDispatcher("/save-request.jsp").forward(req,resp);
    }
}
