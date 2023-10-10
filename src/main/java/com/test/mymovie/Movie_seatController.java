package com.test.mymovie;

import MovieCRUD.SeatCRUD;
import MovieModel.SeatModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Movie_seatController implements Initializable{

    @FXML
    private BorderPane movie_seat;
    
    @FXML
    private void btn_ok(MouseEvent event) {
        if(seat != null) {
            BookingController.id_seat_static.setText(seat.get_Seat_code());
            BookingController.stage.close();
        }
    }
    static SeatModel seat;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        List<SeatModel> seatlist = SeatCRUD.getList();
        for (SeatModel seatModel : seatlist) {
            SeatController.name_seat = seatModel.get_Seat_code();
            hbox.getChildren().add(getPage("seat"));
            if(hbox.getChildren().size() == 10) {
                vbox.getChildren().add(hbox);
                hbox = new HBox();
                
            }
            
        }
        vbox.getChildren().add(hbox);
       
        movie_seat.setCenter(vbox);
    }
    public Pane paneView;    
    
    public Pane pane;
    
    public Pane getPage(String filename) {
        try {
            URL url = App.class.getResource(filename + ".fxml");
            if(url == null) {
                throw new java.io.FileNotFoundException();
            }
            
            pane = FXMLLoader.load(url);
            
        } catch (Exception e) {
        }
        return pane;
    }
}
