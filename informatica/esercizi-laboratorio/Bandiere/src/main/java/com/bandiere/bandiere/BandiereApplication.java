package com.bandiere.bandiere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BandiereApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BandiereApplication.class.getResource("bandiere-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Gioco delle bandiere");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}