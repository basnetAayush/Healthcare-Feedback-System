package org.example.groupproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class HelloController {
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

//    @FXML
//    private TextField email;
//
//    @FXML
//    private PasswordField password;

    // admin
//    @FXML
//    private TextField adminName;
//
//    @FXML
//    private TextField adminEmail;
//
//    @FXML
//    private  TextField adminUsername;
//
//    @FXML
//    private PasswordField adminPassword;
//
//    @FXML
//    private PasswordField adminConfirmPassword;

    // survey creator
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

    // Survey Question
    @FXML
    private AnchorPane dynamicBox;
    @FXML
    private Label SubmitL;


    // User
//    @FXML
//    private TextField UserSignUpName;
//    @FXML
//    private TextField UserSignUpEmail;
//    @FXML
//    private TextField UserSignUpUsername;
//    @FXML
//    private PasswordField UserSignUpPassword;
//    @FXML
//    private PasswordField UserSignUpConfirmPassword;
//    @FXML
//    private TextField UserSignUpNo;

    @FXML
    public void initialize() {
        if (SCreatorGender != null) {
            SCreatorGender.getItems().addAll("Male", "Female", "Other");
        } else {
            System.err.println("SCreatorGender is not initialized.");
        }
    }

    String pathToAdminCSV = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\AdminData.csv";
    String pathToSurveyCData = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyCreatorData.csv";
    String pathToUserData = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\UserCsv.csv";

    public void buttonForAdminSignIn() throws IOException{
        loadStage("Admin.fxml");
    }
//
//    public void buttonForAdminSignUp(ActionEvent event) throws IOException{
//        try {
////            loadStage("AdminSignUp.fxml");
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminSignUp.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = Uses.getCurrentStage(event);
//            stage.setScene(scene);
//        }catch (Exception e){
//            e.getMessage();
//        }
//    }

    public void buttonForCreatorSignIn() throws IOException{
        loadStage("/org/example/groupproject/SurveyCreatorSignIn.fxml");
    }

    public void buttonForUserSignIn() throws IOException{
        loadStage("/org/example/groupproject/UserSignIn.fxml");
    }
//
//    public void buttonForAdminRegister() {
//        String AdminName = adminName.getText();
//        String AdminEmail = adminEmail.getText();
//        String AdminUsername = adminUsername.getText();
//        String AdminPassword = adminPassword.getText();
//        String AdminConformPassword = adminConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathToAdminCSV, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {AdminName, AdminEmail, AdminUsername, AdminPassword, AdminConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/Admin.fxml");
//
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }
//
//    public void buttonForLogin(ActionEvent event){
//        String emailText = email.getText();
//        String passwordText = password.getText();
//        try {
//            FileReader fileReader = new FileReader(pathToAdminCSV);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (emailText.equals(rows[1]) && passwordText.equals(rows[3])){
//                    LoginINFO.setText("Login Successful");
////                    loadStage("AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = Uses.getCurrentStage(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }
//

//
//    public void buttonForAdminLogin()throws IOException{
//        loadStage("/org/example/groupproject/Admin.fxml");
//    }

    // survey creator...........................................
// for login
//    public void buttonForSurveyCreatorSignUp(ActionEvent event) throws IOException{
//        // loadStage("AdminSignUp.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorSignUp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = Uses.getCurrentStage(event);
//        stage.setScene(scene);
//    }
//
//    public void buttonForSurveyCreatorLogin(ActionEvent event){
//        String emailText = SurveyCreatorEmail.getText();
//        String passwordText = SurveyCreatorPassword.getText();
//        try {
//            FileReader fileReader = new FileReader(pathToSurveyCData);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (emailText.equals(rows[2]) && passwordText.equals(rows[7])){
//                    LoginINFO.setText("Login Successful");
//                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCDashboard.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = Uses.getCurrentStage(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }

    //surveycreator functions
//    public void CreateSurvey() throws IOException {
//        userINFO.setText("Survey Created click on view survey");
//        createCSVFile();
//        FileWriter fileWriter1 = new FileWriter("C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyCode.csv",true);
//        CSVWriter csvWriter1 = new CSVWriter(fileWriter1);
//        String data1 = generateRandomWord();
//        String[] data2 = {data1};
//        csvWriter1.writeNext(data2);
//        csvWriter1.close();
//        userINFO.setText("data1");
//
//        //load stage to survey questions
//        loadStage("SurveyQuestions.fxml");
//    }

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
    public static  int fileCounter = 0;
    public static void createCSVFile() {
        // Ensure the directory exists
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = DIRECTORY_PATH + "Survey_" + fileCounter + ".csv";
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            System.out.println("CSV file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
        }
        fileCounter++;
    }

