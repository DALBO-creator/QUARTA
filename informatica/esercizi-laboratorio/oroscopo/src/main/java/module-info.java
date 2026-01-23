module com.albo.oroscopo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.oroscopo to javafx.fxml;
    exports com.albo.oroscopo;
}