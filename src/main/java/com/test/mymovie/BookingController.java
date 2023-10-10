package com.test.mymovie;

import MovieCRUD.BookingCRUD;
import MovieCRUD.BookingInfoCRUD;
import MovieCRUD.CustomerCRUD;
import MovieCRUD.ScheduleCRUD;
import MovieCRUD.ScheduleInfoCRUD;
import MovieCRUD.SeatCRUD;
import MovieModel.BookingInfoModel;
import MovieModel.BookingModel;
import MovieModel.CustomerModel;
import MovieModel.ScheduleInfoModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BookingController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> id_customer;

    @FXML
    private TextField id_schedule;

    @FXML
    private TextField id_seat;

    @FXML
    private TableView<BookingInfoModel> tbl_booking;

    @FXML
    private TableColumn<BookingInfoModel, String> tbl_customer;

    @FXML
    private TableColumn<BookingController, String> tbl_no;

    @FXML
    private TableColumn<BookingInfoModel, String> tbl_schedule;

    @FXML
    private TableColumn<BookingInfoModel, String> tbl_seat;

    @FXML
    void btn_clear(MouseEvent event) {
        reset();
    }

    void reset() {
        id_customer.setValue(null);
        id_schedule.setText(null);
        id_seat.setText(null);
    }
    static TextField id_seat_static;
    static TextField id_schedule_static;
    static BookingModel booking1;

    @FXML
    void btn_delete(MouseEvent event) {
        if(booking != null) {
            BookingCRUD.delete(booking.getBooking().getId());
        }
        initialize();
        reset();
    }
    @FXML
    void btn_update(MouseEvent event) {
         booking1 = new BookingModel (
                booking.getBooking().getId(),
                CustomerCRUD.findByName(id_customer.getValue()).get_Id(),
                scheduleInfo != null ? scheduleInfo.getSchedule().get_Id() : booking.getScheduleinfo().getSchedule().get_Id(),
                SeatCRUD.findBySeat_code(id_seat.getText()) != null ? SeatCRUD.findBySeat_code(id_seat.getText()).getId() : booking.getSeat().getId()
        );
        BookingCRUD.update(booking1);
        initialize();
        reset();
    }

    @FXML
    void btn_save(MouseEvent event) { 
        booking1 = new BookingModel (
                0,
                CustomerCRUD.findByName(id_customer.getValue()).get_Id(),
                scheduleInfo.getSchedule().get_Id(),
                SeatCRUD.findBySeat_code(id_seat.getText()).getId()
        );
        BookingCRUD.insert(booking1);
        initialize();
        reset();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fXMLLoader.load();

    }
    static Stage stage;
    static ScheduleInfoModel scheduleInfo;

    static boolean isCheck = false;

    @FXML
    void btn_schedule(MouseEvent event) throws IOException {
        isCheck = true;
        stage = new Stage();
        Scene scene = new Scene(loadFXML("schedule_table"), 600, 400);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void btn_seat(MouseEvent event) throws IOException {
        stage = new Stage();
        Scene scene = new Scene(loadFXML("movie_seat"));
        stage.setScene(scene);
        stage.show();
    }
    static BookingInfoModel booking;

    @FXML
    void tbl_display(MouseEvent event) {
        booking = tbl_booking.getSelectionModel().getSelectedItem();
        if (booking != null) {
            id_customer.setValue(booking.getCustomer().get_FullName());
            //     id_schedule.setText(booking.getCustomer().get_FullName() + "," + booking.getScheduleinfo().getSchedule().get_Schedule_date() + "," + booking.getScheduleinfo().getRoom().get_RoomName());
            id_schedule.setText(booking.getScheduleinfo().getSchedule().get_Schedule_date() + "," + booking.getCustomer().get_FullName() + "," + booking.getScheduleinfo().getRoom().get_RoomName());
            id_seat.setText(booking.getSeat().get_Seat_code());
        }
    }

    @FXML
    void initialize() {
        tbl_no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookingController, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookingController, String> p) {
                return new ReadOnlyObjectWrapper(tbl_booking.getItems().indexOf(p.getValue()) + 1);
            }
        });
        tbl_customer.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookingInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookingInfoModel, String> p) {
                return p.getValue().getCustomer().getFullName();
            }
        });
        tbl_schedule.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookingInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookingInfoModel, String> p) {
                return new SimpleStringProperty("Movie name :" + p.getValue().getScheduleinfo().getMovie().get_Title() + ",Schedule :" + p.getValue().getScheduleinfo().getSchedule().get_Schedule_date() + ",Room name :" + p.getValue().getScheduleinfo().getRoom().get_RoomName());
            }
        });
        tbl_seat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookingInfoModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookingInfoModel, String> p) {
                return p.getValue().getSeat().getSeat_code();
            }
        });
        bookingList = BookingInfoCRUD.getList();
        ObservableList<BookingInfoModel> dataList = FXCollections.observableArrayList(bookingList);
        tbl_booking.setItems(dataList);

    }
    static List<BookingInfoModel> bookingList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
        List<CustomerModel> customerList = CustomerCRUD.getList();
        for (CustomerModel customerModel : customerList) {
            id_customer.getItems().add(customerModel.get_FullName());
        }

        id_seat_static = id_seat;
        id_schedule_static = id_schedule;
    }

}
