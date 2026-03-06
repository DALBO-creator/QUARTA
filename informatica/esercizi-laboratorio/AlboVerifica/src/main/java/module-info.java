module com.albo.alboverifica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.alboverifica to javafx.fxml;
    exports com.albo.alboverifica;
}