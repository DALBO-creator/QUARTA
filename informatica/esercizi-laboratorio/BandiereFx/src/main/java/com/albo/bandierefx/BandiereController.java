package com.albo.bandierefx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BandiereController {

    @FXML private ImageView imgBandiera;
    @FXML private RadioButton rdb1, rdb2, rdb3, rdb4;
    @FXML private ToggleGroup gruppo;
    @FXML private Label lblPunteggio;
    @FXML private Button btnScegli;

    private Gestore gestore = new Gestore();

    @FXML
    public void initialize() {
        gestore.caricaDati("elenco.txt");
        aggiornaInterfaccia();
    }

    @FXML
    protected void onHelloButtonClick() {
        RadioButton selezionato = (RadioButton) gruppo.getSelectedToggle();

        if (selezionato == null) {
            mostraAvviso("Attenzione", "Seleziona un'opzione prima di continuare!");
            return;
        }

        gestore.controllaRisposta(selezionato.getText());

        lblPunteggio.setText("Punti: " + gestore.getPunteggio() + "/" + gestore.getTotale());

        if (!gestore.isFinito()) {
            aggiornaInterfaccia();
        } else {
            btnScegli.setDisable(true);
            mostraAvviso("Quiz Terminato", "Hai totalizzato " + gestore.getPunteggio() + " punti!");
        }
    }

    private void aggiornaInterfaccia() {
        Gestore.Domanda d = gestore.getDomandaCorrente();
        if (d != null) {
            // Caricamento immagine (gestisce link o percorsi locali)
            try {
                imgBandiera.setImage(new Image(d.url));
            } catch (Exception e) {
                System.out.println("Impossibile caricare l'immagine: " + d.url);
            }

            // Imposta i testi dei radio button
            rdb1.setText(d.o1);
            rdb2.setText(d.o2);
            rdb3.setText(d.o3);
            rdb4.setText(d.o4);

            // Deseleziona tutto per la nuova domanda
            if (gruppo.getSelectedToggle() != null) {
                gruppo.getSelectedToggle().setSelected(false);
            }
        }
    }

    private void mostraAvviso(String titolo, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}