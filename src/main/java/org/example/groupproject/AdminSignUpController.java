package org.example.groupproject;

import com.opencsv.CSVWriter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class AdminSignUpController {
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField adminName;

    @FXML
    private TextField adminEmail;

    @FXML
    private  TextField adminUsername;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private PasswordField adminConfirmPassword;


    String pathToAdminCSV = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\AdminData.csv";

    public void buttonForAdminRegister() {
        String AdminName = adminName.getText();
        String AdminEmail = adminEmail.getText();
        String AdminUsername = adminUsername.getText();
        String AdminPassword = adminPassword.getText();
        String AdminConformPassword = adminConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToAdminCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {AdminName, AdminEmail, AdminUsername, AdminPassword, AdminConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/Admin.fxml");

        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }


    public void buttonForAdminLogin()throws IOException {
        loadStage("/org/example/groupproject/Admin.fxml");
    }


    @FXML
    public void loadStage(String sceneName) throws IOException{
        try {
            System.out.println("Loading FXML file: " + sceneName);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) userINFO.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            userINFO.setText("Failed to load scene: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
