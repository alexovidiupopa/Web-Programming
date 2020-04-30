package servlets;

import controller.ProfilesController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int age = req.getParameter("age").equals("") ? 0 : Integer.parseInt(req.getParameter("age"));
        req.setAttribute("users", ProfilesController.search(req.getParameter("name"),
                req.getParameter("email"), age, req.getParameter("hometown")));
        resp.sendRedirect("/browse.jsp");
    }
}
