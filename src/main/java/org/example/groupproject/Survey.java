package org.example.groupproject;

import com.opencsv.CSVWriter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.example.groupproject.HelloController.createCSVFile;

public class Survey {
    @FXML
    private Label userINFO;

    public void CreateSurvey() throws IOException {
        userINFO.setText("Survey Created click on view survey");
        createCSVFile();
        FileWriter fileWriter1 = new FileWriter("C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyCode.csv",true);
        CSVWriter csvWriter1 = new CSVWriter(fileWriter1);
        String data1 = generateRandomWord();
        String[] data2 = {data1};
        csvWriter1.writeNext(data2);
        csvWriter1.close();
        userINFO.setText("data1");

        //load stage to survey questions
        loadStage("SurveyQuestions.fxml");
    }

    private static final String DIRECTORY_PATH = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyData";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final int WORD_LENGTH = 6;
    public static String generateRandomWord() {
        StringBuilder word = new StringBuilder(WORD_LENGTH);
        Random random = new Random();

        for (int i = 0; i < WORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            word.append(CHARACTERS.charAt(index));
        }
        return word.toString();
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
