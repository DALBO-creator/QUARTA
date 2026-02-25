module com.albo.contatore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.contatore to javafx.fxml;
    exports com.albo.contatore;
}