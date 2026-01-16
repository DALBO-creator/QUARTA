module com.albo.es7fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.es7fx to javafx.fxml;
    exports com.albo.es7fx;
}