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
 * @author Thu Huyen
 */
public class ScheduleModel {

    IntegerProperty id;
    StringProperty schedule_date;
    IntegerProperty movie_id;
    IntegerProperty room_id;

    public ScheduleModel() {
    }

    public ScheduleModel(int id, String schedule_date, int movie_id, int room_id) {
        this.id = new SimpleIntegerProperty(id);
        this.schedule_date = new SimpleStringProperty(schedule_date);
        this.movie_id = new SimpleIntegerProperty(movie_id);
        this.room_id = new SimpleIntegerProperty(room_id);
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

    public StringProperty getSchedule_date() {
        return schedule_date;
    }

    public String get_Schedule_date() {
        return schedule_date.get();
    }

    public void setSchedule_date(StringProperty schedule_date) {
        this.schedule_date = schedule_date;
    }

    public IntegerProperty getMovie() {
        return movie_id;
    }

    public int get_Movie() {
        return movie_id.get();
    }

    public void setMovie(IntegerProperty movie_id) {
        this.movie_id = movie_id;
    }

    public IntegerProperty getRoom() {
        return room_id;
    }

    public int get_Room() {
        return room_id.get();
    }

    public void setRoom(IntegerProperty room_id) {
        this.room_id = room_id;
    }

    public void ReadRecord(ResultSet resultSet) {
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.schedule_date = new SimpleStringProperty(resultSet.getString("schedule_date"));
            this.movie_id = new SimpleIntegerProperty(resultSet.getInt("movie_id"));
            this.room_id = new SimpleIntegerProperty(resultSet.getInt("room_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
