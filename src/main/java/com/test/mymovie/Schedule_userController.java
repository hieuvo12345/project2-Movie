package com.test.mymovie;

import MovieCRUD.BookingCRUD;
import MovieCRUD.MovieCRUD;
import MovieCRUD.RoomCRUD;
import MovieCRUD.ScheduleCRUD;
import MovieModel.BookingModel;
import MovieModel.MovieModel;
import MovieModel.RoomModel;
import MovieModel.ScheduleInfoModel;
import MovieModel.ScheduleModel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Schedule_userController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> txtmovie;

    @FXML
    private ComboBox<String> txtroom;

    @FXML
    private DatePicker txtschedule;
    
    @FXML
    private BorderPane mainPane;

    @FXML
    void btn_clear(MouseEvent event) {
        Reset();
    }
    
    public void Reset() {
        txtschedule.setValue(null);
        txtmovie.setValue(null);
        txtroom.setValue(null);
        Pane view = getPage("schedule_table");
        mainPane.setCenter(view);
    }

    @FXML
    void btn_delete(MouseEvent event) {
        if(scheduleInfo != null) {
            List<BookingModel> bookingList = BookingCRUD.getListByScheduleId(scheduleInfo.getSchedule().get_Id());
            for (BookingModel bookingModel : bookingList) {
                BookingCRUD.delete(bookingModel.getId());
            }
            ScheduleCRUD.delete(scheduleInfo.getSchedule().get_Id());
        }
       
        Reset();
    }

    @FXML
    void btn_save(MouseEvent event) {
        ScheduleModel schedule = new ScheduleModel(
                0, 
                txtschedule.getValue().getYear() + "-" + txtschedule.getValue().getMonthValue() + "-" + txtschedule.getValue().getDayOfMonth(), 
                MovieCRUD.getListByName(txtmovie.getValue()).get_Id(), 
                RoomCRUD.getListByName(txtroom.getValue()).get_Id()
        );
        ScheduleCRUD.add(schedule);
        Reset();
    }

    @FXML
    void btn_update(MouseEvent event) {
         ScheduleModel schedule = new ScheduleModel(
                scheduleInfo.getSchedule().get_Id(), 
                txtschedule.getValue().getYear() + "-" + txtschedule.getValue().getMonthValue() + "-" + txtschedule.getValue().getDayOfMonth(), 
                MovieCRUD.getListByName(txtmovie.getValue()).get_Id(), 
                RoomCRUD.getListByName(txtroom.getValue()).get_Id()
        );
        ScheduleCRUD.update(schedule);
        Reset();
        
    }
    static ScheduleInfoModel scheduleInfo;
    static DatePicker txtschedule_static;
    static ComboBox<String> txtmovie_static;
    static ComboBox<String> txtroom_static;
    
    void initialize() {
    }
    static boolean isCheck = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isCheck = true;
        Pane view = getPage("schedule_table");
        mainPane.setCenter(view);
        
        List<MovieModel> movieList = MovieCRUD.getList();
        for (MovieModel movieModel : movieList) {
            txtmovie.getItems().add(movieModel.get_Title());
        }
        
        List<RoomModel> roomList = RoomCRUD.getList();
        for (RoomModel roomModel : roomList) {
            txtroom.getItems().add(roomModel.get_RoomName());
        }
        txtmovie_static = txtmovie;
        txtroom_static = txtroom;
        txtschedule_static = txtschedule;
    }

    public Pane pane;

    public Pane getPage(String page) {
        try {
            URL url = App.class.getResource(page + ".fxml");
            if (url == null) {
                throw new java.io.FileNotFoundException("fxml can't befound");
                
            }
            pane = FXMLLoader.load(url);

        } catch (IOException e) {
            System.out.println("not page" + page + "please check fxml loader");
        }
        return pane;
    }
}
