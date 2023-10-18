module com.example.dogbreeds {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dogbreeds to javafx.fxml;
    exports com.example.dogbreeds;
}