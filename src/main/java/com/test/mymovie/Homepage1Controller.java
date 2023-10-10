/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.test.mymovie;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thu Huyen
 */
public class Homepage1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private BorderPane main_form;

    public void slider() {
        new Thread() {

            public void run() {

                int count = 0;

                try {

                    while (true) {
                        switch (count) {
                            case 0: {
                                Thread.sleep(5000);

                                TranslateTransition slider1 = new TranslateTransition();
                                sliderr(slider1, img1, 0);

                                TranslateTransition slider2 = new TranslateTransition();
                                sliderr(slider2, img2, 0);

                                TranslateTransition slider3 = new TranslateTransition();
                                sliderr(slider3, img3, -477);

                                TranslateTransition slider4 = new TranslateTransition();
                                sliderr(slider4, img4, -954);

                                TranslateTransition slider5 = new TranslateTransition();
                                sliderr(slider5, img5, -1431);

                                TranslateTransition slider6 = new TranslateTransition();
                                sliderr(slider6, img6, -1908);

                                count = 1;
                                break;

                            }
                            case 1:
                                Thread.sleep(5000);

                                TranslateTransition slider7 = new TranslateTransition();
                                sliderr(slider7, img1, 477);

                                TranslateTransition slider8 = new TranslateTransition();
                                sliderr(slider8, img2, 477);

                                TranslateTransition slider9 = new TranslateTransition();
                                sliderr(slider9, img3, 0);

                                TranslateTransition slider10 = new TranslateTransition();
                                sliderr(slider10, img4, -477);

                                TranslateTransition slider11 = new TranslateTransition();
                                sliderr(slider11, img5, -954);

                                TranslateTransition slider12 = new TranslateTransition();
                                sliderr(slider12, img6, -1431);

                                count = 2;
                                break;

                            case 2:
                                Thread.sleep(5000);

                                TranslateTransition slider13 = new TranslateTransition();
                                sliderr(slider13, img1, 954);

                                TranslateTransition slider14 = new TranslateTransition();
                                sliderr(slider14, img2, 954);

                                TranslateTransition slider15 = new TranslateTransition();
                                sliderr(slider15, img3, 477);

                                TranslateTransition slider16 = new TranslateTransition();
                                sliderr(slider16, img4, 0);

                                TranslateTransition slider17 = new TranslateTransition();
                                sliderr(slider17, img5, -477);

                                TranslateTransition slider18 = new TranslateTransition();
                                sliderr(slider18, img6, -954);

                                count = 3;
                                break;

                            case 3:
                                Thread.sleep(5000);

                                TranslateTransition slider19 = new TranslateTransition();
                                sliderr(slider19, img1, 1431);

                                TranslateTransition slider20 = new TranslateTransition();
                                sliderr(slider20, img2, 1431);

                                TranslateTransition slider21 = new TranslateTransition();
                                sliderr(slider21, img3, 954);

                                TranslateTransition slider22 = new TranslateTransition();
                                sliderr(slider22, img4, 477);

                                TranslateTransition slider23 = new TranslateTransition();
                                sliderr(slider23, img5, 0);

                                TranslateTransition slider24 = new TranslateTransition();
                                sliderr(slider24, img6, -477);

                                count = 4;
                                break;
                            case 4:
                                Thread.sleep(5000);

                                TranslateTransition slider25 = new TranslateTransition();
                                sliderr(slider25, img1, 1908);

                                TranslateTransition slider26 = new TranslateTransition();
                                sliderr(slider26, img2, 1908);

                                TranslateTransition slider27 = new TranslateTransition();
                                sliderr(slider27, img3, 1431);

                                TranslateTransition slider28 = new TranslateTransition();
                                sliderr(slider28, img4, 954);

                                TranslateTransition slider29 = new TranslateTransition();
                                sliderr(slider29, img5, 477);

                                TranslateTransition slider30 = new TranslateTransition();
                                sliderr(slider30, img6, 0);

                                count = 5;
                                break;
                            case 5:
                                Thread.sleep(5000);

                                TranslateTransition slider31 = new TranslateTransition();
                                sliderr(slider31, img1, 1908);

                                TranslateTransition slider32 = new TranslateTransition();
                                sliderr(slider32, img2, 1908);

                                TranslateTransition slider33 = new TranslateTransition();
                                sliderr(slider33, img3, 1908);

                                TranslateTransition slider34 = new TranslateTransition();
                                sliderr(slider34, img4, 1431);

                                TranslateTransition slider35 = new TranslateTransition();
                                sliderr(slider35, img5, 954);

                                TranslateTransition slider36 = new TranslateTransition();
                                sliderr(slider36, img6, 477);

                                count = 0;
                                break;
                            
                        }

                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Homepage1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }.start();
    }

    public void sliderr(TranslateTransition t, ImageView img, double x) {
        t.setNode(img);
        t.setDuration(Duration.seconds(3));//3s img
        t.setToX(x);
        t.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        slider();
    }

}
