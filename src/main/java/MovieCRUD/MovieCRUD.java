/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.MovieModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;

/**
 *
 * @author Thu Huyen
 */
public class MovieCRUD extends BaseCRUD {
    
    public static List<MovieModel> getList() {
        Connect();
        
        List<MovieModel> movieList = new ArrayList<>();
        String sql = "select * from movie";
        
        try {
            statement = conn.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            
            while(set.next()) {
                MovieModel movie = new MovieModel();
                movie.ReadRecord(set);
                movieList.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return movieList;
    }
    static MovieModel movie;
    public static MovieModel getListById(int id) {
        Connect();
        
        movie = new MovieModel();
        String sql = "select * from movie where id = ?";
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            
            while(set.next()) {
                movie.ReadRecord(set);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return movie;
    }
    
     public static MovieModel getListByName(String name) {
        Connect();
        
        movie = new MovieModel();
        String sql = "select * from movie where title = ?";
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();
            
            while(set.next()) {
                movie.ReadRecord(set);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return movie;
    }
    
    public static void add(MovieModel movie) {
        Connect();
        
        String sql =" Insert into movie(title, director, release_date, thumbnail, genres, cast, price) values(?,?,?,?,?,?,?)";
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.get_Title());
            statement.setString(2, movie.get_Director());
            statement.setString(3, movie.get_Relelase());
            statement.setString(4, movie.get_Thumbnail());
            statement.setString(5, movie.get_Genres());
            statement.setString(6, movie.get_Cast());
            statement.setFloat(7, movie.get_Price());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        Disconnect();
        
    }
    
    public static void update(MovieModel movie) {
        Connect();
        
        String sql = "update movie set title=?, director=?, release_date=?, thumbnail=?, genres=?, cast=?, price=? where id=?";
        
        try {
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.get_Title());
            statement.setString(2, movie.get_Director());
            statement.setString(3, movie.get_Relelase());
            statement.setString(4, movie.get_Thumbnail());
            statement.setString(5, movie.get_Genres());
            statement.setString(6, movie.get_Cast());
            statement.setFloat(7, movie.get_Price());
            statement.setInt(8, movie.get_Id());
            statement.execute();
                        
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Disconnect();
    }
    
    public static void delete(int id) {
        Connect();
        
        String sql = "delete from movie where id=?";
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Disconnect();
    }
    
}
