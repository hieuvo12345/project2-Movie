/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.BookingModel;
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
public class BookingCRUD extends BaseCRUD {

    static List<BookingModel> bookingList;

    public static List<BookingModel> getList() {
        Connect();
        bookingList = new ArrayList<>();
        String sql = "select * from booking";

        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                BookingModel booking = new BookingModel();
                booking.ReadRecord(result);
                bookingList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return bookingList;
    }
    
     public static List<BookingModel> getListByCustomerId( int id) {
        Connect();
        bookingList = new ArrayList<>();
        String sql = "select * from booking where customer_id = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                BookingModel booking = new BookingModel();
                booking.ReadRecord(result);
                bookingList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return bookingList;
    }
     
     public static List<BookingModel> getListByScheduleId( int id) {
        Connect();
        bookingList = new ArrayList<>();
        String sql = "select * from booking where schedule_id = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                BookingModel booking = new BookingModel();
                booking.ReadRecord(result);
                bookingList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return bookingList;
    }

    public static void insert(BookingModel bookingAdd) {
        Connect();
        String sql = "insert into booking(customer_id, schedule_id, seat_id) values (?,?,?)";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, bookingAdd.getCustomer_id());
            statement.setInt(2, bookingAdd.getSchedule_id());
            statement.setInt(3, bookingAdd.getSeat_id());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }

    public static void update(BookingModel bookingUpdate) {
        Connect();
        String sql = "update booking set customer_id = ?, schedule_id = ?,seat_id = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, bookingUpdate.getCustomer_id());
            statement.setInt(2, bookingUpdate.getSchedule_id());
            statement.setInt(3, bookingUpdate.getSeat_id());
            statement.setInt(4, bookingUpdate.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }

    public static void delete(int id) {
        Connect();
        String sql = "delete from booking where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
}
