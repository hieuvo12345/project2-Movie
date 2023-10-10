/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thu Huyen
 */
public class BookingModel {
    int id;
    int customer_id;
    int schedule_id;
    int seat_id;

    public BookingModel() {
    }

    public BookingModel(int id, int customer_id, int schedule_id, int seat_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.schedule_id = schedule_id;
        this.seat_id = seat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }
    public void ReadRecord(ResultSet resultSet){
        try {
            this.id = resultSet.getInt("id");
            this.customer_id = resultSet.getInt("customer_id");
            this.schedule_id = resultSet.getInt("schedule_id");
            this.seat_id = resultSet.getInt("seat_id");
        } catch (SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
