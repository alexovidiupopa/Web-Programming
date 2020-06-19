package servlets;

import authentication.CredentialsManager;
import controller.AppController;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String authentication = CredentialsManager.authenticate(username,password);
        if(authentication.equals("success")){
            login(req.getSession(), username);
            resp.sendRedirect("/homepage.jsp");
        }
        else {
            resp.sendRedirect("/index.jsp");
        }
    }

    private void login(HttpSession session, String username) {
        User user = AppController.getUserWithUsername(username);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("userId",user.getUserid());
        session.setAttribute("assets", AppController.getAssetsOfUser(user.getUserid()));
    }
}
