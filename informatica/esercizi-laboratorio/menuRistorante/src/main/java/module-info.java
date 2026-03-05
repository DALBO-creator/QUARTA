module com.example.menuristorante {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.menuristorante to javafx.fxml;
    exports com.example.menuristorante;
}