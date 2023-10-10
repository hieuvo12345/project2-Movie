/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.MovieModel;
import MovieModel.RoomModel;
import MovieModel.ScheduleInfoModel;
import MovieModel.ScheduleModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thu Huyen
 */
public class ScheduleInfoCRUD {
    public static List<ScheduleInfoModel> getList(){
        List<ScheduleInfoModel> dataList = new ArrayList<>();
        List<ScheduleModel> scheduleList = ScheduleCRUD.getList();
        for (ScheduleModel scheduleModel : scheduleList) {
            MovieModel movie = MovieCRUD.getListById(scheduleModel.get_Movie());
            RoomModel room = RoomCRUD.getListById(scheduleModel.get_Room());
            ScheduleInfoModel scheduleInfoModel = new ScheduleInfoModel(scheduleModel, room, movie);
            dataList.add(scheduleInfoModel);
        }
        return dataList;
    }
    public static ScheduleInfoModel getListBySchedule_id(int id){
     
        ScheduleModel scheduleModel = ScheduleCRUD.findById(id);
            MovieModel movie = MovieCRUD.getListById(scheduleModel.get_Movie());
            RoomModel room = RoomCRUD.getListById(scheduleModel.get_Room());
            ScheduleInfoModel scheduleInfoModel = new ScheduleInfoModel(scheduleModel, room, movie); 
            
        return scheduleInfoModel;
    }
    
    public static ScheduleInfoModel getListBySchedule_chedule(String schedule){
     
        ScheduleModel scheduleModel = ScheduleCRUD.findBySchedule(schedule);
            MovieModel movie = MovieCRUD.getListById(scheduleModel.get_Movie());
            RoomModel room = RoomCRUD.getListById(scheduleModel.get_Room());
            ScheduleInfoModel scheduleInfoModel = new ScheduleInfoModel(scheduleModel, room, movie); 
            
        return scheduleInfoModel;
    }
}
