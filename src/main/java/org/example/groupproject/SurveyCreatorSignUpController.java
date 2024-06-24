package org.example.groupproject;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class SurveyCreatorSignUpController {
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField surveyCreatorFName;
    @FXML
    private TextField surveyCreatorLName;
    @FXML
    private TextField surveyCreatorEmail;
    @FXML
    private TextField surveyCreatorUsername;
    @FXML
    private PasswordField surveyCreatorPassword;
    @FXML
    private PasswordField surveyCreatorConfirmPassword;
    @FXML
    private ChoiceBox<String> SCreatorGender;
    @FXML
    private TextField surveyCreatorPhoneNumber;
    @FXML
    private TextField surveyCreatorDepartment;
    @FXML
    private TextField SurveyCreatorEmail;
    @FXML
    private PasswordField SurveyCreatorPassword;

    @FXML
    public void initialize() {
        if (SCreatorGender != null) {
            SCreatorGender.getItems().addAll("Male", "Female", "Other");
        } else {
            System.err.println("SCreatorGender is not initialized.");
        }
    }

    String pathToSurveyCData = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyCreatorData.csv";

    public void buttonForSurveyCreatorSignIn(ActionEvent event) {
        String CreatorFName = surveyCreatorFName.getText();
        String CreatorLName = surveyCreatorLName.getText();
        String CreatorEmail = surveyCreatorEmail.getText();
        String CreatorUsername = surveyCreatorUsername.getText();
        String CreatorDepartment = surveyCreatorDepartment.getText();
        String CreatorGender = SCreatorGender.getValue();
        String CreatorNo = surveyCreatorPhoneNumber.getText();
        String CreatorPassword = surveyCreatorPassword.getText();
        String CreatorConformPassword = surveyCreatorConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToSurveyCData, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {CreatorFName, CreatorLName, CreatorEmail, CreatorUsername, CreatorGender,CreatorDepartment,
                    CreatorNo, CreatorPassword, CreatorConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/SurveyCreatorSignIn.fxml");
        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }


    @FXML
    public void loadStage(String sceneName) throws IOException {
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
