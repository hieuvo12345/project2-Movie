package com.test.mymovie;

import MovieCRUD.BookingCRUD;
import MovieCRUD.MovieCRUD;
import MovieCRUD.ScheduleCRUD;
import MovieModel.BookingModel;
import MovieModel.MovieModel;
import MovieModel.ScheduleModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MovieController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_import;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_update;

    @FXML
    private TableColumn<MovieModel, String> table_cast;

    @FXML
    private TableColumn<MovieModel, String> table_director;

    @FXML
    private TableColumn<MovieModel, String> table_genres;

    @FXML
    private TableColumn<MovieModel, String> table_no;

    @FXML
    private TableColumn<MovieModel, String> table_release;

    @FXML
    private TableColumn<MovieModel, String> table_title;

    @FXML
    private TableColumn<MovieModel, String> tbl_price;

    @FXML
    private TextField txtcast;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtdirector;

    @FXML
    private TextField txtgenres;

    @FXML
    private ImageView txtimg;

    @FXML
    private TableView<MovieModel> txtmovie;

    @FXML
    private DatePicker txtrelease;

    @FXML
    private TextField txttitle;

   
    @FXML
    void import_img(MouseEvent event) {
        FileChooser img = new FileChooser(); // đến cái chỗ đựng ảnh
        File file = img.showOpenDialog(new Stage()); // chọn ảnh
        img_name = file.getPath(); // đường dẫn
        img_name = getImg(img_name); // tên ảnh
        txtimg.setImage(new Image(App.class.getResourceAsStream("/img/" + img_name)));
//        try {
//            txtimg.setImage(new Image(new FileInputStream(img_name)));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         Dùng khi lưu cả đường dẫn ảnh vào database
    }
    
    static String img_name;
   
    @FXML
    void clear(MouseEvent event) {
        Reset();
    }

    @FXML
    void delete(MouseEvent event) {
        if(movie != null) {
            List<ScheduleModel> scheduleList = ScheduleCRUD.getListByMovieId(movie.get_Id());
            for (ScheduleModel scheduleModel : scheduleList) {
                List<BookingModel> bookingList = BookingCRUD.getListByScheduleId(scheduleModel.get_Id());
                for (BookingModel bookingModel : bookingList) {
                    BookingCRUD.delete(bookingModel.getId());
                }
                ScheduleCRUD.delete(scheduleModel.get_Id());
            }
            MovieCRUD.delete(movie.get_Id());
        }
        initialize();
        Reset();
    }
    
    static MovieModel movie;
    @FXML
    void table_movie(MouseEvent event) {
        movie = txtmovie.getSelectionModel().getSelectedItem();
        if(movie != null) {
            txttitle.setText(movie.get_Title());
            txtcast.setText(movie.get_Cast());
            txtdirector.setText(movie.get_Director());
            txtgenres.setText(movie.get_Genres());
            txtprice.setText(movie.get_Price()+"");
            txtrelease.setValue(LocalDate.parse(movie.get_Relelase()));
            txtimg.setImage(new Image( App.class.getResourceAsStream("/img/" + movie.get_Thumbnail())));
            img_name = movie.get_Thumbnail();
        }
    }

    public void Reset() {
        txttitle.setText(null);
        txtcast.setText(null);
        txtdirector.setText(null);
        txtgenres.setText(null);
        txtprice.setText(null);
        txtrelease.setValue(null);
        txtimg.setImage(null);
        img_name = null;
    }
    
     @FXML
    void add(MouseEvent event) {
        movie = new MovieModel(
                0, 
                txttitle.getText(), 
                txtdirector.getText(), 
                txtrelease.getValue().getYear() + "-" + txtrelease.getValue().getMonthValue() + "-" + txtrelease.getValue().getDayOfMonth(), 
                img_name != null ? img_name : "", 
                txtgenres.getText(), 
                txtcast.getText(), 
                Float.parseFloat(txtprice.getText()));
        
        MovieCRUD.add(movie);
        Reset();
        initialize();
    }
    
    @FXML
    void update(MouseEvent event) {
        movie = new MovieModel(
                movie.get_Id(),
                txttitle.getText(), 
                txtdirector.getText(), 
                txtrelease.getValue().getYear()+"-"+ txtrelease.getValue().getMonthValue() + "-" + txtrelease.getValue().getDayOfMonth(), 
                img_name!=null?img_name:movie.get_Thumbnail(), 
                txtgenres.getText(), 
                txtcast.getText(), 
                Float.parseFloat(txtprice.getText())
                );
        MovieCRUD.update(movie);
        Reset();
        initialize();
         

    }
    
    String getImg(String img_name) {
        List<Integer> indexList = new ArrayList<>();
        if(img_name != null && !img_name.equalsIgnoreCase("")) {
            int index = 0;
            while (true) {                
                index = img_name.indexOf("\\",index + 1);
                if(index < 0) {
                    break;
                }
                indexList.add(index);
            }
            img_name = img_name.substring(indexList.get(indexList.size()-1)+1);
        }
        return img_name;
    } 

    public void initialize() {
        table_no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return new ReadOnlyObjectWrapper(txtmovie.getItems().indexOf(p.getValue()) + 1);
            }
        });
        
        table_title.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return p.getValue().getTitle();
            }            
        });
        
        table_director.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return p.getValue().getDirector();
            }            
        });
        
        table_cast.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>()  {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return p.getValue().getCast();
            }           
        });
        
        table_genres.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return p.getValue().getGenres();
            }
            
        });
        
        tbl_price.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>() { 
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return new SimpleStringProperty(p.getValue().get_Price() + "");
            }
            
        });
        
        table_release.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MovieModel, String> p) {
                return p.getValue().getRelelase();
            }
           
        });
        movieList = MovieCRUD.getList();     
        ObservableList<MovieModel> dataList = FXCollections.observableArrayList( movieList);
        txtmovie.setItems(dataList);
    }
    static List<MovieModel> movieList;
}
