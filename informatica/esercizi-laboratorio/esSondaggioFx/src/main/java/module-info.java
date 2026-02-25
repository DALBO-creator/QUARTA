module com.albo.essondaggiofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.albo.essondaggiofx to javafx.fxml;
    exports com.albo.essondaggiofx;
}