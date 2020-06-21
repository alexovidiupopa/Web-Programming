package controller;

import db.Manager;
import model.Asset;
import model.Content;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppController {
    public static User getUserWithUsername(String username) {
        String sql = "SELECT * FROM users WHERE username='" + username + "';";
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            if (result.next()){
                return new User(result.getInt("id"),result.getString("username"));
            }
            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static List<Content> getMostRecent() {
        String sql = "SELECT * FROM content ORDER BY date DESC LIMIT 4";
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            List<Content> assets = new ArrayList<>();

            while (result.next()){
                assets.add(new Content(
                        result.getInt("id"),
                        result.getString("date"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("url"),
                        result.getInt("userid")

                ));
            }
            return assets;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }

    }
    public static List<Content> getContentOfUser(int userid) {
        String sql = "SELECT * FROM content WHERE userid=" + userid;
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            List<Content> assets = new ArrayList<>();

            while (result.next()){
                assets.add(new Content(
                        result.getInt("id"),
                        result.getString("date"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("url"),
                        result.getInt("userid")

                ));
            }
            return assets;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }

    }

    public static List<Content> getAllContents() {
        String sql = "SELECT * FROM content";
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            List<Content> assets = new ArrayList<>();

            while (result.next()){
                assets.add(new Content(
                        result.getInt("id"),
                        result.getString("date"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("url"),
                        result.getInt("userid")

                ));
            }
            return assets;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }

    }
    public static void addContent(int userId, String title,String description,String url) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String sql = "INSERT INTO content(userid, date, title, description, url) VALUES (" + userId + ",'" + date.toString() +"','" + title + "','" + description + "','" + url + "')";
        PreparedStatement stmt = null;
        try {
            stmt = Manager.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void deleteContent(int id, int userId) {
        String sql = "DELETE FROM content WHERE id=" + id + " AND userid=" + userId;
        PreparedStatement stmt = null;
        try {
            stmt = Manager.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
