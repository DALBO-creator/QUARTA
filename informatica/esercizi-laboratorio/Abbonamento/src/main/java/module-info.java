module com.example.abbonamento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abbonamento to javafx.fxml;
    exports com.example.abbonamento;
}