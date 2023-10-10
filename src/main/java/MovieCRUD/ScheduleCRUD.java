/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.ScheduleModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thu Huyen
 */
public class ScheduleCRUD extends BaseCRUD {

    public static List<ScheduleModel> getList() {
        List<ScheduleModel> scheduleList = new ArrayList<>();
        Connect();

        String sql = "select * from schedule";

        try {
            statement = conn.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.ReadRecord(set);
                scheduleList.add(schedule);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        return scheduleList;
    }
    
    public static List<ScheduleModel> getListByRoomId(int id) {
        List<ScheduleModel> scheduleList = new ArrayList<>();
        Connect();

        String sql = "select * from schedule where room_id = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.ReadRecord(set);
                scheduleList.add(schedule);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        return scheduleList;
    }
    
     public static List<ScheduleModel> getListByMovieId(int id) {
        List<ScheduleModel> scheduleList = new ArrayList<>();
        Connect();

        String sql = "select * from schedule where movie_id = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.ReadRecord(set);
                scheduleList.add(schedule);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        return scheduleList;
    }

    public static void add(ScheduleModel schedule) {
        Connect();

        String sql = "insert into schedule(schedule_date, movie_id, room_id) values(?,?,?)";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, schedule.get_Schedule_date());
            statement.setInt(2, schedule.get_Movie());
            statement.setInt(3, schedule.get_Room());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
    }

    public static void update(ScheduleModel schedule) {
        Connect();

        String sql = "update  schedule set schedule_date=?, movie_id=?, room_id=? where id=?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, schedule.get_Schedule_date());
            statement.setInt(2, schedule.get_Movie());
            statement.setInt(3, schedule.get_Room());
            statement.setInt(4, schedule.get_Id());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
    }

    public static void delete(int id) {
        Connect();

        String sql = "delete from schedule where id=?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
    }
    static ScheduleModel schedule;
    public static ScheduleModel findById(int id) {
        schedule = new ScheduleModel();
        Connect();

        String sql = "select * from schedule where id = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {      
                schedule.ReadRecord(set);  
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        return schedule;
    }
    
   public static ScheduleModel findBySchedule(String schedule_date) {
        schedule = new ScheduleModel();
        Connect();

        String sql = "select * from schedule where schedule_date = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, schedule_date);
            ResultSet set = statement.executeQuery();
            while (set.next()) {      
                schedule.ReadRecord(set);  
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Disconnect();
        return schedule;
    }
}
