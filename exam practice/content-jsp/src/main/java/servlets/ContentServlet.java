package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.AppController;
import model.Asset;
import model.Content;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ((action != null) && action.equals("getMostRecent")) {
            JSONObject answer = new JSONObject();
            JSONArray jsonAssets = new JSONArray();
            for (Content content : AppController.getMostRecent()) {
                JSONObject jObj = new JSONObject();
                jObj.put("id", content.getId());
                jObj.put("userId", content.getUserId());
                jObj.put("date", content.getDate());
                jObj.put("title", content.getTitle());
                jObj.put("description", content.getDescription());
                jObj.put("url", content.getUrl());
                jsonAssets.add(jObj);
            }
            answer.put("contents", jsonAssets);
            PrintWriter out = new PrintWriter(resp.getOutputStream());
            out.println(answer);
            out.flush();
        }
        else if (action!=null && action.equals("getAll")){
            JSONObject answer = new JSONObject();
            JSONArray jsonAssets = new JSONArray();
            for (Content content : AppController.getAllContents()) {
                JSONObject jObj = new JSONObject();
                jObj.put("id", content.getId());
                jObj.put("userId", content.getUserId());
                jObj.put("date", content.getDate());
                jObj.put("title", content.getTitle());
                jObj.put("description", content.getDescription());
                jObj.put("url", content.getUrl());
                jsonAssets.add(jObj);
            }
            answer.put("contents", jsonAssets);
            PrintWriter out = new PrintWriter(resp.getOutputStream());
            out.println(answer);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ((action != null) && action.equals("addContents")) {
            String newAssetsToAddJSON = req.getParameter("newContentsToAdd");
            System.out.println("received post");
            System.out.println(newAssetsToAddJSON);
            ObjectMapper mapper = new ObjectMapper();
            Content[] contents = mapper.readValue(newAssetsToAddJSON, Content[].class);
            for(Content content : contents) {
                System.out.println(content.toString());
                AppController.addContent(content.getUserId(),content.getTitle(),content.getDescription(),content.getUrl());
            }
        }
        else if (action!=null && action.equals("deleteContent")){
            System.out.println("here");
            int id = Integer.parseInt(req.getParameter("contentId"));
            int userId = Integer.parseInt(req.getParameter("userId"));
            AppController.deleteContent(id,userId);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("here");
        if ((action != null) && action.equals("deleteContent")) {
            System.out.println("here");
            int id = Integer.parseInt(req.getParameter("contentId"));
            int userId = Integer.parseInt(req.getParameter("userId"));
            AppController.deleteContent(id,userId);
        }
    }
}
