module com.example.lab4exercise1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab4exercise1 to javafx.fxml;
    exports com.example.lab4exercise1;
}