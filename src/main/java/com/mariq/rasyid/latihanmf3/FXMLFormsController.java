/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf3;

import com.mariq.rasyid.latihanmf3.Model.Customer_Models;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLFormsController implements Initializable {

    //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    //Initiate Model
    Customer_Models mdl = new Customer_Models();
    
    @FXML
    private TabPane forms;
    @FXML
    private Button OrderButton;
    @FXML
    private Button Resetbutton;
    @FXML
    private Button closeclick;
    @FXML
    private Label Customer_Name;
    @FXML
    private Label Room_Number;
    @FXML
    private Label Room_Type;
    @FXML
    private Label price_days;
    @FXML
    private Label days;
    @FXML
    private Label totalrates_cal;
    @FXML
    private Label total_rates;
    @FXML
    private Label taxes;
    @FXML
    private Label payment;
    @FXML
    private Button closeclick1;
    @FXML
    private TextField txtcustomer;
    @FXML
    private TextField txtroomnumber;
    @FXML
    private ComboBox<String> roomtype;
    @FXML
    private TextField rentstext;
    @FXML
    private Button BackButton;
    @FXML
    private Tab inputtab;
    @FXML
    private Tab outputtab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roomtype.setItems(FXCollections.observableArrayList("-Select Type Of Room-", "Single", "Family", "Suite"));
        roomtype.getSelectionModel().select(0);
        
    }
    
    @FXML
    private void OrderClick(ActionEvent event) {
        mdl.setCostumername(txtcustomer.getText());
        mdl.setRoom_num(Integer.parseInt(txtroomnumber.getText()));
        mdl.setRoom_Type(roomtype.getSelectionModel().getSelectedIndex());
        mdl.setRents(Integer.parseInt(rentstext.getText()));
        double rates = 0, tax = 0, discount = 0;
        int limit = 0;
        String Type = null;
        switch (mdl.getRoom_Type()) {
            case 1: {
                Type = "Single";
                limit = 7;
                rates = 200000;
                if (mdl.getRents() > limit) {
                    discount = (mdl.getRents() - limit) * 30000;
                } else {
                    discount = 0;
                }
                tax = rates * 0.1;
                Room_Type.setText(Type);
                break;
            }
            case 2: {
                Type = "Family";
                limit = 15;
                rates = 500000;
                if (mdl.getRents() > limit) {
                    discount = (mdl.getRents() - limit) * 30000;
                } else {
                    discount = 0;
                }
                tax = 0;
                Room_Type.setText(Type);
                break;
            }
            case 3: {
                Type = "Suite";
                limit = 5;
                rates = 400000;
                if (mdl.getRents() > limit) {
                    discount = (mdl.getRents() - limit) * 30000;
                } else {
                    discount = 0;
                }
                tax = 0;
                Room_Type.setText(Type);
                break;
            }
            default: {
                Type = null;
                limit = 0;
                rates = 0;
                discount = 0;
                tax = 0;
                Room_Type.setText(Type);
            }
        }
        double Rates =  mdl.getRents()* rates;
        double totalrates = Rates - discount;
        double Payments = totalrates + tax;
        totalrates_cal.setText(formater.format(Rates));
        Customer_Name.setText(mdl.getCostumername());
        Room_Number.setText(String.valueOf(mdl.getRoom_num()));
        price_days.setText(formater.format(rates));
        days.setText(String.valueOf(mdl.getRents()));
        taxes.setText(formater.format(tax));
        total_rates.setText(formater.format(totalrates));
        payment.setText(formater.format(Payments));
        forms.getSelectionModel().select(1);
        
    }
    
    @FXML
    private void Reset_Click(ActionEvent event) {
        txtcustomer.setText(null);
        txtroomnumber.setText(null);
        rentstext.setText(null);
        roomtype.getSelectionModel().select(0);
    }
    
    @FXML
    private void closeclick(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void Backclick(ActionEvent event) {
        txtcustomer.setText(null);
        txtroomnumber.setText(null);
        rentstext.setText(null);
        Customer_Name.setText("Label");
        Room_Number.setText("Label");
        Room_Type.setText("Label");
        price_days.setText("Label");
        days.setText("Label");
        totalrates_cal.setText("Label");
        total_rates.setText("Labele");
        taxes.setText("Label");
        payment.setText("Label");
        forms.getSelectionModel().select(0);
        roomtype.getSelectionModel().select(0);
        txtcustomer.requestFocus();
        
    }
    
}
