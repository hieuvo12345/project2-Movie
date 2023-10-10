/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HieuPC
 */
public class CustomerModel {
    IntegerProperty id;
    StringProperty fullName;
    StringProperty phoneNumber;
    StringProperty createDate;
    IntegerProperty point;

    public CustomerModel() {
    }


    public CustomerModel(int id, String fullName, String phoneNumber, String createDate, int point) {
        this.id = new SimpleIntegerProperty(id);
        this.fullName = new SimpleStringProperty(fullName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.createDate = new SimpleStringProperty(createDate);
        this.point = new SimpleIntegerProperty(point);
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

    public StringProperty getFullName() {
        return fullName;
    }
    
    public String get_FullName() {
        return fullName.get();
    }

    public void setFullName(StringProperty fullName) {
        this.fullName = fullName;
    }

    public StringProperty getPhoneNumber() {
        return phoneNumber;
    }
    
    public String get_PhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(StringProperty phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String get_CreateDate() {
        return createDate.get();
    }
    
    public StringProperty getCreateDate() {
        return createDate;
    }

    public void setCreateDate(StringProperty createDate) {
        this.createDate = createDate;
    }

    public IntegerProperty getPoint() {
        return point;
    }
    
    public int get_Point() {
        return point.get();
    }

    public void setPoint(IntegerProperty point) {
        this.point = point;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.fullName = new SimpleStringProperty(resultSet.getString("fullname"));
            this.phoneNumber = new SimpleStringProperty(resultSet.getString("phone_number"));
            this.createDate = new SimpleStringProperty(resultSet.getString("create_date"));
            this.point = new SimpleIntegerProperty(resultSet.getInt("point"));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
