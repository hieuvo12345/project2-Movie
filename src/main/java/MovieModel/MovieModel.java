/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Thu Huyen
 */
public class MovieModel {
    IntegerProperty id;
    StringProperty title;
    StringProperty director;
    StringProperty release;
    StringProperty thumbnail;
    StringProperty genres;
    StringProperty cast;
    FloatProperty   price;
   

    public MovieModel() {
    }

    public MovieModel(int id, String title, String director, String release, String thumbnail, String genres, String cast, float price) {
        this.id = new SimpleIntegerProperty(id) ;
        this.title =new SimpleStringProperty(title) ;
        this.director =new SimpleStringProperty(director) ;
        this.release = new SimpleStringProperty(release) ;
        this.thumbnail = new SimpleStringProperty(thumbnail) ;
        this.genres =new SimpleStringProperty( genres);
        this.cast = new SimpleStringProperty(cast) ;
        this.price = new SimpleFloatProperty(price) ;
    }

    public IntegerProperty getId() {
        return id;
    }
    
    public int get_Id() {
        return id.get();
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getTitle() {
        return title;
    }
    
    public String get_Title() {
        return title.get();
    }
    
    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getDirector() {
        return director;
    }
    
     public String get_Director() {
        return director.get();
    }

    public void setDirector(StringProperty director) {
        this.director = director;
    }

    public StringProperty getRelelase() {
        return release;
    }
    
     public String get_Relelase() {
        return release.get();
    }
    
    public void setRelelase(StringProperty relelase) {
        this.release = relelase;
    }

    public StringProperty getThumbnail() {
        return thumbnail;
    }
    
    public String get_Thumbnail() {
        return thumbnail.get();
    }

    public void setThumbnail(StringProperty thumbnail) {
        this.thumbnail = thumbnail;
    }

    public StringProperty getGenres() {
        return genres;
    }
    
    public String get_Genres() {
        return genres.get();
    }

    public void setGenres(StringProperty genres) {
        this.genres = genres;
    }

    public StringProperty getCast() {
        return cast;
    }
    
     public String get_Cast() {
        return cast.get();
    }

    public void setCast(StringProperty cast) {
        this.cast = cast;
    }

    public FloatProperty getPrice() {
        return price;
    }
    
     public Float get_Price() {
        return price.get();
    }

    public void setPrice(FloatProperty price) {
        this.price = price;
    }
    
    public void ReadRecord(ResultSet resultSet) {
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.title = new SimpleStringProperty(resultSet.getString("title"));
            this.director = new SimpleStringProperty(resultSet.getString("director"));
            this.release = new SimpleStringProperty(resultSet.getString("release_date"));
            this.thumbnail = new SimpleStringProperty(resultSet.getString("thumbnail"));
            this.genres = new SimpleStringProperty(resultSet.getString("genres"));
            this.cast = new SimpleStringProperty(resultSet.getString("cast"));
            this.price = new SimpleFloatProperty(resultSet.getFloat("price"));
        } catch (SQLException ex) {
            Logger.getLogger(MovieModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
