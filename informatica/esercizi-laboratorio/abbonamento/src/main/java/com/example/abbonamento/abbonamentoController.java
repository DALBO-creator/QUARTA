package com.example.abbonamento;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;

public class abbonamentoController {

    @FXML
    private DatePicker dateInizio;

    @FXML
    private RadioButton radMensile;

    @FXML
    private RadioButton radSemestrale;

    @FXML
    private RadioButton radAnnuale;

    @FXML
    private Label lblRisultato;

    private abbonamento model = new abbonamento();

    @FXML
    protected void onCalcola() {

        LocalDate data = dateInizio.getValue();

        int tipo = 0;

        if(radMensile.isSelected()){
            tipo = 1;
        }

        if(radSemestrale.isSelected()){
            tipo = 6;
        }

        if(radAnnuale.isSelected()){
            tipo = 12;
        }

        LocalDate fine = model.calcolaFine(data, tipo);

        lblRisultato.setText("Fine abbonamento: " + fine);
    }
}