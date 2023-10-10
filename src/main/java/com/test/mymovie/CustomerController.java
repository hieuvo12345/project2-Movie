

package com.test.mymovie;

import MovieCRUD.BookingCRUD;
import MovieCRUD.CustomerCRUD;
import MovieModel.BookingModel;
import MovieModel.CustomerModel;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class CustomerController implements Initializable{

    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML 
    private TableColumn<CustomerModel, String> create_date;

    @FXML 
    private TableColumn<CustomerModel, String> full_name; 

    @FXML 
    private TableColumn<CustomerModel, String> no; 

    @FXML 
    private TableColumn<CustomerModel, String> phone_number; 

    @FXML 
    private TableColumn<CustomerModel, String> point;

    @FXML 
    private TableView<CustomerModel> tbl_customer;

    @FXML 
    private DatePicker txt_create_date;

    @FXML 
    private TextField txt_findByName; 

    @FXML 
    private TextField txt_fullname; 

    @FXML 
    private TextField txt_phone_number; 
    
    @FXML 
    private TextField txt_point; 

    @FXML
    void btn_add(MouseEvent event) {
        boolean check = false;
        CustomerModel customer = new CustomerModel(
                1,
                txt_fullname.getText(),
                txt_phone_number.getText(),
                txt_create_date.getValue().getYear() + "-" + txt_create_date.getValue().getMonthValue() + "-" + txt_create_date.getValue().getDayOfMonth(),
                Integer.parseInt(txt_point.getText()));
        customerList = CustomerCRUD.getList();
        for (CustomerModel customerModel : customerList) {
            if (customerModel.get_FullName().equalsIgnoreCase(txt_fullname.getText()) && customerModel.get_PhoneNumber().equalsIgnoreCase(txt_phone_number.getText())) {
                check = true;
                break;
            }
        }
        if (!check) {
            CustomerCRUD.add(customer);
            
        }
        
        
        customerList = CustomerCRUD.getList();
        clear();
        initialize();
    }

    @FXML
    void btn_clear(MouseEvent event) {
        clear();
    }
    
    void clear(){
        txt_fullname.setText(null);
        txt_phone_number.setText(null);
        txt_create_date.setValue(null);
        txt_point.setText(null);
    }
    @FXML
    void btn_delete(MouseEvent event) {
        if(customer != null) {
            List<BookingModel> bookingList = BookingCRUD.getListByCustomerId(customer.get_Id());
            for (BookingModel bookingModel : bookingList) {
                BookingCRUD.delete(bookingModel.getId());
            }
            CustomerCRUD.delete(customer.get_Id());
        }
       customerList =  CustomerCRUD.getList();
        initialize();
        clear();
        
    }

    @FXML
    void btn_search(MouseEvent event) {
        customerList = CustomerCRUD.searchByName(txt_findByName.getText());
        initialize();
    }

    @FXML
    void btn_update(MouseEvent event) {
        boolean check = false;
        customer = new CustomerModel(
                customer.get_Id(),
                txt_fullname.getText(),
                txt_phone_number.getText(),
                txt_create_date.getValue().getYear() + "-" + txt_create_date.getValue().getMonthValue() + "-" + txt_create_date.getValue().getDayOfMonth(),
                Integer.parseInt(txt_point.getText()));
        customerList = CustomerCRUD.getList();
        for (CustomerModel customerModel : customerList) {
            if (customerModel.get_FullName().equalsIgnoreCase(txt_fullname.getText()) && customerModel.get_PhoneNumber().equalsIgnoreCase(txt_phone_number.getText()) && customer.get_Id() != customerModel.get_Id()) {
                check = true;
                break;
            }
        }
        if (!check) {
            CustomerCRUD.update(customer);
            
        } 
        customerList = CustomerCRUD.getList();
        clear();
        initialize();
    }
    static CustomerModel customer;
    
    @FXML
    void display_selected_item(MouseEvent event) {
        customer = tbl_customer.getSelectionModel().getSelectedItem();
        if (customer != null) {
            txt_fullname.setText(customer.get_FullName());
            txt_phone_number.setText(customer.get_PhoneNumber());
            txt_create_date.setValue(LocalDate.parse(customer.get_CreateDate()));
            txt_point.setText(customer.get_Point()+"");
        }
    }
    
    static List<CustomerModel> customerList;
    @FXML 
    void initialize() {
        no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> p) {
                
                return new ReadOnlyObjectWrapper(tbl_customer.getItems().indexOf(p.getValue()) + 1);    
            }
        });
        full_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> p) {
                return p.getValue().getFullName();
            }
        
        });
        phone_number.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> p) {
                return p.getValue().getPhoneNumber();
            }
        });
        create_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> p) {
                return p.getValue().getCreateDate();
            }
        });
        point.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> p) {
                return new SimpleStringProperty(p.getValue().get_Point()+"");
            }
        });
        ObservableList<CustomerModel> customerOb = FXCollections.observableArrayList(customerList);
        
        tbl_customer.setItems(customerOb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerList = CustomerCRUD.getList();
        initialize();
    }

}
