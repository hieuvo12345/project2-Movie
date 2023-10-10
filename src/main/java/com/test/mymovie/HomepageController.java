package com.test.mymovie;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomepageController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_booking;

    @FXML
    private Button btn_customer;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_movie;

    @FXML
    private Button btn_room;

    @FXML
    private Button btn_schedule;

    @FXML
    private BorderPane main;

    @FXML
    private Label page_title;

    @FXML
    private BorderPane view;

    @FXML
    void btn_home(MouseEvent event) {
        Pane pane1 = getPage("homepage1");
        view.setCenter(pane1);
        page_title.setText("Movie Manager");
    }

    @FXML
    void btn_booking(MouseEvent event) {
        Pane pane1 = getPage("booking");
        view.setCenter(pane1);

        page_title.setText("Booking Page");
    }

    @FXML
    void btn_customer(MouseEvent event) {
        Pane pane1 = getPage("customer");
        view.setCenter(pane1);

        page_title.setText("User Information");
    }

    @FXML
    void btn_logout(MouseEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    void btn_movie(MouseEvent event) {
        Pane pane1 = getPage("movie");
        view.setCenter(pane1);

        page_title.setText("Movie Ticket Manager");
    }

    @FXML
    void btn_room(MouseEvent event) {
        Pane pane1 = getPage("room");
        view.setCenter(pane1);

        page_title.setText("Room Information");
    }

    @FXML
    void btn_schedule(MouseEvent event) {
        Pane pane1 = getPage("Schedule_user");
        view.setCenter(pane1);

        page_title.setText("Movie Schedule");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane pane1 = getPage("homepage1");
        view.setCenter(pane1);

        page_title.setText("Movie Manager");
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
