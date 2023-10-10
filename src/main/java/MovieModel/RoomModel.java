/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HieuPC
 */
public class RoomModel {

    IntegerProperty id;
    StringProperty roomName;

    public RoomModel() {
    }

    public RoomModel(int id, String roomName) {
        this.id = new SimpleIntegerProperty(id);
        this.roomName = new SimpleStringProperty(roomName);
    }

    public IntegerProperty getId() {
        return id;
    }

    public int get_Id() {
        return id.get();
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getRoomName() {
        return roomName;
    }
    public String get_RoomName() {
        return roomName.get();
    }

    public void setRoomName(StringProperty roomName) {
        this.roomName = roomName;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.roomName = new SimpleStringProperty(resultSet.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(RoomModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
