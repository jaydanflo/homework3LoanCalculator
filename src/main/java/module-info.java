module com.example.homework3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.homework3 to javafx.fxml;
    exports com.example.homework3;
}