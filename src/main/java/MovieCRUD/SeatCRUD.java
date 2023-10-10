/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.SeatModel;
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
public class SeatCRUD extends BaseCRUD{
    public static List<SeatModel> getList() {
        Connect();
        
        List<SeatModel> seatlist = new ArrayList<>();
        
        String sql = "select * from seat order by seat_row,seat_colum";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                SeatModel seat = new SeatModel();
                seat.ReadRecord(set);
                seatlist.add(seat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeatCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Disconnect();
        return seatlist;
        
    }
    static SeatModel seat;
    public static SeatModel findById(int id) {
        Connect();
        seat = new SeatModel();
        
        String sql = "select * from seat where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                seat.ReadRecord(set);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeatCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Disconnect();
        return seat;
        
    }
     public static SeatModel findBySeat_code(String seat_code) {
        Connect();
        seat = new SeatModel();
        
        String sql = "select * from seat where seat_code = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, seat_code);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                seat.ReadRecord(set);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeatCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Disconnect();
        return seat;
        
    }
}
