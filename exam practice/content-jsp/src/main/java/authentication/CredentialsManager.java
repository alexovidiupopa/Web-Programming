package authentication;

import db.Manager;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CredentialsManager {
    public static Pair<Integer, Integer> authenticate(String username, String password) {
        ResultSet rs;
        Pair<Integer,Integer> result = null;
        Manager.connect();
        Connection con = Manager.getConnection();
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select id, role from users where username='"+username+"' and password='"+ password +"'");
            if (rs.next()) {
                result = new Pair(rs.getInt("id"),rs.getInt("role"));
            }
            rs.close();
            Manager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
