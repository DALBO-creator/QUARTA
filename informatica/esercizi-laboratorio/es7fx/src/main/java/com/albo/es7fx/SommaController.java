package com.albo.es7fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SommaController {

    @FXML
    private TextField txtN1;

    @FXML
    private TextField txtN2;

    @FXML
    private Label lblSomma;

    @FXML
    private Button Somma;

    @FXML
    public void onSommaButtonClick() {
        try {
            int n1 = Integer.parseInt(txtN1.getText());
            int n2 = Integer.parseInt(txtN2.getText());
            lblSomma.setText(String.valueOf(n1 + n2));
        } catch (NumberFormatException e) {
            lblSomma.setText("Errore");
        }
    }
}
