package mk.ukim.finki.wpaud.web.servlet;

import mk.ukim.finki.wpaud.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servlet-category", urlPatterns = "/servlet/category")
public class MessyCategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public MessyCategoryServlet(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        PrintWriter out = resp.getWriter();
        out.println("<html>"); // HTML Begins
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        //Header for user info
        out.println("<h3>User Info List</h3>");
        out.format("IP Address: %s <br>", ipAddress);
        out.format("Client Agent: %s", clientAgent);


        //List the categories
        out.println("<h3>Category List</h3>");
        out.println("<ul>");
        categoryService.listCategories().forEach(r->
                out.format("<li>%s (%s)</li>",r.getName(),r.getDescription()));
        out.println("</ul>");


        //form for adding category
        out.println("<h3>Add Category</h3>");
        out.println("<form method = 'POST' action='/servlet/category'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input id='name' type='text' name='name'/>");
        out.println("<label for='description'>Description:</label>");
        out.println("<input id='description' type='text' name='description'/>");
        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");




        out.println("</body>");
        out.println("</html>"); //HTML Ends


        //System.out.println("Category server doGet()");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDescription = req.getParameter("description");
        categoryService.create(categoryName,categoryDescription); //add the new category
        resp.sendRedirect("/servlet/category"); //302 code, redirect /servlet/category which calls doGet()
        //System.out.println("doPost() pravi redirect kon /servlet/category");
    }

}
