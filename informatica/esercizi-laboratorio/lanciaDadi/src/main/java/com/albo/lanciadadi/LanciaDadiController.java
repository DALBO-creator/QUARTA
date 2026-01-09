package com.albo.lanciadadi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LanciaDadiController {
    Dado dado6 = new Dado(6);
    Dado dado10 = new Dado(10);
    Dado dado20 = new Dado(20);
    @FXML
    private Label welcomeText;

    public void onLanciaButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}