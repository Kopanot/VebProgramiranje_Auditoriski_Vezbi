package mk.ukim.finki.wpaud.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "hello",urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        PrintWriter writer = resp.getWriter();
        writer.format("<html><head><h1>Hi! %s %s</h1></head><body></body></html>",name,surname);
        System.out.println("Servlet Hello doGet();");
        writer.flush();
    }
}