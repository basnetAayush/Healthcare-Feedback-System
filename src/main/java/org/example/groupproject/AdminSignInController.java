package org.example.groupproject;

import com.opencsv.CSVReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;

public class AdminSignInController {

    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    String pathToAdminCSV = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\AdminData.csv";

    public void buttonForAdminSignUp(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminSignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = Uses.getCurrentStage(event);
            stage.setScene(scene);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void buttonForLogin(ActionEvent event){
        String emailText = email.getText();
        String passwordText = password.getText();
        try {
            FileReader fileReader = new FileReader(pathToAdminCSV);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (emailText.equals(rows[1]) && passwordText.equals(rows[3])){
                    LoginINFO.setText("Login Successful");
//                    loadStage("AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = Uses.getCurrentStage(event);
                    stage.setScene(scene);
                    found = true;
                    break;
                }
            }
            if (!found) {
                LoginINFO.setText("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }




}
