package org.academiadecodigo.examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pantoninho on 23/03/2017.
 */
public class RefreshController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int current;

        // if attribute "reqRefreshes" doesn't exist in the request scope, create it with value 0
        // else, increase it by one
        //
        // this is useless cause it will always come null (req attributes always come clean each request)
        if (req.getAttribute("reqRefreshes") == null) {
            req.setAttribute("reqRefreshes", 0);
        } else {
            current = (int) req.getAttribute("reqRefreshes");
            req.setAttribute("reqRefreshes", current + 1);
        }

        // if attribute "sessionRefreshes" doesn't exist in the session scope, create it with value 0 (new session)
        // else, increase it by one
        //
        // it will only reset to 0 if cookie expires, or admin explicitely invalidates the session
        if (req.getSession().getAttribute("sessionRefreshes") == null) {
            req.getSession().setAttribute("sessionRefreshes", 0);
        } else {
            current = (int) req.getSession().getAttribute("sessionRefreshes");
            req.getSession().setAttribute("sessionRefreshes", current + 1);
        }

        // if attribute "appRefreshes" doesn't exist in the application scope, create it with value 0
        // else, increase it by one
        //
        // this will only happen once when the first guy requests this route. and will only reset to 0 if the application shuts down and restarts
        if (getServletContext().getAttribute("appRefreshes") == null) {
            getServletContext().setAttribute("appRefreshes", 0);
        } else {
            current = (int) getServletContext().getAttribute("appRefreshes");
            getServletContext().setAttribute("appRefreshes", current + 1);
        }


        // forward the request to the JSP parser, letting him handle the request from now on
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/examples/clicker.jsp");
        requestDispatcher.forward(req, resp);

    }

}
