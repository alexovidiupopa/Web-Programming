package servlets;

import controller.AppController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getHeader("userid"));
        System.out.println(req.getParameter("userid"));
        System.out.println(req.getAttribute("userid"));
        int userId = Integer.parseInt((req.getParameter("userid")));
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        int value = Integer.parseInt(req.getParameter("value"));
        AppController.addAsset(userId,name,desc,value);
        req.getSession().setAttribute("assets",AppController.getAssetsOfUser((Integer) req.getSession().getAttribute("userId")));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("assets",AppController.getAssetsOfUser((Integer) req.getSession().getAttribute("userId")));
    }
}
