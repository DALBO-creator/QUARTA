package com.albo.bandierefx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class BandiereController {

    @FXML
    private ImageView imgBandiera;

    @FXML
    private RadioButton rdb1;

    @FXML
    private RadioButton rdb2;

    @FXML
    private RadioButton rdb3;

    @FXML
    private RadioButton rdb4;

    @FXML
    private ToggleGroup gruppo;

    @FXML
    private Label lblPunteggio;

    private List<Scelta> domande;
    private int indice = 0;
    private int punteggio = 0;

    @FXML
    public void initialize() {

        domande = Gestore.caricaDomande();
        mostraDomanda();
    }

    private void mostraDomanda() {

        if (indice >= domande.size()) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Quiz finito. Punteggio: " + punteggio);
            a.show();
            return;
        }

        Scelta s = domande.get(indice);

        Image img = new Image(s.getUrl());
        imgBandiera.setImage(img);

        rdb1.setText(s.getOp1());
        rdb2.setText(s.getOp2());
        rdb3.setText(s.getOp3());
        rdb4.setText(s.getOp4());

        gruppo.selectToggle(null);

        lblPunteggio.setText("Punteggio: " + punteggio);
    }

    @FXML
    protected void onHelloButtonClick() {

        RadioButton selezionato = (RadioButton) gruppo.getSelectedToggle();

        if (selezionato == null) {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Seleziona una risposta");
            a.show();
            return;
        }

        String risposta = selezionato.getText();

        Scelta s = domande.get(indice);

        if (s.verifica(risposta)) {
            punteggio = punteggio + 1;
        }

        indice = indice + 1;

        mostraDomanda();
    }
}
