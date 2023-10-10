/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.test.mymovie;

import MovieCRUD.UserCRUD;
import com.test.mymovie.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Thu Huyen
 */
public class LoginController  {

  @FXML
    private URL location;
  
   @FXML
    private Label error;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_username;

   @FXML
    void btn_login(MouseEvent event) throws IOException {
        if (txt_username.getText().isBlank() == false && txt_password.getText().isBlank() == false) {
            if (UserCRUD.login(txt_username.getText(), txt_password.getText()) == true) {
                App.setRoot("homepage");
            }else{
                error.setText("Username or password incorrect!!!");
            }
        }else{
            error.setText("Please enter completely information!!!");
        }
    }

    /**
     * Initializes the controller class.
     */
     
    
}
