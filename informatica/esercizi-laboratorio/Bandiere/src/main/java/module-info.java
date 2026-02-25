module com.bandiere.bandiere {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bandiere.bandiere to javafx.fxml;
    exports com.bandiere.bandiere;
}