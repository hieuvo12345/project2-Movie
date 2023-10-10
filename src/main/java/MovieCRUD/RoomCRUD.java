/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.RoomModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HieuPC
 */
public class RoomCRUD extends BaseCRUD {

    static List<RoomModel> roomList;

    public static List<RoomModel> getList() {
        
        roomList = new ArrayList<>();
        Connect();
        RoomModel room = null;
        String sql = "select * from room";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room = new RoomModel();
                room.readRecord(resultSet);
                roomList.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return roomList;
    }
    static RoomModel room;
    public static RoomModel getListById(int id) {
        Connect();
        room = new RoomModel();
        String sql = "select * from room where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room.readRecord(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return room;
    }
    
    public static RoomModel getListByName(String name) {
        Connect();
        room = new RoomModel();
        String sql = "select * from room where name = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room.readRecord(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return room;
    }

    public static void add(RoomModel roomAdd) {
        
        Connect();
        String sql = "insert into room (name) values (?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, roomAdd.get_RoomName());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }

    public static void update(RoomModel roomUpdate) {
        
        Connect();
        String sql = "update room set name = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, roomUpdate.get_RoomName());
            statement.setInt(2, roomUpdate.get_Id());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }

    public static void delete(int id) {
        
        Connect();
        String sql = "delete from room where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoomCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
}
