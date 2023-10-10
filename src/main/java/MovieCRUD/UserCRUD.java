/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thu Huyen
 */
public class UserCRUD extends BaseCRUD {

    public static boolean login(String name, String password) {
        Connect();
        UserModel user = null;
        String sql = "select * from users where username=? and password=?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                user = new UserModel();
                user.ReadRecord(set);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        if (user != null) {
            return true;
        }
        return false;
    }
}
