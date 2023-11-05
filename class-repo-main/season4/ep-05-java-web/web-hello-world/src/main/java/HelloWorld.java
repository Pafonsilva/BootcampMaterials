import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name= req.getParameter("username");
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("index.html");
        } else {
            resp.getWriter().printf("Hello Mr. %s, welcome to our servlet!", name);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect("index.html");
    }

}
