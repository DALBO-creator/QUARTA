module com.example.esmenu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.esmenu to javafx.fxml;
    exports com.example.esmenu;
}