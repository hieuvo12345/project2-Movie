/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

/**
 *
 * @author Thu Huyen
 */
public class ScheduleInfoModel {
    ScheduleModel schedule;
    RoomModel room;
    MovieModel movie;

    public ScheduleInfoModel(ScheduleModel schedule, RoomModel room, MovieModel movie) {
        this.schedule = schedule;
        this.room = room;
        this.movie = movie;
    }

    public ScheduleInfoModel() {
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }
    
    
            
}
