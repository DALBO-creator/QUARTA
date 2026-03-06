package com.albo.alboverifica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class campeggioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(campeggioApplication.class.getResource("campeggio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Campeggio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}