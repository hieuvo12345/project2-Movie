/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.test.mymovie;

import MovieCRUD.SeatCRUD;
import MovieModel.SeatModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class 
 *
 * @author Thu Huyen
 */
public class SeatController implements Initializable {

    @FXML
    private Label seat_name;
    
    @FXML
    private void choose_seat(MouseEvent event) {
        seat = SeatCRUD.findBySeat_code(seat_name.getText());
       
        Movie_seatController.seat = seat;
    }
    
     static SeatModel seat;
     static String name_seat;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      seat_name.setText(name_seat);
    }    
    
}
