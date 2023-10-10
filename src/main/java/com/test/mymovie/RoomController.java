package com.test.mymovie;


import MovieCRUD.BookingCRUD;
import MovieCRUD.RoomCRUD;
import MovieCRUD.ScheduleCRUD;
import MovieModel.BookingModel;
import MovieModel.RoomModel;
import MovieModel.ScheduleModel;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class RoomController implements Initializable{
    static RoomModel room;
    static List<RoomModel> roomList;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_room_name;
     
    @FXML
    private TableColumn<RoomModel, String> no;

    @FXML
    private TableColumn<RoomModel, String> room_name;

    @FXML
    private TableView<RoomModel> tbl_romm;

    @FXML
    void btn_add(MouseEvent event) {
        boolean check = false;
        room = new RoomModel(1, txt_room_name.getText());
        for (RoomModel roomModel : roomList) {
            if (roomModel.get_RoomName().equalsIgnoreCase(txt_room_name.getText())) {
                check = true;
                break;
            }
        }
        if (!check) {
            RoomCRUD.add(room);           
        }
        roomList = RoomCRUD.getList();
        clear();
        initialize();
    }

    @FXML
    void btn_clear(MouseEvent event) {
        clear();
    }
    void clear(){
        txt_room_name.setText(null);
    }
    @FXML
    void btn_delete(MouseEvent event) {
        if(room != null) {
            List<ScheduleModel> scheduleList = ScheduleCRUD.getListByRoomId(room.get_Id());
            for (ScheduleModel scheduleModel : scheduleList) {
                List<BookingModel> bookingList = BookingCRUD.getListByScheduleId(scheduleModel.get_Id());
                for (BookingModel bookingModel : bookingList) {
                    BookingCRUD.delete(bookingModel.getId());
                }
                ScheduleCRUD.delete(scheduleModel.get_Id());
            }
            RoomCRUD.delete(room.get_Id());            
        }
        initialize();
        clear();
    }

    @FXML
    void btn_update(MouseEvent event) {
        boolean check = false;
        room = new RoomModel(room.get_Id(),txt_room_name.getText());
        roomList = RoomCRUD.getList();
        for (RoomModel roomModel : roomList) {
            if (room.get_RoomName().equalsIgnoreCase(roomModel.get_RoomName()) && roomModel.get_Id() != room.get_Id()) {
                check = true;
            }
        }
        if (!check) {
            RoomCRUD.update(room);
            
        }
        roomList = RoomCRUD.getList();
        clear();
        initialize(); 
    }
    
    @FXML
    void display_selected_item(MouseEvent event) {
        room = tbl_romm.getSelectionModel().getSelectedItem();
        if (room != null) {
            txt_room_name.setText(room.get_RoomName());
        }
    }
    
    @FXML
    void initialize() {
        no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoomModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<RoomModel, String> p) {
                return new ReadOnlyObjectWrapper(tbl_romm.getItems().indexOf(p.getValue()) + 1);
            }
        });
        room_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoomModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<RoomModel, String> p) {
                return p.getValue().getRoomName();
            }
        });
         roomList = RoomCRUD.getList();
        ObservableList<RoomModel> roomOb = FXCollections.observableArrayList(roomList);
        tbl_romm.setItems(roomOb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        initialize();
    }

}
