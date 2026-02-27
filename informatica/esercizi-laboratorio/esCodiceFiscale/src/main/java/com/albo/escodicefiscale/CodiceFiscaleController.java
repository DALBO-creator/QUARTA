package com.albo.escodicefiscale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class CodiceFiscaleController {

    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private DatePicker datePicker;
    @FXML private RadioButton rbM;
    @FXML private Label lblRisultato;

    @FXML
    protected void onCalcolaClick() {
        String nome = txtNome.getText();
        String cognome = txtCognome.getText();
        LocalDate data = datePicker.getValue();
        // Nota: la tua classe si aspetta "mascio" o altro per determinare il sesso
        String sesso = rbM.isSelected() ? "mascio" : "femmina";

        // Luogo di nascita cablato a B157 come nel tuo metodo calcoloComune()
        String luogo = "B157";

        if (nome.isEmpty() || cognome.isEmpty() || data == null) {
            lblRisultato.setText("Dati mancanti!");
            return;
        }

        try {
            CodiceFiscale cf = new CodiceFiscale(nome, cognome, data, sesso, luogo);

            String risultato = cf.generaPrimi15() + cf.calcoloControllo();
            lblRisultato.setText(risultato.toUpperCase());

        } catch (Exception e) {
            lblRisultato.setText("Errore nel calcolo");
            e.printStackTrace();
        }
    }
}