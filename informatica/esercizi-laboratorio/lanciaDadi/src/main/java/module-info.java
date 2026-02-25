module com.albo.lanciadadi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.lanciadadi to javafx.fxml;
    exports com.albo.lanciadadi;
}