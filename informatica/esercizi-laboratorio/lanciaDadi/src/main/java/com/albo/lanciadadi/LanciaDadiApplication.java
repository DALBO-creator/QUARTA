package com.albo.lanciadadi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LanciaDadiApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LanciaDadiApplication.class.getResource("lanciaDadi-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("lancia i dadi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}