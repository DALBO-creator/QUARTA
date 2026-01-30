package com.albo.essondaggiofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SondaggioController {

    @FXML private RadioButton rb1;
    @FXML private RadioButton rb2;
    @FXML private RadioButton rb3;
    @FXML private Label welcomeText;

    private ToggleGroup gruppo;
    private Sondaggio sondaggio;

    @FXML
    public void initialize() {

        gruppo = new ToggleGroup();
        rb1.setToggleGroup(gruppo);
        rb2.setToggleGroup(gruppo);
        rb3.setToggleGroup(gruppo);


        sondaggio = new Sondaggio();
        sondaggio.aggiungiOpzione(rb1.getText());
        sondaggio.aggiungiOpzione(rb2.getText());
        sondaggio.aggiungiOpzione(rb3.getText());
    }

    @FXML
    protected void onHelloButtonClick() {
        RadioButton selezionato = (RadioButton) gruppo.getSelectedToggle();

        if (selezionato == null) {
            welcomeText.setText("Seleziona un'opzione");
            return;
        }

        sondaggio.vota(selezionato.getText());
        welcomeText.setText(sondaggio.toString());
    }
}
