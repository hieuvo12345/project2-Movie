package com.test.mymovie;

import MovieCRUD.ScheduleInfoCRUD;
import MovieModel.ScheduleInfoModel;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class Schedule_tableController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ScheduleInfoModel, String> movie;

    @FXML
    private TableColumn<ScheduleInfoModel, String> no;

    @FXML
    private TableColumn<ScheduleInfoModel, String> room;

    @FXML
    private TableColumn<ScheduleInfoModel, String> schedule_date;

    @FXML
    private TableView<ScheduleInfoModel> tbl_schedule;

    static ScheduleInfoModel scheduleinfo;
    @FXML
    void display_selected_item(MouseEvent event) {
        scheduleinfo = tbl_schedule.getSelectionModel().getSelectedItem();
        if(Schedule_userController.isCheck==true && scheduleinfo!=null){
            Schedule_userController.txtschedule_static.setValue(LocalDate.parse(scheduleinfo.getSchedule().get_Schedule_date()));
            Schedule_userController.txtmovie_static.setValue(scheduleinfo.getMovie().get_Title());
            Schedule_userController.txtroom_static.setValue(scheduleinfo.getRoom().get_RoomName());
            Schedule_userController.scheduleInfo = scheduleinfo;
        }
        if(scheduleinfo != null && BookingController.isCheck == true) {
            BookingController.scheduleInfo = scheduleinfo;
            BookingController.id_schedule_static.setText(scheduleinfo.getSchedule().get_Schedule_date()+ ", " + scheduleinfo.getMovie().get_Title() + ", " + scheduleinfo.getRoom().get_RoomName());
            BookingController.stage.close();
        }
    }
    static boolean isCheck = false;

    static List<ScheduleInfoModel> scheduleInfoList;
    
    void initialize() {
        no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ScheduleInfoModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ScheduleInfoModel, String> p) {
                return new ReadOnlyObjectWrapper(tbl_schedule.getItems().indexOf(p.getValue())+1);
            }
            
        });
        schedule_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ScheduleInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ScheduleInfoModel, String> p) {
                return p.getValue().getSchedule().getSchedule_date();
            }
        });
        movie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ScheduleInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ScheduleInfoModel, String> p) {
                return p.getValue().getMovie().getTitle();
            }
            
        });
        room.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ScheduleInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ScheduleInfoModel, String> p) {
                return p.getValue().getRoom().getRoomName();
            }
            
        });
        scheduleInfoList = ScheduleInfoCRUD.getList();
        ObservableList<ScheduleInfoModel> dataList = FXCollections.observableArrayList(scheduleInfoList);
        tbl_schedule.setItems(dataList);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }

}
