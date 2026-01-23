package com.albo.oroscopo;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class OroscopoController {
    @FXML
    private Label lblOroscopo;
    @FXML
    private ChoiceBox choTipo;
    @FXML
    private DatePicker dtpDataNascita;

    @FXML
    protected void initialize(){
        choTipo.getItems().add("Segno Zodiacale");
        choTipo.getItems().add("Oroscopo");
        choTipo.getSelectionModel().selectFirst();
        dtpDataNascita.setValue(LocalDate.now());

    }

    @FXML
    protected void onScopriButtonClick() {
        Oroscopo o = new Oroscopo(dtpDataNascita.getValue());
        if(choTipo.getSelectionModel().isSelected(0)){
            lblOroscopo.setText(o.getSegnoZodiacale());
        }else{
            lblOroscopo.setText(o.getOroscopo());
        }
    }
}