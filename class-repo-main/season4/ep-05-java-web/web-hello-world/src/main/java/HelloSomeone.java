import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloSomeone extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        response.sendRedirect("src/main/webapp/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name= req.getParameter("username");
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("/hello/index.html");
        } else {
            resp.getWriter().printf("Hello Mr. %s, welcome to our servlet!", name);
        }
    }

}
