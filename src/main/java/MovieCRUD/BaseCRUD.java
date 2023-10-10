/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thu Huyen
 */
public class BaseCRUD {

    static Connection conn = null;
    static PreparedStatement statement = null;

    public static void Connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mymovie", "root", "12345678");
        } catch (SQLException ex) {
            Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
