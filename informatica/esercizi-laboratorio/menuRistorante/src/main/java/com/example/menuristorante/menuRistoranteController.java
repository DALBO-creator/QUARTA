package com.example.menuristorante;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class menuRistoranteController {

    @FXML
    private CheckBox chkPizza;

    @FXML
    private CheckBox chkPasta;

    @FXML
    private CheckBox chkAcqua;

    @FXML
    private CheckBox chkBibita;

    @FXML
    private CheckBox chkDolce;

    @FXML
    private Label lblTotale;

    private menuRistorante mr = new menuRistorante();

    @FXML
    protected void onCalcolaTotale() {

        double totale = mr.calcolaTotale(
                chkPizza.isSelected(),
                chkPasta.isSelected(),
                chkAcqua.isSelected(),
                chkBibita.isSelected(),
                chkDolce.isSelected()
        );

        lblTotale.setText("Totale: " + totale + "€");
    }
}