package controller;

import db.Manager;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfilesController {
    public static User getUserWithUsername(String username) {
        String sql = "SELECT * FROM profiles WHERE username='" + username + "';";
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            if (result.next()){
                User user = new User();
                user.setUsername(result.getString("username"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPicture(result.getString("picture"));
                user.setAge(result.getInt("age"));
                user.setHometown(result.getString("hometown"));
                return user;
            }
            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static List<User> search(String name, String email, int age, String hometown){
        if (hometown.equals(""))
            hometown = "_";
        if (email.equals(""))
            email = "_";
        if (name.equals(""))
            name = "_";
        String sql = "SELECT * FROM profiles WHERE name LIKE '%" + name + "%' OR email LIKE '%" + email + "%' OR AGE=" + age + " OR hometown LIKE '%" + hometown + "%'";
        try {
            PreparedStatement stmt = Manager.getConnection().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            List<User> users = new ArrayList<>();
            if (result.next()){
                User user = new User();
                user.setUsername(result.getString("username"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPicture(result.getString("picture"));
                user.setAge(result.getInt("age"));
                user.setHometown(result.getString("hometown"));
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }
}
