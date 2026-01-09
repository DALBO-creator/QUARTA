package com.albo.lanciadadi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LanciaDadiController {

    private Dado dado6;
    private Dado dado10;
    private Dado dado20;


    @FXML
    public void initialize() {
        dado6 = new Dado(6);
        dado10 = new Dado(10);
        dado20 = new Dado(20);
    }

    @FXML
    private Label lblRisultato;

    public void onLanciaButtonClick() {
        dado6.lancia();
        lblRisultato.setText(dado6.toString());
    }
}