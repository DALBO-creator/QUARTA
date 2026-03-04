package com.albo.escodicefiscale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class CodiceFiscaleController {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCognome;
    @FXML
    private DatePicker dtpData;
    @FXML
    private RadioButton rdbM;
    @FXML
    private RadioButton rdbF;
    @FXML
    private Label lblRisultato;
    @FXML
    private Button btnCalcola;

    @FXML
    protected String getSesso(){
        if (rdbM.isSelected()){
            return "mascio";
        }
        else return "femmina";
    }

    @FXML
    protected void onBtnCalcolaClick(){
        String nome = txtNome.getText();
        String cognome = txtCognome.getText();
        LocalDate data = dtpData.getValue();
        boolean sesso = rdbM.isSelected();



        CodiceFiscale cf = new CodiceFiscale(nome, cognome, data, getSesso());
        lblRisultato.setText(cf.generaPrimi15()+cf.calcoloControllo());


    }


}