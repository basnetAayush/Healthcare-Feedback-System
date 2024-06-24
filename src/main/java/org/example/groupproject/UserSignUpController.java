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

public class UserSignUpController {
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField UserSignUpName;
    @FXML
    private TextField UserSignUpEmail;
    @FXML
    private TextField UserSignUpUsername;
    @FXML
    private PasswordField UserSignUpPassword;
    @FXML
    private PasswordField UserSignUpConfirmPassword;
    @FXML
    private TextField UserSignUpNo;
    @FXML
    private ChoiceBox<String> SCreatorGender;

    String pathToUserData = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\UserCsv.csv";

    @FXML
    public void initialize() {
        if (SCreatorGender != null) {
            SCreatorGender.getItems().addAll("Male", "Female", "Other");
        } else {
            System.err.println("SCreatorGender is not initialized.");
        }
    }

    public void buttonForUserSignUpRegister(ActionEvent event) {
        String ParticipantName = UserSignUpName.getText();
        String ParticipantEmail = UserSignUpEmail.getText();
        String ParticipantUsername = UserSignUpUsername.getText();
        String ParticipantGender = SCreatorGender.getValue();
        String ParticipantNo = UserSignUpNo.getText();
        String ParticipantPassword = UserSignUpPassword.getText();
        String ParticipantConformPassword = UserSignUpConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToUserData, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {ParticipantName, ParticipantEmail, ParticipantUsername, ParticipantGender,
                    ParticipantNo, ParticipantPassword, ParticipantConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/UserSignIn.fxml");
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
