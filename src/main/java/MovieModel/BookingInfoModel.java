/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

/**
 *
 * @author HieuPC
 */
public class BookingInfoModel {
    CustomerModel customer;
    ScheduleInfoModel scheduleinfo;
    SeatModel seat;
    BookingModel booking;

    public BookingInfoModel() {
    }

    public BookingInfoModel(CustomerModel customer, ScheduleInfoModel scheduleinfo, SeatModel seat, BookingModel booking) {
        this.customer = customer;
        this.scheduleinfo = scheduleinfo;
        this.seat = seat;
        this.booking = booking;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public ScheduleInfoModel getScheduleinfo() {
        return scheduleinfo;
    }

    public void setScheduleinfo(ScheduleInfoModel scheduleinfo) {
        this.scheduleinfo = scheduleinfo;
    }

    public SeatModel getSeat() {
        return seat;
    }

    public void setSeat(SeatModel seat) {
        this.seat = seat;
    }

   
    
}
