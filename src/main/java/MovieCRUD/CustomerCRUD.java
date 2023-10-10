/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovieCRUD;

import MovieModel.CustomerModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HieuPC
 */
public class CustomerCRUD extends BaseCRUD {

    static List<CustomerModel> customerList;

    public static List<CustomerModel> getList() {
        customerList = new ArrayList<>();
        Connect();
        CustomerModel customer = null;
        String sql = "select * from customer";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new CustomerModel();
                customer.readRecord(resultSet);
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return customerList;
    }
    
    public static void add(CustomerModel customerAdd){
        Connect();
        String sql = "insert into customer(fullname,phone_number,create_date,point) values (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, customerAdd.get_FullName());
            statement.setString(2, customerAdd.get_PhoneNumber());
            statement.setString(3, customerAdd.get_CreateDate());
            statement.setInt(4, customerAdd.get_Point());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    public static void update(CustomerModel customerUpdate){
        Connect();
        String sql = "update customer set fullname = ?, phone_number = ?, create_date = ?, point = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, customerUpdate.get_FullName());
            statement.setString(2, customerUpdate.get_PhoneNumber());
            statement.setString(3, customerUpdate.get_CreateDate());
            statement.setInt(4, customerUpdate.get_Point());
            statement.setInt(5, customerUpdate.get_Id());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    } 
    public static void delete(int id){
        Connect();
        String sql = "delete from customer where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
    }
    public static CustomerModel findByName(String fullName) {
        
        Connect();
        CustomerModel customer = null;
        String sql = "select * from customer where fullname like '%" + fullName + "%'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new CustomerModel();
                customer.readRecord(resultSet);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return customer;
    }
    static CustomerModel customer;
    
    public static CustomerModel findById(int id) {
        customer = new CustomerModel();
        Connect();
        String sql = "select * from customer where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer.readRecord(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return customer;

    }
    
     public static List<CustomerModel> searchByName(String fullName) {
        List<CustomerModel> customerList = new ArrayList<>();
        Connect();
        CustomerModel customer = null;
        String sql = "select * from customer where fullname like '%" + fullName + "%'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new CustomerModel();
                customer.readRecord(resultSet);
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect();
        return customerList;
    }
}
