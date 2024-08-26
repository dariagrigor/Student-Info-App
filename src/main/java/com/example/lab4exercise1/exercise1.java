package com.example.lab4exercise1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class lab4exercise1 extends Application {

    @Override
        public void start(Stage primaryStage) {
            // CREATE.ROOT.PANE.
            BorderPane rootPane = new BorderPane();

            // CREATE.INPUT.FIELDS.
            TextField fullNameField = new TextField();
            fullNameField.setPromptText("Full Name");

            TextField addressField = new TextField();
            addressField.setPromptText("Address");

            TextField cityField = new TextField();
            cityField.setPromptText("City");

            TextField provinceField = new TextField();
            provinceField.setPromptText("Province");

            TextField postalCodeField = new TextField(); // POSTAL.CODE.TEXT.FIELD.
            postalCodeField.setPromptText("Postal Code");

            TextField phoneNumberField = new TextField();
            phoneNumberField.setPromptText("Phone Number");

            TextField emailField = new TextField();
            emailField.setPromptText("Email");

            // CREATE.RADIO.BUTTONS.FOR.MAJOR.
            ToggleGroup majorGroup = new ToggleGroup();
            RadioButton csRadioButton = new RadioButton("Computer Science");
            csRadioButton.setToggleGroup(majorGroup);
            RadioButton businessRadioButton = new RadioButton("Business");
            businessRadioButton.setToggleGroup(majorGroup);

            // CREATE.COMBO.BOX.FOR.COURSES.
            ComboBox<String> coursesComboBox = new ComboBox<>();
            ObservableList<String> csCourses = FXCollections.observableArrayList("CS101", "CS102", "CS103");
            ObservableList<String> businessCourses = FXCollections.observableArrayList("BUS101", "BUS102", "BUS103");

            // TEXT.AREA.TO.DISPLAY.SELECTED.COURSES.
            TextArea selectedCoursesTextArea = new TextArea();
            selectedCoursesTextArea.setEditable(false);
            selectedCoursesTextArea.setPromptText("Selected Courses");

            // ADD.CHANGE.LISTENER.TO.MAJOR.RADIO.BUTTONS.
            majorGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == csRadioButton) {
                    coursesComboBox.setItems(csCourses);
                } else if (newValue == businessRadioButton) {
                    coursesComboBox.setItems(businessCourses);
                }
            });

            // ADD.ACTION.TO.COMBO.BOX.
            coursesComboBox.setOnAction(e -> {
                String selectedCourse = coursesComboBox.getValue();
                if (selectedCourse != null && !selectedCoursesTextArea.getText().contains(selectedCourse)) {
                    if (selectedCoursesTextArea.getText().isEmpty()) {
                        selectedCoursesTextArea.setText(selectedCourse);
                    } else {
                        selectedCoursesTextArea.appendText("\n" + selectedCourse);
                    }
                }
            });

            // CREATE.CHECKBOXES.FOR.ADDITIONAL.INFO.
            CheckBox studentCouncilCheckBox = new CheckBox("Student Council"); // STUDENT.COUNCIL.CHECKBOX.
            CheckBox volunteerWorkCheckBox = new CheckBox("Volunteer Work"); // VOLUNTEER.WORK.CHECKBOX.

            // CREATE.TEXT.AREA.FOR.DISPLAYING.STUDENT.INFO.
            TextArea studentInfoTextArea = new TextArea();
            studentInfoTextArea.setPromptText("Student Information");

            // CREATE.DISPLAY.BUTTON.
            Button displayButton = new Button("Display");
            displayButton.setOnAction(e -> {
                StringBuilder studentInfo = new StringBuilder();
                studentInfo.append("Full Name: ").append(fullNameField.getText()).append("\n")
                        .append("Address: ").append(addressField.getText()).append("\n")
                        .append("City: ").append(cityField.getText()).append("\n")
                        .append("Province: ").append(provinceField.getText()).append("\n")
                        .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                        .append("Phone Number: ").append(phoneNumberField.getText()).append("\n")
                        .append("Email: ").append(emailField.getText()).append("\n")
                        .append("Major: ").append(((RadioButton) majorGroup.getSelectedToggle()).getText()).append("\n")
                        .append("Courses: ").append(selectedCoursesTextArea.getText()).append("\n")
                        .append("Additional Info: ")
                        .append(studentCouncilCheckBox.isSelected() ? "Student Council, " : "")
                        .append(volunteerWorkCheckBox.isSelected() ? "Volunteer Work" : "");
                studentInfoTextArea.setText(studentInfo.toString());
            });

            // CREATE.GRID.PANE.FOR.INPUT.FIELDS.
            GridPane inputPane = new GridPane();
            inputPane.setHgap(10);
            inputPane.setVgap(10);
            inputPane.add(new Label("Full Name:"), 0, 0);
            inputPane.add(fullNameField, 1, 0);
            inputPane.add(new Label("Address:"), 0, 1);
            inputPane.add(addressField, 1, 1);
            inputPane.add(new Label("City:"), 0, 2);
            inputPane.add(cityField, 1, 2);
            inputPane.add(new Label("Province:"), 0, 3);
            inputPane.add(provinceField, 1, 3);
            inputPane.add(new Label("Postal Code:"), 0, 4); // ADD.POSTAL.CODE.LABEL.
            inputPane.add(postalCodeField, 1, 4); // ADD.POSTAL.CODE.FIELD.
            inputPane.add(new Label("Phone Number:"), 0, 5);
            inputPane.add(phoneNumberField, 1, 5);
            inputPane.add(new Label("Email:"), 0, 6);
            inputPane.add(emailField, 1, 6);
            inputPane.add(new Label("Major:"), 0, 7);
            inputPane.add(csRadioButton, 1, 7);
            inputPane.add(businessRadioButton, 2, 7);
            inputPane.add(new Label("Country:"), 0, 8);
            inputPane.add(new Label("Courses:"), 0, 9);
            inputPane.add(coursesComboBox, 1, 9);
            inputPane.add(new Label("Selected Courses:"), 0, 10);
            inputPane.add(selectedCoursesTextArea, 1, 10);
            inputPane.add(new Label("Additional Info:"), 0, 11);
            inputPane.add(studentCouncilCheckBox, 1, 12); // ADD.STUDENT.COUNCIL.CHECKBOX.
            inputPane.add(volunteerWorkCheckBox, 2, 12); // ADD.VOLUNTEER.WORK.CHECKBOX.
            inputPane.add(displayButton, 1, 13); // ADD.DISPLAY.BUTTON.

            // SET.COLORS.FOR.THE.PANE.
            inputPane.setStyle("-fx-background-color: pink;");
            selectedCoursesTextArea.setStyle("-fx-background-color: yellow;");
            studentInfoTextArea.setStyle("-fx-background-color: yellow;");
            displayButton.setStyle("-fx-background-color: lightblue;");

            // SET.THE.CENTER.PANE.OF.THE.ROOT.PANE.
            rootPane.setCenter(inputPane);

            // SET.TEXT.AREA.AT.THE.BOTTOM.
            rootPane.setBottom(studentInfoTextArea);

            // CREATE.SCENE.AND.SET.STAGE.
            Scene scene = new Scene(rootPane, 600, 600);
            primaryStage.setTitle("Student Information");
            primaryStage.setScene(scene);
            primaryStage.show();

            // PRINT.STATEMENT.
            System.out.println("I used unauthorized resources.");
        }

        public static void main(String[] args) {
            launch();
        }
}