//
//    //adding new element
//    private int tQuestionCount = 0;
//    private int mcqCount = 0;
//    private int polarCount = 0;
//
//    @FXML
//    public void addTquestion() {
//        TextField newTextField = new TextField();
//        newTextField.setId("tquestion-" + tQuestionCount++);
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("LikertScale Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField.setPrefWidth(380);
//        newTextField.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> addTquestion());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField);
//        layoutBelow(newTextField, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//    @FXML
//    public void addMCQ() {
//        TextField newTextField1 = new TextField();
//        newTextField1.setId("mcq-" + mcqCount++);
//        TextField newTextField2 = new TextField();
//        newTextField2.setId("mcq-" + mcqCount++);
//        TextField newTextField3 = new TextField();
//        newTextField3.setId("mcq-" + mcqCount++);
//        TextField newTextField4 = new TextField();
//        newTextField4.setId("mcq-" + mcqCount++);
//        TextField newTextField5 = new TextField();
//        newTextField5.setId("mcq-" + mcqCount++);
//
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("Polar Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField1.setPrefWidth(380);
//        newTextField1.setPrefHeight(20);
//        newTextField2.setPrefWidth(380);
//        newTextField2.setPrefHeight(20);
//        newTextField3.setPrefWidth(380);
//        newTextField3.setPrefHeight(20);
//        newTextField4.setPrefWidth(380);
//        newTextField4.setPrefHeight(20);
//        newTextField5.setPrefWidth(380);
//        newTextField5.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> addTquestion());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField1);
//        layoutTextFieldBelow(newTextField2, newTextField1);
//        layoutTextFieldBelow(newTextField3, newTextField2);
//        layoutTextFieldBelow(newTextField4, newTextField3);
//        layoutTextFieldBelow(newTextField5, newTextField4);
//        layoutBelow(newTextField5, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField1, newTextField2, newTextField3, newTextField4, newTextField5, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//    @FXML
//    public void addPolarQuestions() {
//        TextField newTextField = new TextField();
//        newTextField.setId("polar-" + polarCount++);
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("Polar Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField.setPrefWidth(380);
//        newTextField.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> addTquestion());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField);
//        layoutBelow(newTextField, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//
//    private void layoutTextField(TextField textField) {
//        Node lastNode = dynamicBox.getChildren().get(dynamicBox.getChildren().size() - 1);
//        double layoutY = lastNode.getLayoutY();
//        textField.setLayoutX(50);
//        textField.setLayoutY(layoutY + lastNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    private void layoutTextFieldBelow(TextField textField, Node aboveNode) {
//        double layoutY = aboveNode.getLayoutY();
//        textField.setLayoutX(50);
//        textField.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    private void layoutBelow(Node aboveNode, Node belowNode) {
//        double layoutY = aboveNode.getLayoutY();
//        belowNode.setLayoutX(50);
//        belowNode.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    @FXML
//    public void submitquestions() {
//        String baseDir = "C:\\Users\\ACER\\Desktop\\IIMS\\6th\\AP\\Group Assignment\\src\\main\\resources\\org\\example\\groupproject\\SurveyData";
//        File newDir = createNewDirectory(baseDir);
//
//        saveTQuestions(newDir.getAbsolutePath());
//        savePolarQuestions(newDir.getAbsolutePath());
//        saveMCQs(newDir.getAbsolutePath());
//
//        SubmitL.setText("Saved");
//    }
//
//    private File createNewDirectory(String baseDir) {
//        File baseDirectory = new File(baseDir);
//        if (!baseDirectory.exists()) {
//            baseDirectory.mkdirs();
//        }
//
//        int nextNumber = 1;
//        try (Stream<Path> paths = Files.list(Paths.get(baseDir))) {
//            nextNumber = paths.filter(Files::isDirectory)
//                    .map(path -> path.getFileName().toString())
//                    .filter(name -> name.matches("\\d+Surveyquestion"))
//                    .map(name -> Integer.parseInt(name.replace("Surveyquestion", "")))
//                    .max(Comparator.naturalOrder())
//                    .orElse(0) + 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File newDir = new File(baseDir, nextNumber + "Surveyquestion");
//        if (!newDir.exists()) {
//            newDir.mkdirs();
//        }
//        return newDir;
//    }

//
//    @FXML
//    public void saveTQuestions(String dirPath) {
//        saveQuestionsToCSV("tquestion", dirPath + "/tquestions.csv");
//    }
//
//    @FXML
//    public void saveMCQs(String dirPath) {
//        saveQuestionsToCSV("mcq", dirPath + "/mcq.csv");
//    }
//
//    @FXML
//    public void savePolarQuestions(String dirPath) {
//        saveQuestionsToCSV("polar", dirPath + "/polar.csv");
//    }
//
//    private void saveQuestionsToCSV(String questionPrefix, String fileName) {
//        List<String> questions = new ArrayList<>();
//        for (Node node : dynamicBox.getChildren()) {
//            if (node instanceof TextField && node.getId() != null && node.getId().startsWith(questionPrefix)) {
//                questions.add(((TextField) node).getText());
//            }
//        }
//
//        try (FileWriter writer = new FileWriter(fileName)) {
//            for (String question : questions) {
//                writer.write(question + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    // for register
//    public void buttonForSurveyCreatorSignIn(ActionEvent event) {
//        String CreatorFName = surveyCreatorFName.getText();
//        String CreatorLName = surveyCreatorLName.getText();
//        String CreatorEmail = surveyCreatorEmail.getText();
//        String CreatorUsername = surveyCreatorUsername.getText();
//        String CreatorDepartment = surveyCreatorDepartment.getText();
//        String CreatorGender = SCreatorGender.getValue();
//        String CreatorNo = surveyCreatorPhoneNumber.getText();
//        String CreatorPassword = surveyCreatorPassword.getText();
//        String CreatorConformPassword = surveyCreatorConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathToSurveyCData, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {CreatorFName, CreatorLName, CreatorEmail, CreatorUsername, CreatorGender,CreatorDepartment,
//                    CreatorNo, CreatorPassword, CreatorConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/SurveyCreatorSignIn.fxml");
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }



    // User
   // for login
//    public void buttonForUserSignUp(ActionEvent event) throws IOException{
//        // loadStage("AdminSignUp.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserSignUp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = Uses.getCurrentStage(event);
//        stage.setScene(scene);
//    }
//
//    public void buttonForUserLogin(ActionEvent event){
//        String emailText = UserSignUpEmail.getText();
//        String passwordText = UserSignUpPassword.getText();
//        try {
//            FileReader fileReader = new FileReader(pathToUserData);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (rows.length >= 7 && emailText.equals(rows[1]) && passwordText.equals(rows[6])){ // Check row length before accessing
//                    //if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
//                    LoginINFO.setText("Login Successful");
//                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = Uses.getCurrentStage(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }

    // for register
//    public void buttonForUserSignUpRegister(ActionEvent event) {
//        String ParticipantName = UserSignUpName.getText();
//        String ParticipantEmail = UserSignUpEmail.getText();
//        String ParticipantUsername = UserSignUpUsername.getText();
//        String ParticipantGender = SCreatorGender.getValue();
//        String ParticipantNo = UserSignUpNo.getText();
//        String ParticipantPassword = UserSignUpPassword.getText();
//        String ParticipantConformPassword = UserSignUpConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathToUserData, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {ParticipantName, ParticipantEmail, ParticipantUsername, ParticipantGender,
//                    ParticipantNo, ParticipantPassword, ParticipantConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/UserSignIn.fxml");
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }

    public void buttonForUserSignUpLogin()throws IOException{
        loadStage("/org/example/groupproject/UserSignIn.fxml");
    }





    @FXML
    public void loadStage(String sceneName) throws IOException{
        try {
            System.out.println("Loading FXML file: " + sceneName);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) userINFO.getScene().getWindow();
            stage.setScene(new Scene (root));
            stage.show();
        }catch (IOException e){
            userINFO.setText("Failed to load scene: " + e.getMessage());
            e.printStackTrace();
        }
    }



}