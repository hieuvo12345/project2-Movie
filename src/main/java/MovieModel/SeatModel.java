/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Thu Huyen
 */
public class SeatModel {
    int id;
    String seat_row;
    int seat_colum;
    int ticket_type;
    StringProperty seat_code;

    public SeatModel() {
    }

    
    public SeatModel(int id, String seat_row, int seat_colum, int ticket_type, String seat_code) {
        this.id = id;
        this.seat_row = seat_row;
        this.seat_colum = seat_colum;
        this.ticket_type = ticket_type;
        this.seat_code = new SimpleStringProperty(seat_code) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(String seat_row) {
        this.seat_row = seat_row;
    }

    public int getSeat_colum() {
        return seat_colum;
    }

    public void setSeat_colum(int seat_colum) {
        this.seat_colum = seat_colum;
    }

    public int getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(int ticket_type) {
        this.ticket_type = ticket_type;
    }

    public StringProperty getSeat_code() {
        return seat_code;
        
    }
     public String get_Seat_code() {
        return seat_code.get();
        
    }

    public void setSeat_code(String seat_code) {
        this.seat_code = new SimpleStringProperty(seat_code) ;       
        
    }
    
    public void ReadRecord(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.seat_row = resultSet.getString("seat_row");
            this.seat_colum = resultSet.getInt("seat_colum");
            this.ticket_type = resultSet.getInt("ticket_type");
            this.seat_code = new SimpleStringProperty( resultSet.getString("seat_code"));
            
        } catch (SQLException ex) {
            Logger.getLogger(SeatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
