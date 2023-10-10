/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.BookingInfoModel;
import MovieModel.BookingModel;
import MovieModel.CustomerModel;
import MovieModel.ScheduleInfoModel;
import MovieModel.SeatModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuPC
 */
public class BookingInfoCRUD extends BaseCRUD{
    public static List<BookingInfoModel> getList(){
        List<BookingInfoModel> bookingInfoList = new ArrayList<>();
        
        List<BookingModel> bookingList = BookingCRUD.getList();
        
        for (BookingModel bookingModel : bookingList) {
            CustomerModel customer = CustomerCRUD.findById(bookingModel.getCustomer_id());
            ScheduleInfoModel schedule = ScheduleInfoCRUD.getListBySchedule_id(bookingModel.getSchedule_id());
            SeatModel seat = SeatCRUD.findById(bookingModel.getSeat_id());
            BookingInfoModel bookingInfo = new BookingInfoModel(customer, schedule, seat, bookingModel);
            
                    
            bookingInfoList.add(bookingInfo);
        }
        return bookingInfoList;
    }
    
}
