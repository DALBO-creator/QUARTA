package com.albo.alboverifica;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class campeggioController {

    @FXML
    private TextField txtNome;

    @FXML
    private DatePicker dateInizio;

    @FXML
    private DatePicker dateFine;

    @FXML
    private TextField txtPiazzola;

    @FXML
    private ChoiceBox<String> choTipoPiazzola;

    @FXML
    private CheckBox chkAnimali;

    @FXML
    private TextField txtAdulti;

    @FXML
    private TextField txtBambini;

    @FXML
    private Label lblRisultato;

    private campeggio camp = new campeggio();

    @FXML
    public void initialize() {
        choTipoPiazzola.getItems().addAll("BASIC", "COMFORT", "COMFORT PLUS");
        choTipoPiazzola.getSelectionModel().selectFirst();
    }

    @FXML
    protected void onCalcola(){

        try{
            String nome = txtNome.getText();
            LocalDate inizio = dateInizio.getValue();
            LocalDate fine = dateFine.getValue();

            int piazzola = Integer.parseInt(txtPiazzola.getText());
            String tipo = choTipoPiazzola.getSelectionModel().getSelectedItem();
            boolean animali = chkAnimali.isSelected();
            int adulti = Integer.parseInt(txtAdulti.getText());
            int bambini = Integer.parseInt(txtBambini.getText());
            double prezzo = camp.calcolaPrezzo(inizio,fine,tipo,animali,adulti,bambini);
            lblRisultato.setText("Prezzo soggiorno: " + prezzo + " €");

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Inserire dati validi");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onInvia(){
        try{
            String nome = txtNome.getText();
            int piazzola = Integer.parseInt(txtPiazzola.getText());
            boolean ok = camp.aggiungiPrenotazione(nome,piazzola);
            if(!ok){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Piazzola già occupata o numero piazzola errato (1-30)");
                alert.showAndWait();
                return;
            }
            lblRisultato.setText("Prenotazione inserita");

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Errore prenotazione");
            e.printStackTrace();
            alert.showAndWait();
        }
    }
    @FXML
    protected void onVisualizza(){
        lblRisultato.setText(camp.visualizzaPrenotazioni());
    }
}