package authentication;

import db.Manager;

import java.sql.*;

public class CredentialsManager {
    public static String authenticate(String username, String password) {
        ResultSet rs;
        String result = "error";
        Manager.connect();
        Connection con = Manager.getConnection();
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from users where username='"+username+"' and password='"+ password +"'");
            if (rs.next()) {
                result = "success";
            }
            rs.close();
            Manager.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
