package org.example.groupproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.example.groupproject.Survey.generateRandomWord;

public class QuestionController {
    @FXML
    private Label userINFO;

    @FXML
    private AnchorPane dynamicBox;
    @FXML
    private Label SubmitL;


    @FXML
    public void submitquestions() {
        String baseDir = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyData";
        File newDir = createNewDirectory(baseDir);

        saveTQuestions(newDir.getAbsolutePath());
        savePolarQuestions(newDir.getAbsolutePath());
        saveMCQs(newDir.getAbsolutePath());

        createCSVFile(newDir.getAbsolutePath());
        SubmitL.setText("Saved");
    }

    public static  int fileCounter = 0;
    public static void createCSVFile(String directoryPath) {
        // Ensure the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = directoryPath + "/" + fileCounter + "Survey_" + fileCounter + ".csv";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            System.out.println("CSV file created: " + fileName);
            fileWriter.write(generateRandomWord());
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
        }
        fileCounter++;
    }

    //adding new element
    private int tQuestionCount = 0;
    private int mcqCount = 0;
    private int polarCount = 0;

    @FXML
    public void addTquestion() {
        TextField newTextField = new TextField();
        newTextField.setId("tquestion-" + tQuestionCount++);
        Button addTquestionBtn = new Button("Add Tquestion");
        Button polarQuestionsBtn = new Button("LikertScale Questions");
        Button mcqBtn = new Button("MCQ");

        newTextField.setPrefWidth(380);
        newTextField.setPrefHeight(20);

        addTquestionBtn.setOnAction(e -> addTquestion());
        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
        mcqBtn.setOnAction(e -> addMCQ());

        layoutTextField(newTextField);
        layoutBelow(newTextField, addTquestionBtn);
        layoutBelow(addTquestionBtn, polarQuestionsBtn);
        layoutBelow(polarQuestionsBtn, mcqBtn);

        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
    }

    @FXML
    public void addMCQ() {
        TextField newTextField1 = new TextField();
        newTextField1.setId("mcq-" + mcqCount++);
        TextField newTextField2 = new TextField();
        newTextField2.setId("mcq-" + mcqCount++);
        TextField newTextField3 = new TextField();
        newTextField3.setId("mcq-" + mcqCount++);
        TextField newTextField4 = new TextField();
        newTextField4.setId("mcq-" + mcqCount++);
        TextField newTextField5 = new TextField();
        newTextField5.setId("mcq-" + mcqCount++);

        Button addTquestionBtn = new Button("Add Tquestion");
        Button polarQuestionsBtn = new Button("Polar Questions");
        Button mcqBtn = new Button("MCQ");

        newTextField1.setPrefWidth(380);
        newTextField1.setPrefHeight(20);
        newTextField2.setPrefWidth(380);
        newTextField2.setPrefHeight(20);
        newTextField3.setPrefWidth(380);
        newTextField3.setPrefHeight(20);
        newTextField4.setPrefWidth(380);
        newTextField4.setPrefHeight(20);
        newTextField5.setPrefWidth(380);
        newTextField5.setPrefHeight(20);

        addTquestionBtn.setOnAction(e -> addTquestion());
        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
        mcqBtn.setOnAction(e -> addMCQ());

        layoutTextField(newTextField1);
        layoutTextFieldBelow(newTextField2, newTextField1);
        layoutTextFieldBelow(newTextField3, newTextField2);
        layoutTextFieldBelow(newTextField4, newTextField3);
        layoutTextFieldBelow(newTextField5, newTextField4);
        layoutBelow(newTextField5, addTquestionBtn);
        layoutBelow(addTquestionBtn, polarQuestionsBtn);
        layoutBelow(polarQuestionsBtn, mcqBtn);

        dynamicBox.getChildren().addAll(newTextField1, newTextField2, newTextField3, newTextField4, newTextField5, addTquestionBtn, polarQuestionsBtn, mcqBtn);
    }

    @FXML
    public void addPolarQuestions() {
        TextField newTextField = new TextField();
        newTextField.setId("polar-" + polarCount++);
        Button addTquestionBtn = new Button("Add Tquestion");
        Button polarQuestionsBtn = new Button("Polar Questions");
        Button mcqBtn = new Button("MCQ");

        newTextField.setPrefWidth(380);
        newTextField.setPrefHeight(20);

        addTquestionBtn.setOnAction(e -> addTquestion());
        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
        mcqBtn.setOnAction(e -> addMCQ());

        layoutTextField(newTextField);
        layoutBelow(newTextField, addTquestionBtn);
        layoutBelow(addTquestionBtn, polarQuestionsBtn);
        layoutBelow(polarQuestionsBtn, mcqBtn);

        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
    }


    private void layoutTextField(TextField textField) {
        Node lastNode = dynamicBox.getChildren().get(dynamicBox.getChildren().size() - 1);
        double layoutY = lastNode.getLayoutY();
        textField.setLayoutX(50);
        textField.setLayoutY(layoutY + lastNode.getBoundsInParent().getHeight() + 20);
    }

    private void layoutTextFieldBelow(TextField textField, Node aboveNode) {
        double layoutY = aboveNode.getLayoutY();
        textField.setLayoutX(50);
        textField.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
    }

    private void layoutBelow(Node aboveNode, Node belowNode) {
        double layoutY = aboveNode.getLayoutY();
        belowNode.setLayoutX(50);
        belowNode.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
    }

    private File createNewDirectory(String baseDir) {
        File baseDirectory = new File(baseDir);
        if (!baseDirectory.exists()) {
            baseDirectory.mkdirs();
        }

        int nextNumber = 1;
        try (Stream<Path> paths = Files.list(Paths.get(baseDir))) {
            nextNumber = paths.filter(Files::isDirectory)
                    .map(path -> path.getFileName().toString())
                    .filter(name -> name.matches("\\d+Surveyquestion"))
                    .map(name -> Integer.parseInt(name.replace("Surveyquestion", "")))
                    .max(Comparator.naturalOrder())
                    .orElse(0) + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newDir = new File(baseDir, nextNumber + "Surveyquestion");
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
        return newDir;
    }


    @FXML
    public void saveTQuestions(String dirPath) {
        saveQuestionsToCSV("tquestion", dirPath + "/tquestions.csv");
    }

    @FXML
    public void saveMCQs(String dirPath) {
        saveQuestionsToCSV("mcq", dirPath + "/mcq.csv");
    }

    @FXML
    public void savePolarQuestions(String dirPath) {
        saveQuestionsToCSV("polar", dirPath + "/polar.csv");
    }

    private void saveQuestionsToCSV(String questionPrefix, String fileName) {
        List<String> questions = new ArrayList<>();
        for (Node node : dynamicBox.getChildren()) {
            if (node instanceof TextField && node.getId() != null && node.getId().startsWith(questionPrefix)) {
                questions.add(((TextField) node).getText());
            }
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String question : questions) {
                writer.write(question + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UserLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserSignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = Uses.getCurrentStage(event);
        stage.setScene(scene);
    }
}
