module com.albo.escodicefiscale {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.albo.escodicefiscale to javafx.fxml;
    exports com.albo.escodicefiscale;
}