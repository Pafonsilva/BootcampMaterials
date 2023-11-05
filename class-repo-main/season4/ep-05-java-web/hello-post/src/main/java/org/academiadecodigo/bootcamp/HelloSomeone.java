package org.academiadecodigo.bootcamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloSomeone extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/hello-someone/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");

        if(name == null || name.isEmpty()) {
            resp.sendRedirect("/hello-someone/index.html");
        } else {
            resp.getWriter().printf("<h1>Hello, %s, welcome to our very modern servlet</h1>", name);
            resp.getWriter().printf("<a href=\"\">wow! take me back</a>");
        }
    }
}
