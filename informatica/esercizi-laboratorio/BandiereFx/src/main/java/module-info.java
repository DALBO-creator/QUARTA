module com.albo.bandierefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.bandierefx to javafx.fxml;
    exports com.albo.bandierefx;
}